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

public class VeterinarianPage extends DriverFactory {

    String email;
    public WebDriver driver;
    TestUtil ts=new TestUtil(driver);
    Properties prop;
    public VeterinarianPage(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
        ConfigReader configReader = new ConfigReader();
        this.prop=configReader.init_prop();
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


    public void clickOnVetButton() throws InterruptedException {

        Thread.sleep(5000);
        ts.presenceOfElementWait(vetButton);
        vetButton.click();
    }

    public void addTheVet() throws InterruptedException {
        Thread.sleep(5000);
        ts.presenceOfElementWait(addNewButton);
        addNewButton.click();
       String fn=prop.getProperty("firstName");
       firstname.sendKeys(fn);
       String ln=prop.getProperty("lastName");
       lastname.sendKeys(ln);
       String email=prop.getProperty("email");
       emailId.sendKeys(email);
       String phone=prop.getProperty("phone");
       phoneNumber.sendKeys(phone);
       createButton.click();
       Thread.sleep(5000);

    }

    public void searchTheAddedVet() throws InterruptedException {
        ts.presenceOfElementWait(search);
        String mail=prop.getProperty("email");
        search.sendKeys(mail);
        ts.presenceOfElementWait(selectTheVet);
        Thread.sleep(5000);
    }

    public void deleteTheVet() throws InterruptedException {
        selectTheVet.click();
        ts.presenceOfElementWait(deleteButton);
        deleteButton.click();
        ts.presenceOfElementWait(deleteConfirm);
        deleteConfirm.click();

    }
}
