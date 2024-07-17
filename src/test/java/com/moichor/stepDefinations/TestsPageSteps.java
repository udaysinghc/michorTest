package com.moichor.stepDefinations;

import com.moichor.base.DriverFactory;
import com.moichor.pages.TestsPage;
import io.cucumber.java.en.Then;
import org.openqa.selenium.JavascriptExecutor;

public class TestsPageSteps extends DriverFactory {


    private final TestsPage testsPage;
    private final JavascriptExecutor js;


    public TestsPageSteps()
    {
        this.driver= DriverFactory.getDriver();
        this.testsPage=new TestsPage(driver);
        this.js=(JavascriptExecutor) driver;

    }


    @Then("add a test")
    public void addATest() throws InterruptedException {
        testsPage.clickOnTestButton();
        testsPage.addATest();
        testsPage.searchForAddedTest();

    }

    @Then("edit the test")
    public void editTheTest() {
        testsPage.clickOnTestButton();
        testsPage.editTheTest();


    }

    @Then("delete the test")
    public void deleteTheTest() throws InterruptedException {
        testsPage.clickOnTestButton();
        testsPage.deleteTest();

    }

    @Then("check all test status")
    public void checkAllTestStatus() throws InterruptedException {
        testsPage.clickOnTestButton();
        testsPage.testStatus();
    }

    @Then("check for info sheet")
    public void checkForInfoSheet() throws InterruptedException {
        testsPage.clickOnTestButton();
        testsPage.infoSheet();
    }

    @Then("archive the test")
    public void archiveTheTest() throws InterruptedException {
        testsPage.clickOnTestButton();
        testsPage.clickOnArchive();
    }

    @Then("archive test is displayed on archive page")
    public void archiveTestIsDisplayedOnArchivePage() {
        testsPage.searchTheArchiveTest();
    }

    @Then("select the veterinarian from test module")
    public void selectTheVeterinarianFromTestModule() throws InterruptedException {
        testsPage.clickOnTestButton();
        testsPage.clickOnVetDropDown();

    }

    @Then("search for existing patient from test module")
    public void searchForExistingPatientFromTestModule() {
        testsPage.clickOnTestButton();
        testsPage.searchThePatientName();

    }
}
