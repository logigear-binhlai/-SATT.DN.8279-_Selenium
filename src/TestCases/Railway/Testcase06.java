package Railway;

import Constant.Constant;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Testcase06 extends TestBase {
    @Test(description = "TC 06 - Additional pages display once user logged in.")
    public void TC06()
    {
        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();
        MyTicketPage myTicket = new MyTicketPage();
        ChangePasswordPage changePassword = new ChangePasswordPage();

        System.out.println("TC 06 - Step1: Navigate to Home Page.");
        homePage.navigateToHomePage();
        homePage.gotoLoginPage();

        System.out.println("TC 06 - Step2: Login with valid username, password.");
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);

        System.out.println("TC 06 - Step3: Navigate to My Ticket.");
        homePage.gotoMyTicket();

        System.out.println("TC 06 - Step4: Check point My Ticket Page.");
        String actualMsgMyTicket = myTicket.getTitleMyTicket();
        String expectedMsgMyTicket = Constant.TITLEMYTICKET;
        Assert.assertEquals(actualMsgMyTicket, expectedMsgMyTicket, "The My Ticket Page is not opened.");

        System.out.println("TC 06 - Step5: Navigate to Change Password.");
        homePage.gotoChangePassword();

        System.out.println("TC 06 - Step6: Check point Change Password Page.");
        String actualMsgChangePassword = changePassword.getTitleChangePassword();
        String expectedMsgChangePassword = Constant.TITLECHANGEPASSWORD;
        Assert.assertEquals(actualMsgChangePassword, expectedMsgChangePassword, "The Change Password Page " +
                "is not opened.");
    }
}

