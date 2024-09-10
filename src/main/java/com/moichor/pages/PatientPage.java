package com.moichor.pages;

import com.moichor.base.DriverFactory;
import com.moichor.util.ConfigReader;
import com.moichor.util.TestUtil;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Properties;
import java.util.Random;

public class PatientPage {

    public WebDriver driver;
    TestUtil ts;
    public JavascriptExecutor js;
    ConfigReader configReader = new ConfigReader();
    Properties prop=configReader.init_prop();
    public PatientPage(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
        this.driver= DriverFactory.getDriver();
        this.ts=new TestUtil(driver);

    }

    @FindBy(xpath = "//a[text()='Clients']")
    private WebElement clientButton;

    @FindBy(css = "[class*='mb'] h1")
    private WebElement clientText;

    @FindBy(id="fname")
    private WebElement firstName;

    @FindBy(id="lname")
    private WebElement lastName;

    @FindBy(id="external_id")
    private WebElement externalId;

    @FindBy(css = "[class*='float']")
    private WebElement saveButton;

    @FindBy(xpath = "//a[text()='Patients']")
    private WebElement patientButton;

    @FindBy(css = "[role='status']")
    private WebElement status;

    @FindBy(id="search")
    private WebElement search;

    @FindBy(css = "[class*='mb'] h1")
    private WebElement patientText;

    @FindBy(css = "[class*='top-right-button ']")
    private WebElement addNewButton;

    @FindBy(id="name")
    private WebElement pName;

    @FindBy(css = "[class*='form-control b']")
    private WebElement weightDropDown;

    @FindBy(id="external_id")
    private WebElement internalId;

    @FindBy(xpath = "//span[@id='react-select-refspecies-live-region']/..")
    private WebElement speciesDropDown;

    @FindBy(css = "[name='weight']")
    private WebElement weightText;

    @FindBy(css = "[value='kg']")
    private WebElement weightUnit;

    @FindBy(id="react-select-refspecies-option-1")
    private WebElement speciesText;

    @FindBy(css = "[placeholder='DOB']")
    private WebElement dob;

    @FindBy(xpath = "//button[text()='SAVE']")
    private WebElement patientSaveButton;

    @FindBy(xpath = "//span[@id='react-select-client-live-region']/..")
    private WebElement clientSearch;

    @FindBy(xpath = "//span[@id='react-select-client-live-region']/../descendant::input")
    private WebElement passClientName;

    @FindBy(xpath = "//div/a/p[contains(@class,'list-it')]")
    private WebElement selectThePatient;

    @FindBy(css = "[class*='false n']")
    private WebElement testLink;

    @FindBy(css = "[class*='top-right-button ']")
    private WebElement createTest;

    @FindBy(css = "[class*='d-flex flex-row ali'] button")
    private WebElement selectTestFromMenu;

    @FindBy(xpath = "//span[contains(@id,'react-select-4')]/..")
    private WebElement selectTestDropDown;

    @FindBy(xpath = "//div[text()='Wellness Plus Thyroid Panel']")
    private WebElement selectTest;

    @FindBy(xpath = "//button[text()='Apply and Close']")
    private WebElement applyCloseButton;

    @FindBy(xpath = "//button[.='Or Request a Sample ID without a Moichor Slide']")
    private WebElement generateVerificationCode;

    @FindBy(css = "[name='id']")
    private WebElement code;
    @FindBy(xpath = "//button[text()='Create']")
    private WebElement createButton;

    @FindBy(xpath = "//button[text()='DELETE']")
    private WebElement deleteButton;

    @FindBy(css = "[class*='d-flex flex-row btn btn-d']")
    private WebElement confirmDelete;

    @FindBy(css = "[class*='infinite-scroll-component ']")
    private WebElement noResultMessage;


    @FindBy(xpath = "//a[text()='Tests']")
    private WebElement testButton;

    @FindBy(css = "[class*='d-flex li']")
    private WebElement addedTest;

    public void clickOnClientButton()
    {
        ts.presenceOfElementWait(clientButton);
        clientButton.click();
        ts.presenceOfElementWait(clientText);
        ts.presenceOfElementWait(search);
    }

    public void clickOnPatientButton()
    {
        ts.presenceOfElementWait(patientButton);
        patientButton.click();
        ts.presenceOfElementWait(search);
        ts.presenceOfElementWait(patientText);
        ts.presenceOfElementWait(addNewButton);
    }

    static  Random r=new Random();
    static int random=r.nextInt(100);
    String clientID=prop.getProperty("externalID");

    public void addClient()  {
        ts.presenceOfElementWait(addNewButton);
        addNewButton.click();
        String fn = prop.getProperty("firstNameClient");
        String ln = prop.getProperty("lastNameClient");
        firstName.sendKeys(fn+random);
        lastName.sendKeys(ln);
        externalId.sendKeys(clientID);
        saveButton.click();
        ts.presenceOfElementWait(status);

    }

    static int random2=r.nextInt(100);
    String patientID=prop.getProperty("idPatient");
    public void addPatient() throws InterruptedException {
        clickOnPatientButton();
        ts.presenceOfElementWait(addNewButton);
        Thread.sleep(2000);
        addNewButton.click();
        Thread.sleep(2000);
        ts.presenceOfElementWait(pName);
        String name=prop.getProperty("namePatient");
        pName.sendKeys(name+random2);
        weightDropDown.click();
        ts.doActionsClick(weightUnit);
        String wg=prop.getProperty("weightPatient");
        weightText.sendKeys(wg);
        internalId.sendKeys(patientID);
        clientSearch.click();
        String clientFName=prop.getProperty("firstNameClient");
        String clientLName=prop.getProperty("lastNameClient");
        ts.presenceOfElementWait(passClientName);
        passClientName.sendKeys(clientFName+random);
        String text=clientFName+random+" "+clientLName;
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[text()='"+text+"']")).click();
        ts.presenceOfElementWait(speciesDropDown);
        speciesDropDown.click();
        ts.doActionsClick(speciesText);
        String dateOFBirth=prop.getProperty("dateOfBirth");
        dob.sendKeys(dateOFBirth);
        patientSaveButton.click();
        ts.presenceOfElementWait(status);
    }

    public void selectTheAddedPatient()
    {
        ts.presenceOfElementWait(search);
        search.sendKeys(patientID);
        ts.presenceOfElementWait(selectThePatient);
        selectThePatient.click();
    }

    public void editedThePatient()
    {
        ts.presenceOfElementWait(dob);
        String date=prop.getProperty("date");
        dob.sendKeys(date);
        patientSaveButton.click();
        ts.presenceOfElementWait(status);

    }

    public void deleteThePatient()
    {
        ts.presenceOfElementWait(deleteButton);
        deleteButton.click();
        ts.presenceOfElementWait(confirmDelete);
        confirmDelete.click();
    }

    public void searchTheDeletedPatient() {
        ts.presenceOfElementWait(search);
        String pName=prop.getProperty("namePatient");
        search.sendKeys(pName+random2);
        ts.presenceOfElementWait(noResultMessage);


    }
    static String codeText;
    public void addTest() throws InterruptedException {
        ts.presenceOfElementWait(createTest);
        createTest.click();
        ts.presenceOfElementWait(selectTestFromMenu);
        selectTestFromMenu.click();
        ts.presenceOfElementWait(selectTestDropDown);
        selectTestDropDown.click();
        ts.presenceOfElementWait(selectTest);
        selectTest.click();
        ts.scrollIntoView(applyCloseButton);
        applyCloseButton.click();
        ts.presenceOfElementWait(generateVerificationCode);
        generateVerificationCode.click();
        ts.presenceOfElementWait(code);
        codeText = ts.doGetElementAttribute(code, "value");
        System.out.println(codeText);
        ts.scrollPageDown();
        ts.presenceOfElementWait(createButton);
        createButton.click();
        Thread.sleep(5000);
        ts.presenceOfElementWait(status);

    }


    public void searchTheTest()
    {
        ts.presenceOfElementWait(testButton);
        testButton.click();
        ts.presenceOfElementWait(search);
        search.sendKeys(codeText);
        ts.presenceOfElementWait(addedTest);

    }


}
