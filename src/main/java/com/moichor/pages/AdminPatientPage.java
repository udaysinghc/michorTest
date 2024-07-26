package com.moichor.pages;


import com.moichor.base.DriverFactory;
import com.moichor.util.ConfigReader;
import com.moichor.util.TestUtil;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.Properties;

public class AdminPatientPage {

    public WebDriver driver;
    TestUtil ts;
    public JavascriptExecutor js;
    ConfigReader configReader = new ConfigReader();
    Properties prop=configReader.init_prop();

    public AdminPatientPage(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
        this.driver= DriverFactory.getDriver();
        this.ts=new TestUtil(driver);

    }

    @FindBy(xpath = "//a[text()='Patients']")
    private WebElement patientButton;

    @FindBy(css = "[class*='mb'] h1")
    private WebElement patientText;

    @FindBy(id="search")
    private WebElement searchBar;



    @FindBy(xpath = "(//div[contains(@class,'card-body')])[2]")
    private WebElement patient;


    @FindBy(css = "[class*='mb'] h4")
    private WebElement noResult;


    public void clickOnPatientButton()
    {
        ts.presenceOfElementWait(patientButton);
        patientButton.click();
        ts.presenceOfElementWait(patientText);
        ts.presenceOfElementWait(searchBar);

    }

    public void searchForAnExistingPatient()
    {
        try {
            ts.presenceOfElementWait(searchBar);
            String pName = prop.getProperty("patientName");
            searchBar.sendKeys(pName);
            ts.presenceOfElementWait(patient);
        }
        catch (Exception e)
        {
            ts.presenceOfElementWait(noResult);
            System.out.println("first create a patient for this name");
        }

    }
}
