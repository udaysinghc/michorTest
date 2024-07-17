package com.healthPro.pages;

import com.healthPro.base.DriverFactory;
import com.healthPro.util.ConfigReader;
import com.healthPro.util.TestUtil;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Properties;

public class LogisticsPage {

    public WebDriver driver;
    TestUtil ts;
    public JavascriptExecutor js;
    ConfigReader configReader = new ConfigReader();
    Properties prop=configReader.init_prop();

    public LogisticsPage(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
        this.driver= DriverFactory.getDriver();
        this.ts=new TestUtil(driver);

    }

    @FindBy(xpath = "//a[text()='Tests']")
    private WebElement testButton;

    @FindBy(xpath = "//a[text()='Logistics']")
    private WebElement logisticsButton;

    @FindBy(xpath = "//i[contains(@class,'iconsminds-t')]/..")
    private WebElement sampleButton;

    @FindBy(xpath = "//i[contains(@class,'iconsminds-sho')]/..")
    private WebElement suppliesButton;

    @FindBy(css = "[class*='text-zero top'] button")
    private WebElement requestSupplies;

    @FindBy(css = "[class*='text-zero'] button")
    private WebElement getSampleShippingLabelButton;

    @FindBy(css = "[class*='d-flex flex-row btn ']")
    private WebElement confirmRequest;

    @FindBy(css = "[role='status']")
    private WebElement status;

    @FindBy(css = "[class*='card-body cursor'] a")
    private WebElement trackingNumbers;

    @FindBy(css = "[class='modal-body'] p")
    private WebElement noSampleTest;

    @FindBy(xpath = "//input[@type='checkbox']")
    private List<WebElement> checkBox;

    @FindBy(css = "[class='btn btn-info d-flex flex-row']")
    private WebElement confirmRequestButton;


    public void clickOnLogisticButton()
    {
        ts.presenceOfElementWait(testButton);
        ts.scrollIntoView(logisticsButton);
        logisticsButton.click();

    }

    public void clickOnSample() throws InterruptedException {
       try {
           ts.presenceOfElementWait(sampleButton);
           Thread.sleep(4000);
           sampleButton.click();
           ts.presenceOfElementWait(getSampleShippingLabelButton);
           getSampleShippingLabelButton.click();
           ts.presenceOfElementWait(confirmRequest);
           confirmRequest.click();
           Thread.sleep(5000);
           ts.switchToTab(0);
           ts.presenceOfElementWait(trackingNumbers);

       }
       catch(Exception e)
       {
           ts.presenceOfElementWait(noSampleTest);
           System.out.println(noSampleTest.getText());
       }

    }

    public void clickOnSupplies() throws InterruptedException {
        ts.presenceOfElementWait(suppliesButton);
        Thread.sleep(2000);
        suppliesButton.click();
        ts.presenceOfElementWait(requestSupplies);
        requestSupplies.click();
        Thread.sleep(5000);
        checkBox.get(0).click();
        ts.presenceOfElementWait(confirmRequestButton);
        confirmRequestButton.click();
        ts.presenceOfElementWait(status);

    }
}
