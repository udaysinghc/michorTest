package com.moichor.stepDefinations.client;

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

    @Then("Add a Client")
    public void addAClient() {
        clientsPage.clickOnClientButton();
        clientsPage.addClient();

    }

    @Then("Added client is displayed")
    public void addedClientIsDisplayed()  {

        clientsPage.searchTheAddedClient();
    }


    @Then("add a patient")
    public void addAPatient()  {
        clientsPage.clickOnClientButton();
        clientsPage.clickOnNewPatient();
        clientsPage.addPatient();
    }



    @And("delete the selected client")
    public void deleteTheSelectedClient() {
        clientsPage.clickOnClientButton();
        clientsPage.deleteTheAddedClient();

    }

    @Then("deleted client is not displayed")
    public void deletedClientIsNotDisplayed()  {
        clientsPage.searchTheDeletedClient();

    }


    @Then("edit the client")
    public void editTheClient() {
        clientsPage.clickOnClientButton();
        clientsPage.editTheClient();

    }

    @When("delete the patient")
    public void deleteThePatient() {
        clientsPage.clickOnClientButton();
        clientsPage.deleteThePatient();

    }


}
