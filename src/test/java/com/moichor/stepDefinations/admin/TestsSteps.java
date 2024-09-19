package com.moichor.stepDefinations.admin;

import com.moichor.base.DriverFactory;
import com.moichor.pages.AdminTestPage;
import io.cucumber.java.en.Then;
import org.openqa.selenium.JavascriptExecutor;

public class TestsSteps extends DriverFactory {


    private final AdminTestPage adminTestPage;
    private final JavascriptExecutor js;

    public TestsSteps()
    {
        this.driver= DriverFactory.getDriver();
        this.adminTestPage=new AdminTestPage(driver);
        this.js=(JavascriptExecutor) driver;
    }

    @Then("search for an existing test by entering patient id or patient name")
    public void searchForAnExistingTestByEnteringPatientIdOrPatientName() {
        adminTestPage.clickOnTestButton();
        adminTestPage.clickOnReviewButton();
        adminTestPage.searchForAnExistingTest();
    }

    @Then("search for an existing test by entering start and end date")
    public void searchForAnExistingTestByEnteringStartAndEndDate() {
        adminTestPage.clickOnTestButton();
        adminTestPage.clickOnReviewButton();
        adminTestPage.searchAnExistingTestByEnteringDate();
    }

    @Then("search for QC and Resulting")
    public void searchForQCAndResulting(){
        adminTestPage.clickOnTestButton();
        adminTestPage.clickOnQCLink();
        adminTestPage.searchQCResult();
    }

    @Then("search multiple status from applicable status dropdown")
    public void searchMultipleStatusFromApplicableStatusDropdown(){
        adminTestPage.clickOnTestButton();
        adminTestPage.clickOnQCLink();
        adminTestPage.searchTheApplicationStatus();

    }

    @Then("search for an existing test")
    public void searchForAnExistingTest(){
        adminTestPage.selectTheTestID();
        adminTestPage.clickOnQCLink();
        adminTestPage.searchForAnTest();

    }


}
