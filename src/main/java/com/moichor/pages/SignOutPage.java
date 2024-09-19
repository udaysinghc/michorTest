package com.moichor.pages;

import com.moichor.base.DriverFactory;
import com.moichor.util.ConfigReader;
import com.moichor.util.TestUtil;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Properties;

public class SignOutPage {

    public WebDriver driver;
    TestUtil ts;
    public JavascriptExecutor js;
    ConfigReader configReader = new ConfigReader();
    Properties prop=configReader.init_prop();

    public SignOutPage(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
        this.driver= DriverFactory.getDriver();
        this.ts=new TestUtil(driver);

    }

    @FindBy(xpath = "//span[contains(@class,'name')]/..")
    private WebElement menuButton;


    @FindBy(css = "[role='menu'] button")
    private List<WebElement> menuItems;

    @FindBy(css = "[class='form-side'] img")
    private WebElement moichorLogo;

    public void clickOnSignOutButton() throws InterruptedException {
        ts.presenceOfElementWait(menuButton);
        ts.clickOnElement(menuButton);
        menuItems.get(1).click();
    }

    public void loginPage()
    {
        ts.presenceOfElementWait(moichorLogo);
    }

}
