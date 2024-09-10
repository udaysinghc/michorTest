package com.moichor.stepDefinations.admin;

import com.moichor.base.DriverFactory;
import com.moichor.pages.AdminLogisticsPage;
import io.cucumber.java.en.Then;
import org.openqa.selenium.JavascriptExecutor;


public class LogisticsPageSteps extends DriverFactory {

    private final AdminLogisticsPage adminLogisticsPage;
    private final JavascriptExecutor js;

    public LogisticsPageSteps()
    {
        this.driver= DriverFactory.getDriver();
        this.adminLogisticsPage=new AdminLogisticsPage(driver);
        this.js=(JavascriptExecutor) driver;
    }

    @Then("search the sample request by tracking number")
    public void searchTheSampleRequestByTrackingNumber() throws InterruptedException {
        adminLogisticsPage.searchTheSampleRequest();
    }

    @Then("search the sample request between the dates")
    public void searchTheSampleRequestBetweenTheDates() {
        adminLogisticsPage.checkTheDateFunctionality();
    }

    @Then("search the sample request by selecting clinic")
    public void searchTheSampleRequestBySelectingClinic() throws InterruptedException {
        adminLogisticsPage.searchSampleByEnterClinic();
    }

    @Then("check the shipment status")
    public void checkTheShipmentStatus() {
        adminLogisticsPage.clickOnEachShipmentStatus();
    }

    @Then("search the supplies requests by tracking number")
    public void searchTheSuppliesRequestsByTrackingNumber() {
        adminLogisticsPage.searchTheSuppliesRequest();
    }

    @Then("search the supplies between dates")
    public void searchTheSuppliesBetweenDates() {
        adminLogisticsPage.searchTheSuppliesBetweenDates();
    }

    @Then("search the supplies by selecting clinic")
    public void searchTheSuppliesBySelectingClinic() throws InterruptedException {
        adminLogisticsPage.searchSuppliesByClinicName();
    }


    @Then("add supplies request")
    public void addSuppliesRequest() {

    }
}
