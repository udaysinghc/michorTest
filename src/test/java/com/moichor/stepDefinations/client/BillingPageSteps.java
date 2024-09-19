package com.moichor.stepDefinations.client;

import com.moichor.base.DriverFactory;
import com.moichor.pages.BillingPage;
import io.cucumber.java.en.Then;
import org.openqa.selenium.JavascriptExecutor;

public class BillingPageSteps extends DriverFactory {

    private final BillingPage billingPage;
    private final JavascriptExecutor js;

    public BillingPageSteps()
    {
        this.driver= DriverFactory.getDriver();
        this.billingPage=new BillingPage(driver);
        this.js=(JavascriptExecutor) driver;
    }

    @Then("check for an existing invoice")
    public void checkForAnExistingInvoice() {
        billingPage.clickOnBillingButton();
        billingPage.clickOnParticularInvoice();

    }

    @Then("check for download invoice pdf")
    public void checkForDownloadInvoicePdf(){
        billingPage.clickOnBillingButton();
        billingPage.clickOnParticularInvoice();
        billingPage.clickOnPDFButton();

    }



}
