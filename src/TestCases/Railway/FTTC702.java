package Railway;

import Common.Constant;
import Common.JsonHelper;
import Common.Utilities;
import com.google.gson.JsonObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FTTC702 extends TestBase {

    //    Register info
    private String email = Constant.EMAIL_REGISTER;
    private String password = Constant.PASSWORD_REGISTER;
    private String confirm_password = Constant.CONFIRM_PASSWORD_REGISTER;
    private String pid = Constant.PID;

    public String departDate = "1/13/2022";


    //    Create Object
    public HomePage homePage = new HomePage();
    public LoginPage loginPage = new LoginPage();
    public RegisterPage registerPage = new RegisterPage();
    public BookTicketPage bookTicketPage = new BookTicketPage();
    public MyTicketPage myTicketPage = new MyTicketPage();

    @Test(description = "FTTC 702 - User can filter Manage ticket table with both Arrive station and Depart date.",
            dataProvider = "data-bookTicket")
    public void FTT7C02(String depart_station, String arrive_station, String seat_type,
                        String ticket_amount) {

//        Pre-condition
        System.out.println("FTTC 702 - Step1: Navigate to Register Page.");
        homePage.navigateToHomePage();
        homePage.goToRegister();

        System.out.println("FTTC 702 - Step2: Create an account.");
        registerPage.registerAccount(email, password, confirm_password, pid);

        System.out.println("FTTC 702 - Step3: Navigate to Login Page");
        homePage.goToLoginPage();

        System.out.println("FTTC 702 - Step4: Login with valid username, password.");
        loginPage.login(email, password);
        System.out.println("The email: " + email);
        System.out.println("The password: " + password);

        System.out.println("FTTC 702 - Step5: Navigate to Book Ticket Tab");
        homePage.goToBookTicket();

        System.out.println("FTTC 702 - Step6: Book Ticket with 6 times.");
        bookTicketPage.bookTicketMultipleTimes(depart_station, arrive_station, seat_type, ticket_amount, 6);

        System.out.println("FTTC 702 - Step5: Navigate to My Ticket Tab");
        homePage.goToMyTicket();

        System.out.println("FTTC 702 - Step6: Filter depart date and arriver station");
        myTicketPage.filter(arrive_station, departDate);

        System.out.println("FTTC 702 - Step7: Check table is display.");
        Assert.assertTrue(myTicketPage.isTableDisplay());
    }

    @DataProvider(name = "data-bookTicket")
    public Object[][] dataProvider() {
        String filePath = Utilities.getProjectPathDataJson();
        JsonObject jsonObject = JsonHelper.getJsonObject(filePath);
        JsonObject dataFTTC02 = jsonObject.getAsJsonObject("FTTC02");
        String departStationFTTC02 = dataFTTC02.get("departStation").getAsString();
        String arriveStationFTTC02 = dataFTTC02.get("arriveStation").getAsString();
        String seatTypeFTTC02 = dataFTTC02.get("seatType").getAsString();
        String ticketAmountFTTC02 = dataFTTC02.get("ticketAmount").getAsString();

        Object[][] object = new Object[][]{
                {departStationFTTC02 , arriveStationFTTC02 , seatTypeFTTC02 , ticketAmountFTTC02 }
        };

        return object;
    }
}
