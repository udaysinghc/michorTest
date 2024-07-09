package com.healthPro.stepDefinations;

import com.healthPro.base.DriverFactory;
import com.healthPro.pages.ClientsPage;
import com.healthPro.pages.VeterinarianPage;
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
    public void addAClient() throws InterruptedException {
        clientsPage.clickOnClientButton();
        clientsPage.addClient();

    }

    @Then("Added client is displayed")
    public void addedClientIsDisplayed() throws InterruptedException {

        clientsPage.searchTheAddedClient();
    }

    @When("Select the added client")
    public void selectTheAddedClient() throws InterruptedException {
        clientsPage.clickOnClientButton();
        clientsPage.selectClient();
    }

    @And("add a patient")
    public void addAPatient() throws InterruptedException {
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
    public void deleteTheSelectedClient() throws InterruptedException {
        clientsPage.deleteTheAddedClient();

    }

    @Then("deleted client is not displayed")
    public void deletedClientIsNotDisplayed() throws InterruptedException {
        clientsPage.searchTheDeletedClient();

    }
}
