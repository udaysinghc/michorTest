package com.healthPro.pages;

import com.healthPro.base.DriverFactory;
import com.healthPro.util.ConfigReader;
import com.healthPro.util.TestUtil;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Properties;
import java.util.Random;

public class HomePage {

    public WebDriver driver;
    TestUtil ts;
    public JavascriptExecutor js;
    ConfigReader configReader = new ConfigReader();
    Properties prop=configReader.init_prop();

    public HomePage(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
        this.driver= DriverFactory.getDriver();
        this.ts=new TestUtil(driver);

    }

    @FindBy(css = "[class='simple-icon-plus']")
    private WebElement orderIcon;


    @FindBy(xpath = "//span[contains(@id,'react')]/..")
    private WebElement clientDropDown;

    @FindBy(xpath = "//span[contains(@id,'react')]/../descendant::input[@id]")
    private WebElement clientInput;

    @FindBy(css = "[class*=' css-d']")
    private WebElement createClient;

    @FindBy(css = "[class*='float-right ']")
    private WebElement saveButton;

    @FindBy(id="lname")
    private WebElement lastName;

    @FindBy(id="external_id")
    private WebElement externalId;

    @FindBy(id="state")
    private WebElement state;

    @FindBy(id="zip")
    private WebElement zipCode;

    @FindBy(css = "[role='status']")
    private WebElement status;

    @FindBy(xpath = "(//span[@class='float-right']/parent::div/descendant::div[@id])[1]")
    private WebElement patientDropDown;

    @FindBy(xpath = "(//span[@class='float-right']/parent::div/descendant::div[@id])[1]/descendant::input")
    private WebElement patientInput;

    @FindBy(css = "[class='close'] span")
    private WebElement cancelButton;

    @FindBy(xpath = "//a[text()='Clients']")
    private WebElement clientButton;

    @FindBy(id="search")
    private  WebElement search;

    @FindBy(xpath = "//div/a/p[contains(@class,'list-it')]")
    private WebElement selectTheClient;

    @FindBy(xpath = "//button[text()='DELETE']")
    private WebElement deleteButton;

    @FindBy(css = "[class*='d-flex flex']")
    private WebElement confirmDelete;

    @FindBy(css = "[class*=' css-d']")
    private WebElement selectClient;

    @FindBy(css = "[class*=' css-q']")
    private WebElement selectPatient;

    @FindBy(css = "[class*='float-right ml']")
    private WebElement updateButton;

    @FindBy(css = "[name='note']")
    private WebElement noteField;

    @FindBy(css = "[class='btn btn-primary']")
    private WebElement confirmUpdate;

    @FindBy(css = "[class*='float-right btn btn-d']")
    private WebElement revertButton;

    @FindBy(css = "[class*='grid '] span")
    private WebElement editPatientButton;

    @FindBy(id="weight")
    private WebElement weightField;

    @FindBy(css = "[class*='react-datepicker__i'] input")
    private WebElement dob;

    @FindBy(xpath = "//button[text()='SAVE DETAILS']")
    private WebElement saveDetailsButton;

    @FindBy(css = "[class*='d-flex flex-row ali'] button")
    private WebElement selectTestFromMenu;

    @FindBy(xpath = "//label[contains(@class,'mr')]/following-sibling::button")
    private WebElement colonyModeButton;

    @FindBy(css = "div[class='mt-3'] textarea")
    private WebElement noteColony;


    @FindBy(css = "[class*='btn btn-success']")
    private WebElement updateButtonColony;



    @FindBy(xpath = "//button[text()='Revert']")
    private WebElement revertButtonColony;

    @FindBy(xpath = "//button[text()='Yes']")
    private WebElement yesButton;


    @FindBy(css = "[class*='mb-3']")
    private WebElement selectTest;

    @FindBy(css = "[class*='mb-3'] input")
    private  WebElement selectTestInput;

    @FindBy(css = "[class*=' css-q'] div")
    private WebElement addTest;

    @FindBy(xpath = "//button[text()='Apply and Close']")
    private WebElement applyCloseButton;

    @FindBy(xpath = "//button[.='Or Request a Sample ID without a Moichor Slide']")
    private WebElement generateVerificationCode;


    @FindBy(css = "[class*='iconsminds-mail']")
    private WebElement shippindLabelIcon;


    static Random r=new Random();
    static int random=r.nextInt(100);
    String id=prop.getProperty("clientID");



    public void addClient()
    {
        ts.presenceOfElementWait(orderIcon);
        orderIcon.click();
        ts.presenceOfElementWait(clientDropDown);
        clientDropDown.click();
        ts.presenceOfElementWait(clientInput);
        String fn=prop.getProperty("clientFirstName");
        String ln=prop.getProperty("clientLastName");
        clientInput.sendKeys(fn+random);
        ts.presenceOfElementWait(createClient);
        createClient.click();
        ts.presenceOfElementWait(saveButton);
        lastName.sendKeys(ln);
        externalId.sendKeys(id);
        saveButton.click();
        ts.presenceOfElementWait(status);
        ts.presenceOfElementWait(patientDropDown);

    }

    public  void clickOnCancelButton()
    {
        ts.presenceOfElementWait(cancelButton);
        cancelButton.click();
    }

    public void deleteTheAddedClient()
    {
        ts.presenceOfElementWait(clientButton);
        clientButton.click();
        ts.presenceOfElementWait(search);
        search.sendKeys(id);
        ts.presenceOfElementWait(selectTheClient);
        selectTheClient.click();
        ts.presenceOfElementWait(deleteButton);
        deleteButton.click();
        ts.presenceOfElementWait(confirmDelete);
        confirmDelete.click();
        ts.presenceOfElementWait(status);


    }

    String st=prop.getProperty("state");
    String zip=prop.getProperty("zip");
    public void updateThePatient()  {
        ts.presenceOfElementWait(orderIcon);
        orderIcon.click();
        ts.presenceOfElementWait(clientDropDown);
        clientDropDown.click();
        ts.presenceOfElementWait(clientInput);
        String fn=prop.getProperty("searchClient");
        clientInput.sendKeys(fn);
        ts.presenceOfElementWait(selectClient);
        selectClient.click();
        ts.presenceOfElementWait(state);
        state.clear();
        state.sendKeys(st);
        zipCode.clear();
        zipCode.sendKeys(zip);
        ts.presenceOfElementWait(saveButton);
        saveButton.click();
        ts.presenceOfElementWait(status);
        ts.presenceOfElementWait(patientDropDown);
        patientDropDown.click();
        ts.presenceOfElementWait(selectPatient);
        selectPatient.click();
        ts.presenceOfElementWait(editPatientButton);
        ts.presenceOfElementWait(editPatientButton);
        editPatientButton.click();
        ts.presenceOfElementWait(dob);
        dob.clear();
        String date=prop.getProperty("date");
        dob.sendKeys(date);
        ts.presenceOfElementWait(weightField);
        weightField.clear();
        String wg=prop.getProperty("weight");
        weightField.sendKeys(wg);
        saveDetailsButton.click();
        ts.presenceOfElementWait(status);
        ts.scrollIntoView(selectTestFromMenu);

    }

    public void turnOnColonyMode() throws InterruptedException {
        ts.presenceOfElementWait(orderIcon);
        orderIcon.click();
        ts.presenceOfElementWait(clientDropDown);
        clientDropDown.click();
        ts.presenceOfElementWait(clientInput);
        String fn=prop.getProperty("searchClient");
        clientInput.sendKeys(fn);
        ts.presenceOfElementWait(selectClient);
        selectClient.click();
        ts.presenceOfElementWait(state);
        state.clear();
        state.sendKeys(st);
        zipCode.clear();
        zipCode.sendKeys(zip);
        ts.presenceOfElementWait(saveButton);
        saveButton.click();
        ts.presenceOfElementWait(status);
        ts.presenceOfElementWait(colonyModeButton);
        colonyModeButton.click();
        ts.presenceOfElementWait(patientDropDown);
        patientDropDown.click();
        ts.presenceOfElementWait(selectPatient);
        selectPatient.click();
        ts.presenceOfElementWait(editPatientButton);
        ts.presenceOfElementWait(editPatientButton);
        editPatientButton.click();
        ts.presenceOfElementWait(weightField);
        weightField.clear();
        String wg=prop.getProperty("weight");
        weightField.sendKeys(wg);
        saveDetailsButton.click();
        Thread.sleep(2000);
        ts.presenceOfElementWait(status);
        ts.scrollIntoView(selectTestFromMenu);
    }

    public void selectClientPatient() throws InterruptedException {
        ts.presenceOfElementWait(orderIcon);
        orderIcon.click();
        ts.presenceOfElementWait(clientDropDown);
        clientDropDown.click();
        ts.presenceOfElementWait(clientInput);
        String fn=prop.getProperty("searchClient");
        clientInput.sendKeys(fn);
        ts.presenceOfElementWait(selectClient);
        selectClient.click();
        ts.presenceOfElementWait(patientDropDown);
        patientDropDown.click();
        ts.presenceOfElementWait(patientInput);
        String pn=prop.getProperty("searchPatient");
        patientInput.sendKeys(pn);
        Thread.sleep(4000);
        patientInput.sendKeys(Keys.ENTER);
//        ts.presenceOfElementWait(selectPatient);
//        selectPatient.click();
    }
    public void selectTestMenu() throws InterruptedException {
        Thread.sleep(5000);
        ts.scrollIntoView(selectTestFromMenu);
        selectTestFromMenu.click();
        ts.presenceOfElementWait(selectTest);
        selectTest.click();
        ts.presenceOfElementWait(selectTestInput);
        String test=prop.getProperty("NameOfTest");
        selectTestInput.sendKeys(test);
        ts.presenceOfElementWait(addTest);
        addTest.click();
        ts.scrollIntoView(applyCloseButton);
        applyCloseButton.click();
        ts.presenceOfElementWait(generateVerificationCode);
    }

    public void clickOnShippingLabel() throws InterruptedException {
        ts.presenceOfElementWait(shippindLabelIcon);
        shippindLabelIcon.click();
        Thread.sleep(5000);
        ts.presenceOfElementWait(status);
        ts.openNewTab();
        driver.get("chrome://downloads/");

    }

}
