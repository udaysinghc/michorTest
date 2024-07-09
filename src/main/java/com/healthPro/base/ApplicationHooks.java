package com.healthPro.base;

import java.util.Properties;

import com.healthPro.util.ConfigReader;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class ApplicationHooks {

  //    private DriverFactory driverFactory;
  public WebDriver driver;
  //  private ConfigReader configReader;
  Properties prop;

  @Before(order = 0)
  public void getProperty() {
    ConfigReader configReader = new ConfigReader();
    prop = configReader.init_prop();
  }

  @Before(order = 1)
  public void launchBrowser() {
    String browserName = prop.getProperty("browser");
    DriverFactory driverFactory = new DriverFactory();
    driver = driverFactory.init_driver(browserName);
    String app = prop.getProperty("App_url");
    driver.get(app);
  }

  @After(order = 0)
  public void quitBrowser() {
    driver.quit();
  }

  @After(order = 1)
  public void tearDown(Scenario scenario) {
    if (scenario.isFailed()) {
      // take screenshot:
      String screenshotName = scenario.getName().replaceAll(" ", "_");
      byte[] sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
      scenario.attach(sourcePath, "image/png", screenshotName);
    }

  }
}
