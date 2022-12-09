package com.testingservice.saucedemopom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPom {
    private static final String USER_NAME = "standard_user";
    private static final String USER_PASSWORD = "secret_sauce";
    private static WebDriver driver;
    @FindBy(xpath = "//*[@id='user-name']")
    private WebElement userName;
    @FindBy(xpath = "//*[@id='password']")
    private WebElement password;
    @FindBy(xpath = "//*[@id='login-button']")
    private WebElement loginBtn;
    @FindBy(xpath = "//*[@class='title']")
    private WebElement title;

    public LoginPom(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getTitle() {
        return title.getText();
    }

    public void setUserName(String userNameString) {
        if (userNameString == null){
            userNameString = USER_NAME;
        }
        userName.clear();
        userName.sendKeys(userNameString);
    }

    public void setPassword(String passwordString) {
        if (passwordString == null){
            passwordString = USER_PASSWORD;
        }
        password.clear();
        password.sendKeys(passwordString);
    }

    public void login(String userNameString,
                      String passwordString){
        setUserName(userNameString);
        setPassword(passwordString);
        loginBtn.click();
    }
}
