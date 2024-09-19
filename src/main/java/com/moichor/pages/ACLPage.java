package com.moichor.pages;


import com.moichor.base.DriverFactory;
import com.moichor.util.ConfigReader;
import com.moichor.util.TestUtil;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.Properties;
import java.util.Random;

public class ACLPage {

    public WebDriver driver;
    TestUtil ts;
    public JavascriptExecutor js;
    ConfigReader configReader = new ConfigReader();
    Properties prop=configReader.init_prop();

    public ACLPage(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
        this.driver= DriverFactory.getDriver();
        this.ts=new TestUtil(driver);

    }


    @FindBy(xpath = "//a[text()='ACL']")
    private WebElement ACLButton;

    @FindBy(xpath = "//a[text()='Roles']")
    private WebElement rolesButton;

    @FindBy(xpath = "//a[text()='Permissions']")
    private WebElement permissionButton;

    @FindBy(css = "[class*='mb'] h1")
    private WebElement rolesText;

    @FindBy(id="search")
    private WebElement searchBar;

    @FindBy(css = "[class*='text'] button")
    private WebElement addRole;

    @FindBy(id="title")
    private WebElement title;

    @FindBy(id="slug")
    private WebElement slug;

    @FindBy(id="permissions")
    private WebElement permissionDropDown;

    @FindBy(id="react-select-permissions-option-2")
    private WebElement selectPermission;

    @FindBy(xpath = "//button[text()='Cancel']")
    private WebElement cancelButton;

    @FindBy(css = "[class*='d-flex btn']")
    private WebElement submitButton;

    @FindBy(css="[role='status']")
    private WebElement status;

    @FindBy(xpath = "(//div[contains(@class,'card-body')]/div/p)[1]")
    private WebElement selectRole;

    @FindBy(css = "[class*='mb'] h1")
    private WebElement permissionText;

    @FindBy(css = "[class*='text-zero'] button")
    private WebElement addPermissionButton;


    @FindBy(id="roles")
    private WebElement roleDropDown;

    @FindBy(id="react-select-roles-option-1")
    private WebElement Role;

    @FindBy(xpath = "(//div[contains(@class,'card-body')]/div/p[contains(@class,'list')])[1]")
    private WebElement Permission;

    public void clickOnACLButton()
    {
        ts.presenceOfElementWait(ACLButton);
        ACLButton.click();

    }

    static Random r=new Random();
    char c = (char)(r.nextInt(26) + 'a');
    static int random=r.nextInt(1000);
    public void addARole()
    {

        ts.presenceOfElementWait(rolesButton);
        rolesButton.click();
        ts.presenceOfElementWait(rolesText);
        ts.presenceOfElementWait(addRole);
        ts.presenceOfElementWait(searchBar);
        addRole.click();
        ts.presenceOfElementWait(title);
        String titleName=prop.getProperty("title");
        title.sendKeys(titleName+c+random);
        ts.presenceOfElementWait(slug);
        String slugName=prop.getProperty("slug");
        slug.sendKeys(slugName+c+random);
        String permission=prop.getProperty("permissionTitle");
        driver.findElement(By.xpath("//label[text()='"+permission+"']/../input")).click();
        ts.presenceOfElementWait(submitButton);
        submitButton.click();
        ts.presenceOfElementWait(status);
        String successMessage=status.getText();
        Assert.assertTrue(successMessage.contains("successfully"));

    }

    public void searchTheAddedRole()
    {
        ts.presenceOfElementWait(searchBar);
        String identifier=prop.getProperty("slug");
        searchBar.sendKeys(identifier+random);
        ts.presenceOfElementWait(selectRole);

    }

    public void searchForExistingRole()
    {
        ts.presenceOfElementWait(rolesButton);
        rolesButton.click();
        ts.presenceOfElementWait(rolesText);
        ts.presenceOfElementWait(addRole);
        ts.presenceOfElementWait(searchBar);
        ts.presenceOfElementWait(selectRole);
        selectRole.click();

    }

    public void editTheRole()
    {
        ts.presenceOfElementWait(title);
        title.clear();
        String titleName=prop.getProperty("title");
        title.sendKeys(titleName+c+random);
        ts.presenceOfElementWait(submitButton);
        submitButton.click();
        ts.presenceOfElementWait(status);
        String successMessage=status.getText();
        Assert.assertTrue(successMessage.contains("successfully"));
    }

    public void clickOnPermission()
    {
        ts.presenceOfElementWait(permissionButton);
        permissionButton.click();
        ts.presenceOfElementWait(permissionText);
        ts.presenceOfElementWait(searchBar);

    }


    public void searchForExistingPermission()
    {
        ts.presenceOfElementWait(Permission);
        Permission.click();

    }

    public void editThePermission()
    {
        int random=r.nextInt(100);
        ts.presenceOfElementWait(title);
        title.clear();
        String titleName=prop.getProperty("permissionTitle");
        title.sendKeys(titleName+random);
        submitButton.click();
        ts.presenceOfElementWait(status);
        String successMessage=status.getText();
        Assert.assertTrue(successMessage.contains("successfully"));

    }

}
