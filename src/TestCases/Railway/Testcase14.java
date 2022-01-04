package Railway;

import Constant.Constant;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Testcase14 extends TestBase {
    @Test(description = "TC 14 - User can book many tickets at a time.", dataProvider = "BookTicket",
    dataProviderClass = DataProviderClass.class)
    public void TC14(String depart_date, String depart_station, String arrive_station, String seat_type,
                     String ticket_amount)
    {
        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();
        BookTicketPage bookTicketPage = new BookTicketPage();

        System.out.println("TC 14 - Step1: Navigate to Login Page.");
        homePage.navigateToHomePage();
        homePage.gotoLoginPage();

        System.out.println("TC 14 - Step2: Login with valid account.");
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);

        System.out.println("TC 14 - Step3: Navigate to Book Ticket Page.");
        homePage.gotoBookTicket();

        System.out.println("TC 14 - Step4: Book Ticket.");
        bookTicketPage.bookTicketWithDataProvider(depart_date, depart_station, arrive_station,
                seat_type, ticket_amount);

        System.out.println("TC 14 - Step5: Check point.");
        String actualMsg = bookTicketPage.getTxtSuccess().getText();
        String expectedMsg = Constant.SUCCESS_MSG;
        Assert.assertEquals(actualMsg, expectedMsg, "An message is not displayed as design.");
    }
}

