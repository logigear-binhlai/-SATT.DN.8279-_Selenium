package Railway;

import Common.Constant;
import Common.JsonHelper;
import Common.Utilities;
import com.google.gson.JsonObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Testcase14 extends TestBaseWithPreCondition {
    @Test(description = "TC 14 - User can book many tickets at a time.", dataProvider = "data-bookTicket")
    public void TC14(String depart_date, String depart_station, String arrive_station, String seat_type,
                     String ticket_amount)
    {
        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();
        BookTicketPage bookTicketPage = new BookTicketPage();

        System.out.println("TC 14 - Step3: Navigate to Login Page.");
        homePage.navigateToHomePage();
        homePage.goToLoginPage();

        System.out.println("TC 14 - Step4: Login with valid account.");
        loginPage.login(email, password);
        System.out.println(email);
        System.out.println(password);

        System.out.println("TC 14 - Step5: Navigate to Book Ticket Page.");
        homePage.goToBookTicket();

        System.out.println("TC 14 - Step6: Book Ticket.");
        bookTicketPage.bookTicketWithDataProvider(depart_date, depart_station, arrive_station,
                seat_type, ticket_amount);

        System.out.println("TC 14 - Step7: Check point.");
        String actualMsg = bookTicketPage.getTxtSuccess().getText();
        String expectedMsg = Constant.SUCCESS_MSG;
        Assert.assertEquals(actualMsg, expectedMsg, "An message is not displayed as design.");
    }

    @DataProvider(name = "data-bookTicket")
    public Object[][] dataProvider() {
        String filePath = Utilities.getProjectPathDataJson();
        JsonObject jsonObject = JsonHelper.getJsonObject(filePath);
        JsonObject dataTC01 = jsonObject.getAsJsonObject("TC01");
        String departDate01 = dataTC01.get("departDate").getAsString();
        String departStation01 = dataTC01.get("departStation").getAsString();
        String arriveStation01 = dataTC01.get("arriveStation").getAsString();
        String seatType01 = dataTC01.get("seatType").getAsString();
        String ticketAmount01 = dataTC01.get("ticketAmount").getAsString();

        JsonObject dataTC02 = jsonObject.getAsJsonObject("TC02");
        String departDate02 = dataTC02.get("departDate").getAsString();
        String departStation02 = dataTC02.get("departStation").getAsString();
        String arriveStation02 = dataTC02.get("arriveStation").getAsString();
        String seatType02 = dataTC02.get("seatType").getAsString();
        String ticketAmount02 = dataTC02.get("ticketAmount").getAsString();

        Object[][] object = new Object[][]{
                {departDate01 ,departStation01, arriveStation01, seatType01, ticketAmount01},
                {departDate02 ,departStation02, arriveStation02, seatType02, ticketAmount02}
        };

        return object;
    }
}

