package com.moichor.stepDefinations.client;

import com.moichor.base.DriverFactory;
import com.moichor.pages.LoginPage;
import com.moichor.util.TestUtil;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import java.util.Properties;

public class LoginSteps {
  private final TestUtil testUtil=new TestUtil(DriverFactory.getDriver());
  private final LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
  Properties prop;


  @Given("^user logged in to the application$")
  public void userLoggedInToTheApplication()  {

   loginPage.loginApp();

  }


    @Then("home page is displayed")
    public void homePageIsDisplayed() {
      loginPage.homePage();
    }


}
