package Railway;

import Constant.Constant;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Testcase04 extends TestBase {
    @Test(description = "TC 04 - User is redirected to Book ticket page after logging in.")
    public void TC04()
    {
        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();
        BookTicketPage bookTicket = new BookTicketPage();

        System.out.println("TC 04 - Step1: Navigate to Home Page.");
        homePage.navigateToHomePage();
        homePage.gotoLoginPage();

        System.out.println("TC 04 - Step2: Login with valid username, password.");
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);

        System.out.println("TC 04 - Step3: Navigate to Book Ticket.");
        homePage.gotoBookTicket();

        System.out.println("TC 04 - Step4: Check point.");
        String actualMsg = bookTicket.getTitleBookTicket();
        String expectedMsg = Constant.TITLEBOOKTICKET;

        Assert.assertEquals(actualMsg, expectedMsg, "The Book Ticket Page is not opened.");
    }
}

