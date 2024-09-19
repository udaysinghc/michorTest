package com.moichor.pages;

import com.moichor.base.DriverFactory;
import com.moichor.util.ConfigReader;
import com.moichor.util.TestUtil;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Properties;

public class AlertsPage {

    public WebDriver driver;
    TestUtil ts;
    public JavascriptExecutor js;
    ConfigReader configReader = new ConfigReader();
    Properties prop=configReader.init_prop();

    public AlertsPage(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
        this.driver= DriverFactory.getDriver();
        this.ts=new TestUtil(driver);

    }

    @FindBy(xpath = "//a[text()='Clinics']")
    private WebElement clinic;

    @FindBy(xpath = "//i[@class='iconsminds-information']/..")
    private WebElement alertsLink;

    @FindBy(css = "[class*='mb'] h1")
    private WebElement alertsText;

    @FindBy(css = "[class*='top-right-button btn']")
    private WebElement addAlertsButton;

    @FindBy(id = "search")
    private WebElement searchBar;

    @FindBy(css = "[class='btn-group'] button")
    private List<WebElement> alertsButton;

    @FindBy(xpath = "//div[contains(@id,'react-select-cl')]/../../..")
    private WebElement clinicNameDropDown;

    @FindBy(xpath = "//div[contains(@id,'react-select-cl')]/../../../descendant::input")
    private WebElement clinicNameInput;

    @FindBy(css = "[role='listbox']")
    private WebElement listBox;

    @FindBy(xpath = "(//div[@role='option'])[1]")
    private WebElement elementInDropDown;

    @FindBy(css = "[role='listbox'] [role='option']")
    private List<WebElement> dropDownElements;

    @FindBy(xpath = "//div[contains(@id,'react-select-le')]/../../..")
    private WebElement levelDropDown;

    @FindBy(xpath = "//div[contains(@id,'react-select-le')]/../../../descendant::input")
    private WebElement levelInput;

    @FindBy(id = "subject")
    private WebElement subjectInputField;

    @FindBy(id = "message")
    private WebElement messageInputField;

    @FindBy(css = "[class*='react-datepicker__input'] input")
    private WebElement dateTimeInputField;

    @FindBy(css = "[class='btn btn-info']")
    private WebElement submitButton;

    @FindBy(xpath = "//span[contains(@id,'react-select-level')]/..")
    private WebElement levelNewDropDown;

    @FindBy(xpath = "//span[contains(@id,'react-select-level')]/../descendant::input")
    private WebElement levelNewInputField;


    @FindBy(css = "[role='status']")
    private WebElement status;

    @FindBy(xpath = "(//div[@class='d-flex flex-row alert-card-info card']/*/*/*/*)[1]")
    private WebElement firstAlerts;

    @FindBy(xpath = "//div[@class='infinite-scroll-component ']")
    private WebElement allAlerts;

    @FindBy(css = "[class='btn btn-danger']")
    private WebElement deleteAlertsButton;

    @FindBy(css = "[class*='d-flex btn btn-danger']")
    private WebElement yesButtonForDeletingAlerts;

    public void addAAlerts()  {
        ts.presenceOfElementWait(clinic);
        ts.scrollIntoView(alertsLink);
        ts.presenceOfElementWait(alertsLink);
        alertsLink.click();
        ts.presenceOfElementWait(alertsText);
        ts.presenceOfElementWait(searchBar);
        ts.presenceOfElementWait(addAlertsButton);
        addAlertsButton.click();
        ts.presenceOfElementWait(clinicNameDropDown);
        clinicNameDropDown.click();
        ts.presenceOfElementWait(clinicNameInput);
        String clinicName=prop.getProperty("clinic");
        clinicNameInput.sendKeys(clinicName);
        ts.presenceOfElementWait(listBox);
        ts.presenceOfElementWait(elementInDropDown);
        int size=dropDownElements.size();
        for(int i=0; i<size; i++)
        {
            String clinic=dropDownElements.get(i).getText();
            if(clinic.contains(clinicName))
            {
                dropDownElements.get(i).click();
                break;
            }
        }
        ts.presenceOfElementWait(levelDropDown);
        levelDropDown.click();
        ts.presenceOfElementWait(levelInput);
        String levelName=prop.getProperty("level");
        levelInput.sendKeys(levelName);
        ts.presenceOfElementWait(listBox);
        ts.presenceOfElementWait(elementInDropDown);
        int listOfLevels=dropDownElements.size();
        for(int i=0; i<listOfLevels; i++)
        {

            String levels=dropDownElements.get(i).getText();
            if(levels.contains(levelName))
            {
                System.out.println("hello from if block");
                dropDownElements.get(i).click();
                break;
            }
        }
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yy HH:mm");
        String formattedDateTime = now.format(formatter);
        ts.presenceOfElementWait(subjectInputField);
        String subject=prop.getProperty("subject");
        subjectInputField.sendKeys(subject);
        ts.presenceOfElementWait(messageInputField);
        String message=prop.getProperty("message");
        messageInputField.sendKeys(message);
        ts.presenceOfElementWait(dateTimeInputField);
        dateTimeInputField.sendKeys(formattedDateTime);
        ts.presenceOfElementWait(submitButton);
        submitButton.click();
        ts.presenceOfElementWait(status);
        String successMessage=status.getText();
        Assert.assertTrue(successMessage.contains("successfully"));
    }

    public void searchTheAddedAlerts()
    {
        ts.presenceOfElementWait(searchBar);
        String clinic=prop.getProperty("clinic");
        searchBar.sendKeys(clinic);
        ts.presenceOfElementWait(firstAlerts);
    }

    public void editTheAlerts()  {
        ts.presenceOfElementWait(firstAlerts);
        ts.clickOnElement(firstAlerts);
        ts.presenceOfElementWait(levelNewDropDown);
        levelNewDropDown.click();
        ts.presenceOfElementWait(levelNewInputField);
        String editLevel=prop.getProperty("editLevel");
        levelNewInputField.sendKeys(editLevel);
        ts.presenceOfElementWait(listBox);
        levelNewInputField.sendKeys(Keys.ENTER);
        ts.presenceOfElementWait(submitButton);
        submitButton.click();
        ts.presenceOfElementWait(status);
        String successMessage=status.getText();
        Assert.assertTrue(successMessage.contains("successfully"));
    }

    public void deleteTheAlerts()
    {
        ts.presenceOfElementWait(firstAlerts);
        firstAlerts.click();
        ts.presenceOfElementWait(deleteAlertsButton);
        deleteAlertsButton.click();
        ts.presenceOfElementWait(yesButtonForDeletingAlerts);
        yesButtonForDeletingAlerts.click();
        ts.presenceOfElementWait(status);
        String successMessage=status.getText();
        Assert.assertTrue(successMessage.contains("successfully"));
    }

    public void clickAllTHeButton()
    {
        ts.presenceOfElementWait(clinic);
        ts.scrollIntoView(alertsLink);
        ts.presenceOfElementWait(alertsLink);
        alertsLink.click();
        ts.presenceOfElementWait(alertsText);
        ts.presenceOfElementWait(searchBar);
        int size=alertsButton.size();
        for(int i=0; i<size; i++)
        {
            alertsButton.get(i).click();
            ts.presenceOfElementWait(allAlerts);
        }
    }
 }
