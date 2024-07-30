package com.moichor.pages;


import com.moichor.base.DriverFactory;
import com.moichor.util.ConfigReader;
import com.moichor.util.TestUtil;
import junit.framework.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Properties;

public class NotificationPage {

    public WebDriver driver;
    TestUtil ts;
    public JavascriptExecutor js;
    ConfigReader configReader = new ConfigReader();
    Properties prop=configReader.init_prop();
    public NotificationPage(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
        this.driver= DriverFactory.getDriver();
        this.ts=new TestUtil(driver);

    }

    @FindBy(xpath = "//a[text()='Tests']")
    private WebElement testButton;

    @FindBy(css = "[class*='mb'] h1")
    private WebElement testText;

    @FindBy(id="search")
    private WebElement searchBar;

    @FindBy(css = "[class*='top-right-button btn']")
    private WebElement addNewButton;

    @FindBy(xpath = "(//div[@class='collapse show']/descendant::p[contains(@class,'list')])[1]")
    private WebElement firstTest;

    @FindBy(css = "[class*='col'] h1")
    private WebElement testDetail;

    @FindBy(css = "[class='d-flex flex-row'] span")
    private WebElement saveButton;

    @FindBy(id="body")
    private WebElement textBody;

    @FindBy(css = "[class*='event-send-button']")
    private WebElement sendButton;

    @FindBy(xpath = "(//button[@class='btn btn-success btn-sm'])[1]")
    private WebElement replyButton;

    @FindBy(id = "notificationsButton")
    private WebElement notificationButton;

    @FindBy(css = "[class='false nav-link']")
    private WebElement messageSent;

    @FindBy(css = "[class='active nav-link']")
    private WebElement messageReceived;

    @FindBy(xpath = "(//*[@class='d-flex flex-row list-item-card card'])[1]")
    private WebElement sentMessageDisplayed;

    @FindBy(xpath = "(//*[contains(@class,'notification-item')]/div)[1]")
    private WebElement notificationText;

    @FindBy(xpath = "(//div[contains(@class,'d-flex flex-row list-title notification')])[1]")
    private WebElement testID;

    @FindBy(css = "[class='mb-2 form-control']")
    private WebElement textArea;

    @FindBy(css = "[class*='flex btn btn']")
    private WebElement sendMessage;

    @FindBy(xpath = "(//*[@class='card-body'])[1]")
    private WebElement sentMessage;

    @FindBy(xpath = "(//div[@class='w-30 mb-1 w-sm-100 notification-item d-flex flex-row'])[1]")
    private WebElement messageText;

    public void clickOnTestButton()
    {
        ts.presenceOfElementWait(testButton);
        testButton.click();
        ts.presenceOfElementWait(searchBar);
        ts.presenceOfElementWait(testText);
        ts.presenceOfElementWait(addNewButton);

    }

    public void selectTheTest()
    {
        ts.presenceOfElementWait(firstTest);
        firstTest.click();
    }

    public void sendMessageToAdmin() throws InterruptedException {
        ts.presenceOfElementWait(testDetail);
        ts.presenceOfElementWait(saveButton);
        ts.scrollIntoView(textBody);
        ts.presenceOfElementWait(textBody);
        String sms= prop.getProperty("message");
        textBody.sendKeys(sms);
        ts.presenceOfElementWait(sendButton);
        sendButton.click();
        Thread.sleep(2000);
        ts.presenceOfElementWait(replyButton);
        ts.presenceOfElementWait(notificationButton);
        notificationButton.click();
        ts.presenceOfElementWait(messageSent);
        messageSent.click();
        ts.presenceOfElementWait(sentMessageDisplayed);
        ts.presenceOfElementWait(notificationText);
        String note = notificationText.getText();
        Assert.assertEquals(sms,note);
    }


    public void searchMessageReceivedFromClientSide()
    {
        ts.presenceOfElementWait(notificationButton);
        notificationButton.click();
        ts.presenceOfElementWait(messageSent);
        messageSent.click();
        ts.presenceOfElementWait(messageReceived);
        messageReceived.click();
        ts.presenceOfElementWait(sentMessageDisplayed);
        String sms= prop.getProperty("message");
        ts.presenceOfElementWait(messageText);
        String text = messageText.getText();
        Assert.assertEquals("Message text validated",sms,text);


    }

    public void sendMessageToClient() throws InterruptedException {
        ts.presenceOfElementWait(testID);
        testID.click();
        Thread.sleep(2000);
        ts.switchToTab(1);
        ts.presenceOfElementWait(textArea);
        String sms=prop.getProperty("messageToClient");
        textArea.sendKeys(sms);
        ts.presenceOfElementWait(sendMessage);
        sendMessage.click();
        ts.presenceOfElementWait(sentMessage);
        ts.switchToTab(0);
        ts.presenceOfElementWait(messageSent);
        messageSent.click();
        ts.presenceOfElementWait(sentMessageDisplayed);
        ts.presenceOfElementWait(messageText);
        String text = messageText.getText();
        Assert.assertEquals("Message text validated",sms,text);
    }

    public void searchMessageReceivedFromAdminSide() throws InterruptedException {
        ts.presenceOfElementWait(notificationButton);
        Thread.sleep(5000);
        notificationButton.click();
        ts.presenceOfElementWait(sentMessageDisplayed);
        ts.presenceOfElementWait(notificationText);
        String note = notificationText.getText();
        String sms= prop.getProperty("messageToClient");
        Assert.assertEquals("Message text validation",sms,note);

    }
}