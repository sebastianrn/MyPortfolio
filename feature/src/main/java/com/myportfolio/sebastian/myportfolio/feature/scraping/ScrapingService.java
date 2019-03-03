package com.myportfolio.sebastian.myportfolio.feature.scraping;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlAnchor;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.myportfolio.sebastian.myportfolio.feature.scrapingEntities.Currency;
import com.myportfolio.sebastian.myportfolio.feature.scrapingEntities.Price;
import com.myportfolio.sebastian.myportfolio.feature.scrapingEntities.PriceListItem;
import org.apache.commons.lang3.tuple.Pair;
import org.eclipse.jetty.util.StringUtil;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ScrapingService {
    private List<PriceListItem> priceListItems = new ArrayList<>();
    private static final String searchUrl = "https://philoro.ch/preisliste";

    public List<PriceListItem> getPriceListFromWebsite() {
        List<HtmlElement> rawPriceListItems = initializeWebsite(searchUrl).getByXPath("//div[@class='philoro_shoping-cart--element']");

        if (rawPriceListItems.isEmpty()) {
            System.out.println("No items found !");
        } else {
            for (HtmlElement priceListItem : rawPriceListItems) {
                PriceListItem priceItem = new PriceListItem();
                priceItem.setArticleNumber(getArticleNumber(priceListItem));
                priceItem.setArticleName(getArticleName(priceListItem));
                priceItem.setWeight(getWeight(priceListItem));
                priceItem.setPrice(getBuyPrice(priceListItem));
                priceListItems.add(priceItem);
            }
        }
        return priceListItems;
    }

    HtmlPage initializeWebsite(String searchUrl) {
        try {
            WebClient client = new WebClient();
            client.getOptions().setCssEnabled(false);
            client.getOptions().setJavaScriptEnabled(false);

            return client.getPage(searchUrl);
        } catch (IOException e) {
            return null;
        }
    }

    private Price getBuyPrice(HtmlElement priceListItem) {
        Price price = new Price();
        HtmlElement e = priceListItem.getFirstByXPath(".//div[@class=\'col-sm-4']");
        List<HtmlElement> y = e.getByXPath(".//div[@class=\'col-xs-6 col-sm-12 col-md-6']");

        for (HtmlElement x : y) {
            HtmlElement priceType = x.getFirstByXPath(".//button");
            if (priceType != null && priceType.getAttribute("class").equals("philoro_shoping-cart--gray-btn sell")) {
                price.setSellPrice(getPriceObject((HtmlElement) x.getFirstByXPath(".//var")));
            }
            if (priceType != null && priceType.getAttribute("class").equals("philoro_shoping-cart--blue-btn buy")) {
                price.setBuyPrice(getPriceObject((HtmlElement) x.getFirstByXPath(".//var")));
            }
        }

        return price;
    }

    private Pair<Currency, BigDecimal> getPriceObject(HtmlElement firstByXPath) {
        return StringUtil.isNotBlank(firstByXPath.getTextContent()) ? getValues(firstByXPath.getTextContent().split(" ", 2)) : null;
    }

    private Pair<Currency, BigDecimal> getValues(String[] priceString) {
        return Pair.of(Currency.valueOf(priceString[0]), new BigDecimal(getFormattedPriceValueString(priceString[1])));
    }

    private String getFormattedPriceValueString(String rawPriceValueString) {
        return rawPriceValueString.replace(".", "").replace(",", ".");
    }

    private String getWeight(HtmlElement priceListItem) {
        HtmlElement e = priceListItem.getFirstByXPath(".//div[@class=\'col-sm-3']");
        HtmlElement y = e.getFirstByXPath(".//p[@class=\'text-right']");
        return y.getTextContent();
    }

    private String getArticleName(HtmlElement priceListItem) {
        HtmlAnchor itemAnchor = priceListItem.getFirstByXPath(".//a");
        return itemAnchor.asText();
    }

    private Integer getArticleNumber(HtmlElement priceListItem) {
        HtmlElement e = priceListItem.getFirstByXPath(".//div[@class=\'col-sm-2 visible-xs']");
        HtmlElement y = e.getFirstByXPath(".//p[@class=\'text-right']");
        return Integer.valueOf(y.getTextContent().trim());
    }
}
