package ee.bcs.valiit.booksearch.crawler;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class CrawlerApollo {
    public static void main(String[] args) {
       // String contents = WebReader.readWeb("https://www.apollo.ee/raamatud/eestikeelsed-raamatud?");
       // Document document = Jsoup.parse(contents);


        String url = "https://www.apollo.ee/raamatud/eestikeelsed-raamatud?";


        for (int i=1; i<=470;i++) {
            String newUrl = url + "p=" + i;
            String contents = WebReader.readWeb(newUrl);
            Document document = Jsoup.parse(contents);

            Elements elements = document.select("div.products-grid .item");
//            System.out.println(elements.size());
            for (Element e : elements) {
                Elements productName = e.getElementsByClass("product-name");
                String title = productName.get(0).getElementsByTag("a").get(0).attributes().get("title");
                String author = e.getElementsByClass("author").text();
                String productPrice = e.getElementsByClass("regular-price").text();
                String link = productName.get(0).getElementsByTag("a").get(0).attributes().get("href");
                System.out.println(title + " " + " " + author + " " + productPrice + " " + link);
            }
        }

    }

}
