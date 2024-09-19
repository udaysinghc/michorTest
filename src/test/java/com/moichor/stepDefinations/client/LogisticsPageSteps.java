package com.moichor.stepDefinations.client;

import com.moichor.base.DriverFactory;
import com.moichor.pages.LogisticsPage;
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
    public void selectTheSampleToIncludeInShipping() {
        logisticsPage.clickOnLogisticButton();
        logisticsPage.clickOnSample();
    }

    @Then("Select items for supplies")
    public void selectItemsForSupplies(){
        logisticsPage.clickOnLogisticButton();
        logisticsPage.clickOnSupplies();
    }

    @Then("search the sample shipment between dates")
    public void searchTheSampleShipmentBetweenDates() {
        logisticsPage.searchTheSampleShipment();
    }
}
