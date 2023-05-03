package com.sauce.step_definitions;

import com.sauce.pages.*;
import com.sauce.utilities.ConfigurationReader;
import com.sauce.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.logging.Logger;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Steps {
    LoginPage loginPage = new LoginPage();
    ProductsPage productsPage = new ProductsPage();
    YourCartPage yourCartPage = new YourCartPage();
    YourInformationPage yourInformationPage = new YourInformationPage();
    OverviewPage overviewPage = new OverviewPage();

    Logger logger = Logger.getLogger(Steps.class.getName());

    @Given("user is on login page")
    public void user_is_on_login_page() {
        Driver.get().get(ConfigurationReader.get("url"));
        logger.info("INFO: User is logging in");

    }


    @When("user enters valid username and valid password")
    public void user_enters_valid_username_and_valid_password() {
        loginPage.username.clear();
        loginPage.username.sendKeys(ConfigurationReader.get("validUsername"));
        loginPage.password.clear();
        loginPage.password.sendKeys(ConfigurationReader.get("ValidPassword"));
        loginPage.login.click();
    }

    @Then("user is on {string} page")
    public void user_is_on_page(String actualPage) {

        logger.info("User is on page: " + actualPage);


        switch (actualPage) {
            case "Products":
                String expectedProductURL = "https://www.saucedemo.com/inventory.html";
                String actualURL = Driver.get().getCurrentUrl();
                assertEquals(expectedProductURL, actualURL);
                break;
            case "Checkout: Your Information":
                String expectedCheckoutURL = "https://www.saucedemo.com/checkout-step-one.html";
                String actualcheckoutURL = Driver.get().getCurrentUrl();
                assertEquals(expectedCheckoutURL, actualcheckoutURL);
                break;
            case "Overview":
                String expectedOverviewURL = "https://www.saucedemo.com/checkout-step-two.html";
                String actualOverviewURL = Driver.get().getCurrentUrl();
                assertEquals(expectedOverviewURL, actualOverviewURL);
                break;
            case "Complete":
                String expectedCompleteURL = "https://www.saucedemo.com/checkout-complete.html";
                String actualCompleteURL = Driver.get().getCurrentUrl();
                assertEquals(expectedCompleteURL, actualCompleteURL);
            default:
                logger.info("URL error");
        }
    }

    @When("user enters invalid username and invalid password")
    public void user_enters_invalid_username_and_invalid_password() {
        loginPage.username.clear();
        loginPage.username.sendKeys(ConfigurationReader.get("InValidUsername"));
        loginPage.password.clear();
        loginPage.password.sendKeys(ConfigurationReader.get("InValidPassword"));
        loginPage.login.click();
    }

    @Then("user sees the login error message")
    public void user_sees_the_login_error_message() {
        assertTrue(loginPage.loginErrorMessage.isDisplayed());
    }

    @Given("user is logged in  on {string} page")
    public void user_is_logged_in_on_page(String products) {
        Driver.get().get(ConfigurationReader.get("url"));
        loginPage.username.clear();
        loginPage.username.sendKeys(ConfigurationReader.get("validUsername"));
        loginPage.password.clear();
        loginPage.password.sendKeys(ConfigurationReader.get("ValidPassword"));
        loginPage.login.click();
    }

    @When("user adds {string} to the cart")
    public void user_adds_to_the_cart(String item) {
        productsPage.backpack.click();
    }

    @When("user clicks on {string}")
    public void user_clicks_on(String button) {
        System.out.println("button = " + button);
        switch (button) {
            case "Cart":
                productsPage.cart.click();
                break;
            case "checkout":
                yourCartPage.checkout.click();
                break;
            case "Finish":
                overviewPage.finish.click();
                break;
            default:
                logger.info("No item in cart");
        }
    }

    @Then("user sees the {string} for the {string}")
    public void user_sees_the_for_the(String rightPrice, String item) {
        String expectedBAckpackPrice = "$29.99";
        String actualBackpackPrice = productsPage.price.getText();
        assertEquals(expectedBAckpackPrice, actualBackpackPrice);
    }

    @Then("user enters {string}")
    public void user_enters(String value) {
        System.out.println("value = " + value);
        switch (value) {
            case "name":
                yourInformationPage.firstName.sendKeys(ConfigurationReader.get("purchaserName"));
                break;
            case "surname":
                yourInformationPage.lastName.sendKeys(ConfigurationReader.get("purchaserSurname"));
                break;
            case "postcode":
                yourInformationPage.postcode.sendKeys(ConfigurationReader.get("purchaserPostcode"));
                break;
            default:
                logger.info("Missing data");
        }

    }

    @Then("user clicks continue")
    public void user_clicks_continue() {
        yourInformationPage.continueButton.click();
    }

    @Given("user gets all prices")
    public void user_gets_all_prices() {
        List<WebElement> prices = Driver.driver.findElements(By.className("inventory_item_price"));
        System.out.println("prices.size() = " + prices.size());
        System.out.println("prices.get(5).getText() = " + prices.get(5).getText());
        for (int i = 0; i < prices.size(); i++) {
            System.out.println("Prices for item [ " + i + "] is = " + prices.get(i).getText());

        }
    }
    @Given("user gets all item names")
    public void user_gets_all_item_names() {
        List<WebElement>itemNames = Driver.driver.findElements(By.className("inventory_item_name"));
        for (int i = 0; i < itemNames.size(); i++) {
            System.out.println("ItemNames for "+i+ " = " + itemNames.get(i).getText());

        }
    }


}
