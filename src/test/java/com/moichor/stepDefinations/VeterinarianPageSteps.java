package com.moichor.stepDefinations;

import com.moichor.base.DriverFactory;
import com.moichor.pages.VeterinarianPage;
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
    public void addAVeterinarian() {
        veterinarianPage.clickOnVetButton();
        veterinarianPage.addTheVet();
    }

    @Then("Added Veterinarian is displayed")
    public void addedVeterinarianIsDisplayed() {
        veterinarianPage.searchTheAddedVet();
    }

    @When("search for added Veterinarian and delete it")
    public void searchForAddedVeterinarianAndDeleteIt() {
        veterinarianPage.clickOnVetButton();
        veterinarianPage.searchTheAddedVet();
        veterinarianPage.deleteTheVet();
    }

    @Then("deleted Veterinarian is not displayed")
    public void deletedVeterinarianIsNotDisplayed() {

        veterinarianPage.searchTheDeleteVet();
    }


    @When("Edit a Veterinarian")
    public void editAVeterinarian() {
        veterinarianPage.clickOnVetButton();
        veterinarianPage.searchTheAddedVet();
        veterinarianPage.editTheVet();

    }


    @When("click on toggle button and verify the message")
    public void clickOnToggleButtonAndVerifyTheMessage()  {
        veterinarianPage.clickOnVetButton();
        veterinarianPage.verifyTheToggleButton();


    }
}
