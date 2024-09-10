package com.moichor.pages;

import com.moichor.base.DriverFactory;
import com.moichor.util.ConfigReader;
import com.moichor.util.TestUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Properties;

public class AdminTestPage {

    public WebDriver driver;
    TestUtil ts;
    public JavascriptExecutor js;
    ConfigReader configReader = new ConfigReader();
    Properties prop=configReader.init_prop();

    public AdminTestPage(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
        this.driver= DriverFactory.getDriver();
        this.ts=new TestUtil(driver);

    }


    @FindBy(xpath = "//a[text()='Clinics']")
    private WebElement clinicsButton;

    @FindBy(xpath = "//a[text()='Orders']")
    private WebElement orderButton;

    @FindBy(xpath = "(//div[@class='w-30 w-sm-100 d-flex flex-row list-title']/p)[1]")
    private WebElement selectOrder;

    @FindBy(xpath = "(//div[contains(@class,'d-flex flex-row align')])[1]/span[2]")
    private WebElement testID;

    @FindBy(xpath = "(//div[contains(@class,'d-flex flex-row align')])[1]/span[3]")
    private WebElement testName;

    @FindBy(css = "[class='btn btn-outline-primary']")
    private WebElement closeButton;

    @FindBy(xpath = "(//div[contains(@class,'d-flex flex-row')]/span)[2]")
    private WebElement testStatus;

    @FindBy(css = "[data-flag='tests']")
    private WebElement testsButton;

    @FindBy(css = "[href='/app/tests/all']")
    private WebElement reviewTestLink;

    @FindBy(css = "[href='/app/tests/qc']")
    private WebElement qc;

    @FindBy(css = "[class*='mb'] h1")
    private WebElement qcText;

    @FindBy(css = "[class*='mb'] h1")
    private WebElement testText;

    @FindBy(id = "search")
    private WebElement searchBar;

    @FindBy(css = "[placeholder='Start']")
    private WebElement startDate;

    @FindBy(css = "[placeholder='End']")
    private WebElement endDate;

    @FindBy(css = "[class*='simple-icon-btn']")
    private WebElement clearButton;

    @FindBy(css = "[class*='infinite-scroll-component ']")
    private WebElement allReviewTest;

    @FindBy(xpath = "(//div[contains(@class,'d-flex flex-row')]/p)[1]")
    private WebElement firstTest;

    @FindBy(css = "[class*='col'] h4")
    private WebElement noResultFound;

    @FindBy(xpath = "(//span[contains(@id,'live-region')]/..)[1]")
    private WebElement referenceTestDropDown;

    @FindBy(xpath = "(//span[contains(@id,'live-region')]/..)[1]/descendant::input")
    private WebElement referenceTestInput;

    @FindBy(xpath = "(//span[contains(@id,'live-region')]/..)[2]")
    private WebElement applicableStatusDropDown;

    @FindBy(xpath = "(//span[contains(@id,'live-region')]/..)[2]/descendant::input")
    private WebElement applicableStatusInput;

    @FindBy(css = "[type='search']")
    private WebElement findTestSearchBar;

    @FindBy(xpath = "//table")
    private WebElement table;


    public void clickOnTestButton()
    {
        ts.presenceOfElementWait(clinicsButton);
        ts.scrollIntoView(testsButton);
        testsButton.click();

    }

    public void clickOnReviewButton()
    {
        ts.presenceOfElementWait(reviewTestLink);
        reviewTestLink.click();
        ts.presenceOfElementWait(testText);
        ts.presenceOfElementWait(searchBar);
        ts.presenceOfElementWait(startDate);
        ts.presenceOfElementWait(endDate);
        ts.presenceOfElementWait(clearButton);
        ts.presenceOfElementWait(allReviewTest);
    }

    public void searchForAnExistingTest()
    {
        try {
            String pName = prop.getProperty("patientName");
            ts.presenceOfElementWait(searchBar);
            searchBar.sendKeys(pName);
            ts.presenceOfElementWait(firstTest);
        }
        catch (Exception e)
        {
            ts.presenceOfElementWait(noResultFound);
            System.out.print(noResultFound.getText());
        }

    }

    public void searchAnExistingTestByEnteringDate()
    {
        try {
            ts.presenceOfElementWait(startDate);
            ts.presenceOfElementWait(endDate);
            String sDate = prop.getProperty("start");
            String eDate = prop.getProperty("end");
            startDate.sendKeys(sDate);
            endDate.sendKeys(eDate);
            ts.presenceOfElementWait(allReviewTest);
        }
        catch(Exception e)
        {
            ts.presenceOfElementWait(noResultFound);
            System.out.print(noResultFound.getText());
        }
    }

    public void clickOnQCLink() throws InterruptedException {
        ts.presenceOfElementWait(qc);
        qc.click();
        Thread.sleep(2000);
        ts.presenceOfElementWait(qcText);
    }

    public void searchQCResult() throws InterruptedException {
        ts.presenceOfElementWait(referenceTestDropDown);
        referenceTestDropDown.click();
        ts.presenceOfElementWait(referenceTestInput);
        List<WebElement> allReference = driver.findElements(By.cssSelector("[role='listbox'] div"));
        for(WebElement r: allReference)
        {
            String ref=prop.getProperty("reference");
            if(r.getText().equalsIgnoreCase(ref))
            {
                r.click();
                break;
            }
        }
        ts.presenceOfElementWait(applicableStatusDropDown);
        Thread.sleep(2000);
        applicableStatusDropDown.click();
        ts.presenceOfElementWait(applicableStatusInput);
        List<WebElement> allApplicable = driver.findElements(By.cssSelector("[role='listbox'] div"));
        for(WebElement r1:allApplicable)
        {
            String applicable=prop.getProperty("applicable");
            if(r1.getText().equalsIgnoreCase(applicable))
            {
                r1.click();
            }
        }


    }

    public void searchTheApplicationStatus()
    {
        ts.presenceOfElementWait(applicableStatusDropDown);
        applicableStatusDropDown.click();
        ts.presenceOfElementWait(applicableStatusInput);
        List<WebElement> allApplicable = driver.findElements(By.cssSelector("[role='listbox'] div"));
        for(WebElement r1:allApplicable)
        {
            String applicable1=prop.getProperty("applicable1");
            String applicable2=prop.getProperty("applicable2");
            String applicable3=prop.getProperty("applicable3");
            if(r1.getText().equalsIgnoreCase(applicable1) || r1.getText().equalsIgnoreCase(applicable2) || r1.getText().equalsIgnoreCase(applicable3)  )
            {
                r1.click();

            }

        }


    }

    static String testI;
    static String testN;
    static String testS;

    public void selectTheTestID()
    {
        ts.presenceOfElementWait(clinicsButton);
        ts.scrollIntoView(orderButton);
        orderButton.click();
        ts.presenceOfElementWait(testStatus);
        testS=testStatus.getText();
        ts.presenceOfElementWait(selectOrder);
        selectOrder.click();
        ts.presenceOfElementWait(testID);
        ts.presenceOfElementWait(testName);
        testI=testID.getText();
        testN=testName.getText();
        System.out.println(testI);
        System.out.println(testN);
        System.out.println(testS);
        ts.scrollIntoView(closeButton);
        closeButton.click();
        ts.presenceOfElementWait(testsButton);
        testsButton.click();

    }

    public void searchForAnTest()
    {
        ts.presenceOfElementWait(referenceTestDropDown);
        referenceTestDropDown.click();
        ts.presenceOfElementWait(referenceTestInput);
        List<WebElement> allReference = driver.findElements(By.cssSelector("[role='listbox'] div"));
        for(WebElement r: allReference)
        {

            if(r.getText().equalsIgnoreCase(testN))
            {
                r.click();
                break;
            }
        }
        ts.presenceOfElementWait(applicableStatusDropDown);
        applicableStatusDropDown.click();
        ts.presenceOfElementWait(applicableStatusInput);
        List<WebElement> allApplicable = driver.findElements(By.cssSelector("[role='listbox'] div"));
        for(WebElement r1:allApplicable)
        {

            if(r1.getText().equalsIgnoreCase(testS))
            {
                r1.click();
                break;

            }
        }

        ts.presenceOfElementWait(findTestSearchBar);
        findTestSearchBar.sendKeys(testI);
        ts.presenceOfElementWait(table);
    }


}
