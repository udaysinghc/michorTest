package com.moichor.pages;


import com.moichor.base.DriverFactory;
import com.moichor.util.ConfigReader;
import com.moichor.util.TestUtil;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Properties;


public class AdminOrderPage {

    public WebDriver driver;
    TestUtil ts;
    public JavascriptExecutor js;
    ConfigReader configReader = new ConfigReader();
    Properties prop=configReader.init_prop();

    public AdminOrderPage(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
        this.driver= DriverFactory.getDriver();
        this.ts=new TestUtil(driver);

    }

    @FindBy(css = "[class*='col'] h1")
    private WebElement dashBoardText;

    @FindBy(xpath = "//a[text()='Orders']")
    private WebElement ordersButton;

    @FindBy(css = "[class*='mb'] h1")
    private WebElement testOrdersText;

    @FindBy(id="search")
    private WebElement searchBar;

    @FindBy(css = "[class*='top-right-button btn']")
    private WebElement downloadStatics;

    @FindBy(css = "[class='btn btn-primary']")
    private WebElement yesButton;

    @FindBy(css = "[placeholder='Start']")
    private WebElement startDate;

    @FindBy(css = "[placeholder='End']")
    private WebElement endDate;

    @FindBy(xpath = "//i[@class='simple-icon-reload']/..")
    private WebElement clearDate;

    @FindBy(xpath = "(//div[contains(@class,'d-flex list')])[1]")
    private WebElement order;

    @FindBy(css = "[class*='mb'] h4")
    private WebElement noResult;

    @FindBy(xpath = "//a[text()='Clinics']")
    private WebElement clinicsButton;

    @FindBy(xpath = "(//div[contains(@class,'d-flex flex-column combo')])[1]")
    private WebElement orderInParticularDate;

    @FindBy(id="clinic-select-field")
    private WebElement clinicDropDown;


    @FindBy(css = "[id='clinic-select-field'] input[id]")
    private WebElement clinicInput;

    @FindBy(id="species-select-field")
    private WebElement speciesDropDown;

    @FindBy(css = "[id='species-select-field'] input[id]")
    private WebElement speciesInput;


    @FindBy(xpath = "(//div[contains(@class,'d-flex list')])[1]")
    private WebElement firstTest;

    @FindBy(xpath = "//div/p[text()='Test status']")
    private WebElement testStatus;

    @FindBy(css = "[class='infinite-scroll-component__outerdiv']")
    private WebElement allTests;
    

    @FindBy(css = "[class*='edit_text_button']")
    private WebElement editButton;

    @FindBy(css = "[class='modal-header'] h5")
    private WebElement patientForm;

    @FindBy(id="weight")
    private WebElement weightInput;

    @FindBy(css = "[placeholder='DOB']")
    private WebElement dob;

    @FindBy(css = "[type='submit']")
    private WebElement saveDetailButton;

    @FindBy(css = "[role='status']")
    private WebElement status;

    @FindBy(xpath = "(//div[@class='col-12']/descendant::div[contains(@class,'d-flex flex-row list-title')]/p)[1]")
    private WebElement selectTest;

    public void clickOnOrdersButton()
    {
        ts.presenceOfElementWait(clinicsButton);
        ts.scrollIntoView(ordersButton);
        ordersButton.click();
        ts.presenceOfElementWait(searchBar);
        ts.presenceOfElementWait(testOrdersText);
        ts.presenceOfElementWait(startDate);
        ts.presenceOfElementWait(endDate);
        ts.presenceOfElementWait(clearDate);

    }

    public void searchTheExistingOrder()
    {
        try {
            ts.presenceOfElementWait(searchBar);
            String pName = prop.getProperty("patientName");
            searchBar.sendKeys(pName);
            ts.presenceOfElementWait(order);
        }
        catch (Exception e)
        {
            ts.presenceOfElementWait(noResult);
            System.out.println("first create a test for this patient");

        }

    }

    public void clickOnDownloadStaticsButton() throws InterruptedException {
        ts.presenceOfElementWait(downloadStatics);
        downloadStatics.click();
        ts.presenceOfElementWait(yesButton);
        yesButton.click();
        Thread.sleep(2000);

    }

    public void enterStartAndEndDate()
    {
        ts.presenceOfElementWait(startDate);
        String start=prop.getProperty("start");
        startDate.sendKeys(start, Keys.ENTER);
        ts.presenceOfElementWait(endDate);
        String end=prop.getProperty("end");
        endDate.sendKeys(end,Keys.ENTER);
        ts.presenceOfElementWait(orderInParticularDate);
        ts.presenceOfElementWait(clearDate);
    }

    public void searchTheTest() throws InterruptedException {
        ts.presenceOfElementWait(clinicDropDown);
        clinicDropDown.click();
        ts.presenceOfElementWait(clinicInput);
        String clinicText=prop.getProperty("clinicText");
        String speciesText=prop.getProperty("speciesText");
        clinicInput.sendKeys(clinicText);
        Thread.sleep(2000);
        clinicInput.sendKeys(Keys.ENTER);
        ts.presenceOfElementWait(speciesDropDown);
        speciesDropDown.click();
        ts.presenceOfElementWait(speciesInput);
        speciesInput.sendKeys(speciesText);
        Thread.sleep(4000);
        speciesInput.sendKeys(Keys.ENTER);
        ts.presenceOfElementWait(firstTest);
    }

    List<WebElement> allTestStatus;
    public void testStatus() throws InterruptedException {
        ts.presenceOfElementWait(testStatus);
        allTestStatus = driver.findElements(By.cssSelector("[class*='px'] [href*='/app/']"));
        for(WebElement r:allTestStatus)
        {
            r.click();
            ts.scrollIntoView(r);
            ts.presenceOfElementWait(allTests);
            Thread.sleep(2000);
        }
    }

    public void editThePatient()
    {
        ts.presenceOfElementWait(selectTest);
        selectTest.click();
        ts.presenceOfElementWait(editButton);
        editButton.click();
        ts.presenceOfElementWait(patientForm);
        ts.presenceOfElementWait(weightInput);
        weightInput.clear();
        String pWeight=prop.getProperty("patientWeight");
        weightInput.sendKeys(pWeight);
        ts.presenceOfElementWait(dob);
        dob.clear();
        String date=prop.getProperty("patientDOB");
        dob.sendKeys(date);
        ts.presenceOfElementWait(saveDetailButton);
        saveDetailButton.click();
        ts.presenceOfElementWait(status);
    }
}
