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

    @FindBy(id="roles")
    private WebElement rolesDropDown;

    @FindBy(css = "[id='roles'] input")
    private WebElement rolesInput;

    @FindBy(id="clinics")
    private WebElement clinicDropDown;

    @FindBy(css = "[id='clinics'] input")
    private WebElement clinicInput;

    @FindBy(css = "[class='d-flex btn btn-primary']")
    private WebElement saveDetailButton;

    @FindBy(css = "[role='status']")
    private WebElement status;

    @FindBy(css = "[class*='btn-outline-second']")
    private WebElement cancelButton;

    @FindBy(css = "[class*='card-body'] p[class*='list']")
    private WebElement user;

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

    static Random r=new Random();
    static int random=r.nextInt(100);
    static int random1=r.nextInt(100);
    public void addAUser() throws InterruptedException {

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
           emailTextField.sendKeys(eName+random+random1+domain);
           ts.presenceOfElementWait(rolesDropDown);
           rolesDropDown.click();
           Thread.sleep(2000);
           List<WebElement> allRoles = driver.findElements(By.cssSelector("[role='listbox'] div"));

           for (WebElement r : allRoles) {
               String role = prop.getProperty("userRole");
               if (r.getText().contains(role)) {
                   r.click();
                   break;
               }
           }

           ts.presenceOfElementWait(clinicDropDown);
           clinicDropDown.click();
           Thread.sleep(2000);
           List<WebElement> allClinic = driver.findElements(By.cssSelector("[role='listbox'] div"));
           for (WebElement r1 : allClinic) {
               String clinic = prop.getProperty("userClinic");
               if (r1.getText().contains(clinic)) {
                   r1.click();
                   break;
               }


           }
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
        searchBar.sendKeys(eName+random+random1+domain);
        ts.presenceOfElementWait(user);
    }

    public void editTheUser() throws InterruptedException {
        ts.presenceOfElementWait(user);
        Thread.sleep(2000);
        user.click();
        ts.presenceOfElementWait(rolesDropDown);
        rolesDropDown.click();
        ts.presenceOfElementWait(rolesInput);
        Thread.sleep(2000);
        List<WebElement> allRoles = driver.findElements(By.cssSelector("[role='listbox'] div"));
        for(WebElement r: allRoles)
        {
            String role=prop.getProperty("newUserRole");
            if(r.getText().contains(role))
            {
                r.click();
                break;
            }
        }

        ts.presenceOfElementWait(saveDetailButton);
        saveDetailButton.click();
        ts.presenceOfElementWait(status);

    }

    public void deactivateTheUser() throws InterruptedException {
        ts.presenceOfElementWait(user);
        Thread.sleep(2000);
        user.click();
        ts.presenceOfElementWait(deactivateButton);
        deactivateButton.click();
        ts.presenceOfElementWait(deactivateTextField);
        String dName=prop.getProperty("dName");
        deactivateTextField.sendKeys(dName);
        ts.presenceOfElementWait(yesButton);
        yesButton.click();
        ts.presenceOfElementWait(status);
    }

    public void restoreTheDeactivateUser() {
        ts.presenceOfElementWait(user);
        ts.presenceOfElementWait(restoreButton);
        restoreButton.click();
        ts.presenceOfElementWait(restoreYesButton);
        restoreYesButton.click();
        ts.presenceOfElementWait(status);
    }

    public void clickOnResetPasswordLink() throws InterruptedException {
        ts.presenceOfElementWait(reset);
        Thread.sleep(2000);
        reset.click();
        ts.presenceOfElementWait(status);
    }

    public void getNada() throws InterruptedException {
        ts.openNewTab();
        driver.get("https://inboxes.com/");
        ts.switchToTab(1);
        ts.presenceOfElementWait(getInbox);
        getInbox.click();
        ts.presenceOfElementWait(userName);
        String name=prop.getProperty("dummyEmailName");
        String domain=prop.getProperty("dummyDomainName");
        userName.sendKeys(name+random+random1);
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
