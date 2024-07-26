package com.moichor.stepDefinations.admin;


import com.moichor.base.DriverFactory;
import com.moichor.pages.ClinicsPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.JavascriptExecutor;

public class ClinicsSteps extends DriverFactory {

    private final ClinicsPage clinicsPage;
    private final JavascriptExecutor js;

    public ClinicsSteps()
    {
        this.driver= DriverFactory.getDriver();
        this.clinicsPage=new ClinicsPage(driver);
        this.js=(JavascriptExecutor) driver;
    }

    @Then("Add A Clinic From the Clinics Module")
    public void addAClinicFromTheClinicsModule() throws InterruptedException {

        clinicsPage.clickOnClinicsButton();
        clinicsPage.addAClinics();
    }



    @Then("Added Clinic Is Displayed On Clinics Page")
    public void addedClinicIsDisplayedOnClinicsPage() {

        clinicsPage.searchForAddedClinic();
    }

    @Then("search for existing clinic")
    public void searchForExistingClinic() {
        clinicsPage.clickOnClinicsButton();
        clinicsPage.searchTheClinic();

    }

    @And("edit the clinic details")
    public void editTheClinicDetails() {
        clinicsPage.editTheClinic();
    }


}
