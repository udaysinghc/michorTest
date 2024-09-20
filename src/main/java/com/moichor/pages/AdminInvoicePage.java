package com.moichor.pages;

import com.moichor.base.DriverFactory;
import com.moichor.util.ConfigReader;
import com.moichor.util.TestUtil;
import junit.framework.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Properties;
import java.util.Random;

public class AdminInvoicePage {

    public WebDriver driver;
    TestUtil ts;
    public JavascriptExecutor js;
    ConfigReader configReader = new ConfigReader();
    Properties prop=configReader.init_prop();

    public AdminInvoicePage(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
        this.driver= DriverFactory.getDriver();
        this.ts=new TestUtil(driver);

    }

    @FindBy(xpath = "//a[text()='Invoices']")
    private WebElement invoiceButton;

    @FindBy(xpath = "//a[text()='Clinics']")
    private WebElement clinic;

    @FindBy(css = "[class*='mb'] h1")
    private WebElement invoiceText;

    @FindBy(id = "search")
    private WebElement searchBar;

    @FindBy(css = "[placeholder='Start']")
    private WebElement startDate;

    @FindBy(css = "[placeholder='End']")
    private WebElement endDate;

    @FindBy(css = "[class*='top-right-button btn']")
    private WebElement  generateInvoice;

    @FindBy(xpath = "//div[contains(@class,'react-select__place')]/parent::div/../..")
    private WebElement clinicDropDown;

    @FindBy(xpath = "//div[contains(@class,'react-select__place')]/parent::div/../../descendant::input[@id]")
    private WebElement clinicInput;

    @FindBy(css = "[role='listbox']")
    private WebElement listBox;

    @FindBy(css = "[class*=' css-d']")
    private WebElement firstElementInDropDown;

    @FindBy(xpath = "//div[contains(@class,'modal')]/descendant::div[contains(@id,'date')]/descendant::input[@placeholder='Start']")
    private WebElement startInvoiceDate;

    @FindBy(css = "[class='react-datepicker__current-month']")
    private WebElement monthPicker;

    @FindBy(xpath = "//div[contains(@class,'modal')]/descendant::div[contains(@id,'date')]/descendant::input[@placeholder='End']")
    private WebElement endInvoiceDate;

    @FindBy(css = "[class='btn btn-outline-danger']")
    private WebElement clearFilterButton;

    @FindBy(css = "[class='btn btn-success']")
    private WebElement generateInvoiceButton;

    @FindBy(css = "[class='btn btn-outline-primary']")
    private WebElement closeButton;

    @FindBy(css = "[role='status']")
    private WebElement status;

    @FindBy(xpath = "//div[contains(text(),'successfully')]")
    private WebElement successStatus;

    @FindBy(xpath = "//div[contains(text(),'successfully issued.')]")
    private WebElement invoiceSuccessfullyIssuedStatus;

    @FindBy(xpath = "(//div[contains(@class,'d-flex flex-row list-item-card  card')])[1]")
    private WebElement firstInvoice;

    @FindBy(css = "[class*='col'] h4")
    private WebElement noResult;

    @FindBy(xpath = "//span[contains(@id,'live-region')]/..")
    private WebElement selectClinic;

    @FindBy(xpath = "//span[contains(@id,'live-region')]/../descendant::input[@id]")
    private WebElement selectClinicInput;

    @FindBy(xpath = "(//div[@class='d-flex flex-row list-item-card  card']/descendant::p[contains(@class,'w-20 mb-1 w-sm')])[1]")
    private WebElement invoice;

    @FindBy(xpath = "(//div[contains(@class,'px-4 mt-4')])[1]")
    private WebElement paymentStatus;

    @FindBy(xpath = "(//div[contains(@class,'d-flex flex-row list-item')])[1]")
    private WebElement firstPaymentStatus;

    @FindBy(xpath = "(//ul[@class='list-unstyled'])[2]/li/following::li/following::li")
    private WebElement createdStatusLink;

    @FindBy(xpath = "(//ul[@class='list-unstyled'])[2]/li/following::li/a/i[@class='simple-icon-check align-middle']")
    private WebElement issuedInvoiceLink;

    @FindBy(xpath = "(//p[contains(@class,'list-item-heading')])[1]")
    private WebElement firstID;

    @FindBy(css = "[class='modal-title']")
    private WebElement title;

    @FindBy(css = "[class='d-flex flex-column'] h5+div+div")
    private WebElement clientInfo;

    @FindBy(css = "[class='btn btn-danger']")
    private WebElement unIssueButton;

    @FindBy(css = "[class='btn btn-orange disabled']")
    private WebElement cancelOrderButton;

    @FindBy(css = "[class='btn btn-success']")
    private WebElement issueButton;

    @FindBy(css = "[class='btn btn-outline-primary']")
    private WebElement invoiceCloseButton;

    @FindBy(css = "[class='modal-body'] h4")
    private WebElement issuePopUpBody;

    @FindBy(xpath = "//button[text()='Yes']")
    private WebElement yesButton;

    @FindBy(xpath = "//button[text()='No']")
    private WebElement noButton;

    @FindBy(css = "[class='modal-title'] h5")
    private WebElement invoiceID;

    @FindBy(xpath = "(//div[contains(@class,'d-flex flex-row list-item')]/descendant::p)[1]")
    private WebElement selectFirstInvoice;

    @FindBy(xpath = "//i[@class='simple-icon-cloud-download d-block ']/..")
    private WebElement downloadLink;

    @FindBy(css = "[class*='cursor-pointer price']")
    private WebElement price;

    @FindBy(css = "[class*='cursor-pointer price'] input")
    private WebElement priceInput;

    @FindBy(xpath = "(//span[@class='d-flex in-edit-action']/span)[1]")
    private WebElement rightIcon;

    @FindBy(css = "[class='btn btn-danger']")
    private WebElement editInvoice;

    @FindBy(xpath = "//table")
    private WebElement tableInvoice;

    @FindBy(css = "[class*='d-flex btn btn-danger']")
    private WebElement editPriceYesButton;

    @FindBy(xpath = "(//ul[@class='list-unstyled'])[1]/li/a/i[@class='simple-icon-ban align-middle']")
    private WebElement unpaidInvoiceLink;

    @FindBy(css = "[class='btn btn-primary']")
    private WebElement markAsPAid;

    @FindBy(css = "[class*='d-flex btn btn-primary']")
    private WebElement markAsPaidYesButton;

    @FindBy(css = "[class*='float-right btn btn-outline-primary']")
    private WebElement markAsPaidNoButton;

    @FindBy(css = "[class='btn btn-orange']")
    private WebElement emailInvoiceButton;

    @FindBy(css = "[class='modal-body'] h4")
    private WebElement inputEmailPopUp;

    @FindBy(css = "[class='modal-body'] h4+span+input")
    private WebElement emailInput;

    @FindBy(css = "[class*='d-flex btn btn-orange']")
    private WebElement emailYesButton;

    @FindBy(css = "[class*='text-center font-medium']")
    private WebElement getInbox;

    @FindBy(css = "input[placeholder='Enter username']")
    private WebElement userName;

    @FindBy(css = "[class*='dark:focus:border-primary-500']")
    private WebElement selectDomain;

    @FindBy(xpath = "//button[text()='Add Inbox']")
    private WebElement addInbox;

    @FindBy(xpath = "//table/tbody/tr/td[2]")
    private WebElement inboxMessage;

    @FindBy(xpath = "//a[text()='Pay Invoice Electronically']")
    private WebElement payInvoiceLink;

    @FindBy(css = "[class*='HeaderImage-text Text Text-color']")
    private WebElement paymentPage;

    @FindBy(css = "[class*='d-flex flex-row']+h5")
    private WebElement summary;

    @FindBy(css = "[class='btn btn-danger']+button")
    private WebElement cancelOrder;

    @FindBy(css = "[class*=' d-flex btn btn-orange']")
    private WebElement cancelOrderYesButton;

    public void clickOnInvoices()
    {
        ts.presenceOfElementWait(clinic);
        ts.scrollIntoView(invoiceButton);
        invoiceButton.click();
        ts.presenceOfElementWait(invoiceText);
        ts.presenceOfElementWait(searchBar);
        ts.presenceOfElementWait(startDate);
        ts.presenceOfElementWait(endDate);

    }

    public void generateInvoices(){
        ts.presenceOfElementWait(generateInvoice);
        generateInvoice.click();
        ts.presenceOfElementWait(clinicDropDown);
        clinicDropDown.click();
        ts.presenceOfElementWait(clinicInput);
        String hospitalName=prop.getProperty("hospitalName");
        clinicInput.sendKeys(hospitalName);
        ts.presenceOfElementWait(listBox);
        ts.presenceOfElementWait(firstElementInDropDown);
        firstElementInDropDown.click();
        ts.presenceOfElementWait(startInvoiceDate);
        String startDate=getRandomDate();
        startInvoiceDate.sendKeys(startDate);
        ts.presenceOfElementWait(monthPicker);
        startInvoiceDate.sendKeys(Keys.ENTER);
        String endDate=localDate();
        endInvoiceDate.sendKeys(endDate);
        ts.presenceOfElementWait(monthPicker);
        endInvoiceDate.sendKeys(Keys.ENTER);
        ts.presenceOfElementWait(generateInvoiceButton);
        generateInvoiceButton.click();
        ts.presenceOfElementWait(status);
        ts.presenceOfElementWait(successStatus);
    }

    public void searchForInvoice() {
        ts.presenceOfElementWait(searchBar);
        String hospitalName=prop.getProperty("hospitalName");
        ts.presenceOfElementWait(firstInvoice);
        searchBar.sendKeys(hospitalName);
        try {
            ts.waitForTheElementVisibility(firstInvoice,10);
            }
        catch (Exception e)
        {
            ts.presenceOfElementWait(noResult);
            String text=noResult.getText();
            String noResult=prop.getProperty("noResultMessage");
            Assert.assertEquals(noResult,text);
        }
    }

    public void searchInvoiceBetweenDates(){
        ts.presenceOfElementWait(startDate);
        String start = prop.getProperty("startInvoice");
        String end = localDate();
        startDate.sendKeys(start);
        startDate.sendKeys(Keys.ENTER);
        endDate.sendKeys(end);
        endDate.sendKeys(Keys.ENTER);
        ts.presenceOfElementWait(firstInvoice);
        List<WebElement> allInvoice = driver.findElements(By.cssSelector("[class*='card-body'] div+p+p+p+div"));
        for(WebElement r: allInvoice)
        {
            try {
                ts.presenceOfElementWait(r);
            }
            catch (Exception e)
            {
                ts.presenceOfElementWait(noResult);
                String text=noResult.getText();
                String noResult=prop.getProperty("noResultMessage");
                Assert.assertEquals(noResult,text);
            }
        }

    }

    public void searchTheInvoiceByEnteringHospitalName()  {
        ts.presenceOfElementWait(selectClinic);
        selectClinic.click();
        ts.presenceOfElementWait(selectClinicInput);
        String hospitalName=prop.getProperty("hospitalName");
        selectClinicInput.sendKeys(hospitalName);
        ts.presenceOfElementWait(listBox);
        ts.presenceOfElementWait(firstElementInDropDown);
        firstElementInDropDown.click();
        ts.presenceOfElementWait(firstInvoice);
        ts.presenceOfElementWait(invoice);
       try {
           List<WebElement> invoices = driver.findElements(By.xpath("//div[@class='d-flex flex-row list-item-card  card']/descendant::p[contains(@class,'w-20 mb-1 w-sm')]"));
           for (WebElement r : invoices) {
               String text = r.getText();
               Assert.assertEquals(hospitalName, text);
           }

       }
       catch (Exception e)
       {
           ts.presenceOfElementWait(noResult);
           String text=noResult.getText();
           String noResult=prop.getProperty("noResultMessage");
           Assert.assertEquals(noResult,text);
       }

    }

    public void checkThePaymentStatus()
    {
        ts.presenceOfElementWait(paymentStatus);
        List<WebElement> allPaymentStatus = driver.findElements(By.xpath("(//div[contains(@class,'px-4 mt-4')])[1]/descendant::a"));
        for (WebElement r: allPaymentStatus)
        {
            r.click();
            String actualText=r.getText();

            ts.presenceOfElementWait(firstPaymentStatus);
            List<WebElement> particularStatus = driver.findElements(By.xpath("//div[contains(@class,'d-flex flex-row list-item')]/descendant::p[@class='w-15 mb-1 w-sm-100']"));
            for(WebElement r1: particularStatus)
            {
                if(actualText.contains("Paid")) {
                    String expectedText = r1.getText();
                    Assert.assertEquals("paid",expectedText);
                }
                else if (actualText.contains("Unpaid"))
                {
                    String expectedText = r1.getText();
                    Assert.assertEquals("unpaid",expectedText);
                }
                else if (actualText.contains("Payment Failed"))
                {
                    String expectedText = r1.getText();
                    Assert.assertEquals("Failed",expectedText);
                }
            }
        }

    }

    public void issueTheInvoice()  {
        ts.presenceOfElementWait(createdStatusLink);
        createdStatusLink.click();
        ts.presenceOfElementWait(firstPaymentStatus);
        ts.presenceOfElementWait(firstID);
        firstID.click();
        ts.presenceOfElementWait(clientInfo);
        ts.presenceOfElementWait(issueButton);
        issueButton.click();
        ts.presenceOfElementWait(issuePopUpBody);
        ts.presenceOfElementWait(yesButton);
        yesButton.click();
        ts.presenceOfElementWait(status);
        ts.presenceOfElementWait(invoiceSuccessfullyIssuedStatus);
        ts.presenceOfElementWait(invoiceCloseButton);
        invoiceCloseButton.click();
    }

    public void cancelSomeOrders() {
        ts.presenceOfElementWait(issuedInvoiceLink);
        ts.clickOnElement(issuedInvoiceLink);
        ts.presenceOfElementWait(unpaidInvoiceLink);
        ts.clickOnElement(unpaidInvoiceLink);
        ts.presenceOfElementWait(firstInvoice);
        ts.presenceOfElementWait(firstID);
        ts.clickOnElement(firstID);
        ts.presenceOfElementWait(title);
        ts.presenceOfElementWait(clientInfo);
        ts.presenceOfElementWait(summary);
        List<WebElement> allCheckbox = driver.findElements(By.cssSelector("[type='checkbox']"));
        allCheckbox.get(1).click();
        ts.presenceOfElementWait(cancelOrder);
        cancelOrder.click();
        ts.presenceOfElementWait(cancelOrderYesButton);
        cancelOrderYesButton.click();
        ts.presenceOfElementWait(successStatus);

    }
    public String localDate()
    {
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy"); // Adjust pattern if needed

        return currentDate.format(formatter);
    }


    public void downloadTheInvoice()  {
        ts.presenceOfElementWait(selectFirstInvoice);
        selectFirstInvoice.click();
        ts.presenceOfElementWait(title);
        ts.presenceOfElementWait(clientInfo);
        ts.presenceOfElementWait(downloadLink);
        downloadLink.click();

    }

    public void editThePriceOFInvoice(){
        ts.presenceOfElementWait(issuedInvoiceLink);
        issuedInvoiceLink.click();
        ts.presenceOfElementWait(unpaidInvoiceLink);
        unpaidInvoiceLink.click();
        ts.presenceOfElementWait(firstInvoice);
        ts.presenceOfElementWait(firstID);
        firstID.click();
        ts.presenceOfElementWait(title);
        ts.presenceOfElementWait(clientInfo);
        ts.scrollIntoView(price);
        ts.presenceOfElementWait(price);
        ts.doActionsDoubleClick(price);
        ts.presenceOfElementWait(priceInput);
        priceInput.clear();
        Random r=new Random();
        int random=r.nextInt(1000);
        priceInput.sendKeys("1"+random);
        ts.presenceOfElementWait(rightIcon);
        rightIcon.click();
        ts.presenceOfElementWait(editInvoice);
        editInvoice.click();
        ts.presenceOfElementWait(tableInvoice);
        ts.presenceOfElementWait(editPriceYesButton);
        editPriceYesButton.click();
        ts.presenceOfElementWait(status);
        try {
            ts.waitForTheElementVisibility(successStatus,10);
        }
        catch (Exception e)
        {
            ts.presenceOfElementWait(markAsPaidNoButton);
            markAsPaidNoButton.click();
        }

    }

    public void markInvoiceAsPaid()
    {
        ts.presenceOfElementWait(title);
        ts.presenceOfElementWait(clientInfo);
        ts.presenceOfElementWait(markAsPAid);
        markAsPAid.click();
        ts.presenceOfElementWait(markAsPaidYesButton);
        markAsPaidYesButton.click();
        ts.presenceOfElementWait(status);

    }

    static Random r=new Random();
    static int random=r.nextInt(100);
    public void sendTheInvoiceEmail()
    {
        ts.presenceOfElementWait(issuedInvoiceLink);
        issuedInvoiceLink.click();
        ts.presenceOfElementWait(firstInvoice);
        ts.presenceOfElementWait(firstID);
        firstID.click();
        ts.presenceOfElementWait(emailInvoiceButton);
        emailInvoiceButton.click();
        ts.presenceOfElementWait(inputEmailPopUp);
        ts.presenceOfElementWait(emailInput);
        String eName = prop.getProperty("userEmail");
        String domain = prop.getProperty("userDomain");
        emailInput.sendKeys(eName+random+domain);
        emailYesButton.click();
        ts.presenceOfElementWait(status);
        ts.switchToTab(1);
        try {
            ts.waitForTheElementVisibility(inboxMessage,10);
            inboxMessage.click();
        }
        catch (Exception e)
        {
            ts.refreshTheWebPAge();
            ts.presenceOfElementWait(inboxMessage);
            ts.clickOnElement(inboxMessage);
        }

        ts.presenceOfElementWait(payInvoiceLink);
        ts.scrollIntoView(payInvoiceLink);
        payInvoiceLink.click();
        ts.switchToTab(2);
        ts.presenceOfElementWait(paymentPage);
    }

    public void getNada(){
        ts.openNewTab();
        driver.get("https://inboxes.com/");
        ts.switchToTab(1);
        ts.presenceOfElementWait(getInbox);
        getInbox.click();
        ts.presenceOfElementWait(userName);
        String name=prop.getProperty("dummyEmailName");
        String domain=prop.getProperty("dummyDomainName");
        userName.sendKeys(name+random);
        ts.presenceOfElementWait(selectDomain);
        selectDomain.click();
        ts.doSelectDropDownByVisibleText(selectDomain,domain);
        ts.presenceOfElementWait(addInbox);
        addInbox.click();
        ts.switchToTab(0);
    }




    public static LocalDate getRandomDate(LocalDate startDate, LocalDate endDate) {
        Random random = new Random();
        long daysBetween = ChronoUnit.DAYS.between(startDate, endDate);
        long randomDays = random.nextInt((int) daysBetween + 1);
        return startDate.plusDays(randomDays);
    }

    public static String formatDate(LocalDate date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        return date.format(formatter);
    }

    public String getRandomDate()
    {
        LocalDate startDate = LocalDate.of(2024, 8, 1);
        LocalDate endDate = LocalDate.of(2024, 9, 30);
        LocalDate randomDate= getRandomDate(startDate, endDate);
        return formatDate(randomDate);
    }
}
