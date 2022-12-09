package com.testingservice.saucedemopom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class InventoryPom {
    private static WebDriver driver;
    @FindBy(css = ".inventory_list .inventory_item")
    private List<WebElement> inventoryItem;
    @FindBy(xpath = "//*[@class='btn btn_primary btn_small btn_inventory']")
    private List<WebElement> addToCartBtn;
    @FindBy(xpath = "//*[@class='shopping_cart_link']")
    private WebElement goToCartBtn;
    @FindBy(xpath = "//*[@class='shopping_cart_badge']")
    private WebElement numberOfProductsInCart;
    @FindBy(xpath = "//*[@class='title']")
    private WebElement title;

    public InventoryPom(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getTitle() {
        return title.getText();
    }

    public int inventoryItemsCount(){
        return inventoryItem.size();
    }

    public void clickToAddButtons(){
        for(WebElement btn: addToCartBtn){
            btn.click();
        }
    }

    public int productsInCart(){
        return Integer.parseInt(numberOfProductsInCart.getText());
    }

    public void moveToCart(){
        goToCartBtn.click();
    }
}

