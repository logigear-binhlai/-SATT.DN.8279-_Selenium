package Railway;

import Common.Constant;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Testcase15 extends TestBase {
    @Test(description = "TC 15 - \'Ticket price\' page displays with ticket details after clicking on \'check price\' " +
            "link in \'Train timetable\' page")
    public void TC15()
    {
        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();
        TrainTimeTablePage trainTimeTablePage = new TrainTimeTablePage();
        TicketPrice ticketPrice = new TicketPrice();

        System.out.println("TC 15 - Step1: Navigate to Login Page.");
        homePage.navigateToHomePage();
        homePage.goToLoginPage();

        System.out.println("TC 15 - Step2: Login with valid account.");
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);

        System.out.println("TC 15 - Step3: Navigate to Train Time Table Page.");
        homePage.goToTrainTimeTable();

        System.out.println("TC 15 - Step4: Click \'check price\' link to navigate to Ticket Page.");
        trainTimeTablePage.navigateToCheckTicket("Đà Nẵng", "Nha Trang");

        System.out.println("TC 15 - Step5: Check point Ticket Price.");
        String actualMsg = ticketPrice.getTittle();
        String expectedMsg = Constant.TITLE_TICKET_PRICE;
        Assert.assertEquals(actualMsg, expectedMsg, "An message is not displayed as design.");

        System.out.println("TC 15 - Step6: Check point table Ticket Price.");
        String actualTableTicketPriceMsg = ticketPrice.getTxtTableTicketPrice().getText();
        String expectedTableTicketPriceMsg = Constant.TXT_TABLE_TICKET_PRICE;
        Assert.assertEquals(actualTableTicketPriceMsg, expectedTableTicketPriceMsg,
                "An message is not displayed as design.");
    }
}

