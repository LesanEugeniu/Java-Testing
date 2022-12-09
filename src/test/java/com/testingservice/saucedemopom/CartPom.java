package com.testingservice.saucedemopom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CartPom {
    private static WebDriver driver;
    @FindBy(xpath = "//*[@id='remove-sauce-labs-onesie']")
    private WebElement removeButtonElement;
    @FindBy(xpath = "//*[@id='checkout']")
    private WebElement checkoutButtonElements;
    @FindBy(css = ".cart_list .cart_item")
    private List<WebElement> cartItemsElements;
    @FindBy(xpath = "//*[@class='title']")
    private WebElement titleElement;

    public CartPom(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void removeElement(){
        removeButtonElement.click();
    }

    public int inventoryItemsCount(){
        return cartItemsElements.size();
    }

    public void pressCheckoutButton(){
        checkoutButtonElements.click();
    }

    public String getTitle() {
        return titleElement.getText();
    }
}

