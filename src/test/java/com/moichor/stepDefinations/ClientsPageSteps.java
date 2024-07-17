package com.moichor.stepDefinations;

import com.moichor.base.DriverFactory;
import com.moichor.pages.ClientsPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.JavascriptExecutor;

public class ClientsPageSteps extends DriverFactory {

    private final ClientsPage clientsPage;
    private final JavascriptExecutor js;


    public ClientsPageSteps()
    {
        this.driver= DriverFactory.getDriver();
        this.clientsPage=new ClientsPage(driver);
        this.js=(JavascriptExecutor) driver;

    }

    @When("Add a Client")
    public void addAClient() {
        clientsPage.clickOnClientButton();
        clientsPage.addClient();

    }

    @Then("Added client is displayed")
    public void addedClientIsDisplayed()  {

        clientsPage.searchTheAddedClient();
    }

    @When("Select the added client")
    public void selectTheAddedClient() throws InterruptedException {
        clientsPage.clickOnClientButton();
        clientsPage.selectClient();
    }

    @And("add a patient")
    public void addAPatient()  {
        clientsPage.clickOnNewPatient();
        clientsPage.addPatient();
    }


    @Then("patient is displayed")
    public void patientIsDisplayed() throws InterruptedException {
        clientsPage.clickOnClientButton();
        clientsPage.selectClient();
        clientsPage.searchTheAddedPatient();


    }

    @And("delete the selected client")
    public void deleteTheSelectedClient() {
        clientsPage.deleteTheAddedClient();

    }

    @Then("deleted client is not displayed")
    public void deletedClientIsNotDisplayed()  {
        clientsPage.searchTheDeletedClient();

    }


    @When("edit the client")
    public void editTheClient() throws InterruptedException {
        clientsPage.clickOnClientButton();
        clientsPage.selectClient();
        clientsPage.editTheClient();

    }

    @Then("edited data is displayed")
    public void editedDataIsDisplayed() throws InterruptedException {
        clientsPage.selectClient();
    }

    @When("edit the patient")
    public void editThePatient() throws InterruptedException {
        clientsPage.clickOnClientButton();
        clientsPage.selectClient();
        clientsPage.editThePatient();

    }

    @Then("edited data is displayed in patient")
    public void editedDataIsDisplayedInPatient()  {
        clientsPage.searchTheEditedPatient();
    }


    @When("delete the patient")
    public void deleteThePatient() throws InterruptedException {
        clientsPage.clickOnClientButton();
        clientsPage.selectClient();
        clientsPage.deleteThePatient();

    }

    @Then("deleted patient is not display")
    public void deletedPatientIsNotDisplay() throws InterruptedException {
        clientsPage.clickOnClientButton();
        clientsPage.selectClient();
        clientsPage.searchTheDeletedPatient();



    }


}
