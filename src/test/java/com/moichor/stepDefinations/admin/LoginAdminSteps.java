package com.moichor.stepDefinations.admin;


import com.moichor.base.DriverFactory;
import com.moichor.pages.LoginAdminPage;
import com.moichor.util.TestUtil;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class LoginAdminSteps {

    private final TestUtil testUtil=new TestUtil(DriverFactory.getDriver());
    private final LoginAdminPage loginAdminPage = new LoginAdminPage(DriverFactory.getDriver());

    @Given("user logged in to the admin portal")
    public void userLoggedInToTheAdminPortal() {
        loginAdminPage.loginAdminApp();
    }

    @Then("Dashboard page is displayed")
    public void dashboardPageIsDisplayed() {
        loginAdminPage.dashBoardPage();
    }


}
