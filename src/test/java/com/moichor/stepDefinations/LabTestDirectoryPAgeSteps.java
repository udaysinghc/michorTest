package com.moichor.stepDefinations;

import com.moichor.base.DriverFactory;
import com.moichor.pages.LabTestDirectoryPage;
import io.cucumber.java.en.Then;
import org.openqa.selenium.JavascriptExecutor;

public class LabTestDirectoryPAgeSteps  extends DriverFactory{

    private final LabTestDirectoryPage labTestDirectoryPage;
    private final JavascriptExecutor js;

    public LabTestDirectoryPAgeSteps()
    {
        this.driver= DriverFactory.getDriver();
        this.labTestDirectoryPage=new LabTestDirectoryPage(driver);
        this.js=(JavascriptExecutor) driver;
    }

    @Then("check the Lab Test Directory page")
    public void checkTheLabTestDirectoryPage() {

        labTestDirectoryPage.clickOnLabDirectoryButton();

    }

    @Then("check for each element in test bundles")
    public void checkForEachElementInTestBundles() throws InterruptedException {
        labTestDirectoryPage.clickOnEachElement();
    }

    @Then("search the relevant test from search lab test directory")
    public void searchTheRelevantTestFromSearchLabTestDirectory() {
        labTestDirectoryPage.clickOnLabDirectoryButton();
        labTestDirectoryPage.searchTheTest();
    }
}
