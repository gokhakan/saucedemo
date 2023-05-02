package com.sauce.pages;

import com.sauce.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YourInformationPage {
    public YourInformationPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(id = "first-name")
    public WebElement firstName;

    @FindBy(id = "last-name")
    public WebElement lastName;

    @FindBy(id = "postal-code")
    public WebElement postcode;

    @FindBy(id = "continue")
    public WebElement continueButton;
}
