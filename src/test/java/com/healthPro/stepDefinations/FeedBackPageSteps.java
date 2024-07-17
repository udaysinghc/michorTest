package com.healthPro.stepDefinations;

import com.healthPro.base.DriverFactory;
import com.healthPro.pages.AddNewSpeciesPage;
import com.healthPro.pages.FeedBackPage;
import io.cucumber.java.en.Then;
import org.openqa.selenium.JavascriptExecutor;

public class FeedBackPageSteps extends DriverFactory {

    private final FeedBackPage feedBackPage;
    private final JavascriptExecutor js;

    public FeedBackPageSteps()
    {
        this.driver= DriverFactory.getDriver();
        this.feedBackPage=new FeedBackPage(driver);
        this.js=(JavascriptExecutor) driver;
    }


    @Then("add a feedback")
    public void addAFeedback() {
        feedBackPage.clickOnFeedbackButton();
        feedBackPage.addFeedback();
    }
}
