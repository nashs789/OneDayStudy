package org.example.Crawling;

import org.example.Dto.ProductDto;
import org.example.Logic.Excel.ExcelWriter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class SeleniumTest1 {

    public static void main(String[] args) throws IOException {

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
                String itemId = href.substring(href.indexOf("products/") + 9);
                WebElement info_box = productItem.findElement(By.className("info_box"));

                String itemName = info_box.findElement(By.className("name")).getText();
                String price = info_box.findElement(By.className("price")).getText();
                String imageUrl = productItem.findElement(By.xpath("//*[@id=\"wrap\"]/div[4]/div[3]/div[2]/div[4]/div[2]/div[1]/div[1]/a/div[1]/div/picture/source[1]"))
                        .getAttribute("srcset");

                // 안에 있는 html 태그들을 더 추출해보시고 -> productDto 안에 set 해주세요!
                productDto.setHref(href);
                productDto.setItemNo(itemId);
                productDto.setItemName(itemName);
                productDto.setPrice(price);
                productDto.setImgUrl(imageUrl);

                productDtoList.add(productDto);
            }
        );

        ExcelWriter ew = new ExcelWriter(new String[]{"href", "itemNo", "itemName", "price", "imgUrl"});

        // ew.createExcel("items.xlsx", "아이템 정보");
    }
}
