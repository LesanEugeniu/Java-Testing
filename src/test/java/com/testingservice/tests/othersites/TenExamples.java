package com.testingservice.tests.othersites;

import com.testingservice.utility.Url;
import com.testingservice.utility.Writer;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class TenExamples {
    private static List<String> webElements = new ArrayList<>();

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(Url.MOBILA.getUrl());

        WebDriver driver1 = new ChromeDriver();
        driver1.get(Url.GITHUB.getUrl());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //XPATH
        WebElement onsale = driver.findElement(By.xpath("*//span[@class='onsale']"));
        webElements.add(onsale.getText());
        WebElement dormitor = driver.findElement(By.xpath("*//p[@class='elementor-icon-box-title']/a"));
        webElements.add(dormitor.getAttribute("href"));
        WebElement portoImage = driver.findElement(By.xpath("*//img"));
        webElements.add(portoImage.getAttribute("src"));
        WebElement currency = driver.findElement(By.xpath("*//bdi/span"));
        webElements.add(currency.getText());
        WebElement mobile = driver.findElement(By.xpath("*//span/a"));
        webElements.add(mobile.getAttribute("href"));

        //CSS selectors
        WebElement banner = driver1.findElement(By.cssSelector("div:first-child"));
        webElements.add(banner.getAttribute("class"));
        WebElement navDiv = driver1.findElement(By.cssSelector("nav div:first-child"));
        webElements.add(navDiv.getAttribute("class"));
        WebElement footer = driver1.findElement(By.cssSelector("footer"));
        webElements.add(footer.getAttribute("data-dark-theme"));
        WebElement a = driver1.findElement(By.cssSelector("footer div div div a"));
        webElements.add(a.getAttribute("aria-label"));
        WebElement data = driver1.findElement(By.cssSelector(".application-main div div img"));
        webElements.add(data.getAttribute("src"));

        Writer.writeToFile(webElements);
        System.out.println(webElements);

    }
}
