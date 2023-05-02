package com.sauce.pages;

import com.sauce.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YourCartPage {
    public YourCartPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(id = "checkout")
    public WebElement checkout;
}
