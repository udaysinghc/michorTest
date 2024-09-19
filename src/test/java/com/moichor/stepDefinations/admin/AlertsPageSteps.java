package com.moichor.stepDefinations.admin;

import com.moichor.base.DriverFactory;
import com.moichor.pages.AlertsPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.JavascriptExecutor;

public class AlertsPageSteps extends DriverFactory {

    private final AlertsPage alertsPage;
    private final JavascriptExecutor js;

    public AlertsPageSteps()
    {
        this.driver= DriverFactory.getDriver();
        this.alertsPage=new AlertsPage(driver);
        this.js=(JavascriptExecutor) driver;
    }

    @Then("add a alerts")
    public void addAAlerts()  {
        alertsPage.addAAlerts();
    }

    @And("search for added alerts")
    public void searchForAddedAlerts() {
        alertsPage.searchTheAddedAlerts();
    }

    @Then("edit the alerts")
    public void editTheAlerts()  {
        alertsPage.editTheAlerts();
    }

    @Then("delete the alerts")
    public void deleteTheAlerts() {
        alertsPage.deleteTheAlerts();
    }

    @Then("check the functionality of all button")
    public void checkTheFunctionalityOfAllButton() {
        alertsPage.clickAllTHeButton();
    }


}
