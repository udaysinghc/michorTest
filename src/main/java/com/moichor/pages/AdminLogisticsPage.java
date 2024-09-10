package com.moichor.pages;

import com.moichor.base.DriverFactory;
import com.moichor.util.ConfigReader;
import com.moichor.util.TestUtil;
import junit.framework.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Properties;

public class AdminLogisticsPage {

    public WebDriver driver;
    TestUtil ts;
    public JavascriptExecutor js;
    ConfigReader configReader = new ConfigReader();
    Properties prop=configReader.init_prop();

    public AdminLogisticsPage(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
        this.driver= DriverFactory.getDriver();
        this.ts=new TestUtil(driver);

    }

    @FindBy(xpath = "//a[text()='Clinics']")
    private WebElement clinic;

    @FindBy(xpath = "//i[@class='iconsminds-mail']/..")
    private WebElement logisticsLink;

    @FindBy(xpath = "//i[@class='iconsminds-tag']/..")
    private WebElement testIncomingLink;

    @FindBy(css = "[class*='flex justify'] h1")
    private WebElement sampleRequestText;

    @FindBy(id = "search")
    private WebElement searchBar;

    @FindBy(css = "[placeholder='Start']")
    private WebElement startDate;

    @FindBy(css = "[placeholder='End']")
    private WebElement endDate;

    @FindBy(xpath = "//i[@class='simple-icon-reload']/..")
    private WebElement reloadButton;

    @FindBy(xpath = "//div[contains(@id,'react')]/../../..")
    private WebElement filterClinicDropDown;

    @FindBy(xpath = "//div[contains(@id,'react')]/../../../descendant::input")
    private WebElement filterClinicInputField;

    @FindBy(css = "[class='btn btn-secondary']")
    private WebElement requestSuppliesButton;

    @FindBy(xpath = "(//div[contains(@class,'cursor-p card')])[1]")
    private WebElement firstSample;

    @FindBy(css = "ul[class='list-unstyled'] li a")
    private List<WebElement> allShipmentStatus;

    @FindBy(xpath = "//div[contains(@class,'cursor-')]/a")
    private  List<WebElement> allTrackingNumber;

    @FindBy(css = "[class*='mb'] h4")
    private WebElement noResult;

    @FindBy(xpath = "(//i[@class='iconsminds-shopping-bag']/..)[1]")
    private WebElement suppliesLink;

    @FindBy(xpath = "//h1")
    private WebElement suppliesRequestText;


    @FindBy(xpath = "//div[contains(@class,'card-body')]/a")
    private List<WebElement> trackingNumbers;

    @FindBy(xpath = "(//div[contains(@class,'card-body')])[1]")
    private WebElement firstSupplies;

    public void clickOnSupplies()
    {
        ts.presenceOfElementWait(clinic);
        ts.scrollIntoView(logisticsLink);
        ts.presenceOfElementWait(logisticsLink);
        logisticsLink.click();
        ts.presenceOfElementWait(suppliesLink);
        suppliesLink.click();

    }

    public void clickOnTestIncoming()
    {
        ts.presenceOfElementWait(clinic);
        ts.scrollIntoView(logisticsLink);
        ts.presenceOfElementWait(logisticsLink);
        logisticsLink.click();
        ts.presenceOfElementWait(testIncomingLink);
        testIncomingLink.click();

    }

    public void searchTheSampleRequest() throws InterruptedException {
        clickOnTestIncoming();
        ts.presenceOfElementWait(sampleRequestText);
        ts.presenceOfElementWait(startDate);
        ts.presenceOfElementWait(endDate);
        ts.presenceOfElementWait(firstSample);
        Thread.sleep(4000);
        int size=allTrackingNumber.size();
        String trackingNumber="";
        for(int i=0; i<size; i++)
        {
            trackingNumber=allTrackingNumber.get(i).getText();
            System.out.println(trackingNumber);
            break;
        }
        ts.presenceOfElementWait(searchBar);
        searchBar.sendKeys(trackingNumber);
        ts.presenceOfElementWait(firstSample);
    }

    public void checkTheDateFunctionality()
    {
        clickOnTestIncoming();
        ts.presenceOfElementWait(sampleRequestText);
        ts.presenceOfElementWait(startDate);
        ts.presenceOfElementWait(endDate);
        ts.presenceOfElementWait(firstSample);
        String sDate=prop.getProperty("starDate");
        startDate.sendKeys(sDate, Keys.ENTER);
        String eDate=localDate();
        endDate.sendKeys(eDate, Keys.ENTER);
        ts.presenceOfElementWait(firstSample);
    }

    public String localDate()
    {
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy"); // Adjust pattern if needed

        return currentDate.format(formatter);
    }

    public void searchSampleByEnterClinic() throws InterruptedException {

        clickOnTestIncoming();
        ts.presenceOfElementWait(sampleRequestText);
        ts.presenceOfElementWait(startDate);
        ts.presenceOfElementWait(endDate);
        ts.presenceOfElementWait(firstSample);
        ts.presenceOfElementWait(filterClinicDropDown);
        filterClinicDropDown.click();
        ts.presenceOfElementWait(filterClinicInputField);
        String clinicName=prop.getProperty("filterClinicName");
        filterClinicInputField.sendKeys(clinicName);
        Thread.sleep(2000);
        filterClinicInputField.sendKeys(Keys.ENTER);
        ts.presenceOfElementWait(firstSample);
    }

    public void clickOnEachShipmentStatus()
    {
        clickOnTestIncoming();
        ts.presenceOfElementWait(sampleRequestText);
        ts.presenceOfElementWait(startDate);
        ts.presenceOfElementWait(endDate);
        ts.presenceOfElementWait(firstSample);
        int size=allShipmentStatus.size();
        for (int i=0; i<size; i++)
        {
            allShipmentStatus.get(i).click();
            try {
                ts.waitForTheElementVisibility(firstSample, 5);
            }
            catch (Exception e)
            {
                ts.waitForTheElementVisibility(noResult,5);
                String actual=noResult.getText();
                String expected=prop.getProperty("noResultMessage");
                Assert.assertEquals(expected,actual);
            }
        }
    }

    public void searchTheSuppliesRequest()
    {
        clickOnSupplies();
        ts.presenceOfElementWait(suppliesRequestText);
        ts.presenceOfElementWait(firstSupplies);
        int size=trackingNumbers.size();
        String trackingNumber="";
        for(int i=0; i<size; i++)
        {
            String text=trackingNumbers.get(i).getText();
            String message=prop.getProperty("trackingNumberNotAvailable");
            if(!(text.equalsIgnoreCase(message)))
            {
                trackingNumber=text;
                break;
            }
        }
        ts.presenceOfElementWait(searchBar);
        searchBar.sendKeys(trackingNumber);
        ts.presenceOfElementWait(firstSupplies);
    }

    public void searchTheSuppliesBetweenDates()
    {
        clickOnSupplies();
        ts.presenceOfElementWait(startDate);
        String sDate=prop.getProperty("dateStart");
        startDate.sendKeys(sDate);
        ts.presenceOfElementWait(endDate);
        String eDate=localDate();
        endDate.sendKeys(eDate, Keys.ENTER);
        ts.presenceOfElementWait(firstSupplies);
        ts.presenceOfElementWait(reloadButton);
        reloadButton.click();
        ts.presenceOfElementWait(firstSupplies);
    }

    public void searchSuppliesByClinicName() throws InterruptedException {

        clickOnSupplies();
        ts.presenceOfElementWait(filterClinicDropDown);
        filterClinicDropDown.click();
        ts.presenceOfElementWait(filterClinicInputField);
        String clinicName=prop.getProperty("filterClinicName");
        filterClinicInputField.sendKeys(clinicName);
        Thread.sleep(2000);
        filterClinicInputField.sendKeys(Keys.ENTER);
        ts.presenceOfElementWait(firstSupplies);

    }

    public void addARequestSupplies()
    {
        clickOnSupplies();
        ts.presenceOfElementWait(requestSuppliesButton);

    }

}
