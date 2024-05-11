package org.example.Crawling;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

@Slf4j
public class SeleniumTest {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "./chromedriver");
        WebDriver driver = new ChromeDriver();

        // 웹페이지 접속
        String url = "https://www.naver.com";
        driver.get(url);

        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));

        // 웹페이지 제목 출력
        System.out.println(driver.getTitle());

        WebElement element = driver.findElement(By.id("query"));
        element.sendKeys("코로나");
        // enter key
        element.sendKeys(Keys.ENTER);
    }
}