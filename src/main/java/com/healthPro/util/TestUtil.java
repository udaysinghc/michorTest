package com.healthPro.util;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.sql.Driver;
import java.time.Duration;
import java.util.List;

import com.healthPro.base.DriverFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestUtil {
  public WebElement webelement;
  public WebDriver driver;
  public JavascriptExecutor js;
  public static long PAGE_LOAD_TIMEOUT = 30;
  public static long IMPLICIT_WAIT = 60;

  public TestUtil(WebDriver driver)
  {
    this.driver= DriverFactory.getDriver();
    js=(JavascriptExecutor) driver;
  }
  private void isHighlight(WebElement element) {
    if (Boolean.parseBoolean(DriverFactory.highlight)) {

    }
  }
  public void presenceOfElementWait(WebElement elemen) {
    webelement =
        (new WebDriverWait(driver, Duration.ofSeconds(120))
            .until(ExpectedConditions.visibilityOf(elemen)));
  }

  public String getElement(WebElement element1) {
    String text = element1.getText();
    return text;
  }

  public void click(WebElement element1) {
    element1.click();
  }

  public WebElement elementToBeClickableWait(By locator) {
    webelement =
        (new WebDriverWait(driver, Duration.ofSeconds(120))
            .until(ExpectedConditions.elementToBeClickable(locator)));
    return webelement;
  }

  public void uploadFile(String path) throws InterruptedException, AWTException {
    // Store the location of the file in clipboard
    Thread.sleep(1500);
    StringSelection strSel = new StringSelection(path);
    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(strSel, null);

    // Create an object for robot class
    Robot robot = new Robot();
    new Actions(driver).sendKeys(Keys.ENTER).build().perform();
    // Control key in the keyboard
    // Ctrl+V

  }


  // ***************Select drop Down Utils***************//


  private Select createSelect(WebElement ele) {
    Select select = new Select(ele);
    return select;
  }


  public void doSelectDropDownByIndex(WebElement ele, int index) {
    createSelect(ele).selectByIndex(index);
  }

  public void doSelectDropDownByVisibleText(WebElement ele, String visibleText) {
    createSelect(ele).selectByVisibleText(visibleText);
  }

  public void doSelectDropDownByValue(WebElement ele, String value) {
    createSelect(ele).selectByValue(value);
  }


  // *****************Actions utils ***************//



  public void doActionsClick(WebElement ele) {
    Actions act = new Actions(driver);
    act.moveToElement(ele).click().build().perform();
  }

  // location of file
  public static String avatarFile = System.getProperty("user.dir") + "\\Resources\\avatar.jpg";
}


// *****************Actions utils ***************//

