package com.moichor.pages;

import com.moichor.base.DriverFactory;
import com.moichor.util.ConfigReader;
import com.moichor.util.TestUtil;
import junit.framework.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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

    @FindBy(xpath = "//div[contains(@class,'modal')]/descendant::div[contains(@id,'date')]/descendant::input[@placeholder='Start']")
    private WebElement startInvoiceDate;

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

    @FindBy(css = "input[class*=' focus:bg-white']")
    private WebElement userName;

    @FindBy(css = "[class*='dark:focus:border-primary-500']")
    private WebElement selectDomain;

    @FindBy(css = "[class*='rounded-lg w-full1']")
    private WebElement addInbox;

    @FindBy(xpath = "//table/tbody/tr/td[2]")
    private WebElement inboxMessage;

    @FindBy(xpath = "//a[text()='Pay Invoice Electronically']")
    private WebElement payInvoiceLink;

    @FindBy(css = "[class*='ContentCard ContentCard-mobileNoMargin ']")
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

    public void generateInvoices() throws InterruptedException {
        ts.presenceOfElementWait(generateInvoice);
        generateInvoice.click();
        ts.presenceOfElementWait(clinicDropDown);
        clinicDropDown.click();
        ts.presenceOfElementWait(clinicInput);
        String hospitalName=prop.getProperty("hospitalName");
        clinicInput.sendKeys(hospitalName);
        Thread.sleep(2000);
        List<WebElement> allClinic = driver.findElements(By.cssSelector("[class*='react-select__option']"));
        for(WebElement r:allClinic)
        {
            if(r.getText().equalsIgnoreCase(hospitalName))
            {
                r.click();
                break;
            }
        }
        ts.presenceOfElementWait(startInvoiceDate);
        String startDate=prop.getProperty("startDate");
        startInvoiceDate.sendKeys(startDate);
        Thread.sleep(2000);
        startInvoiceDate.sendKeys(Keys.ENTER);
        String endDate=localDate();
        endInvoiceDate.sendKeys(endDate);
        Thread.sleep(2000);
        endInvoiceDate.sendKeys(Keys.ENTER);
        ts.presenceOfElementWait(generateInvoiceButton);
        generateInvoiceButton.click();
        ts.presenceOfElementWait(status);
        String text = status.getText();
        System.out.println(text);
        Thread.sleep(9000);
        ts.presenceOfElementWait(status);
        System.out.println(status.getText());
        Thread.sleep(5000);

    }

    public void searchForInvoice() throws InterruptedException {
        ts.presenceOfElementWait(searchBar);
        String hospitalName=prop.getProperty("hospitalName");
        ts.presenceOfElementWait(firstInvoice);
        searchBar.sendKeys(hospitalName);
        Thread.sleep(2000);
        try {
            List<WebElement> particularInvoice = driver.findElements(By.cssSelector("[class*='card-body'] div+p+p+p"));
            particularInvoice.get(0);
            for (WebElement r : particularInvoice) {
                String name = r.getText();
                Assert.assertEquals(hospitalName, name);
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

    public void searchInvoiceBetweenDates() throws ParseException {
        ts.presenceOfElementWait(startDate);
        String start = prop.getProperty("startInvoice");
        String end = prop.getProperty("endInvoice");
        startDate.sendKeys(start);
        startDate.sendKeys(Keys.ENTER);
        endDate.sendKeys(end);
        endDate.sendKeys(Keys.ENTER);
        ts.presenceOfElementWait(firstInvoice);
        List<WebElement> allInvoice = driver.findElements(By.cssSelector("[class*='card-body'] div+p+p+p+div"));
        for(WebElement r: allInvoice)
        {
            ts.presenceOfElementWait(r);
        }

    }

    public void searchTheInvoiceByEnteringHospitalName() throws InterruptedException {
        ts.presenceOfElementWait(selectClinic);
        selectClinic.click();
        ts.presenceOfElementWait(selectClinicInput);
        String hospitalName=prop.getProperty("hospitalName");
        selectClinicInput.sendKeys(hospitalName);
        Thread.sleep(4000);
        selectClinicInput.sendKeys(Keys.ENTER);
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

    public void issueTheInvoice() throws InterruptedException {
        ts.presenceOfElementWait(createdStatusLink);
        createdStatusLink.click();
        ts.presenceOfElementWait(firstPaymentStatus);
        ts.presenceOfElementWait(firstID);
        firstID.click();
        ts.presenceOfElementWait(title);
        ts.presenceOfElementWait(clientInfo);
        ts.presenceOfElementWait(issueButton);
        issueButton.click();
        ts.presenceOfElementWait(issuePopUpBody);
        ts.presenceOfElementWait(yesButton);
        yesButton.click();
        ts.presenceOfElementWait(status);
        ts.presenceOfElementWait(status);
        Thread.sleep(5000);
        ts.presenceOfElementWait(invoiceID);
        String idName=invoiceID.getText();
        String idOfIssueInvoice=trimTheInvoiceID(idName);
        System.out.println(idOfIssueInvoice);
        ts.presenceOfElementWait(invoiceCloseButton);
        invoiceCloseButton.click();
        Thread.sleep(2000);
        ts.presenceOfElementWait(issuedInvoiceLink);
        issuedInvoiceLink.click();
        Thread.sleep(2000);
        ts.presenceOfElementWait(searchBar);
        searchBar.sendKeys(idOfIssueInvoice);
        ts.presenceOfElementWait(firstPaymentStatus);

    }

    public String localDate()
    {
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy"); // Adjust pattern if needed

        return currentDate.format(formatter);
    }

    public String trimTheInvoiceID(String id)
    {
        String id1=id.replaceAll("Invoice ID:","");
        String id2="";
        for(int i=0; i<id1.length(); i++)
        {
            char ch=id1.charAt(i);
            if(ch=='(')
            {
                break;
            }
            else
            {
                id2=id2+ch;
            }
        }

        return id2.trim();
    }

    public void downloadTheInvoice() throws InterruptedException {
        ts.presenceOfElementWait(selectFirstInvoice);
        selectFirstInvoice.click();
        ts.presenceOfElementWait(title);
        ts.presenceOfElementWait(clientInfo);
        ts.presenceOfElementWait(downloadLink);
        downloadLink.click();
        Thread.sleep(4000);
        ts.openNewTab();
        Thread.sleep(2000);
        ts.switchToTab(1);
        driver.get("chrome://downloads/");

    }

    public void editThePriceOFInvoice() throws InterruptedException {
        Thread.sleep(2000);
        ts.presenceOfElementWait(issuedInvoiceLink);
        issuedInvoiceLink.click();
        Thread.sleep(2000);
        ts.presenceOfElementWait(unpaidInvoiceLink);
        unpaidInvoiceLink.click();
        ts.presenceOfElementWait(firstInvoice);
        ts.presenceOfElementWait(firstID);
        firstID.click();
        Thread.sleep(2000);
        ts.presenceOfElementWait(title);
        ts.presenceOfElementWait(clientInfo);
        ts.scrollIntoView(price);
        ts.presenceOfElementWait(price);
        Thread.sleep(4000);
        ts.doActionsDoubleClick(price);
        ts.presenceOfElementWait(priceInput);
        priceInput.clear();
        Random r=new Random();
        int random=r.nextInt(1000);
        priceInput.sendKeys("1"+random);
        ts.presenceOfElementWait(rightIcon);
        rightIcon.click();
        Thread.sleep(2000);
        ts.presenceOfElementWait(editInvoice);
        editInvoice.click();
        ts.presenceOfElementWait(tableInvoice);
        ts.presenceOfElementWait(editPriceYesButton);
        editPriceYesButton.click();
        ts.presenceOfElementWait(status);
        Thread.sleep(4000);
        ts.presenceOfElementWait(status);
        String message=status.getText();
        System.out.println(message);
        String error=prop.getProperty("errorMessage");
        if(message.equalsIgnoreCase(error))
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
        getNada();
    }

    public void getNada()
    {
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
        try {
            ts.presenceOfElementWait(inboxMessage);
            inboxMessage.click();
    }
        catch (Exception e)
        {
            ts.switchToTab(0);
            ts.presenceOfElementWait(emailYesButton);
            emailYesButton.click();
            ts.presenceOfElementWait(status);
            ts.switchToTab(1);
            ts.refreshTheWebPAge();
            ts.presenceOfElementWait(inboxMessage);
            inboxMessage.click();

        }

        ts.presenceOfElementWait(payInvoiceLink);
        ts.scrollIntoView(payInvoiceLink);
        payInvoiceLink.click();
        ts.switchToTab(2);
        ts.presenceOfElementWait(paymentPage);
    }

    public void cancelOrder() throws InterruptedException {
        Thread.sleep(2000);
        ts.presenceOfElementWait(issuedInvoiceLink);
        issuedInvoiceLink.click();
        Thread.sleep(2000);
        ts.presenceOfElementWait(unpaidInvoiceLink);
        unpaidInvoiceLink.click();
        ts.presenceOfElementWait(firstInvoice);
        ts.presenceOfElementWait(firstID);
        firstID.click();
        ts.presenceOfElementWait(title);
        ts.presenceOfElementWait(clientInfo);
        ts.presenceOfElementWait(summary);
        List<WebElement> allCheckbox = driver.findElements(By.cssSelector("[type='checkbox']"));
        allCheckbox.get(1).click();
        ts.presenceOfElementWait(cancelOrder);
        cancelOrder.click();
        ts.presenceOfElementWait(cancelOrderYesButton);
        cancelOrderYesButton.click();
        ts.presenceOfElementWait(status);

    }


}
