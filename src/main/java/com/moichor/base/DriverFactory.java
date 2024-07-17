package com.moichor.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class DriverFactory {

  public WebDriver driver;
  public static String highlight = null;

  public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

  public WebDriver init_driver(String browser) {
    switch (browser) {
      case "chrome":
        tlDriver.set(new ChromeDriver());
        break;
      case "firefox":
        tlDriver.set(new FirefoxDriver());
        break;
      case "safari":
        tlDriver.set(new SafariDriver());
        break;
      default:
        System.out.println("Please pass the correct browser value: " + browser);
        break;
    }

    getDriver().manage().deleteAllCookies();
    getDriver().manage().window().maximize();
    return getDriver();
  }

  public static synchronized WebDriver getDriver() {
    return tlDriver.get();
  }

}
