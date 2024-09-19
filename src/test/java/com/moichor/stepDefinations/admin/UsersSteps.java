package com.moichor.stepDefinations.admin;

import com.moichor.base.DriverFactory;
import com.moichor.pages.UsersPage;
import io.cucumber.java.en.Then;
import org.openqa.selenium.JavascriptExecutor;

public class UsersSteps extends DriverFactory {

    private final UsersPage usersPage;
    private final JavascriptExecutor js;

    public UsersSteps()
    {
        this.driver= DriverFactory.getDriver();
        this.usersPage=new UsersPage(driver);
        this.js=(JavascriptExecutor) driver;
    }

    @Then("Add a user and search for added user")
    public void addAUserAndSearchForAddedUser()  {
        usersPage.clickOnUsersButton();
        usersPage.addAUser();
        usersPage.searchTheUser();
    }

    @Then("Edit the user")
    public void editTheUser(){
        usersPage.clickOnUsersButton();
        usersPage.editTheUser();

    }

    @Then("Deactivate the user and restore the deactivated user")
    public void deactivateTheUserAndRestoreTheDeactivatedUser(){
        usersPage.deactivateTheUser();
        usersPage.restoreTheDeactivateUser();
    }

    @Then("Reset the password of existing user")
    public void resetThePasswordOfExistingUser(){
        usersPage.clickOnResetPasswordLink();
        usersPage.getNada();
    }

    @Then("Home page is displayed")
    public void homePageIsDisplayed() {
        usersPage.homePage();
    }
}
