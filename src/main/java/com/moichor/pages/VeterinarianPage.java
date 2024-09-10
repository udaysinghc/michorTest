package com.moichor.pages;

import com.moichor.base.DriverFactory;
import com.moichor.util.ConfigReader;
import com.moichor.util.TestUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Properties;

public class VeterinarianPage extends DriverFactory {


    public WebDriver driver;
    TestUtil ts=new TestUtil(driver);
    Properties prop;
    public VeterinarianPage(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
        ConfigReader configReader = new ConfigReader();
        this.prop=configReader.init_prop();
        this.driver=DriverFactory.getDriver();
    }

    @FindBy(xpath = "//a[text()='Veterinarians']")
    private WebElement vetButton;

    @FindBy(css = "[class*='top-right-button btn btn-succ']")
    private WebElement addNewButton;

    @FindBy(id="fname")
    private WebElement firstname;

    @FindBy(id="lname")
    private WebElement lastname;

    @FindBy(id="email")
    private WebElement emailId;

    @FindBy(id="mobile_no")
    private WebElement phoneNumber;

    @FindBy(css = "[type='submit']")
    private WebElement createButton;

   @FindBy(id="search")
   private WebElement search;

    @FindBy(css = "[class*='card-body align-self-center d-flex flex-column flex-lg-row justify-content-between m'] div")
    private WebElement selectTheVet;

    @FindBy(css = "[class*='btn btn-d']")
    private WebElement deleteButton;

    @FindBy(css = "[class*='d-flex flex-row b']")
    private WebElement deleteConfirm;

    @FindBy(css = "[class='search-icon icon'] i")
    private WebElement cancelIcon;

    @FindBy(css = "[class*='infinite-scroll-component ']")
    private WebElement noResultMessage;

    @FindBy(xpath = "(//button[contains(@class,'custom-switch')])[1]")
    private WebElement toggleButton;

    @FindBy(css = "[role='status']")
    private WebElement status;

    public void clickOnVetButton() {

        ts.presenceOfElementWait(vetButton);
        vetButton.click();
    }

    public void addTheVet(){
        ts.presenceOfElementWait(addNewButton);
        addNewButton.click();
       String fn=prop.getProperty("firstName");
       firstname.sendKeys(fn);
       String ln=prop.getProperty("lastName");
       lastname.sendKeys(ln);
       String email=prop.getProperty("email");
       emailId.sendKeys(email);
       String mobileNumber=prop.getProperty("mobileNo");
       ts.presenceOfElementWait(phoneNumber);
       phoneNumber.sendKeys(mobileNumber);
       createButton.click();
       ts.presenceOfElementWait(status);

    }

    public void searchTheAddedVet() {
        ts.presenceOfElementWait(search);
        String mail=prop.getProperty("email");
        search.sendKeys(mail);
        ts.presenceOfElementWait(selectTheVet);
    }

    public void deleteTheVet() {
        selectTheVet.click();
        ts.presenceOfElementWait(deleteButton);
        deleteButton.click();
        ts.presenceOfElementWait(deleteConfirm);
        deleteConfirm.click();
        ts.presenceOfElementWait(status);


    }

    public void editTheVet() {
        selectTheVet.click();
        ts.presenceOfElementWait(phoneNumber);
        phoneNumber.clear();
        String ph=prop.getProperty("phone");
        phoneNumber.sendKeys(ph);
        createButton.click();
        ts.presenceOfElementWait(status);
    }

    public void searchTheDeleteVet()
    {
        ts.presenceOfElementWait(cancelIcon);
        cancelIcon.click();
        String mail=prop.getProperty("email");
        search.sendKeys(mail);
        ts.presenceOfElementWait(noResultMessage);

    }

    public void verifyTheToggleButton() {
        String mail=prop.getProperty("email");
        ts.presenceOfElementWait(search);
        search.sendKeys(mail);
        ts.presenceOfElementWait(toggleButton);
        toggleButton.click();
        ts.presenceOfElementWait(status);
        ts.presenceOfElementWait(toggleButton);
        toggleButton.click();
        ts.presenceOfElementWait(status);
    }
}
