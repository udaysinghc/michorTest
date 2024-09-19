package com.moichor.pages;


import com.moichor.base.DriverFactory;
import com.moichor.util.ConfigReader;
import com.moichor.util.TestUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Properties;
import java.util.Random;

public class UsersPage {

    public WebDriver driver;
    TestUtil ts;
    public JavascriptExecutor js;
    ConfigReader configReader = new ConfigReader();
    Properties prop=configReader.init_prop();

    public UsersPage(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
        this.driver= DriverFactory.getDriver();
        this.ts=new TestUtil(driver);

    }

    @FindBy(xpath = "//a[text()='Users']")
    private WebElement usersButton;

    @FindBy(css = "[class*='mb'] h1")
    private WebElement usersText;

    @FindBy(id="search")
    private WebElement searchBar;

    @FindBy(css = "[class*='top-right-button btn']")
    private WebElement addUserButton;

    @FindBy(css = "[class='infinite-scroll-component ']")
    private WebElement allUsers;

    @FindBy(id="firstname")
    private WebElement firstNameTextField;

    @FindBy(id="lastname")
    private WebElement lastNameTextField;

    @FindBy(id="email")
    private WebElement emailTextField;

    @FindBy(xpath = "//span[@id='react-select-roles-live-region']/..")
    private WebElement rolesDropDown;

    @FindBy(xpath = "//span[@id='react-select-roles-live-region']/../descendant::input")
    private WebElement rolesInputField;

    @FindBy(xpath = "//div[@id='react-select-clinics-placeholder']/../../..")
    private WebElement clinicDropDown;

    @FindBy(xpath = "//div[@id='react-select-clinics-placeholder']/../../../descendant::input")
    private WebElement clinicInput;

    @FindBy(css = "[class*='css-d']")
    private WebElement firstElementInDropDown;

    @FindBy(css = "[class='d-flex btn btn-primary']")
    private WebElement saveDetailButton;

    @FindBy(css = "[role='status']")
    private WebElement status;

    @FindBy(xpath = "//div[contains(text(),'successfully')]")
    private WebElement successStatus;

    @FindBy(css = "[class*='btn-outline-second']")
    private WebElement cancelButton;

    @FindBy(xpath = "(//div[contains(@class,'d-flex flex-row list')]/*/*/*/p)[1]")
    private WebElement firstUser;

    @FindBy(css = "[class*=' btn btn-danger']")
    private WebElement deactivateButton;

    @FindBy(css = "[class*=' form-control']")
    private WebElement deactivateTextField;

    @FindBy(css = "[class='btn btn-danger']")
    private WebElement yesButton;

    @FindBy(css = "[class*='d-flex just']")
    private WebElement restoreButton;

    @FindBy(css = "[class='btn btn-info']")
    private WebElement restoreYesButton;

    @FindBy(xpath = "(//button[@class='d-flex justify-content-center align-items-center btn btn-outline-info btn-xs'])[1]")
    private WebElement reset;

    @FindBy(css = "[class*='text-center font-medium']")
    private WebElement getInbox;

    @FindBy(css = "input[placeholder='Enter username']")
    private WebElement userName;

    @FindBy(css = "[class*='dark:focus:border-primary-500']")
    private WebElement selectDomain;

    @FindBy(xpath = "//button[text()='Add Inbox']")
    private WebElement addInbox;

    @FindBy(xpath = "//table/tbody/tr/td[2]")
    private WebElement inboxMessage;

    @FindBy(xpath = "//tbody/tr/td/p/a[1]")
    private WebElement resetPasswordLink;

    @FindBy(css = "[name='password']")
    private WebElement passwordTextField;

    @FindBy(css = "[name='confirm']")
    private WebElement resetConfirmPassword;

    @FindBy(css = "[class*='custom-checkbox'] input")
    private WebElement checkBox;

    @FindBy(css = "[class*='btn-shadow']")
    private WebElement continueButton;

    @FindBy(css = "[class*='container-fluid'] h1")
    private WebElement home;

    @FindBy(xpath = "//sapn[text()='Close']")
    private WebElement adCloseButton;

    public void clickOnUsersButton()
    {
        ts.presenceOfElementWait(usersButton);
        usersButton.click();
        ts.presenceOfElementWait(searchBar);
        ts.presenceOfElementWait(usersText);
        ts.presenceOfElementWait(addUserButton);
    }

    LocalDateTime now = LocalDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyMMddHHmmss");
    String formattedDateTime = now.format(formatter);
    public void addAUser() {

           addUserButton.click();
           ts.presenceOfElementWait(firstNameTextField);
           String fName = prop.getProperty("FirstName");
           firstNameTextField.sendKeys(fName);
           ts.presenceOfElementWait(lastNameTextField);
           String lName = prop.getProperty("LastName");
           lastNameTextField.sendKeys(lName);
           ts.presenceOfElementWait(emailTextField);
           String eName = prop.getProperty("userEmail");
           String domain = prop.getProperty("userDomain");
           emailTextField.sendKeys(eName+formattedDateTime+domain);
           ts.presenceOfElementWait(rolesDropDown);
           rolesDropDown.click();
           ts.presenceOfElementWait(rolesInputField);
           String roles=prop.getProperty("userRole");
           rolesInputField.sendKeys(roles);
           ts.presenceOfElementWait(firstElementInDropDown);
           firstElementInDropDown.click();
           ts.presenceOfElementWait(clinicDropDown);
           clinicDropDown.click();
           ts.presenceOfElementWait(clinicInput);
           String clinic = prop.getProperty("userClinic");
           clinicInput.sendKeys(clinic);
           ts.presenceOfElementWait(firstElementInDropDown);
           firstElementInDropDown.click();
           ts.presenceOfElementWait(saveDetailButton);
           saveDetailButton.click();
           ts.presenceOfElementWait(status);
           String text=status.getText();
           String emailPresent=prop.getProperty("userAlreadyPresent");
           if(text.equalsIgnoreCase(emailPresent))
           {
               ts.presenceOfElementWait(cancelButton);
               cancelButton.click();
               addAUser();
           }

    }

    public void searchTheUser()
    {
        ts.presenceOfElementWait(searchBar);
        String eName= prop.getProperty("userEmail");
        String domain=prop.getProperty("userDomain");
        searchBar.sendKeys(eName+formattedDateTime+domain);
        ts.presenceOfElementWait(firstUser);
    }

    public void editTheUser() {
        ts.presenceOfElementWait(firstUser);
        ts.clickOnElement(firstUser);
        ts.presenceOfElementWait(rolesDropDown);
        rolesDropDown.click();
        ts.presenceOfElementWait(rolesInputField);
        String role=prop.getProperty("newUserRole");
        rolesInputField.sendKeys(role);
        ts.presenceOfElementWait(firstElementInDropDown);
        firstElementInDropDown.click();
        ts.presenceOfElementWait(saveDetailButton);
        saveDetailButton.click();
        ts.presenceOfElementWait(status);

    }

    public void deactivateTheUser(){
        ts.presenceOfElementWait(firstUser);
        ts.clickOnElement(firstUser);
        ts.presenceOfElementWait(deactivateButton);
        deactivateButton.click();
        ts.presenceOfElementWait(deactivateTextField);
        String dName=prop.getProperty("dName");
        deactivateTextField.sendKeys(dName);
        ts.presenceOfElementWait(yesButton);
        yesButton.click();
        ts.presenceOfElementWait(successStatus);
    }

    public void restoreTheDeactivateUser() {
        ts.presenceOfElementWait(firstUser);
        ts.presenceOfElementWait(restoreButton);
        restoreButton.click();
        ts.presenceOfElementWait(restoreYesButton);
        restoreYesButton.click();
        ts.presenceOfElementWait(status);
    }

    public void clickOnResetPasswordLink(){
        ts.presenceOfElementWait(reset);
        reset.click();
        ts.presenceOfElementWait(status);
    }

    public void getNada()  {
        ts.openNewTab();
        driver.get("https://inboxes.com/");
        ts.switchToTab(1);
        ts.presenceOfElementWait(getInbox);
        getInbox.click();
        ts.presenceOfElementWait(userName);
        String name=prop.getProperty("dummyEmailName");
        String domain=prop.getProperty("dummyDomainName");
        userName.sendKeys(name+formattedDateTime);
        ts.presenceOfElementWait(selectDomain);
        selectDomain.click();
        ts.doSelectDropDownByVisibleText(selectDomain,domain);
        ts.presenceOfElementWait(addInbox);
        addInbox.click();
        try {
            ts.presenceOfElementWait(inboxMessage);
            inboxMessage.click();
        }
        catch(Exception e)
        {
            ts.switchToTab(0);
            clickOnResetPasswordLink();
            ts.switchToTab(1);

        }
        try{
            ts.presenceOfElementWait(inboxMessage);
            inboxMessage.click();
        }
        catch (Exception e)
        {
           driver.navigate().refresh();
           ts.presenceOfElementWait(inboxMessage);
           inboxMessage.click();

        }

        ts.presenceOfElementWait(resetPasswordLink);
        ts.scrollIntoView(resetPasswordLink);
        resetPasswordLink.click();
        ts.switchToTab(2);
        ts.presenceOfElementWait(passwordTextField);
        String resetPassword=prop.getProperty("resetPassword");
        passwordTextField.sendKeys(resetPassword);
        ts.presenceOfElementWait(resetConfirmPassword);
        resetConfirmPassword.sendKeys(resetPassword);
        checkBox.click();
        ts.presenceOfElementWait(continueButton);
        continueButton.click();

    }

    public void homePage()
    {
        ts.presenceOfElementWait(home);
        List<WebElement> allElement = driver.findElements(By.xpath("//div[@class='text-center card-body']/.."));
        for(WebElement r: allElement)
        {
            ts.presenceOfElementWait(r);
        }
    }


}
