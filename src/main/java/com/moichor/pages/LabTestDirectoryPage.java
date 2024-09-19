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

public class LabTestDirectoryPage {

    public WebDriver driver;
    TestUtil ts;
    public JavascriptExecutor js;
    ConfigReader configReader = new ConfigReader();
    Properties prop=configReader.init_prop();

    public LabTestDirectoryPage(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
        this.driver= DriverFactory.getDriver();
        this.ts=new TestUtil(driver);

    }

    @FindBy(xpath = "//a[text()='Tests']")
    private WebElement testButton;

    @FindBy(xpath = "//a[text()='Lab Test Directory']")
    private WebElement labTestDirectoryButton;

    @FindBy(css = "[placeholder='Search']")
    private WebElement search;

    @FindBy(css = "[class='search-bar'] i[class*='simple-icon-ma']")
    private WebElement searchIcon;

    @FindBy(css = "[class='search-bar'] i[class*='simple-icon-close']")
    private WebElement cancelIcon;

    @FindBy(css = "[class*='mb'] h1")
    private WebElement labDirectoryText;

    @FindBy(css = "[class='mb-4'] h3")
    private WebElement allText;

    @FindBy(xpath = "(//div[@class='action-card large card']/a)[1]")
    private WebElement testBundles;

    @FindBy(xpath = "//div[contains(@class,'card-body')]")
    private WebElement cardBody;

    @FindBy(css = "[class='btn btn-outline-primary']")
    private WebElement orderButton;

    @FindBy(css = "[class*='text-zero'] button")
    private WebElement backButton;

    @FindBy(css = "[class*='test-directory-search']")
    private WebElement searchTestResult;


    public void clickOnLabDirectoryButton()
    {
        ts.presenceOfElementWait(testButton);
        ts.scrollIntoView(labTestDirectoryButton);
        labTestDirectoryButton.click();
        ts.presenceOfElementWait(labDirectoryText);
        ts.presenceOfElementWait(search);
        ts.presenceOfElementWait(searchIcon);
        ts.presenceOfElementWait(cancelIcon);
    }

    public void clickOnEachElement() {
        ts.scrollPageDown();
        ts.presenceOfElementWait(testBundles);
        testBundles.click();
        List<WebElement> allElement = driver.findElements(By.cssSelector("[class*='d-flex px'] a"));
        for(WebElement r:allElement)
        {
            r.click();
            try{
                ts.waitForTheElementVisibility(cardBody,2);
                ts.waitForTheElementVisibility(orderButton,2);
            }
            catch(Exception e)
            {

            }
        }
    }

    public void searchTheTest()
    {
        ts.presenceOfElementWait(search);
        String test=prop.getProperty("searchTest");
        search.sendKeys(test);
        ts.presenceOfElementWait(searchTestResult);
    }



}
