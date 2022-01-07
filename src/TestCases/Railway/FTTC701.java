package Railway;

import Common.Constant;
import Common.JsonHelper;
import Common.Utilities;
import com.google.gson.JsonObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FTTC701 extends TestBase {

    //    Register info
    private String email = Constant.EMAIL_REGISTER;
    private String password = Constant.PASSWORD_REGISTER;
    private String confirm_password = Constant.CONFIRM_PASSWORD_REGISTER;
    private String pid = Constant.PID;


    //    Check point
    public String successBookTicketMsg = "Ticket Booked Successfully!";

    //    Create Object
    public HomePage homePage = new HomePage();
    public LoginPage loginPage = new LoginPage();
    public RegisterPage registerPage = new RegisterPage();
    public BookTicketPage bookTicketPage = new BookTicketPage();

    @Test(description = "FTTC 701 - User can book 1 ticket at a time.", dataProvider = "data-bookTicket")
    public void FTT7C01(String depart_station, String arrive_station, String seat_type,
                       String ticket_amount) {

//        Pre-condition
        System.out.println("FTTC 701 - Step1: Navigate to Register Page.");
        homePage.navigateToHomePage();
        homePage.goToRegister();

        System.out.println("FTTC 701 - Step2: Create an account.");
        registerPage.registerAccount(email, password, confirm_password, pid);

        System.out.println("FTTC 701 - Step3: Navigate to Login Page");
        homePage.goToLoginPage();

        System.out.println("FTTC 701 - Step4: Login with valid username, password.");
        loginPage.login(email, password);
        System.out.println("The email: " + email);
        System.out.println("The password: " + password);

        System.out.println("FTTC 701 - Step5: Navigate to Book Ticket Tab");
        homePage.goToBookTicket();

        System.out.println("FTTC 701 - Step6: Book Ticket.");
        bookTicketPage.bookTicketWithDataProvider(depart_station, arrive_station,
                seat_type, ticket_amount);

        System.out.println("FTTC 701 - Step7: Check point success book ticket message.");
        String actualMsg = bookTicketPage.getLBLSuccessMSG().getText();
        Assert.assertEquals(actualMsg, successBookTicketMsg, "Success message is not displayed as expected.");

        System.out.println("FTTC 701 - Step7: Check point depart info message.");
        String actualDepartStation = bookTicketPage.getLblBookedDepartStationInfo(depart_station).getText();
        Assert.assertEquals(actualDepartStation, depart_station, "Depart info is not displayed as expected.");

        System.out.println("FTTC 701 - Step7: Check point arrvier info message.");
        String actualArriverStation = bookTicketPage.getLblBookedArriverStationInfo(arrive_station).getText();
        Assert.assertEquals(actualArriverStation, arrive_station, "Arriver info is not displayed as expected.");

        System.out.println("FTTC 701 - Step7: Check point seat type info message.");
        String actualSeatType = bookTicketPage.getLblBookedSeatTypeInfo(seat_type).getText();
        Assert.assertEquals(actualSeatType, seat_type, "Seat type info is not displayed as expected.");

        System.out.println("FTTC 701 - Step7: Check point ticket amount info message.");
        String actualTicketAmount = bookTicketPage.getLblBookedTicketAmountInfo(ticket_amount).getText();
        Assert.assertEquals(actualTicketAmount, ticket_amount, "Ticket Amount info is not displayed " +
                "as expected.");
    }

    @DataProvider(name = "data-bookTicket")
    public Object[][] dataProvider() {
        String filePath = Utilities.getProjectPathDataJson();
        JsonObject jsonObject = JsonHelper.getJsonObject(filePath);
        JsonObject dataTC01 = jsonObject.getAsJsonObject("FTTC01");
        String departStation01 = dataTC01.get("departStation").getAsString();
        String arriveStation01 = dataTC01.get("arriveStation").getAsString();
        String seatType01 = dataTC01.get("seatType").getAsString();
        String ticketAmount01 = dataTC01.get("ticketAmount").getAsString();

        Object[][] object = new Object[][]{
                {departStation01, arriveStation01, seatType01, ticketAmount01}
        };

        return object;
    }
}
