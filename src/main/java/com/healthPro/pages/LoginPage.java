package com.healthPro.pages;

import com.healthPro.base.ApplicationHooks;
import com.healthPro.base.DriverFactory;
import com.healthPro.util.ConfigReader;
import com.healthPro.util.TestUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Properties;

public class LoginPage extends DriverFactory {

    Properties prop;
    TestUtil ts=new TestUtil(driver);
    public LoginPage(WebDriver driver)
    {
        ConfigReader configReader = new ConfigReader();
        PageFactory.initElements(driver,this);
        this.prop=configReader.init_prop();

    }

    @FindBy(css = "[type='email']")
    public WebElement emailField;

    @FindBy(css = "[type='password']")
    private WebElement passwordField;

    @FindBy(css = "[type='submit']")
    private WebElement loginButton;

    @FindBy(css = "[class*='container-fluid'] h1")
    private WebElement home;

    @FindBy(xpath="//div[@class='text-center card-body']/..")
    private WebElement links;

    @FindBy(css = "[class*='d-flex'] h2")
    private WebElement notification;

    @FindBy(css = "[class*='d-flex m']")
    private WebElement allNotification;



    public void loginApp()  {

        String email=prop.getProperty("userName");
        String password=prop.getProperty("password");
        ts.presenceOfElementWait(emailField);
        emailField.sendKeys(email);
        ts.presenceOfElementWait(passwordField);
        passwordField.sendKeys(password);
        ts.presenceOfElementWait(loginButton);
        loginButton.click();
    }

    public void homePage(){
        ts.presenceOfElementWait(home);
        ts.presenceOfElementWait(links);
        ts.presenceOfElementWait(notification);
        ts.presenceOfElementWait(allNotification);

    }




}
