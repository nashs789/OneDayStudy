package org.example.Crawling;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class JsoupTest {

    public static void main(String[] args) {
        String url = "https://sum.su.or.kr:8888/bible/today?base_de=2023-03-23";

        try {
            Document document = Jsoup.connect(url).get();

            Element bibleText = document.getElementById("bible_text");
            Element bibleInfoBox = document.getElementById("bibleinfo_box");

            System.out.println("bibleText: " + bibleText.text());
            System.out.println("bibleInfoBox: " + bibleInfoBox.text());
            System.out.println();

            // num과 info를 포함하는 요소 찾기
            Elements numElements = document.select(".num");
            Elements infoElements = document.select(".info");

            // num과 info를 포함하는 요소 출력
            for (int i =0; i < numElements.size(); i++) {
                System.out.println(numElements.get(i).text() + ": " + infoElements.get(i).text());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
