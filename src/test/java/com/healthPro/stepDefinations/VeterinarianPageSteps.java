package com.healthPro.stepDefinations;

import com.healthPro.base.DriverFactory;
import com.healthPro.pages.VeterinarianPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.JavascriptExecutor;

public class VeterinarianPageSteps extends DriverFactory {

    private final  VeterinarianPage veterinarianPage;
    private final JavascriptExecutor js;


    public VeterinarianPageSteps()
    {
        this.driver= DriverFactory.getDriver();
        this.veterinarianPage=new VeterinarianPage(driver);
        this.js=(JavascriptExecutor) driver;

    }


    @When("Add a veterinarian")
    public void addAVeterinarian() throws InterruptedException {
        veterinarianPage.clickOnVetButton();
        veterinarianPage.addTheVet();
    }

    @Then("Added Veterinarian is displayed")
    public void addedVeterinarianIsDisplayed() throws InterruptedException {
        veterinarianPage.searchTheAddedVet();
    }

    @When("search for added Veterinarian and delete it.")
    public void searchForAddedVeterinarianAndDeleteIt() throws InterruptedException {
        veterinarianPage.clickOnVetButton();
        veterinarianPage.searchTheAddedVet();
        veterinarianPage.deleteTheVet();
    }

    @Then("deleted Veterinarian is not displayed")
    public void deletedVeterinarianIsNotDisplayed() throws InterruptedException {

        veterinarianPage.searchTheAddedVet();
    }



}
