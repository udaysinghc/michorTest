package com.healthPro.pages;

import com.healthPro.base.DriverFactory;
import com.healthPro.util.ConfigReader;
import com.healthPro.util.TestUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Properties;
import java.util.Random;

public class ClientsPage  {

    public WebDriver driver;
    ;
    TestUtil ts;
    ConfigReader configReader = new ConfigReader();
    Properties prop=configReader.init_prop();

    public ClientsPage(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
        this.driver=DriverFactory.getDriver();
        this.ts=new TestUtil(driver);
    }

    @FindBy(xpath = "//a[text()='Clients']")
    private WebElement clientButton;

    @FindBy(css = "[class*='top-right-button btn']")
    private WebElement addNewButton;

    @FindBy(css = "[class*='mb'] h1")
    private WebElement clientText;

  @FindBy(id="search")
  private  WebElement search;

    @FindBy(css = "[class*='col-'] h1")
    private WebElement createClientText;

    @FindBy(id="fname")
    private WebElement firstName;

    @FindBy(id="lname")
    private WebElement lastName;

    @FindBy(id="external_id")
    private WebElement externalId;

    @FindBy(css = "[class*='float']")
    private WebElement saveButton;

    @FindBy(xpath = "//div/a/p[contains(@class,'list-it')]")
    private WebElement selectClient;

    @FindBy(css = "[class*='flex-grow']")
    private WebElement createPatientButton;

    @FindBy(css = "[class='col-12'] h1")
    private WebElement createPatientText;

    @FindBy(id="name")
    private WebElement pName;

    @FindBy(css = "[placeholder='DOB']")
    private WebElement dob;

    @FindBy(xpath = "(//div[contains(@class,' css-')])[1]")
    private WebElement genderDropDown;

    @FindBy(id="weight")
    private WebElement weight;

    @FindBy(css = "[class*='form-control b']")
    private WebElement weightDropDown;

    @FindBy(css = "[name='weight']")
    private WebElement weightText;

    @FindBy(css = "[value='kg']")
    private WebElement weightUnit;


    @FindBy(id="external_id")
    private WebElement internalId;

    @FindBy(id="react-select-client-input")
    private WebElement clientDropDown;

   @FindBy(xpath = "//span[@id='react-select-refspecies-live-region']/..")
   private WebElement speciesDropDown;

   @FindBy(id="react-select-refspecies-option-1")
   private WebElement speciesText;

    @FindBy(css = "[class*='float-right']")
    private WebElement patientSaveButton;

    @FindBy(css = "[class*='false n']")
    private WebElement patientLink;

    @FindBy(css = "[class*='align-self-center d-flex flex-column flex-m'] a")
    private WebElement addedPatient;

    @FindBy(css = "[class*='float-right m-1 b']")
    private WebElement deleteClient;

    @FindBy(css = "[class*='d-flex fl']")
    private WebElement confirmDelete;

    @FindBy(css = "[class*='infinite-scroll-component ']")
    private WebElement noResultMessage;

    public void clickOnClientButton()
    {
        ts.presenceOfElementWait(clientButton);
        clientButton.click();
        ts.presenceOfElementWait(clientText);
        ts.presenceOfElementWait(search);
    }

  static  Random r=new Random();
   static int random=r.nextInt(100);
    String clientID=prop.getProperty("externalID");
    public void addClient() throws InterruptedException {
        Thread.sleep(5000);
        ts.presenceOfElementWait(addNewButton);
        addNewButton.click();
        String fn = prop.getProperty("firstNameClient");
        String ln = prop.getProperty("lastNameClient");
        firstName.sendKeys(fn+random);
        Thread.sleep(2000);
        lastName.sendKeys(ln);
        Thread.sleep(2000);
        externalId.sendKeys(clientID);
        Thread.sleep(2000);
        saveButton.click();
        Thread.sleep(5000);

    }

    public void searchTheAddedClient() throws InterruptedException {
        Thread.sleep(2000);
        ts.presenceOfElementWait(search);
        search.sendKeys(clientID);
        ts.presenceOfElementWait(selectClient);
        Thread.sleep(2000);
    }

    public void selectClient() throws InterruptedException {
        Thread.sleep(5000);
        ts.presenceOfElementWait(search);
        search.sendKeys(clientID);
        ts.presenceOfElementWait(selectClient);
        Thread.sleep(5000);
        selectClient.click();
        Thread.sleep(5000);
    }

    public void clickOnNewPatient()
    {
        ts.presenceOfElementWait(createPatientButton);
        createPatientButton.click();
        ts.presenceOfElementWait(createPatientText);
    }

   static int random2=r.nextInt(100);
    String patientID=prop.getProperty("idPatient");
    public void addPatient() throws InterruptedException {
        ts.presenceOfElementWait(pName);
        String name=prop.getProperty("namePatient");
        pName.sendKeys(name+random2);
        weightDropDown.click();
        Thread.sleep(2000);
        ts.doActionsClick(weightUnit);
        String wg=prop.getProperty("weightPatient");
        weightText.sendKeys(wg);
        Thread.sleep(2000);
        internalId.sendKeys(patientID);
        Thread.sleep(2000);
        speciesDropDown.click();
        ts.doActionsClick(speciesText);
        patientSaveButton.click();
        Thread.sleep(2000);

    }

    public void searchTheAddedPatient() throws InterruptedException {
        ts.presenceOfElementWait(patientLink);
        patientLink.click();
        Thread.sleep(2000);
        ts.presenceOfElementWait(addedPatient);
        Thread.sleep(4000);

    }

    public void deleteTheAddedClient() throws InterruptedException {
        ts.presenceOfElementWait(deleteClient);
        deleteClient.click();
        ts.presenceOfElementWait(confirmDelete);
        confirmDelete.click();
        Thread.sleep(2000);
    }

    public void searchTheDeletedClient() throws InterruptedException {
        Thread.sleep(2000);
        ts.presenceOfElementWait(search);
        search.sendKeys(clientID);
        ts.presenceOfElementWait(noResultMessage);
        Thread.sleep(2000);
    }
}
