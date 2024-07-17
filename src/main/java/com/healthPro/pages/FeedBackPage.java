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

public class FeedBackPage {

    public WebDriver driver;
    TestUtil ts;
    public JavascriptExecutor js;
    ConfigReader configReader = new ConfigReader();
    Properties prop=configReader.init_prop();

    public FeedBackPage(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
        this.driver= DriverFactory.getDriver();
        this.ts=new TestUtil(driver);

    }

    @FindBy(xpath = "//a[text()='Tests']")
    private WebElement testButton;

    @FindBy(xpath = "//a[text()='Feedback']")
    private WebElement feedbackButton;

    @FindBy(css = "[class='modal-header'] h5")
    private WebElement title;

    @FindBy(css = "[class='modal-body']")
    private WebElement body;

    @FindBy(css = "[class='modal-body'] textarea")
    private WebElement textArea;

    @FindBy(css = "[class*='d-flex flex-row btn']")
    private WebElement submitButton;

    @FindBy(css = "[class='btn btn-outline-primary']")
    private WebElement cancelButton;

    @FindBy(css = "[class='close'] span")
    private WebElement cancelIcon;

    @FindBy(css = "[role='status']")
    private WebElement status;

    public void clickOnFeedbackButton()
    {
        ts.presenceOfElementWait(testButton);
        ts.scrollIntoView(feedbackButton);
        feedbackButton.click();
        ts.presenceOfElementWait(title);
        ts.presenceOfElementWait(body);
        ts.presenceOfElementWait(submitButton);
        ts.presenceOfElementWait(cancelButton);
        ts.presenceOfElementWait(cancelIcon);
        ts.presenceOfElementWait(textArea);
    }

    public void addFeedback()
    {
        ts.presenceOfElementWait(textArea);
        String text=prop.getProperty("text");
        textArea.sendKeys(text);
        submitButton.click();
        ts.presenceOfElementWait(status);

    }

}
