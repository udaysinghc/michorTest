package com.moichor.stepDefinations.admin;

import com.moichor.base.DriverFactory;
import com.moichor.pages.ReferencesPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.JavascriptExecutor;

public class ReferencesSteps extends  DriverFactory {

    private final ReferencesPage referencesPage;
    private final JavascriptExecutor js;

    public ReferencesSteps()
    {
        this.driver= DriverFactory.getDriver();
        this.referencesPage=new ReferencesPage(driver);
        this.js=(JavascriptExecutor) driver;
    }


    @Then("add a bin")
    public void addABin() throws InterruptedException {
        referencesPage.clickOnReferenceButton();
        referencesPage.addABin();
    }

    @Then("search for an added bin")
    public void searchForAnAddedBin() {
        referencesPage.searchForAddedBin();

    }

    @Then("edit the added bin")
    public void editTheAddedBin() throws InterruptedException {
        referencesPage.editTheBin();
    }

    @Then("delete the bin")
    public void deleteTheBin() {
        referencesPage.deleteTheBin();
    }

    @Then("add a issue and search for added issue")
    public void addAIssueAndSearchForAddedIssue() throws InterruptedException {
        referencesPage.clickOnReferenceButton();
        referencesPage.addAIssue();
        referencesPage.searchForAnAddedIssue();

    }

    @Then("edit the issue and delete the issue")
    public void editTheIssueAndDeleteTheIssue() throws InterruptedException {
        referencesPage.editTheIssue();
        referencesPage.deleteTheIssue();
    }

    @Then("add a variable and search for added variable")
    public void addAVariableAndSearchForAddedVariable() throws InterruptedException {
        referencesPage.clickOnReferenceButton();
        referencesPage.addAVariable();
        referencesPage.searchForTheVariable();
    }


    @Then("edit the variable and delete the variable")
    public void editTheVariableAndDeleteTheVariable() throws InterruptedException {
        referencesPage.editTheVariable();
        referencesPage.deleteTheVariable();
    }


    @Then("add a value")
    public void addAValue() throws InterruptedException {
        referencesPage.clickOnReferenceButton();
        referencesPage.addAVariable();
        referencesPage.addAValue();
    }

    @And("search for added value")
    public void searchForAddedValue() throws InterruptedException {
        referencesPage.searchTheValueBySpeciesDropDown();
        referencesPage.searchTheValueByGenus();
        referencesPage.searchTheValueByCommonName();
        referencesPage.searchTheValue();

    }

    @Then("edit the added value")
    public void editTheAddedValue() throws InterruptedException {
        referencesPage.editTheValue();
    }

    @And("delete the added value")
    public void deleteTheAddedValue() throws InterruptedException {
        referencesPage.deleteTheValue();

    }

    @Then("search the value by breed name")
    public void searchTheValueByBreedName() throws InterruptedException {
        referencesPage.searchTheValueByBreedName();
    }

    @Then("add a new species from admin portal")
    public void addANewSpeciesFromAdminPortal() throws InterruptedException {
        referencesPage.clickOnReferenceButton();
        referencesPage.addNewSpecies();
    }

    @And("search for added species")
    public void searchForAddedSpecies() {
        referencesPage.searchTheSpecies();
    }

    @Then("edit the species")
    public void editTheSpecies() throws InterruptedException {
        referencesPage.editTheSpecies();
    }

    @And("delete the species")
    public void deleteTheSpecies() {
        referencesPage.deleteTheSpecies();
    }

    @Then("add a question")
    public void addAQuestion() {
        referencesPage.clickOnReferenceButton();
        referencesPage.addAQuestion();
    }

    @And("search for added question")
    public void searchForAddedQuestion() {
        referencesPage.searchForTheAddedQuestion();
    }

    @Then("edit the question")
    public void editTheQuestion() throws InterruptedException {
        referencesPage.editTheAddedQuestion();
    }

    @And("delete the question")
    public void deleteTheQuestion() throws InterruptedException {
        referencesPage.deleteTheAddedTest();

    }

    @Then("add a test from test module")
    public void addATestFromTestModule() {
        referencesPage.clickOnReferenceButton();
        referencesPage.addATest();
    }

    @And("search for the added test")
    public void searchForTheAddedTest() {
        referencesPage.searchTheAddedTest();
    }

    @Then("edit the added test")
    public void editTheAddedTest() {
        referencesPage.editTheTest();
    }

    @Then("add a test group")
    public void addATestGroup() {
        referencesPage.clickOnReferenceButton();
        referencesPage.addATestGroup();
    }

    @And("search for added test group")
    public void searchForAddedTestGroup() throws InterruptedException {
        referencesPage.searchForTheAddedTestGroup();
    }

    @Then("edit the test group")
    public void editTheTestGroup() throws InterruptedException {
        referencesPage.editTheTestGroup();
    }

    @And("delete the test group")
    public void deleteTheTestGroup() throws InterruptedException {
        referencesPage.deleteTheAddedTestGroup();
    }

    @Then("check the test group sorting filter functionality")
    public void checkTheTestGroupSortingFilterFunctionality() throws InterruptedException {
        referencesPage.checkForSortFilter();
    }

    @Then("add a item")
    public void addAItem() {
        referencesPage.clickOnReferenceButton();
        referencesPage.addAItem();
    }


    @And("search the added item")
    public void searchTheAddedItem() {
        referencesPage.searchTheAddedItem();
    }

    @Then("edit the item")
    public void editTheItem() throws InterruptedException {
        referencesPage.editTheItem();
    }

    @And("delete the added item")
    public void deleteTheAddedItem() {
        referencesPage.deleteTheAddedItem();
    }


    @Then("check the item sorting filter functionality")
    public void checkTheItemSortingFilterFunctionality() {
        referencesPage.checkForItemSortingFilter();
    }

    @Then("add a bundle")
    public void addABundle() throws InterruptedException {
        referencesPage.clickOnReferenceButton();
        referencesPage.addABundle();
    }

    @And("search for added bundle")
    public void searchForAddedBundle() {
        referencesPage.searchTheAddedBundle();

    }

    @Then("edit the added bundle")
    public void editTheAddedBundle() throws InterruptedException {
        referencesPage.editTheBundle();
    }

    @And("delete the added bundle")
    public void deleteTheAddedBundle() {
        referencesPage.deleteTheBundle();
    }

    @Then("check the bundle sorting filter functionality")
    public void checkTheBundleSortingFilterFunctionality() {
        referencesPage.bundleSortingFilter();
    }

    @Then("add a volume tier")
    public void addAVolumeTier() throws InterruptedException {
        referencesPage.clickOnReferenceButton();
        referencesPage.addAVolumeTier();
    }

    @And("search the added volume tier")
    public void searchTheAddedVolumeTier() {
        referencesPage.searchTheAddedTier();
    }

    @Then("edit the added volume tier")
    public void editTheAddedVolumeTier() {
        referencesPage.editTheTier();
    }

    @Then("delete the added volume tier")
    public void deleteTheAddedVolumeTier() {
        referencesPage.deleteTheTier();
    }

    @Then("add a clinical template")
    public void addAClinicalTemplate() {
        referencesPage.clickOnReferenceButton();
        referencesPage.addAClinicalTemplate();
    }

    @And("search the added clinical template")
    public void searchTheAddedClinicalTemplate() {
        referencesPage.searchTheClinicalTemplate();
    }

    @Then("edit the clinical template")
    public void editTheClinicalTemplate() {
        referencesPage.editTheClinicalTemplate();
    }

    @Then("delete the clinical template")
    public void deleteTheClinicalTemplate() {
        referencesPage.deleteTheClinicalTemplate();
    }

    @Then("add a conditions")
    public void addAConditions() throws InterruptedException {
        referencesPage.clickOnReferenceButton();
        referencesPage.addAConditions();
    }

    @And("search for added conditions")
    public void searchForAddedConditions() {
        referencesPage.searchTheAddedConditions();
    }

    @Then("edit the conditions")
    public void editTheConditions() {
        referencesPage.editTheConditions();
    }

    @Then("delete the conditions")
    public void deleteTheConditions() {
        referencesPage.deleteTheAddedConditions();
    }

    @Then("check the conditions sorting functionality")
    public void checkTheConditionsSortingFunctionality() {
        referencesPage.filterTheCondition();
    }

    @Then("add a task")
    public void addATask() throws InterruptedException {
        referencesPage.clickOnReferenceButton();
        referencesPage.addATask();
    }

    @And("search the task")
    public void searchTheTask() {
        referencesPage.searchTheTasks();
    }

    @Then("edit the task")
    public void editTheTask() throws InterruptedException {
        referencesPage.editTheTask();
    }

    @Then("delete the task")
    public void deleteTheTask() {
        referencesPage.deleteTheTasks();
    }


}
