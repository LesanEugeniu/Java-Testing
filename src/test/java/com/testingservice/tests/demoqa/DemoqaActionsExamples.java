package com.testingservice.tests.demoqa;

import com.testingservice.utility.Url;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DemoqaActionsExamples {
    private static WebDriver driver;
    @BeforeClass
    public static void beforeExecution(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @Test
    public void testDemoqaThreeElements(){
        driver.get(Url.DEMOQA_TEXT_BOX.getUrl());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Actions action = new Actions(driver);

        //**FULL NAME**
        WebElement fullName = driver.findElement(By.xpath("*//*[@id='userName']"));
        fullName.sendKeys("Lesan Eugeniu");
        //**EMAIL**
        WebElement email = driver.findElement(By.xpath("*//*[@id='userEmail']"));
        email.sendKeys("eugeniu_only_buisness@moldova.md");
        //**CURRENT ADDRESS**
        WebElement addressCurent = driver.findElement(By.xpath("*//*[@id='currentAddress']"));
        addressCurent.sendKeys("Brazilia 11/2");
        //**PERMANENT ADDRESS**
        WebElement addressPermanent = driver.findElement(By.xpath("*//*[@id='permanentAddress']"));
        addressPermanent.sendKeys("Jamaica 99/3");
        //Click Submit
        action.moveToElement(driver.findElement(By.xpath("*//*[@id='submit']")))
                .click().perform();
        //Click Check Box
        action.moveToElement(driver.findElement(By.xpath("*//*[text()='Check Box']")))
                .click().perform();
        //Click Expand All
        action.moveToElement(driver.findElement(By.xpath("*//*[@title='Expand all']")))
                .click().perform();
        //Click WorkSpace
        action.moveToElement(driver.findElement(By.xpath("*//*[text()='WorkSpace']")))
                .click().perform();
        //Click Radio Button
        action.moveToElement(driver.findElement(By.xpath("*//*[text()='Radio Button']")))
                .click().perform();
        //Click Impressive
        action.moveToElement(driver.findElement(By.xpath("*//*[text()='Impressive']")))
                .click().perform();
    }
    @AfterClass
    public static void afterExecution(){
        driver.quit();
    }
}
