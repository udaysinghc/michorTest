package com.healthPro.stepDefinations;

import com.healthPro.base.DriverFactory;
import com.healthPro.pages.AddNewSpeciesPage;
import com.healthPro.pages.BillingPage;
import io.cucumber.java.en.Then;
import org.openqa.selenium.JavascriptExecutor;

public class AddNewSpeciesPageSteps extends DriverFactory {


    private final AddNewSpeciesPage addNewSpeciesPage;
    private final JavascriptExecutor js;

    public AddNewSpeciesPageSteps()
    {
        this.driver= DriverFactory.getDriver();
        this.addNewSpeciesPage=new AddNewSpeciesPage(driver);
        this.js=(JavascriptExecutor) driver;
    }


    @Then("add a new species")
    public void addANewSpecies() throws InterruptedException {
        addNewSpeciesPage.clickOnAddSpeciesButton();
        addNewSpeciesPage.addSpecies();
    }


}
