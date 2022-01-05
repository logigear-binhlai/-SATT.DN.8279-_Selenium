package Railway;

import Common.Constant;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Testcase06 extends TestBase {
    @Test(description = "TC 06 - User is redirected to Home page after logging out")
    public void TC06()
    {
        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();
        ChangePasswordPage changePassword = new ChangePasswordPage();

        System.out.println("TC 06 - Step1: Navigate to Home Page.");
        homePage.navigateToHomePage();
        homePage.goToLoginPage();

        System.out.println("TC 06 - Step2: Login with valid username, password.");
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);

        System.out.println("TC 06 - Step3: Navigate to Contact Page.");
        homePage.goToContact();

        System.out.println("TC 06 - Step4: Navigate to Logout.");
        homePage.goToLogout();

        System.out.println("TC 06 - Step5: Check point Home Page.");
        String actualMsgMyTicket = homePage.getTitleHomePage();
        String expectedMsgMyTicket = Constant.TITLE_HOMEPAGE;
        Assert.assertEquals(actualMsgMyTicket, expectedMsgMyTicket, "The My Ticket Page is not opened.");

        System.out.println("TC 06 - Step6: Check point Logout.");
        Assert.assertFalse(homePage.isDisplayTabLogout(), "Tab Logout was displayed. Failed !!!");
    }
}

