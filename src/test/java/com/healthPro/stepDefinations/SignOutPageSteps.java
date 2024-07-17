package com.healthPro.stepDefinations;

import com.healthPro.base.DriverFactory;
import com.healthPro.pages.BillingPage;
import com.healthPro.pages.SignOutPage;
import io.cucumber.java.en.Then;
import org.openqa.selenium.JavascriptExecutor;

public class SignOutPageSteps extends DriverFactory {

    private final SignOutPage signOutPage;
    private final JavascriptExecutor js;

    public SignOutPageSteps()
    {
        this.driver= DriverFactory.getDriver();
        this.signOutPage=new SignOutPage(driver);
        this.js=(JavascriptExecutor) driver;
    }


    @Then("sign out from the application")
    public void signOutFromTheApplication() throws InterruptedException {
        signOutPage.clickOnSignOutButton();
    }

    @Then("login page is displayed")
    public void loginPageIsDisplayed() {
        signOutPage.loginPage();

    }
}
