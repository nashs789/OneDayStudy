package org.example.Crawling;

import org.example.Dto.ProductDto;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class SeleniumTest1 {

    public static void main(String[] args) {

        List<ProductDto> productDtoList = new ArrayList<>();
        ProductDto productDto = new ProductDto();


        System.setProperty("webdriver.chrome.driver", "./chromedriver");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless"); // Browser를 띄우지 않음

        WebDriver driver = new ChromeDriver(options);
        // 웹페이지 접속
        String url = "https://kream.co.kr/";
        driver.get(url);

        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));

        // 웹페이지 제목 출력
        System.out.println(driver.getTitle());

        // 상품 목록

        WebElement element = driver.findElement(By.xpath("//*[@id=\"wrap\"]/div[4]/div[3]/div[2]/div[4]/div[2]/div[1]"));

        element.findElements(By.className("product_item")).forEach(
                productItem -> {
                    String href = productItem.findElement(By.className("item_inner")).getAttribute("href");
                    System.out.println("href: " + href);
                    // /products/281127 내 ItemId 추출
                    String itemId = href.substring(href.indexOf("products/") + 9);
                    System.out.println("itemId: " + itemId);

                    WebElement info_box = productItem.findElement(By.className("info_box"));

                    String itemName = info_box.findElement(By.className("name")).getText();
                    System.out.println(itemName);

                    String price = info_box.findElement(By.className("price")).getText();
                    System.out.println(price.replaceAll("\\D", ""));

                    String imageUrl = productItem.findElement(By.xpath("//*[@id=\"wrap\"]/div[4]/div[3]/div[2]/div[4]/div[2]/div[1]/div[1]/a/div[1]/div/picture/source[1]"))
                            .getAttribute("srcset");
                    System.out.println("imageUrl: " + imageUrl);

                    // 안에 있는 html 태그들을 더 추출해보시고 -> productDto 안에 set 해주세요!
                }
        );


        System.out.println("productDtoList: " + productDtoList);
    }
}
