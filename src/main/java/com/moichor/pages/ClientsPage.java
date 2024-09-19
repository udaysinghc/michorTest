package com.moichor.pages;

import com.moichor.base.DriverFactory;
import com.moichor.util.ConfigReader;
import com.moichor.util.TestUtil;
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

    @FindBy(css = "[class*=' css-1d']")
    private WebElement clientName;

    @FindBy(css = "[class='false nav-link']")
    private WebElement patientsLink;

    @FindBy(css = "[class='text-center silver-header']")
    private WebElement noPatientCreated;

    @FindBy(css = "[class='false nav-link']")
    private WebElement detailsLink;

    @FindBy(xpath = "//button[text()='SAVE']")
    private WebElement saveButton;

    @FindBy(css = "[role='status']")
    private WebElement status;

    @FindBy(xpath = "(//div/a/p[contains(@class,'list-it')])[1]")
    private WebElement selectClient;

    @FindBy(css = "[class*='col'] h1")
    private WebElement clientDetails;

    @FindBy(xpath = "//a[text()='Main']")
    private WebElement mainText;

    @FindBy(xpath = "(//div[@class='d-flex flex-row list-item-card card']/*/*/a)[1]")
    private WebElement firstClient;

    @FindBy(id = "city")
    private WebElement cityField;

    @FindBy(id="state")
    private WebElement stateField;

    @FindBy(id="zip")
    private WebElement zipField;

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

    @FindBy(css =  "[placeholder='DOB']")
    private WebElement date;

    @FindBy(css = "[class*='float-right']")
    private WebElement patientSaveButton;

    @FindBy(css = "[class*='false n']")
    private WebElement patientLink;

    @FindBy(css = "[class*='align-self-center d-flex flex-column flex-m'] a")
    private WebElement addedPatient;

    @FindBy(xpath = "(//div/a/p[contains(@class,'list-it')])[1]")
    private WebElement selectPatient;

    @FindBy(css = "[class*='float-right m-1 b']")
    private WebElement deleteButton;

    @FindBy(css = "[class*='d-flex fl']")
    private WebElement confirmDelete;


    @FindBy(xpath = "//div[contains(text(),'deleted')]")
    private WebElement deleteStatus;

    @FindBy(css = "[class*='text-ce']")
    private WebElement noResultFound;

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
    public void addClient()  {
        ts.presenceOfElementWait(addNewButton);
        addNewButton.click();
        String fn = prop.getProperty("firstNameClient");
        String ln = prop.getProperty("lastNameClient");
        ts.presenceOfElementWait(firstName);
        firstName.sendKeys(fn+random);
        lastName.sendKeys(ln);
        externalId.sendKeys(clientID);
        saveButton.click();
        ts.presenceOfElementWait(status);

    }

    public void searchTheAddedClient() {
        ts.presenceOfElementWait(search);
        search.sendKeys(clientID);
        ts.presenceOfElementWait(selectClient);
    }


    public void editTheClient()
    {
        ts.presenceOfElementWait(firstClient);
        firstClient.click();
        ts.presenceOfElementWait(cityField);
        String city=prop.getProperty("city");
        cityField.sendKeys(city);
        String state=prop.getProperty("state");
        stateField.sendKeys(state);
        String zip=prop.getProperty("zip");
        zipField.sendKeys(zip);
        saveButton.click();
        ts.presenceOfElementWait(status);
    }

    public void clickOnNewPatient()
    {
        ts.presenceOfElementWait(firstClient);
        firstClient.click();
        ts.presenceOfElementWait(saveButton);
        ts.presenceOfElementWait(patientsLink);
        patientsLink.click();
        try {
            ts.waitForTheElementVisibility(noPatientCreated,5);
        }
        catch (Exception e)
        {

        }
        ts.presenceOfElementWait(detailsLink);
        detailsLink.click();
        ts.presenceOfElementWait(createPatientButton);
        createPatientButton.click();
        ts.presenceOfElementWait(createPatientText);
    }

   static int random2=r.nextInt(100);
    String patientID=prop.getProperty("idPatient");
    public void addPatient() {
        ts.presenceOfElementWait(pName);
        ts.presenceOfElementWait(clientName);
        String name=prop.getProperty("namePatient");
        pName.sendKeys(name+random2);
        weightDropDown.click();
        ts.doActionsClick(weightUnit);
        String wg=prop.getProperty("weightPatient");
        weightText.sendKeys(wg);
        internalId.sendKeys(patientID);
        speciesDropDown.click();
        ts.presenceOfElementWait(speciesText);
        ts.doActionsClick(speciesText);
        String dateOfPatient=prop.getProperty("dateOfBirth");
        date.sendKeys(dateOfPatient);
        patientSaveButton.click();
        ts.presenceOfElementWait(status);

    }


    public void deleteTheAddedClient() {
        ts.presenceOfElementWait(selectClient);
        selectClient.click();
        ts.presenceOfElementWait(deleteButton);
        deleteButton.click();
        ts.presenceOfElementWait(confirmDelete);
        confirmDelete.click();
        ts.presenceOfElementWait(deleteStatus);
    }

    public void searchTheDeletedClient() {
        ts.presenceOfElementWait(search);
        search.sendKeys(clientID);

    }


    public void deleteThePatient()
    {
        ts.presenceOfElementWait(patientLink);
        patientLink.click();
        ts.presenceOfElementWait(addedPatient);
        addedPatient.click();
        ts.presenceOfElementWait(deleteButton);
        deleteButton.click();
        ts.presenceOfElementWait(confirmDelete);
        confirmDelete.click();
        ts.presenceOfElementWait(status);

    }


}
