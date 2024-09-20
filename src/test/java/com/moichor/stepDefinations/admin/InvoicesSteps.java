package com.moichor.stepDefinations.admin;

import com.moichor.base.DriverFactory;
import com.moichor.pages.AdminInvoicePage;
import io.cucumber.java.en.Then;
import org.openqa.selenium.JavascriptExecutor;


public class InvoicesSteps extends  DriverFactory{

    private final AdminInvoicePage adminInvoicePage;
    private final JavascriptExecutor js;

    public InvoicesSteps()
    {
        this.driver= DriverFactory.getDriver();
        this.adminInvoicePage=new AdminInvoicePage(driver);
        this.js=(JavascriptExecutor) driver;
    }

    @Then("generate the invoices")
    public void generateTheInvoices(){

        adminInvoicePage.clickOnInvoices();
        adminInvoicePage.generateInvoices();
    }

    @Then("search for an existing invoice")
    public void searchForAnExistingInvoice()  {
        adminInvoicePage.clickOnInvoices();
        adminInvoicePage.searchForInvoice();
    }

    @Then("search for an existing invoice between dates")
    public void searchForAnExistingInvoiceBetweenDates() {
        adminInvoicePage.clickOnInvoices();
        adminInvoicePage.searchInvoiceBetweenDates();
    }

    @Then("search for the particular invoice")
    public void searchForTheParticularInvoice() {
        adminInvoicePage.clickOnInvoices();
        adminInvoicePage.searchTheInvoiceByEnteringHospitalName();

    }

    @Then("check for each payment status")
    public void checkForEachPaymentStatus() {
        adminInvoicePage.clickOnInvoices();
        adminInvoicePage.checkThePaymentStatus();

    }

    @Then("issue the invoice for created payment status")
    public void issueTheInvoiceForCreatedPaymentStatus(){

        adminInvoicePage.issueTheInvoice();

    }

    @Then("download the invoice from an existing invoice")
    public void downloadTheInvoiceFromAnExistingInvoice() {
        adminInvoicePage.clickOnInvoices();
        adminInvoicePage.downloadTheInvoice();

    }

    @Then("edit the price of any issued invoice")
    public void editThePriceOfAnyIssuedInvoice(){
        adminInvoicePage.clickOnInvoices();
        adminInvoicePage.editThePriceOFInvoice();

    }

    @Then("mark the invoice as paid")
    public void markTheInvoiceAsPaid() {
        adminInvoicePage.markInvoiceAsPaid();
    }

    @Then("send the invoice email")
    public void sendTheInvoiceEmail() {
        adminInvoicePage.clickOnInvoices();
        adminInvoicePage.getNada();
        adminInvoicePage.sendTheInvoiceEmail();

    }

    @Then("cancel some order")
    public void cancelSomeOrder(){
        adminInvoicePage.cancelSomeOrders();

    }

}
