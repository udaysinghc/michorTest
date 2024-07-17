package com.healthPro.stepDefinations;

import com.healthPro.base.DriverFactory;
import com.healthPro.pages.BillingPage;
import com.healthPro.pages.LogisticsPage;
import io.cucumber.java.en.Then;
import org.openqa.selenium.JavascriptExecutor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogisticsPageSteps extends DriverFactory{


    private static final Logger log = LoggerFactory.getLogger(LogisticsPageSteps.class);
    private final LogisticsPage logisticsPage;
    private final JavascriptExecutor js;

    public LogisticsPageSteps()
    {
        this.driver= DriverFactory.getDriver();
        this.logisticsPage=new LogisticsPage(driver);
        this.js=(JavascriptExecutor) driver;
    }

    @Then("select the sample to include in shipping")
    public void selectTheSampleToIncludeInShipping() throws InterruptedException {
        logisticsPage.clickOnLogisticButton();
        logisticsPage.clickOnSample();
    }

    @Then("Select items for supplies")
    public void selectItemsForSupplies() throws InterruptedException {
        logisticsPage.clickOnLogisticButton();
        logisticsPage.clickOnSupplies();
    }
}
