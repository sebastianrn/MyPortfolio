package com.myportfolio.sebastian.myportfolio.feature.scraping;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlAnchor;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

import java.net.URLEncoder;
import java.util.List;

class ScrapingService {

    void initializeWebsite() {
        String searchQuery = "Iphone 6s";

        WebClient client = new WebClient();
        client.getOptions().setCssEnabled(false);
        client.getOptions().setJavaScriptEnabled(false);
        try {
            String searchUrl = "https://philoro.ch/preisliste";
            HtmlPage page = client.getPage(searchUrl);
            String pageAsXml = page.asXml();

            List<HtmlElement> items = page.getByXPath("//div[@class='philoro_shoping-cart--element']");
            if (items.isEmpty()) {
                System.out.println("No items found !");
            } else {
                for (HtmlElement item : items) {
                    HtmlAnchor itemAnchor = ((HtmlAnchor) item.getFirstByXPath(".//a"));

                    String itemName = itemAnchor.asText();
                    String itemUrl = itemAnchor.getHrefAttribute();
                    HtmlElement spanPrice = ((HtmlElement) item.getFirstByXPath(".//span[@class='result-price']"));
                    // It is possible that an item doesn't have any price
                    String itemPrice = spanPrice == null ? "no price" : spanPrice.asText();

                    System.out.println(String.format("Name : %s Url : %s Price : %s", itemName, itemPrice, itemUrl));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
