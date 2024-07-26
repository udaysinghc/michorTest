package com.moichor.pages;


import com.moichor.base.DriverFactory;
import com.moichor.util.ConfigReader;
import com.moichor.util.TestUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Properties;

public class LoginAdminPage extends DriverFactory {

    Properties prop;
    TestUtil ts;
    public WebDriver driver;
    public LoginAdminPage(WebDriver driver)
    {
        ConfigReader configReader = new ConfigReader();
        PageFactory.initElements(driver,this);
        this.prop=configReader.init_prop();
        this.driver=DriverFactory.getDriver();
        this.ts=new TestUtil(driver);

    }

    @FindBy(css = "[type='email']")
    private WebElement emailField;

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

    @FindBy(xpath = "(//*[@class='col-12'])[1]//child::h1")
    private WebElement dashboardText;

    @FindBy(xpath = "//div[@class='card']")
    private List<WebElement> allLinks;


    public void loginAdminApp()  {

        String url=prop.getProperty("Admin_url");
        driver.get(url);
        String email=prop.getProperty("userName");
        String password=prop.getProperty("password");
        ts.presenceOfElementWait(emailField);
        emailField.sendKeys(email);
        ts.presenceOfElementWait(passwordField);
        passwordField.sendKeys(password);
        ts.presenceOfElementWait(loginButton);
        loginButton.click();
    }

    public void dashBoardPage()
    {
        ts.presenceOfElementWait(dashboardText);
        for(WebElement r:allLinks)
        {
           ts.presenceOfElementWait(r);

        }

    }
}
