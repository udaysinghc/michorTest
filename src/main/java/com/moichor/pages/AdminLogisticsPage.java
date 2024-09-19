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

    @FindBy(css = "[class*='css-d']")
    private WebElement firstElementInDropDown;

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

    @FindBy(xpath = "//div[contains(@class,'react-select__value')]/../..")
    private WebElement selectClinicDropDown;

    @FindBy(xpath = "(//div[contains(@class,'react-select__value')]/../../descendant::input)[1]")
    private WebElement selectClinicInputField;

    @FindBy(xpath = "//span[@id='react-select-items-live-region']/..")
    private WebElement suppliesItemDropDown;

    @FindBy(xpath = "//span[@id='react-select-items-live-region']/../descendant::input")
    private WebElement suppliesInputField;

    @FindBy(css = "[class='btn btn-info']")
    private WebElement confirmRequestButton;

    @FindBy(css = "[role='status']")
    private WebElement status;

    @FindBy(xpath = "(//div[@class='d-flex flex-row card']/..)[1]")
    private WebElement firstSuppliesRequest;

    @FindBy(css = "[class*='btn btn-outline-success btn-xs']")
    private List<WebElement> allNewLabelButton;

    @FindBy(css = "[class='modal-header'] h5")
    private WebElement titleInfo;

    @FindBy(xpath = "//span[@id='react-select-serviceLevel-live-region']/..")
    private WebElement serviceLevelDropDown;

    @FindBy(css = "[class*=' css-tr']")
    private WebElement firstServiceInDropDown;

    @FindBy(id = "packageDimension.width")
    private WebElement widthInputField;

    @FindBy(id = "packageDimension.length")
    private WebElement lengthInputField;

    @FindBy(id = "packageDimension.height")
    private WebElement heightInputField;

    @FindBy(id = "packageDimension.weight")
    private WebElement weightInputField;

    @FindBy(css = "[class*='d-inline-flex']")
    private WebElement submitButton;

    @FindBy(xpath = "//i[@class='iconsminds-microscope']/..")
    private WebElement testsLink;

    @FindBy(xpath = "(//div[@class='d-flex flex-row']/..)[1]")
    private WebElement firstTest;

    @FindBy(xpath = "//i[@class='simple-icon-plus align-middle']/..")
    private WebElement createdTest;

    @FindBy(xpath = "(//div[@class='d-flex flex-row']/../*/*/*/a)[1]")
    private WebElement firstTestName;

    @FindBy(css = "[class*='active breadcrumb']")
    private WebElement testID;

    @FindBy(xpath = "(//i[@class='iconsminds-shopping-bag']/..)[2]")
    private WebElement sampleReceivingLink;

    @FindBy(css = "[placeholder='Test id']")
    private WebElement testIDInputField;

    @FindBy(css = "[class*='btn btn-success float-right']")
    private WebElement createOrderButton;

    @FindBy(xpath = "//div[contains(@class,'d-flex flex-row justify-content-between p')]/..")
    private WebElement testBody;


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

    public void searchTheSampleRequest(){
        clickOnTestIncoming();
        ts.presenceOfElementWait(sampleRequestText);
        ts.presenceOfElementWait(startDate);
        ts.presenceOfElementWait(endDate);
        try {
            ts.presenceOfElementWait(firstSample);
            int size = allTrackingNumber.size();
            String trackingNumber = "";
            for (int i = 0; i < size; i++) {
                trackingNumber = allTrackingNumber.get(i).getText();
                break;
            }
            ts.presenceOfElementWait(searchBar);
            searchBar.sendKeys(trackingNumber);
            ts.presenceOfElementWait(firstSample);
        }
        catch (Exception e)
        {
            ts.presenceOfElementWait(noResult);
        }
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
        try {
            ts.presenceOfElementWait(firstSample);
        }
        catch (Exception e)
        {
            ts.presenceOfElementWait(noResult);
        }
    }

    public String localDate()
    {
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy"); // Adjust pattern if needed

        return currentDate.format(formatter);
    }

    public void searchSampleByEnterClinic(){

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
        ts.presenceOfElementWait(firstElementInDropDown);
        firstElementInDropDown.click();
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

    public void searchSuppliesByClinicName(){

        clickOnSupplies();
        ts.presenceOfElementWait(filterClinicDropDown);
        filterClinicDropDown.click();
        ts.presenceOfElementWait(filterClinicInputField);
        String clinicName=prop.getProperty("filterClinicName");
        filterClinicInputField.sendKeys(clinicName);
        ts.presenceOfElementWait(firstElementInDropDown);
        firstElementInDropDown.click();
        ts.presenceOfElementWait(firstSupplies);

    }

    public void addARequestSupplies()
    {
        clickOnSupplies();
        ts.presenceOfElementWait(requestSuppliesButton);
        requestSuppliesButton.click();
        ts.presenceOfElementWait(selectClinicDropDown);
        selectClinicDropDown.click();
        ts.presenceOfElementWait(selectClinicInputField);
        String clinicName=prop.getProperty("requestClinicName");
        selectClinicInputField.sendKeys(clinicName);
        ts.presenceOfElementWait(firstElementInDropDown);
        firstElementInDropDown.click();
        ts.presenceOfElementWait(suppliesItemDropDown);
        suppliesItemDropDown.click();
        ts.presenceOfElementWait(suppliesInputField);
        String itemName=prop.getProperty("suppliesRequest");
        suppliesInputField.sendKeys(itemName);
        ts.presenceOfElementWait(firstElementInDropDown);
        firstElementInDropDown.click();
        ts.presenceOfElementWait(confirmRequestButton);
        confirmRequestButton.click();
        ts.presenceOfElementWait(status);
    }

    public void clickOnNewLabelButton()
    {
        clickOnSupplies();
        ts.presenceOfElementWait(firstSuppliesRequest);
        allNewLabelButton.get(0).click();
        ts.presenceOfElementWait(titleInfo);
        ts.presenceOfElementWait(serviceLevelDropDown);
        serviceLevelDropDown.click();
        ts.presenceOfElementWait(firstServiceInDropDown);
        firstServiceInDropDown.click();
        ts.presenceOfElementWait(widthInputField);
        String width=prop.getProperty("width");
        widthInputField.sendKeys(width);
        ts.presenceOfElementWait(lengthInputField);
        String length=prop.getProperty("length");
        lengthInputField.sendKeys(length);
        ts.presenceOfElementWait(heightInputField);
        String height=prop.getProperty("height");
        heightInputField.sendKeys(height);
        ts.presenceOfElementWait(weightInputField);
        String weight=prop.getProperty("labelWeight");
        weightInputField.sendKeys(weight);
        ts.presenceOfElementWait(submitButton);
        submitButton.click();
        try
        {
            ts.waitForTheElementVisibility(status,15);
        }
        catch (Exception e)
        {
            ts.switchToTab(1);
        }
    }

    static String createdTestID="";
    public void fetchTestID()
    {
        ts.presenceOfElementWait(testsLink);
        testsLink.click();
        ts.presenceOfElementWait(searchBar);
        ts.presenceOfElementWait(firstTest);
        ts.presenceOfElementWait(createdTest);
        ts.clickOnElement(createdTest);
        ts.presenceOfElementWait(firstTest);
        ts.presenceOfElementWait(firstTestName);
        ts.clickOnElement(firstTestName);
        ts.presenceOfElementWait(testID);
        String ID=testID.getText();
        String [] array=ID.split("-");
        createdTestID=array[0];
    }

    public void clickOnSampleReceiving()
    {
        ts.presenceOfElementWait(clinic);
        ts.scrollIntoView(logisticsLink);
        ts.presenceOfElementWait(logisticsLink);
        logisticsLink.click();
        ts.presenceOfElementWait(sampleReceivingLink);
        sampleReceivingLink.click();
        ts.presenceOfElementWait(createOrderButton);
        ts.presenceOfElementWait(testIDInputField);
    }

    public void searchTheSampleByTestID()
    {
        clickOnSampleReceiving();
        System.out.println(createdTestID);
        ts.presenceOfElementWait(testIDInputField);
        testIDInputField.sendKeys(createdTestID);
        try {
            ts.presenceOfElementWait(testBody);
        }
        catch (Exception e)
        {
            ts.presenceOfElementWait(noResult);
        }
    }
}
