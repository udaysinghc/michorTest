package com.moichor.pages;


import com.moichor.base.DriverFactory;
import com.moichor.util.ConfigReader;
import com.moichor.util.TestUtil;
import jdk.jfr.Experimental;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.awt.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Properties;


public class AdminOrderPage {

    public WebDriver driver;
    TestUtil ts;
    public JavascriptExecutor js;
    ConfigReader configReader = new ConfigReader();
    Properties prop=configReader.init_prop();

    public AdminOrderPage(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
        this.driver= DriverFactory.getDriver();
        this.ts=new TestUtil(driver);

    }

    @FindBy(css = "[class*='col'] h1")
    private WebElement dashBoardText;

    @FindBy(xpath = "//a[text()='Orders']")
    private WebElement ordersButton;

    @FindBy(css = "[class*='mb'] h1")
    private WebElement testOrdersText;

    @FindBy(id="search")
    private WebElement searchBar;

    @FindBy(css = "[class*='top-right-button btn']")
    private WebElement downloadStatics;

    @FindBy(css = "[class='btn btn-primary']")
    private WebElement yesButton;

    @FindBy(css = "[placeholder='Start']")
    private WebElement startDate;

    @FindBy(css = "[placeholder='End']")
    private WebElement endDate;

    @FindBy(xpath = "//i[@class='simple-icon-reload']/..")
    private WebElement clearDate;

    @FindBy(xpath = "(//div[contains(@class,'d-flex list')])[1]")
    private WebElement order;

    @FindBy(css = "[class*='mb'] h4")
    private WebElement noResult;

    @FindBy(xpath = "//a[text()='Clinics']")
    private WebElement clinicsButton;

    @FindBy(xpath = "(//div[contains(@class,'d-flex flex-column combo')])[1]")
    private WebElement orderInParticularDate;

    @FindBy(id="clinic-select-field")
    private WebElement clinicDropDown;


    @FindBy(css = "[id='clinic-select-field'] input[id]")
    private WebElement clinicInput;

    @FindBy(css = "[role='listbox']")
    private WebElement listBox;

    @FindBy(xpath = "(//div[@role='option'])[1]")
    private WebElement elementInDropDown;

    @FindBy(xpath = "(//div[contains(@class,'indicatorContainer')])[1]")
    private WebElement cancelIcon;

    @FindBy(id="species-select-field")
    private WebElement speciesDropDown;

    @FindBy(css = "[id='species-select-field'] input[id]")
    private WebElement speciesInput;

    @FindBy(css = "[role='listbox'] [role='option']")
    private List<WebElement> dropDownElements;

    @FindBy(xpath = "(//div[contains(@class,'d-flex list')])[1]")
    private WebElement firstTest;

    @FindBy(xpath = "//div/p[text()='Test status']")
    private WebElement testStatus;

    @FindBy(xpath = "(//div[@class='d-flex flex-row']/../..)[1]")
    private WebElement allTests;
    

    @FindBy(css = "[class*='edit_text_button']")
    private WebElement editButton;

    @FindBy(css = "[class='modal-header'] h5")
    private WebElement patientForm;

    @FindBy(id="weight")
    private WebElement weightInput;

    @FindBy(css = "[placeholder='DOB']")
    private WebElement dob;

    @FindBy(css = "[type='submit']")
    private WebElement saveDetailButton;

    @FindBy(css = "[role='status']")
    private WebElement status;

    @FindBy(xpath = "(//div[@class='col-12']/descendant::div[contains(@class,'d-flex flex-row list-title')]/p)[1]")
    private WebElement selectTest;

    @FindBy(xpath = "(//div[@class='d-flex flex-row']/div/descendant::p)[1]")
    private WebElement selectFirstTest;

    @FindBy(css = "[class='modal-body']")
    private WebElement body;

    @FindBy(xpath = "//button[text()='View Result']")
    private WebElement viewResultButton;

    @FindBy(css = "[class*='images-modal']")
    private WebElement imagesBody;

    @FindBy(css = "[class*='mt-4 mb-4 btn btn-outline-info']")
    private WebElement UploadedImageButton;

    @FindBy(css = "input[type='file']")
    private WebElement uploadedFile;

    @FindBy(css = "[class*='filepicker'] span")
    private WebElement dropFile;

    @FindBy(css = "[class='btn btn-info']")
    private WebElement uploadedButton;

    @FindBy(id = "osd-zoom-in")
    private WebElement zoomIn;

    @FindBy(id = "osd-zoom-out")
    private WebElement zoomOut;

    @FindBy(id="osd-restore-view")
    private WebElement homeButton;

    @FindBy(id="osd-fullscreen")
    private WebElement fullScreenButton;

    @FindBy(css = "[class='btn btn-danger']")
    private WebElement disableImage;

    @FindBy(css = "[name='message']")
    private WebElement textField;

    @FindBy(css = "[class='btn btn-primary btn-sm']")
    private WebElement attachCurrentImage;

    @FindBy(css = "[class='form-check-input']")
    private WebElement requiredResponseCheckBox;

    @FindBy(css = "[class='d-flex btn btn-success btn-sm']")
    private WebElement sendButton;

    @FindBy(css = "[class='btn btn-secondary btn-sm']")
    private WebElement markAsReply;

    @FindBy(css = "[class='btn btn-success btn-sm']")
    private WebElement addReplyButton;

    @FindBy(css = "div[class*='d-flex justify-content-e']+textarea")
    private WebElement replyMessageTextField;

    @FindBy(css = "div[class*='d-flex justify-content-e']~div button[class*='success btn']")
    private WebElement replySendButton;

    @FindBy(css = "[role='switch']")
    private WebElement toggleButton;

    @FindBy(xpath = "(//button[@role='switch']/following-sibling::button)[1]")
    private WebElement validationCheck;

    @FindBy(css = "[class='modal-header'] h5")
    private WebElement title;

    @FindBy(css = "[class='btn btn-info']")
    private WebElement testFailureYesButton;

    @FindBy(css = "[class='btn btn-info']")
    private WebElement saveButtonForComplete;


    public void clickOnOrdersButton()
    {
        ts.presenceOfElementWait(clinicsButton);
        ts.scrollIntoView(ordersButton);
        ordersButton.click();
        ts.presenceOfElementWait(searchBar);
        ts.presenceOfElementWait(testOrdersText);
        ts.presenceOfElementWait(startDate);
        ts.presenceOfElementWait(endDate);
        ts.presenceOfElementWait(clearDate);

    }

    public void searchTheExistingOrder()
    {
        try {
            ts.presenceOfElementWait(searchBar);
            String pName = prop.getProperty("patientName");
            searchBar.sendKeys(pName);
            ts.presenceOfElementWait(order);
        }
        catch (Exception e)
        {
            ts.presenceOfElementWait(noResult);
            System.out.println("first create a test for this patient");

        }

    }

    public void clickOnDownloadStaticsButton(){
        ts.presenceOfElementWait(downloadStatics);
        downloadStatics.click();
        ts.presenceOfElementWait(yesButton);
        yesButton.click();
    }

    public void enterStartAndEndDate()
    {
        ts.presenceOfElementWait(startDate);
        String start=prop.getProperty("start");
        startDate.sendKeys(start, Keys.ENTER);
        ts.presenceOfElementWait(endDate);
        String end=localDate();
        endDate.sendKeys(end,Keys.ENTER);
        try {
            ts.presenceOfElementWait(orderInParticularDate);
        }
        catch (Exception e)
        {
            ts.presenceOfElementWait(noResult);
        }
        ts.presenceOfElementWait(clearDate);
    }

    public String localDate()
    {
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy"); // Adjust pattern if needed

        return currentDate.format(formatter);
    }

    public void searchTheTest() {
        ts.presenceOfElementWait(clinicDropDown);
        clinicDropDown.click();
        ts.presenceOfElementWait(clinicInput);
        String clinicText=prop.getProperty("clinicText");
        String speciesText=prop.getProperty("speciesText");
        clinicInput.sendKeys(clinicText);
        ts.presenceOfElementWait(listBox);
        ts.presenceOfElementWait(elementInDropDown);
        int size=dropDownElements.size();
        for(int i=0; i<size; i++)
        {
            String clinicName=dropDownElements.get(i).getText();
            if(clinicName.contains(clinicText))
            {
                dropDownElements.get(i).click();
                break;
            }
        }
        ts.presenceOfElementWait(speciesDropDown);
        speciesDropDown.click();
        ts.presenceOfElementWait(speciesInput);
        speciesInput.sendKeys(speciesText);
        ts.presenceOfElementWait(listBox);
        ts.presenceOfElementWait(elementInDropDown);
        int listOfSpecies=dropDownElements.size();
        for(int i=0; i<listOfSpecies; i++)
        {
            String clinicName=dropDownElements.get(i).getText();
            if(clinicName.contains(speciesText))
            {
                dropDownElements.get(i).click();
                break;
            }
        }
        try {
            ts.presenceOfElementWait(firstTest);
        }
        catch (Exception e)
        {
            ts.presenceOfElementWait(noResult);
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
                ts.waitForTheElementVisibility(allTests,10);
            }
            catch (Exception e)
            {
                ts.waitForTheElementVisibility(noResult,10);
            }
        }
    }

    public void editThePatient()
    {
        ts.presenceOfElementWait(selectTest);
        selectTest.click();
        ts.presenceOfElementWait(editButton);
        editButton.click();
        ts.presenceOfElementWait(patientForm);
        ts.presenceOfElementWait(weightInput);
        weightInput.clear();
        String pWeight=prop.getProperty("patientWeight");
        weightInput.sendKeys(pWeight);
        ts.presenceOfElementWait(dob);
        dob.clear();
        String date=prop.getProperty("patientDOB");
        dob.sendKeys(date);
        ts.presenceOfElementWait(saveDetailButton);
        saveDetailButton.click();
        ts.presenceOfElementWait(status);
    }

    public void uploadImage() {
        ts.presenceOfElementWait(selectFirstTest);
        selectFirstTest.click();
        ts.presenceOfElementWait(body);
        ts.scrollIntoView(viewResultButton);
        viewResultButton.click();
        UploadedImageButton.click();
        String path=prop.getProperty("image_path");
        uploadedFile.sendKeys(path);
        ts.presenceOfElementWait(uploadedButton);
        uploadedButton.click();
    }

    public void sendMessage()
    {
        ts.presenceOfElementWait(zoomIn);
        ts.presenceOfElementWait(zoomOut);
        ts.presenceOfElementWait(homeButton);
        ts.presenceOfElementWait(fullScreenButton);
        ts.presenceOfElementWait(disableImage);
        ts.scrollIntoView(textField);
        ts.presenceOfElementWait(attachCurrentImage);
        String message= prop.getProperty("messageWithImage");
        textField.sendKeys(message);
        attachCurrentImage.click();
        ts.presenceOfElementWait(requiredResponseCheckBox);
        requiredResponseCheckBox.click();
        ts.presenceOfElementWait(sendButton);
        sendButton.click();

    }

    public void replyMessage()
    {
        ts.presenceOfElementWait(markAsReply);
        markAsReply.click();
        ts.presenceOfElementWait(addReplyButton);
        addReplyButton.click();
        ts.presenceOfElementWait(replyMessageTextField);
        String message=prop.getProperty("replyMessage");
        replyMessageTextField.sendKeys(message);
        ts.presenceOfElementWait(replySendButton);
        replySendButton.click();

    }

    public void turnOnToggle() {
        ts.scrollIntoView(toggleButton);
        toggleButton.click();
        toggleButton.click();

    }

    public void testValidationStatus(){
        ts.presenceOfElementWait(selectFirstTest);
        selectFirstTest.click();
        ts.presenceOfElementWait(viewResultButton);
        viewResultButton.click();
        ts.scrollIntoView(validationCheck);
        validationCheck.click();
        try {
            ts.waitForTheElementVisibility(title,10);
            String text = prop.getProperty("textForTestFailure");
            driver.findElement(By.xpath("//label[contains(text(),'" + text + "')]/input")).click();
            ts.scrollIntoView(testFailureYesButton);
            ts.presenceOfElementWait(testFailureYesButton);
            testFailureYesButton.click();
            ts.presenceOfElementWait(status);
            ts.presenceOfElementWait(viewResultButton);
            viewResultButton.click();
            ts.scrollIntoView(validationCheck);
            validationCheck.click();
            ts.presenceOfElementWait(saveButtonForComplete);
            saveButtonForComplete.click();
            ts.presenceOfElementWait(status);
        }
        catch (Exception e)
        {

        }

    }
}
