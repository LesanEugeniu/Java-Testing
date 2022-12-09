package com.testingservice.tests.demoqa;

import com.testingservice.utility.Url;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.List;

public class DemoqaForm {
    private static WebDriver driver;
    @BeforeClass
    public static void beforeClass(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

//        System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver.exe");
//        driver = new FirefoxDriver();


    }

    @Test
    public void testDemoqaForm() throws InterruptedException {
        driver.get(Url.DEMOQA_FORM.getUrl());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        JavascriptExecutor executor = (JavascriptExecutor) driver;

        executor.executeScript("var elem = document.getElementById('adplus-anchor');" +
                "elem.parentNode.removeChild(elem);");

        //First Name
        driver.findElement(By.xpath("*//*[@id='firstName']")).sendKeys("Lesan");
        //Last Name
        driver.findElement(By.xpath("*//*[@id='lastName']")).sendKeys("Eugeniu");
        //Email
        driver.findElement(By.xpath("*//*[@id='userEmail']")).sendKeys("eugeniu_only_buisness@moldova.md");
        //Gender
        driver.findElement(By.xpath("*//label[@for='gender-radio-1']")).click();
        //Mobile
        driver.findElement(By.xpath("*//*[@id='userNumber']")).sendKeys("0612344321");
        //Date of Birth
        WebElement date = driver.findElement(By.xpath("*//*[@id='dateOfBirthInput']"));
        date.sendKeys(Keys.LEFT_CONTROL + "a");
        date.sendKeys("07 Dec 2003");
        date.sendKeys(Keys.ESCAPE);
        //Subjects
        WebElement subjects = driver.findElement(By.xpath("*//*[@id='subjectsInput']"));
        subjects.click();
        subjects.sendKeys("co");
        subjects.sendKeys(Keys.ENTER);
        //Hobbies
        driver.findElement(By.xpath("*//label[@for='hobbies-checkbox-1']")).click();
        driver.findElement(By.xpath("*//label[@for='hobbies-checkbox-3']")).click();
        //Picture
        driver.findElement(By.xpath("*//input[@type='file']")).sendKeys("D:\\Projects\\TestingProject\\src\\test\\resources\\images\\neo.jpg");
        //Current Adress
        driver.findElement(By.xpath("*//*[@id='currentAddress']")).sendKeys("Stradela macilor nr.5");
        //State
        WebElement state = driver.findElement(By.xpath("*//*[@id='state']"));
        executor.executeScript("var elem = document.getElementById('fixedban'); elem.parentNode.removeChild(elem)");
        executor.executeScript("arguments[0].scrollIntoView(true);",state);
        state.click();
        List<WebElement> stateOptions = driver
                .findElements(By.xpath("*//*[@class=' css-2b097c-container']//*[contains(@class,'option')]"));
        driver.findElement(By.xpath("*//*[text()='"+stateOptions.get(0).getText()+"']")).click();
        //State and City
        WebElement stateAndCity = driver.findElement(By.xpath("*//*[@class=' css-yk16xz-control']"));
        executor.executeScript("arguments[0].scrollIntoView(true);",stateAndCity);
        stateAndCity.click();
        List<WebElement> stateAndCityOptions = driver
                .findElements(By.xpath("*//*[@class=' css-26l3qy-menu']//*[contains(@class,'option')]"));
        driver.findElement(By.xpath("*//*[text()='"+stateAndCityOptions.get(0).getText()+"']")).click();
        //Submit
        driver.findElement(By.xpath("*//button[@id='submit']")).submit();

        Thread.sleep(2000);
        String studentName = driver.findElement(By.xpath("*//*[contains(text(),'Lesan')]")).getText();
        Assert.assertEquals("Lesan Eugeniu", studentName);
        String studentEmail = driver.findElement(By.xpath("*//*[contains(text(),'@moldova.md')]")).getText();
        Assert.assertEquals("eugeniu_only_buisness@moldova.md", studentEmail);
        String gender = driver.findElement(By.xpath("*//*[contains(text(),'Male')]")).getText();
        Assert.assertEquals("Male", gender);
        String mobile = driver.findElement(By.xpath("*//*[contains(text(),'06123')]")).getText();
        Assert.assertEquals("0612344321", mobile);
        String dateOfBirth = driver.findElement(By.xpath("*//*[contains(text(),'December')]")).getText();
        Assert.assertEquals("07 December,2003", dateOfBirth);
        String subjectss = driver.findElement(By.xpath("*//*[contains(text(),'Science')]")).getText();
        Assert.assertEquals("Computer Science", subjectss);
        String hobbies = driver.findElement(By.xpath("*//*[contains(text(),', Music')]")).getText();
        Assert.assertEquals("Sports, Music", hobbies);
        String picture = driver.findElement(By.xpath("*//*[contains(text(),'o.jpg')]")).getText();
        Assert.assertEquals("neo.jpg", picture);
        String address = driver.findElement(By.xpath("*//*[contains(text(),'macilor')]")).getText();
        Assert.assertEquals("Stradela macilor nr.5", address);
        String stateAndCityy = driver.findElement(By.xpath("*//*[contains(text(),'R Delhi')]")).getText();
        Assert.assertEquals("NCR Delhi", stateAndCityy);

    }

    @AfterClass
    public static void afterClass(){
        driver.quit();
    }
}
