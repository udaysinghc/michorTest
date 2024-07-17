package com.moichor.pages;

import com.moichor.base.DriverFactory;
import com.moichor.util.ConfigReader;
import com.moichor.util.TestUtil;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Properties;

public class TestsPage {

    public WebDriver driver;
    TestUtil ts;
    public JavascriptExecutor js;
    ConfigReader configReader = new ConfigReader();
    Properties prop=configReader.init_prop();

    public TestsPage(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
        this.driver= DriverFactory.getDriver();
        this.ts=new TestUtil(driver);

    }

    @FindBy(xpath = "//a[text()='Tests']")
    private WebElement testsButton;

    @FindBy(id = "search")
    private WebElement search;

    @FindBy(css = "[class*='top-right-button ']")
    private WebElement addNewButton;

    @FindBy(xpath = "//span[text()='Create New Reference Test']")
    private WebElement createNew;

    @FindBy(xpath = "(//span[contains(@id,'react')]/..)[2]")
    private WebElement clientDropDown;

    @FindBy(xpath = "(//span[contains(@id,'react')]/..)[2]/descendant::input")
    private WebElement clientText;

    @FindBy(css = "[class*=' css-d']")
    private WebElement createClient;

    @FindBy(css = "[class*='float-right m-']")
    private WebElement saveButton;

    @FindBy(xpath = "(//span[@class='float-right']/parent::div/descendant::div[@id])[1]")
    private WebElement patientDropDown;

    @FindBy(xpath = "(//span[@class='float-right']/parent::div/descendant::div[@id])[1]/descendant::input")
    private WebElement patientText;

    @FindBy(css = "[class*=' css-d']")
    private WebElement createPatient;

    @FindBy(css = "[class*='d-flex flex-row ali'] button")
    private WebElement selectTestFromMenu;

    @FindBy(xpath = "//label[text()='Selected Tests']")
    private WebElement selectTestText;

    @FindBy(xpath = "//button[text()='Apply and Close']")
    private WebElement applyCloseButton;

    @FindBy(xpath = "//button[.='Or Request a Sample ID without a Moichor Slide']")
    private WebElement generateVerificationCode;

    @FindBy(css = "[name='id']")
    private WebElement code;

    @FindBy(xpath = "//button[text()='Create']")
    private WebElement createButton;

    @FindBy(css = "[role='status']")
    private WebElement status;

    @FindBy(css = "[class*='d-flex li']")
    private WebElement particularTest;

    @FindBy(xpath = "//a/p[contains(@class,'list')]")
    private WebElement allTest;

    @FindBy(xpath = "//span[text()='DELETE']")
    private WebElement deleteButton;

    @FindBy(xpath = "//span[text()='SAVE']")
    private WebElement save;

    @FindBy(xpath = "(//span[contains(@id,'react-')])[1]/..")
    private WebElement vetDropDown;

    @FindBy(xpath = "((//span[contains(@id,'react-')])[1]/../descendant::input)[1]")
    private WebElement vetDropDownInput;

    @FindBy(xpath = "(//span[contains(@id,'react')])[2]/..")
    private WebElement priorityDropDown;

    @FindBy(xpath = "(//span[contains(@id,'react')])[2]/../descendant::input[@id]")
    private WebElement priorityInput;

    @FindBy(css = "[class*='react-select__option ']")
    private WebElement selectPriority;

    @FindBy(css = "[class*='react-select__option css']")
    private WebElement vetSelection;

    @FindBy(css = "[class*='icon-button']")
    private WebElement deleteTheTest;

    @FindBy(css = "[class*='d-flex flex-row ']")
    private WebElement confirmDelete;

    @FindBy(xpath = "//div/p[text()='Test Status']")
    private WebElement testStatus;

    @FindBy(css = "[class='infinite-scroll-component__outerdiv']")
    private WebElement allTests;

    @FindBy(xpath = "(//p/span[contains(@class,'cursor-pointer badge badge')])[1]")
    private WebElement infoSheet;

    @FindBy(xpath = "(//div[contains(@class,'d-flex flex-column c')]/descendant::button)[1]")
    private WebElement archiveButton;

    @FindBy(xpath = "(//div[contains(@class,'d-flex flex-column c')]/descendant::p/following::p)[1]")
    private WebElement sampleID;

    @FindBy(xpath = "//button[text()='Yes']")
    private WebElement yesButton;

    @FindBy(xpath = "//span[text()='Archive']")
    private WebElement archiveLink;

    @FindBy(css = "[class*='infinite-scroll-component_']")
    private WebElement archiveTest;

    @FindBy(xpath = "//span[contains(@id,'react')]/..")
    private WebElement veterinarianDropDown;

    @FindBy(xpath = "//span[contains(@id,'react')]/../descendant::input[@id]")
    private WebElement veterinarianInput;

    @FindBy(xpath = "//div[contains(@class,'react-select__menu-li')]/div")
    private WebElement selectVet;

    @FindBy(xpath = "//div/h3[text()='No results found.']")
    private WebElement noResult;


    public void clickOnTestButton()
    {
        ts.presenceOfElementWait(testsButton);
        testsButton.click();

    }

    static String codeText;

    public void addATest() throws InterruptedException {
        ts.presenceOfElementWait(addNewButton);
        addNewButton.click();
        ts.presenceOfElementWait(clientDropDown);
        clientText.click();
        ts.presenceOfElementWait(clientText);
        clientText.sendKeys("uday88");
        ts.presenceOfElementWait(createClient);
        createClient.click();
        ts.presenceOfElementWait(saveButton);
        ts.presenceOfElementWait(patientDropDown);
        patientDropDown.click();
        ts.presenceOfElementWait(patientText);
        patientText.sendKeys("uday");
        ts.presenceOfElementWait(createPatient);
        createClient.click();
        ts.scrollPageDown();
        ts.presenceOfElementWait(selectTestFromMenu);
        selectTestFromMenu.click();
        ts.presenceOfElementWait(selectTestText);
        String nameOfTest=prop.getProperty("testName");
        Thread.sleep(5000);
        driver.findElement(By.xpath("//label[text()='"+nameOfTest+"']/preceding-sibling::input")).click();
        ts.scrollPageDown();
        ts.presenceOfElementWait(applyCloseButton);
        applyCloseButton.click();
        ts.presenceOfElementWait(generateVerificationCode);
        generateVerificationCode.click();
        ts.presenceOfElementWait(code);
        codeText = ts.doGetElementAttribute(code, "value");
        System.out.println(codeText);
        ts.scrollPageDown();
        ts.presenceOfElementWait(createButton);
        createButton.click();
        ts.presenceOfElementWait(status);

    }

    public void searchForAddedTest() throws InterruptedException {
        Thread.sleep(5000);
        ts.switchToTab(0);
        ts.presenceOfElementWait(search);
        search.sendKeys(codeText);
        ts.presenceOfElementWait(particularTest);
    }

    public void editTheTest()
    {
        ts.presenceOfElementWait(allTest);
        allTest.click();
        ts.presenceOfElementWait(deleteButton);
        ts.presenceOfElementWait(save);
        ts.presenceOfElementWait(vetDropDown);
        vetDropDown.click();
        ts.presenceOfElementWait(vetDropDownInput);
        vetDropDownInput.sendKeys("Dr.");
        ts.presenceOfElementWait(vetSelection);
        vetSelection.click();
        ts.presenceOfElementWait(priorityDropDown);
        priorityDropDown.click();
        ts.presenceOfElementWait(priorityInput);
        String priority=prop.getProperty("priority");
        priorityInput.sendKeys(priority);
        ts.presenceOfElementWait(selectPriority);
        selectPriority.click();
        ts.scrollPageUP();
        save.click();
        ts.presenceOfElementWait(status);

    }

    public void deleteTest() throws InterruptedException {
        try {
            ts.presenceOfElementWait(deleteTheTest);
            deleteTheTest.click();
            ts.presenceOfElementWait(confirmDelete);
            confirmDelete.click();
            ts.presenceOfElementWait(status);
        }
        catch (Exception e)
        {
            addATest();
            searchForAddedTest();
            deleteTest();
        }
    }

    List<WebElement> allTestStatus;
    public void testStatus() throws InterruptedException {
        ts.presenceOfElementWait(testStatus);
        allTestStatus = driver.findElements(By.cssSelector("[class*='px'] [href*='/app/']"));
        System.out.println(allTestStatus);
        for(WebElement r:allTestStatus)
        {
            System.out.println(r.getText());
            r.click();
            ts.scrollIntoView(r);
            ts.presenceOfElementWait(allTests);
            Thread.sleep(2000);
        }


    }

    public void infoSheet() throws InterruptedException {
        ts.presenceOfElementWait(search);
        ts.presenceOfElementWait(infoSheet);
        infoSheet.click();

    }

    static String sampleId;
    public void clickOnArchive() throws InterruptedException {
        testStatus();
        for(WebElement r:allTestStatus)
        {
            System.out.println(r.getText());
            if(r.getText().equalsIgnoreCase("Completed Tests"))
            {
                r.click();
                break;
            }
        }
        ts.presenceOfElementWait(sampleID);
        sampleId = sampleID.getText();
        ts.presenceOfElementWait(archiveButton);
        archiveButton.click();
        ts.presenceOfElementWait(yesButton);
        yesButton.click();
        ts.presenceOfElementWait(status);

    }

    public void searchTheArchiveTest()
    {
        ts.presenceOfElementWait(archiveLink);
        archiveLink.click();
        ts.presenceOfElementWait(search);
        search.sendKeys(sampleId);
        ts.presenceOfElementWait(archiveTest);

    }

    public void clickOnVetDropDown() throws InterruptedException {

        try {
            ts.presenceOfElementWait(veterinarianDropDown);
            veterinarianDropDown.click();
            ts.presenceOfElementWait(veterinarianInput);
            String vet = prop.getProperty("vetName");
            veterinarianInput.sendKeys(vet);
            Thread.sleep(2000);
            veterinarianInput.sendKeys(Keys.ENTER);
            ts.presenceOfElementWait(allTest);
        }
        catch (Exception e)
        {
            System.out.println("No Result is found");
            ts.presenceOfElementWait(noResult);
        }

    }

    public void searchThePatientName()
    {
        try {
            ts.presenceOfElementWait(search);
            String pName = prop.getProperty("patientName");
            search.sendKeys(pName);
            ts.presenceOfElementWait(allTest);

        }
        catch (Exception e)
        {
            System.out.println("No result found");
            ts.presenceOfElementWait(noResult);
        }
    }


}
