package com.moichor.stepDefinations.admin;


import com.moichor.base.DriverFactory;
import com.moichor.pages.AdminPatientPage;
import io.cucumber.java.en.Then;
import org.openqa.selenium.JavascriptExecutor;

public class PatientSteps extends DriverFactory {

    private final AdminPatientPage adminPatientPage;
    private final JavascriptExecutor js;

    public PatientSteps()
    {
        this.driver= DriverFactory.getDriver();
        this.adminPatientPage=new AdminPatientPage(driver);
        this.js=(JavascriptExecutor) driver;
    }


    @Then("search for an existing patient")
    public void searchForAnExistingPatient() {
        adminPatientPage.clickOnPatientButton();
        adminPatientPage.searchForAnExistingPatient();
    }


}
