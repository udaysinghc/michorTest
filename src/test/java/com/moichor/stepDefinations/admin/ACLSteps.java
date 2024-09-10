package com.moichor.stepDefinations.admin;


import com.moichor.base.DriverFactory;
import com.moichor.pages.ACLPage;
import io.cucumber.java.en.Then;
import org.openqa.selenium.JavascriptExecutor;

public class ACLSteps extends DriverFactory {

    private final ACLPage aclPage;
    private final JavascriptExecutor js;

    public ACLSteps()
    {
        this.driver= DriverFactory.getDriver();
        this.aclPage=new ACLPage(driver);
        this.js=(JavascriptExecutor) driver;
    }


    @Then("Add a role")
    public void addARole() {
        aclPage.clickOnACLButton();
        aclPage.addARole();
    }

    @Then("Added role is displayed on roles page")
    public void addedRoleIsDisplayedOnRolesPage() {
        aclPage.searchTheAddedRole();
    }

    @Then("Search for an existing role")
    public void searchForAnExistingRole() {
        aclPage.clickOnACLButton();
        aclPage.searchForExistingRole();
    }

    @Then("edit the role")
    public void editTheRole() {
        aclPage.editTheRole();
    }

    @Then("Search for an existing permission")
    public void searchForAnExistingPermission() {
        aclPage.clickOnACLButton();
        aclPage.clickOnPermission();
        aclPage.searchForExistingPermission();
    }

    @Then("edit the permission")
    public void editThePermission() {

        aclPage.editThePermission();
    }


}
