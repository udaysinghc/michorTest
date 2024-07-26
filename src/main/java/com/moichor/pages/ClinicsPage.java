package com.moichor.pages;


import com.moichor.base.DriverFactory;
import com.moichor.util.ConfigReader;
import com.moichor.util.TestUtil;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Properties;
import java.util.Random;

public class ClinicsPage {

    public WebDriver driver;
    TestUtil ts;
    public JavascriptExecutor js;
    ConfigReader configReader = new ConfigReader();
    Properties prop=configReader.init_prop();

    public ClinicsPage(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
        this.driver= DriverFactory.getDriver();
        this.ts=new TestUtil(driver);

    }

    @FindBy(xpath = "//a[text()='Clinics']")
    private WebElement clinicsButton;

    @FindBy(css = "[class*='col'] h1")
    private WebElement clinicsText;

    @FindBy(id="search")
    private WebElement searchBar;

    @FindBy(css = "[class*='col'] button")
    private WebElement addClinicButton;

    @FindBy(css = "[class*='d-flex flex-row list']")
    private List<WebElement> allClinics;

    @FindBy(id="name")
    private WebElement nameField;

    @FindBy(id="geosuggest__input")
    private WebElement addressField;

    @FindBy(id="address")
    private WebElement street;

    @FindBy(id="city")
    private WebElement city;

    @FindBy(id="state")
    private WebElement state;

    @FindBy(id="zip")
    private WebElement zip;

    @FindBy(id="representative")
    private WebElement representativeDropDown;

    @FindBy(css = "[id='representative'] input")
    private WebElement representativeInput;

    @FindBy(id="currency")
    private WebElement currencyDropDown;

    @FindBy(css = "[id='currency'] input")
    private WebElement currencyInput;

    @FindBy(id="email")
    private WebElement email;

    @FindBy(id="billing_email")
    private WebElement billingEmail;

    @FindBy(id="phone1")
    private WebElement phoneField;


    @FindBy(css = "[class='d-flex btn btn-primary']")
    private WebElement saveClinicInfoButton;

    @FindBy(xpath = "//button[text()='Cancel']")
    private WebElement cancelButton;

    @FindBy(css = "[role='status']")
    private WebElement status;

    @FindBy(xpath = "(//*[contains(@class,'mb-2 cursor')])[1]")
    private WebElement addedClinic;

    @FindBy(xpath = "(//div[contains(@class,'card-body')]/div/p)[1]")
    private  WebElement ClinicName;

    public void clickOnClinicsButton()
    {
        ts.presenceOfElementWait(clinicsButton);
        clinicsButton.click();
        ts.presenceOfElementWait(searchBar);
        ts.presenceOfElementWait(clinicsText);
        ts.presenceOfElementWait(addClinicButton);
        for(WebElement r:allClinics)
        {
            ts.presenceOfElementWait(r);
        }

    }

    static Random r=new Random();

    public void addAClinics() throws InterruptedException {
        addClinicButton.click();
        ts.presenceOfElementWait(nameField);
        String cName= prop.getProperty("clinicName");
        int random=r.nextInt(100);
        nameField.sendKeys(cName+random);
        ts.presenceOfElementWait(street);
        String streetName=prop.getProperty("street");
        street.sendKeys(streetName);
        ts.presenceOfElementWait(city);
        String cityName=prop.getProperty("clinicCity");
        city.sendKeys(cityName);
        ts.presenceOfElementWait(state);
        String stateName=prop.getProperty("ClinicState");
        state.sendKeys(stateName);
        ts.presenceOfElementWait(zip);
        String zipcode=prop.getProperty("ClinicZip");
        zip.sendKeys(zipcode);
        ts.presenceOfElementWait(representativeDropDown);
        representativeDropDown.click();
        ts.presenceOfElementWait(representativeInput);
        String representativeName=prop.getProperty("RepresentativeName");
        representativeInput.sendKeys(representativeName);
        Thread.sleep(4000);
        representativeInput.sendKeys(Keys.ENTER);
        ts.presenceOfElementWait(currencyDropDown);
        currencyDropDown.click();
        ts.presenceOfElementWait(currencyInput);
        String currencyName=prop.getProperty("Currency");
        currencyInput.sendKeys(currencyName);
        Thread.sleep(4000);
        currencyInput.sendKeys(Keys.ENTER);
        ts.presenceOfElementWait(email);
        String emailName=prop.getProperty("clinicEmail");
        String domain= prop.getProperty("emailDomain");
        int random1=r.nextInt(100);
        email.sendKeys(emailName+random1+domain);
        ts.presenceOfElementWait(billingEmail);
        billingEmail.sendKeys(emailName+random1+domain);
        ts.presenceOfElementWait(phoneField);
        String number=prop.getProperty("clinicPhoneNumber");
        phoneField.sendKeys(number);
        ts.presenceOfElementWait(saveClinicInfoButton);
        saveClinicInfoButton.click();
        ts.presenceOfElementWait(status);

    }

    public void searchForAddedClinic()
    {
        ts.presenceOfElementWait(searchBar);
        String clinicName=prop.getProperty("clinicName");
        searchBar.sendKeys(clinicName);
        ts.presenceOfElementWait(addedClinic);
    }

    public void searchTheClinic()
    {
        ts.presenceOfElementWait(ClinicName);
        ClinicName.click();
    }
    public  void editTheClinic()
    {
        int random=r.nextInt(100);
        ts.presenceOfElementWait(email);
        String emailName=prop.getProperty("clinicEmail");
        String domain=prop.getProperty("emailDomain");
        email.clear();
        email.sendKeys(emailName+random+domain);
        ts.presenceOfElementWait(saveClinicInfoButton);
        saveClinicInfoButton.click();
        ts.presenceOfElementWait(status);
    }


}
