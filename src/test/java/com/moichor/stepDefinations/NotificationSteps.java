package com.moichor.stepDefinations;

import com.moichor.base.DriverFactory;
import com.moichor.pages.NotificationPage;
import io.cucumber.java.en.Then;
import org.openqa.selenium.JavascriptExecutor;

public class NotificationSteps extends DriverFactory {

    private final NotificationPage notificationPage;
    private final JavascriptExecutor js;

    public NotificationSteps()
    {
        this.driver= DriverFactory.getDriver();
        this.notificationPage=new NotificationPage(driver);
        this.js=(JavascriptExecutor) driver;
    }

    @Then("select a test and send a message")
    public void selectATestAndSendAMessage() {
        notificationPage.clickOnTestButton();
        notificationPage.selectTheTest();

    }


    @Then("sent message is displayed on notification page")
    public void sentMessageIsDisplayedOnNotificationPage() throws InterruptedException {
        notificationPage.sendMessageToAdmin();
    }

    @Then("search for message received from client side")
    public void searchForMessageReceivedFromClientSide() {

        notificationPage.searchMessageReceivedFromClientSide();
    }

    @Then("send a message back to the client")
    public void sendAMessageBackToTheClient() throws InterruptedException {
        notificationPage.sendMessageToClient();
    }

    @Then("search for a message received from admin side")
    public void searchForAMessageReceivedFromAdminSide() throws InterruptedException {
        notificationPage.searchMessageReceivedFromAdminSide();
    }


    @Then("search the existing notification by patient name")
    public void searchTheExistingNotificationByPatientName() {
        notificationPage.searchNotificationByPatientName();
    }

    @Then("search the existing notification by clinic name")
    public void searchTheExistingNotificationByClinicName() {
        notificationPage.searchNotificationByClinicName();
    }
}
