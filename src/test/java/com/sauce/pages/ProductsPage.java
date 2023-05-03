package com.sauce.pages;

import com.sauce.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage extends LoginPage {
    public ProductsPage(){
        PageFactory.initElements(Driver.get(), this);
    }
    @FindBy (id = "add-to-cart-sauce-labs-backpack")
    public WebElement backpack;

    @FindBy (id = "add-to-cart-sauce-labs-bike-light")
    public WebElement bikeLight;

    @FindBy (id = "add-to-cart-sauce-labs-bolt-t-shirt")
    public WebElement tshirt;

    @FindBy (id = "add-to-cart-sauce-labs-fleece-jacket")
    public WebElement fleeceJacket;

    @FindBy (id = "add-to-cart-sauce-labs-onesie")
    public WebElement onesie;

    @FindBy (id = "shopping_cart_container")
    public WebElement cart;

    @FindBy (xpath = "//*[@id=\"cart_contents_container\"]/div/div[1]/div[3]/div[2]/div[2]/div")
    public WebElement price;

    @FindBy (css = ".inventory_item_price")
    public WebElement prices;

}
