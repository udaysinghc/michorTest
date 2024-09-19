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

public class BillingPage {

    public WebDriver driver;
    TestUtil ts;
    public JavascriptExecutor js;
    ConfigReader configReader = new ConfigReader();
    Properties prop=configReader.init_prop();

    public BillingPage(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
        this.driver= DriverFactory.getDriver();
        this.ts=new TestUtil(driver);

    }

    @FindBy(xpath = "//a[text()='Tests']")
    private WebElement testButton;

    @FindBy(xpath = "//a[text()='Veterinarians']")
    private WebElement vetButton;

    @FindBy(xpath = "//a[text()='Billing']")
    private WebElement billingButton;

    @FindBy(css = "[class*='col'] div h1")
    private WebElement paymentsText;

    @FindBy(id="search")
    private WebElement searchBar;

    @FindBy(css = "[class*='search-icon']")
    private WebElement searchIcon;

    @FindBy(xpath = "(//div[@id='datepicker-end-position']/descendant::input)[1]")
    private WebElement startDate;

    @FindBy(xpath = "(//div[@id='datepicker-end-position']/descendant::input)[2]")
    private WebElement endDate;

    @FindBy(css = "[class*='simple-icon-btn']")
    private WebElement reloadButton;

    @FindBy(css = "[class*='infinite-scroll-component__out']")
    private WebElement allInvoice;

    @FindBy(xpath = "(//div[@class='infinite-scroll-component__outerdiv']/descendant::span)[1]")
    private WebElement selectInvoice;

    @FindBy(css = "[class='modal-body'] h2")
    private WebElement invoiceText;

    @FindBy(css = "[class='modal-body'] p")
    private WebElement allTextInInvoice;

    @FindBy(css = "[class*='position'] button")
    private WebElement pdfButton;


    public void clickOnBillingButton()
    {
        ts.presenceOfElementWait(testButton);
        ts.scrollIntoView(billingButton);
        billingButton.click();
        ts.presenceOfElementWait(paymentsText);
        ts.presenceOfElementWait(searchBar);
        ts.presenceOfElementWait(searchIcon);
        ts.presenceOfElementWait(startDate);
        ts.presenceOfElementWait(endDate);
        ts.presenceOfElementWait(reloadButton);
        ts.presenceOfElementWait(allInvoice);

    }

    public void clickOnParticularInvoice()
    {
        ts.presenceOfElementWait(selectInvoice);
        selectInvoice.click();
        ts.presenceOfElementWait(invoiceText);
        ts.presenceOfElementWait(allTextInInvoice);
    }

    public void clickOnPDFButton()  {
        ts.scrollIntoView(pdfButton);
        pdfButton.click();
        ts.openNewTab();
        ts.switchToTab(1);
        driver.get("chrome://downloads/");

    }



}
