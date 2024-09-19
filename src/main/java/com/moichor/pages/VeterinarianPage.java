package com.moichor.pages;

import com.moichor.base.DriverFactory;
import com.moichor.util.ConfigReader;
import com.moichor.util.TestUtil;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Properties;
import java.util.Random;

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

    @FindBy(xpath = "(//div[contains(@class,'d-flex flex-row')]/*/*/*)[1]")
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

    Random random = new Random();
    int r=random.nextInt(100);
    public void addTheVet(){
        ts.presenceOfElementWait(addNewButton);
        addNewButton.click();
        String fn=prop.getProperty("firstName");
        firstname.sendKeys(fn);
        String ln=prop.getProperty("lastName");
        lastname.sendKeys(ln);
        String email=prop.getProperty("emailName");
        String domain=prop.getProperty("emailDomainForVet");
        emailId.sendKeys(email+r+ domain);
        String mobileNumber=randomMobileNumber();
        ts.presenceOfElementWait(phoneNumber);
        phoneNumber.sendKeys("+91"+mobileNumber);
        createButton.click();
        ts.presenceOfElementWait(status);

    }


    public void deleteTheVet() {
        ts.presenceOfElementWait(selectTheVet);
        selectTheVet.click();
        ts.presenceOfElementWait(deleteButton);
        deleteButton.click();
        ts.presenceOfElementWait(deleteConfirm);
        deleteConfirm.click();
        ts.presenceOfElementWait(status);

    }

    public void editTheVet() {
        ts.presenceOfElementWait(selectTheVet);
        selectTheVet.click();
        ts.presenceOfElementWait(phoneNumber);
        phoneNumber.clear();
        String mobileNumber=randomMobileNumber();
        ts.presenceOfElementWait(phoneNumber);
        phoneNumber.sendKeys("+91"+mobileNumber);
        createButton.click();
        ts.presenceOfElementWait(status);

    }

    public void searchTheDeleteVet()
    {
        ts.presenceOfElementWait(cancelIcon);
        cancelIcon.click();
        String email=prop.getProperty("emailName");
        String domain=prop.getProperty("emailDomainForVet");
        search.sendKeys(email+r+domain);
        ts.presenceOfElementWait(noResultMessage);

    }

    public void verifyTheToggleButton() {
        ts.presenceOfElementWait(toggleButton);
        toggleButton.click();
        ts.presenceOfElementWait(status);
        ts.presenceOfElementWait(toggleButton);
        toggleButton.click();
        ts.presenceOfElementWait(status);

    }


    public String randomMobileNumber()
    {
        int[] startingDigits = {7, 8, 9, 6, 5};

        // Create a Random object to generate random numbers
        Random random = new Random();

        // Choose a random starting digit
        int firstDigit = startingDigits[random.nextInt(startingDigits.length)];

        // Generate the remaining 9 digits of the mobile number
        StringBuilder mobileNumber = new StringBuilder();
        mobileNumber.append(firstDigit); // Append the first digit

        // Append the remaining 9 random digits
        for (int i = 0; i < 9; i++) {
            int nextDigit = random.nextInt(10); // Generate a random digit (0-9)
            mobileNumber.append(nextDigit);
        }

        return mobileNumber.toString();
    }
}
