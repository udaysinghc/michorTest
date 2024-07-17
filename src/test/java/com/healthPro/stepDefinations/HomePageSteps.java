package com.healthPro.stepDefinations;

import com.healthPro.base.DriverFactory;
import com.healthPro.pages.HomePage;
import io.cucumber.java.en.Then;
import org.openqa.selenium.JavascriptExecutor;

public class HomePageSteps extends DriverFactory {

    private final HomePage homePage;
    private final JavascriptExecutor js;

    public HomePageSteps()
    {
        this.driver= DriverFactory.getDriver();
        this.homePage=new HomePage(driver);
        this.js=(JavascriptExecutor) driver;
    }

    @Then("add a client from home page")
    public void addAClientFromHomePage() {

        homePage.addClient();

    }


    @Then("added client is displayed on client page and delete it")
    public void addedClientIsDisplayedOnClientPageAndDeleteIt() {
        homePage.clickOnCancelButton();
        homePage.deleteTheAddedClient();
    }


    @Then("search for a patient and turn on the colony mode and update the patient")
    public void searchForAPatientAndTurnOnTheColonyModeAndUpdateThePatient() throws InterruptedException {

        homePage.turnOnColonyMode();
    }

    @Then("add a test from select test menu")
    public void addATestFromSelectTestMenu() throws InterruptedException {
        homePage.selectClientPatient();
        homePage.selectTestMenu();

    }

    @Then("click on create shipping label element")
    public void clickOnCreateShippingLabelElement() throws InterruptedException {
        homePage.clickOnShippingLabel();

    }

    @Then("search for a patient and update a patient")
    public void searchForAPatientAndUpdateAPatient() {
        homePage.updateThePatient();
    }


}
