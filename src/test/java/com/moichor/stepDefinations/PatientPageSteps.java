package com.moichor.stepDefinations;

import com.moichor.base.DriverFactory;
import com.moichor.pages.PatientPage;
import io.cucumber.java.en.Then;
import org.openqa.selenium.JavascriptExecutor;

public class PatientPageSteps extends DriverFactory {

    private final PatientPage patientPage;
    private final JavascriptExecutor js;

    public PatientPageSteps()
    {
        this.driver= DriverFactory.getDriver();
        this.patientPage=new PatientPage(driver);
        this.js=(JavascriptExecutor) driver;
    }

    @Then("Add a patient from patient page")
    public void addAPatientFromPatientPage() throws InterruptedException {
        patientPage.clickOnClientButton();
        patientPage.addClient();
        patientPage.addPatient();

    }

    @Then("edit the patient from patient page")
    public void editThePatientFromPatientPage() {
        patientPage.clickOnPatientButton();
        patientPage.selectTheAddedPatient();
        patientPage.editedThePatient();

    }

    @Then("edited data is displayed on patient")
    public void editedDataIsDisplayedOnPatient() {
        patientPage.clickOnPatientButton();
        patientPage.selectTheAddedPatient();
    }

    @Then("delete the patient from patient page")
    public void deleteThePatientFromPatientPage() {
        patientPage.clickOnPatientButton();
        patientPage.selectTheAddedPatient();
        patientPage.deleteThePatient();

    }


    @Then("deleted patient is not display on patient page")
    public void deletedPatientIsNotDisplayOnPatientPage()  {
        patientPage.clickOnPatientButton();
        patientPage.searchTheDeletedPatient();

    }

    @Then("Add a test to added patient")
    public void addATestToAddedPatient() throws InterruptedException {
        patientPage.clickOnPatientButton();
        patientPage.selectTheAddedPatient();
        patientPage.addTest();

    }


    @Then("Added test is displayed on test page")
    public void addedTestIsDisplayedOnTestPage() {
        patientPage.searchTheTest();
    }



}
