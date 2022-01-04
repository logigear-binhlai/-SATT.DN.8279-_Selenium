package Railway;

import Constant.Constant;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Testcase14Set3 extends TestBase {
    @Test(description = "TC 14 Set 3 - User can't book more than 10 tickets.")
    public void TC14Set3()
    {
        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();
        BookTicketPage bookTicketPage = new BookTicketPage();

        System.out.println("TC 14 - Step1: Navigate to Login Page.");
        homePage.navigateToHomePage();
        homePage.gotoLoginPage();

        System.out.println("TC 14 - Step2: Login with valid account.");
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);

        System.out.println("TC 14 - Step3: Book Ticket.");
        bookTicketPage.bookTicketMultipleTimes(3);

        System.out.println("TC 14 - Step4: Check point.");
        String actualMsg = bookTicketPage.getErrorMsg().getText();
        String expectedMsg = Constant.ERROR_MSG;
        Assert.assertEquals(actualMsg, expectedMsg, "An message is not displayed as design.");

        String actualTicketAmountMsg = bookTicketPage.getErrorTicketAmountMsg().getText();
        String expectedTicketAmountMsg = Constant.ERROR_TicketAmount_MSG;
        Assert.assertEquals(actualTicketAmountMsg, expectedTicketAmountMsg, "An message is not displayed as design.");
    }
}

