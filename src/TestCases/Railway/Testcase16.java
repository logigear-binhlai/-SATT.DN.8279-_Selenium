package Railway;

import Constant.Constant;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;

public class Testcase16 extends TestBase {
    @Test(description = "TC 16 - User can cancel a ticket.")
    public void TC16() throws InterruptedException, AWTException {
        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();
        MyTicketPage myTicketPage = new MyTicketPage();
        BookTicketPage bookTicketPage= new BookTicketPage();

        System.out.println("TC 16 - Step1: Navigate to Login Page.");
        homePage.navigateToHomePage();
        homePage.gotoLoginPage();

        System.out.println("TC 16 - Step2: Login with valid account.");
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);

        System.out.println("TC 16 - Step3: Navigate to Book Ticket Page.");
        homePage.gotoBookTicket();

        System.out.println("TC 16 - Step4: Book a ticket");
        bookTicketPage.bookTicket();

        System.out.println("TC 16 - Step5: Navigate to My Ticket.");
        homePage.gotoMyTicket();

        System.out.println("TC 16 - Step6: Cancel a ticket");
        myTicketPage.cancelTicket();

        System.out.println("TC 16 - Step7: select \'Yes\' on the pop up alert.");
        myTicketPage.acceptAlert();

//        System.out.println("TC 14 - Step8: Check point.");
//        String actualMsg = trainTimeTablePage.getTittle();
//        String expectedMsg = Constant.TITLE_TICKET_PRICE;
//        Assert.assertEquals(actualMsg, expectedMsg, "An message is not displayed as design.");
    }
}

