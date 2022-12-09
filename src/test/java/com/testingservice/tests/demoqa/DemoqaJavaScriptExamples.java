package com.testingservice.tests.demoqa;

import com.testingservice.utility.Url;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DemoqaJavaScriptExamples {
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

        JavascriptExecutor executor = (JavascriptExecutor) driver;

        driver.get(Url.DEMOQA_TEXT_BOX.getUrl());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Actions action = new Actions(driver);

        //**FULL NAME**
        executor.executeScript("document.getElementById('userName').setAttribute(\"value\", \"Lesan Eugeniu\");");
        //**EMAIL**
        executor.executeScript("document.getElementById('userEmail').setAttribute(\"value\", \"eugeniu_only_buisness@moldova.md\");");
        //**CURRENT ADDRESS**
        executor.executeScript("document.getElementById('currentAddress').value = 'Brazilia 11/2'");
        //**PERMANENT ADDRESS**
        executor.executeScript("document.getElementById('permanentAddress').value= 'Jamaica 99/3'");
        //Click Submit
        executor.executeScript("document.getElementById('submit').click()");
        //Click Check Box
        executor.executeScript("document.getElementById('item-1').click()");
        //Click Expand All
        executor.executeScript("document.querySelector('[title=\"Expand all\"]').click()");
        //Click WorkSpace
        executor.executeScript("var xpath = \"//span[text()='WorkSpace']\";\n" +
                "var matchingElement = document.evaluate(xpath, document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue;" +
                "matchingElement.click()");
        //Click Radio Button
        executor.executeScript("var xpath = \"//span[text()='Radio Button']\";\n" +
                "var matchingElement = document.evaluate(xpath, document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue;" +
                "matchingElement.click()");
        //Click Impressive
        executor.executeScript("var xpath = \"//label[text()='Impressive']\";\n" +
                "var matchingElement = document.evaluate(xpath, document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue;" +
                "matchingElement.click()");
    }
    @AfterClass
    public static void afterExecution(){
        driver.quit();
    }
}
