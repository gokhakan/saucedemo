package com.sauce.pages;

import com.sauce.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public LoginPage(){
        PageFactory.initElements(Driver.get(), this);
    }
    @FindBy (id = "user-name")
    public WebElement username;

    @FindBy (id = "password")
    public WebElement password;

    @FindBy (id = "login-button")
    public WebElement login;

    @FindBy (css = "button.error-button")
    public WebElement loginErrorMessage;
}
