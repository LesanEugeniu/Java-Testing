package com.testingservice.tests.saucedemo;

import com.testingservice.saucedemopom.LoginPom;
import com.testingservice.utility.Url;
import com.testingservice.utility.WaitUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LoginTest {
    static final Logger logger = Logger.getLogger(LoginTest.class.getName());
    private static final String USER_NAME = "standard_user";
    private static final String USER_PASSWORD = "secret_sauce";
    private static WebDriver driver;
    private By title =  By.xpath("//*[@class='title']");

    @BeforeClass
    public static void setUpProperty(){
        /**CHROME DRIVER**/
//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
        /** FIREFOX DRIVER**/
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();

        driver.manage().window().maximize();

        driver.get(Url.SAUCEDEMO.getUrl());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @Test(description = "Logging in",
            timeOut = 3000,
            groups = "saucedemo")
    public void sauceTest() throws InterruptedException {
        logger.info("Test Start");
        LoginPom loginPage = new LoginPom(driver);
        loginPage.login(USER_NAME, USER_PASSWORD);
        String expectedTitle = "PRODUCTS";
        logger.info("ExpectedTitle: " + expectedTitle);
        WaitUtils.explicit(driver, ExpectedConditions.visibilityOfElementLocated(title),1);
        String actualTitle = loginPage.getTitle();
        logger.info("ActualTitle: " + actualTitle);
        Assert.assertEquals(expectedTitle, actualTitle);
        logger.info("Test Finished");
    }

    @AfterClass
    public static void afterClass(){
        driver.quit();
    }
}
