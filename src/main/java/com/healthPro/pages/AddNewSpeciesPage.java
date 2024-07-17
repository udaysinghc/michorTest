package com.healthPro.pages;

import com.healthPro.base.DriverFactory;
import com.healthPro.util.ConfigReader;
import com.healthPro.util.TestUtil;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Properties;

public class AddNewSpeciesPage {

    public WebDriver driver;
    TestUtil ts;
    public JavascriptExecutor js;
    ConfigReader configReader = new ConfigReader();
    Properties prop=configReader.init_prop();

    public AddNewSpeciesPage(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
        this.driver= DriverFactory.getDriver();
        this.ts=new TestUtil(driver);

    }

    @FindBy(xpath = "//a[text()='Add']")
    private WebElement addNewSpeciesButton;

    @FindBy(xpath = "//a[text()='Tests']")
    private WebElement testButton;

    @FindBy(css = "[class='modal-header'] h5")
    private WebElement title;

    @FindBy(css = "[class='modal-body']")
    private WebElement body;

    @FindBy(css = "[class='modal-body'] textarea")
    private WebElement textarea;

    @FindBy(css = "[class*='d-flex flex']")
    private WebElement submitButton;

    @FindBy(css = "[class*='btn btn-outline']")
    private WebElement cancelButton;

    @FindBy(css = "[role='status']")
    private WebElement status;

    public void clickOnAddSpeciesButton()
    {
        ts.presenceOfElementWait(testButton);
        ts.scrollIntoView(addNewSpeciesButton);
        addNewSpeciesButton.click();
        ts.presenceOfElementWait(title);
        ts.presenceOfElementWait(body);
        ts.presenceOfElementWait(textarea);
        ts.presenceOfElementWait(submitButton);
        ts.presenceOfElementWait(cancelButton);

    }

    public void addSpecies() throws InterruptedException {
        ts.presenceOfElementWait(textarea);
        String species=prop.getProperty("speciesName");
        textarea.sendKeys(species);
        submitButton.click();
        Thread.sleep(2000);
        ts.presenceOfElementWait(status);

    }
}
