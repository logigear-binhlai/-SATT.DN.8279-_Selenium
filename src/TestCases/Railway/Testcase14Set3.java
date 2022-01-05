package Railway;

import Common.Constant;
import Common.JsonHelper;
import Common.Utilities;
import com.google.gson.JsonObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Testcase14Set3 extends TestBaseWithPreCondition {
    @Test(description = "TC 14 Set 3 - User can't book more than 10 tickets.", dataProvider = "data-bookTicketMultiple")
    public void TC14Set3(String depart_date, String depart_station, String arrive_station, String seat_type,
                         String ticket_amount)
    {
        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();
        BookTicketPage bookTicketPage = new BookTicketPage();

        System.out.println("TC 14 - Step1: Navigate to Login Page.");
        homePage.goToLoginPage();

        System.out.println("TC 14 - Step2: Login with valid account.");
        loginPage.login(email, password);

        System.out.println("TC 14 - Step3: Book Ticket.");
        bookTicketPage.bookTicketMultipleTimes(depart_date, depart_station, arrive_station, seat_type,
                ticket_amount, 6);

        System.out.println("TC 14 - Step4: Check point.");
        String actualMsg = bookTicketPage.getErrorMsg().getText();
        String expectedMsg = Constant.ERROR_MSG;
        Assert.assertEquals(actualMsg, expectedMsg, "An message is not displayed as design.");

        String actualTicketAmountMsg = bookTicketPage.getErrorTicketAmountMsg().getText();
        String expectedTicketAmountMsg = Constant.ERROR_TICKET_AMOUNT_MSG;
        Assert.assertEquals(actualTicketAmountMsg, expectedTicketAmountMsg, "An message is not displayed as design.");
    }

    @DataProvider(name = "data-bookTicketMultiple")
    public Object[][] dataProvider() {
        String filePath = Utilities.getProjectPathDataJson();
        JsonObject jsonObject = JsonHelper.getJsonObject(filePath);
        JsonObject dataTC17 = jsonObject.getAsJsonObject("TC17");
        String departDate17 = dataTC17.get("departDate").getAsString();
        String departStation17 = dataTC17.get("departStation").getAsString();
        String arriveStation17 = dataTC17.get("arriveStation").getAsString();
        String seatType17 = dataTC17.get("seatType").getAsString();
        String ticketAmount17 = dataTC17.get("ticketAmount").getAsString();

        Object[][] object = new Object[][]{
                {departDate17 ,departStation17, arriveStation17, seatType17, ticketAmount17}
        };

        return object;
    }
}

