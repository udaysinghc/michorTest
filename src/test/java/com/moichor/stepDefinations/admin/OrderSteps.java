package com.moichor.stepDefinations.admin;



import com.moichor.base.DriverFactory;
import com.moichor.pages.AdminOrderPage;
import io.cucumber.java.en.Then;
import org.openqa.selenium.JavascriptExecutor;


public class OrderSteps extends DriverFactory {

    private final AdminOrderPage adminOrderPage;
    private final JavascriptExecutor js;

    public OrderSteps()
    {
        this.driver= DriverFactory.getDriver();
        this.adminOrderPage=new AdminOrderPage(driver);
        this.js=(JavascriptExecutor) driver;
    }

    @Then("search for an existing order")
    public void thenSearchForAnExistingOrder() {
        adminOrderPage.clickOnOrdersButton();
        adminOrderPage.searchTheExistingOrder();
    }

    @Then("download the statistic functionality")
    public void downloadTheStatisticFunctionality() {
        adminOrderPage.clickOnOrdersButton();
        adminOrderPage.clickOnDownloadStaticsButton();

    }

    @Then("search the order while entering date")
    public void searchTheOrderWhileEnteringDate() {

        adminOrderPage.clickOnOrdersButton();
        adminOrderPage.enterStartAndEndDate();
    }

    @Then("select the clinic and species from dropdown")
    public void selectTheClinicAndSpeciesFromDropdown()  {
        adminOrderPage.clickOnOrdersButton();
        adminOrderPage.searchTheTest();
    }

    @Then("check all test status in admin portal")
    public void checkAllTestStatusInAdminPortal()  {
        adminOrderPage.clickOnOrdersButton();
        adminOrderPage.testStatus();
    }

    @Then("Edit the patient from order page")
    public void editThePatientFromOrderPage() {

        adminOrderPage.clickOnOrdersButton();
        adminOrderPage.editThePatient();

    }


    @Then("upload the image and send a message with image")
    public void uploadTheImageAndSendAMessageWithImage()  {
        adminOrderPage.clickOnOrdersButton();
        adminOrderPage.uploadImage();
        adminOrderPage.sendMessage();
    }

    @Then("reply to that message")
    public void replyToThatMessage() {
        adminOrderPage.replyMessage();
    }

    @Then("turn on historical toggle button")
    public void turnOnHistoricalToggleButton()  {
        adminOrderPage.turnOnToggle();
    }

    @Then("check for validation test status")
    public void checkForValidationTestStatus()  {
        adminOrderPage.clickOnOrdersButton();
        adminOrderPage.testValidationStatus();
    }
}
