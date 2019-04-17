package Jsoup;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class JsoupDemo1 {
    public static void main(String[] args) throws Exception{
        String url = "https://www.jianshu.com/";
        Connection connection = Jsoup.connect(url);
        Document document = connection.get();
        Elements elements = document.getElementsByClass("content");
        System.out.println(elements.size());
        for (Element element : elements){
            Element link = element.child(0);
            String titleString = link.text();
            System.out.println(titleString);
        }
    }
}
