package com.moichor.pages;

import com.moichor.base.DriverFactory;
import com.moichor.util.ConfigReader;
import com.moichor.util.TestUtil;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
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

    @FindBy(xpath = "//div[contains(text(),'successfully')]")
    private WebElement successStatus;

    @FindBy(xpath = "//div[contains(text(),'deleted')]")
    private WebElement deleteStatus;

    @FindBy(xpath = "(//span[@class='float-right']/parent::div/descendant::div[@id])[1]")
    private WebElement patientDropDown;

    @FindBy(xpath = "(//span[@class='float-right']/parent::div/descendant::div[@id])[1]/descendant::input")
    private WebElement patientInput;

    @FindBy(xpath = "(//input[@id='external_id'])[2]")
    private WebElement patientExternalId;

    @FindBy(css = "[class*='form-control b']")
    private WebElement weightDropDown;

    @FindBy(css = "[value='kg']")
    private WebElement weightUnit;

    @FindBy(css = "[name='weight']")
    private WebElement weightText;

    @FindBy(xpath = "//a[text()='Patients']")
    private WebElement patientButton;


    @FindBy(xpath = "(//*[@class='react-contextmenu-wrapper']//descendant::p)[1]")
    private WebElement addedPatient;

    @FindBy(css = "[class*='d-flex flex-row btn btn-d']")
    private WebElement patientConfirmDelete;

    @FindBy(xpath = "//span[@id='react-select-refspecies-live-region']/..")
    private WebElement speciesDropDown;

    @FindBy(id="react-select-refspecies-option-1")
    private WebElement speciesText;

    @FindBy(css = "[class='close'] span")
    private WebElement cancelButton;

    @FindBy(xpath = "//a[text()='Clients']")
    private WebElement clientButton;

    @FindBy(id="search")
    private  WebElement search;

    @FindBy(xpath = "(//div/a/p[contains(@class,'list-it')])[1]")
    private WebElement selectTheClient;

    @FindBy(xpath = "//button[text()='DELETE']")
    private WebElement deleteButton;

    @FindBy(css = "[class*='d-flex flex']")
    private WebElement confirmDelete;

    @FindBy(css = "[class*=' css-d']")
    private WebElement selectFirstElement;

    @FindBy(xpath = "(//div[contains(@class,' css-qr')]/div)[1]")
    private WebElement firstPatient;

    @FindBy(css = "[role='listbox'] [role='option']")
    private List<WebElement> selectPatient;

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
        int random=r.nextInt(100);
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

    public void searchTheClient()
    {
        ts.presenceOfElementWait(orderIcon);
        orderIcon.click();
        ts.presenceOfElementWait(clientDropDown);
        clientDropDown.click();
        ts.presenceOfElementWait(clientInput);
        String fn=prop.getProperty("searchClient");
        clientInput.sendKeys(fn);
        ts.presenceOfElementWait(selectFirstElement);
        selectFirstElement.click();
        ts.presenceOfElementWait(state);
    }

    public void addPatient() {

        patientDropDown.click();
        ts.presenceOfElementWait(patientInput);
        String pName=prop.getProperty("namePatient");
        int random=r.nextInt(100);
        Random r = new Random();
        char c = (char)(r.nextInt(26) + 'a');
        patientInput.sendKeys(pName+c+random);
        ts.presenceOfElementWait(selectFirstElement);
        selectFirstElement.click();
        ts.presenceOfElementWait(patientExternalId);
        String id=prop.getProperty("idPatient");
        patientExternalId.sendKeys(id);
        ts.presenceOfElementWait(speciesDropDown);
        speciesDropDown.click();
        ts.presenceOfElementWait(speciesText);
        ts.doActionsClick(speciesText);
        weightDropDown.click();
        ts.doActionsClick(weightUnit);
        String wg=prop.getProperty("weightPatient");
        weightText.clear();
        weightText.sendKeys(wg);
        ts.presenceOfElementWait(dob);
        String date=prop.getProperty("date");
        dob.sendKeys(date);
        ts.presenceOfElementWait(saveDetailsButton);
        saveDetailsButton.click();
        ts.presenceOfElementWait(status);
    }

    public void searchForAddedPatient()
    {
        ts.presenceOfElementWait(patientButton);
        patientButton.click();
        ts.presenceOfElementWait(search);
        String id=prop.getProperty("idPatient");
        search.sendKeys(id);


    }

    public void deleteTheAddedPatient(){
        ts.presenceOfElementWait(addedPatient);
        ts.clickOnElement(addedPatient);
        ts.presenceOfElementWait(deleteButton);
        deleteButton.click();
        ts.presenceOfElementWait(patientConfirmDelete);
        patientConfirmDelete.click();
        ts.presenceOfElementWait(deleteStatus);

    }


    public  void clickOnCancelButton()
    {
        ts.presenceOfElementWait(cancelButton);
        cancelButton.click();
    }

    public void deleteTheAddedClient() {
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
        ts.presenceOfElementWait(deleteStatus);
    }

    public void turnOnColonyModeAndAddAPatient()  {
        searchTheClient();
        ts.presenceOfElementWait(colonyModeButton);
        colonyModeButton.click();
        addPatient();
    }

    String st=prop.getProperty("state");
    String zip=prop.getProperty("zip");
    public void updateThePatient() {
        searchTheClient();
        state.clear();
        state.sendKeys(st);
        zipCode.clear();
        zipCode.sendKeys(zip);
        ts.presenceOfElementWait(saveButton);
        saveButton.click();
        ts.presenceOfElementWait(status);
        ts.presenceOfElementWait(patientDropDown);
        patientDropDown.click();
        int size=selectPatient.size();
        for(int i=0; i<size; i++)
        {
            selectPatient.get(i).click();
            break;
        }
        ts.presenceOfElementWait(editPatientButton);
        ts.presenceOfElementWait(editPatientButton);
        editPatientButton.click();
        ts.presenceOfElementWait(weightField);
        weightField.clear();
        String wg=prop.getProperty("weight");
        weightField.sendKeys(wg);
        saveDetailsButton.click();
        ts.presenceOfElementWait(status);
        ts.scrollIntoView(selectTestFromMenu);

    }

    public void turnOnColonyMode() {
        searchTheClient();
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
        int size=selectPatient.size();
        for(int i=0; i<size; i++)
        {
            selectPatient.get(i).click();
            break;
        }
        ts.presenceOfElementWait(editPatientButton);
        editPatientButton.click();
        ts.presenceOfElementWait(weightField);
        weightField.clear();
        String wg=prop.getProperty("weight");
        weightField.sendKeys(wg);
        saveDetailsButton.click();
        ts.presenceOfElementWait(successStatus);
        ts.scrollIntoView(selectTestFromMenu);
    }

    public void selectClientPatient(){
        ts.presenceOfElementWait(orderIcon);
        orderIcon.click();
        ts.presenceOfElementWait(clientDropDown);
        clientDropDown.click();
        ts.presenceOfElementWait(clientInput);
        String fn=prop.getProperty("searchClient");
        clientInput.sendKeys(fn);
        ts.presenceOfElementWait(selectFirstElement);
        selectFirstElement.click();
        ts.presenceOfElementWait(patientDropDown);
        patientDropDown.click();
        ts.presenceOfElementWait(patientInput);
        String pn=prop.getProperty("searchPatient");
        patientInput.sendKeys(pn);
        ts.presenceOfElementWait(selectFirstElement);
        selectFirstElement.click();
//        int size=selectPatient.size();
//        System.out.println(size);
//        for(int i=0; i<size; i++)
//        {
//            selectPatient.get(i).click();
//            break;
//        }
    }

    public void selectTestMenu() {
        ts.presenceOfElementWait(selectTestFromMenu);
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

    public void clickOnShippingLabel(){
        ts.presenceOfElementWait(shippindLabelIcon);
        shippindLabelIcon.click();
        ts.presenceOfElementWait(status);
        ts.openNewTab();
        driver.get("chrome://downloads/");
    }

}
