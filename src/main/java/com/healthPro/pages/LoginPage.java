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

    public WebElement getEmailField() {
        return emailField;
    }

    public WebElement getPasswordField() {
        return passwordField;
    }

    public WebElement getLoginButton() {
        return loginButton;
    }

    public void loginApp() throws InterruptedException {
        Thread.sleep(8000);
        String email=prop.getProperty("userName");
        String password=prop.getProperty("password");
        getEmailField().sendKeys(email);
        getPasswordField().sendKeys(password);
        getLoginButton().click();
    }

    public void homePage() throws InterruptedException {
        Thread.sleep(9000);
        ts.presenceOfElementWait(home);
        String text = home.getText();
        System.out.println(text);
    }




}
