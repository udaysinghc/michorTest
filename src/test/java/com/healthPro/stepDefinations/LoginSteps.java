package com.healthPro.stepDefinations;

import com.healthPro.base.DriverFactory;

import com.healthPro.pages.LoginPage;
import com.healthPro.util.ConfigReader;
import com.healthPro.util.TestUtil;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.Properties;

public class LoginSteps {
  private final TestUtil testUtil=new TestUtil(DriverFactory.getDriver());
  private final LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
  Properties prop;


  @Given("^user logged in to the application$")
  public void userLoggedInToTheApplication() throws InterruptedException {

   loginPage.loginApp();

  }


    @Then("home page is displayed")
    public void homePageIsDisplayed() throws InterruptedException {

      loginPage.homePage();
    }


}
