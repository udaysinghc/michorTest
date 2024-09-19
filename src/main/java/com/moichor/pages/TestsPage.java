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

    @FindBy(css = "[class='reftest-list-groups']")
    private WebElement refTestList;

    @FindBy(xpath = "(//*[@class='modal-body'])[2]/descendant::div[@class=' css-hlgwow']/../..")
    private WebElement selectTestFromBundleDropDown;

    @FindBy(xpath = "(//*[@class='modal-body'])[2]/descendant::div[@class=' css-hlgwow']/../../descendant::input")
    private WebElement selectTestFromBundleInputField;

    @FindBy(css = "[class*=' css-d']")
    private WebElement firstElementInDropDown;

    @FindBy(xpath = "//button[text()='Apply and Close']")
    private WebElement applyCloseButton;

    @FindBy(xpath = "//button[.='Or Request a Sample ID without a Moichor Slide']")
    private WebElement generateVerificationCode;

    @FindBy(css = "[name='id']")
    private WebElement code;

    @FindBy(css = "[class='questions-block']")
    private WebElement questionBody;

    @FindBy(css = "[class*='badge badge-danger py']")
    private List<WebElement> requiredFields;

    @FindBy(css = "textarea[class*='form-control']")
    private WebElement noteTextArea;

    @FindBy(css = "button[class='btn btn-primary']")
    private WebElement answerButton;

    @FindBy(xpath = "//button[text()='Create']")
    private WebElement createButton;

    @FindBy(css = "[role='status']")
    private WebElement status;

    @FindBy(xpath = "//div[contains(text(),'successfully')]")
    private WebElement successStatus;

    @FindBy(css = "[class*='d-flex li']")
    private WebElement particularTest;

    @FindBy(xpath = "(//a/p[contains(@class,'list')])[1]")
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

    @FindBy(xpath = "(//div[@class='d-flex flex-row']/*/*/a)[1]")
    private WebElement allTests;


    @FindBy(xpath = "(//span[@class='cursor-pointer flex badge badge-info badge-pill'])[1]")
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

    @FindBy(xpath = "(//div[contains(@class,'react-select__option')])[1]")
    private WebElement firstVet;

    @FindBy(xpath = "//div[contains(@class,'react-select__menu-li')]/div")
    private WebElement selectVet;

    @FindBy(xpath = "//div/h3")
    private WebElement noResult;


    public void clickOnTestButton()
    {
        ts.presenceOfElementWait(testsButton);
        testsButton.click();

    }

    static String codeText;

    public void addATest(){
        ts.presenceOfElementWait(addNewButton);
        addNewButton.click();
        ts.presenceOfElementWait(clientDropDown);
        clientText.click();
        ts.presenceOfElementWait(clientText);
        String clientName=prop.getProperty("clientName");
        clientText.sendKeys(clientName);
        ts.presenceOfElementWait(createClient);
        createClient.click();
        ts.presenceOfElementWait(saveButton);
        ts.presenceOfElementWait(patientDropDown);
        patientDropDown.click();
        ts.presenceOfElementWait(patientText);
        String patientName=prop.getProperty("testPatientName");
        patientText.sendKeys(patientName);
        ts.presenceOfElementWait(createPatient);
        createClient.click();
        ts.scrollPageDown();
        ts.presenceOfElementWait(selectTestFromMenu);
        selectTestFromMenu.click();
        ts.presenceOfElementWait(selectTestText);
        ts.presenceOfElementWait(refTestList);
        ts.presenceOfElementWait(selectTestFromBundleDropDown);
        selectTestFromBundleDropDown.click();
        ts.presenceOfElementWait(selectTestFromBundleInputField);
        String nameOfTest=prop.getProperty("testName");
        selectTestFromBundleInputField.sendKeys(nameOfTest);
        ts.presenceOfElementWait(firstElementInDropDown);
        firstElementInDropDown.click();
        ts.scrollPageDown();
        ts.presenceOfElementWait(applyCloseButton);
        applyCloseButton.click();
        ts.presenceOfElementWait(generateVerificationCode);
        generateVerificationCode.click();
        ts.presenceOfElementWait(code);
        codeText = ts.doGetElementAttribute(code, "value");
        System.out.println(codeText);
        try {
            ts.presenceOfElementWait(questionBody);
            int count = requiredFields.size();
            for (int i = 1; i <= count; i++) {

                try {
                    WebElement dropdown = driver.findElement(By.xpath("(//span[contains(@class,'badge badge-danger py')])[" + i + "]/../.." +
                            "/descendant::div[@class=' css-hlgwow']/../.."));
                    ts.waitForTheElementVisibility(dropdown, 10);
                    dropdown.click();
                    ts.presenceOfElementWait(firstElementInDropDown);
                    firstElementInDropDown.click();
                } catch (RuntimeException e) {
                    WebElement inputField = driver.findElement(By.xpath("(//span[contains(@class,'badge badge-danger py')])[" + i + "]" +
                            "/../../descendant::input"));
                    inputField.click();
                    ts.presenceOfElementWait(noteTextArea);
                    String text = prop.getProperty("noteText");
                    noteTextArea.sendKeys(text);
                    ts.presenceOfElementWait(answerButton);
                    answerButton.click();
                }
            }
        }
        catch (Exception e)
        {

        }
        ts.scrollPageDown();
        ts.presenceOfElementWait(createButton);
        createButton.click();
        ts.presenceOfElementWait(successStatus);

    }

    public void searchForAddedTest() {
        ts.switchToTab(0);
        ts.presenceOfElementWait(search);
        search.sendKeys(codeText);
        ts.presenceOfElementWait(particularTest);
    }

    public void editTheTest()
    {
        ts.presenceOfElementWait(allTest);
        allTest.click();
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

    public void deleteTest() {
        try {
            ts.waitForTheElementVisibility(deleteTheTest,10);
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
    public void testStatus() {
        ts.presenceOfElementWait(testStatus);
        allTestStatus = driver.findElements(By.cssSelector("[class*='px'] [href*='/app/']"));
        for(WebElement r:allTestStatus)
        {
            r.click();
            ts.scrollIntoView(r);
            try {
                ts.waitForTheElementVisibility(allTest,15);
            }
            catch (Exception e)
            {
                ts.waitForTheElementVisibility(noResult,5);
            }
        }


    }

    public void infoSheet(){
        ts.presenceOfElementWait(search);
        ts.presenceOfElementWait(infoSheet);
        infoSheet.click();

    }

    static String sampleId;
    public void clickOnArchive() {
        testStatus();
        for(WebElement r:allTestStatus)
        {
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

    public void clickOnVetDropDown() {

        try {
            ts.presenceOfElementWait(veterinarianDropDown);
            veterinarianDropDown.click();
            ts.presenceOfElementWait(veterinarianInput);
            ts.presenceOfElementWait(firstVet);
            firstVet.click();
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
