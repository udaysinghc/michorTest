package com.moichor.stepDefinations.client;

import com.moichor.base.DriverFactory;
import com.moichor.pages.AddNewSpeciesPage;
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
    public void addANewSpecies(){
        addNewSpeciesPage.clickOnAddSpeciesButton();
        addNewSpeciesPage.addSpecies();
    }


}
