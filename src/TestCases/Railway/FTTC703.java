package Railway;

import Common.Constant;
import Common.JsonHelper;
import Common.Utilities;
import com.google.gson.JsonObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FTTC703 extends TestBase {

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
    public TicketPrice ticketPrice = new TicketPrice();

    @Test(description = "FTTC 703 - User can book ticket with known price.", dataProvider = "data-bookTicket")
    public void FTT7C03(String depart_station, String arrive_station, String seat_type,
                        String ticket_amount) {

//        Pre-condition
        System.out.println("FTTC 703 - Step1: Navigate to Register Page.");
        homePage.navigateToHomePage();
        homePage.goToRegister();

        System.out.println("FTTC 703 - Step2: Create an account.");
        registerPage.registerAccount(email, password, confirm_password, pid);

        System.out.println("FTTC 701 - Step3: Navigate to Login Page");
        homePage.goToLoginPage();

        System.out.println("FTTC 703 - Step4: Login with valid username, password.");
        loginPage.login(email, password);
        System.out.println("The email: " + email);
        System.out.println("The password: " + password);

        System.out.println("FTTC 703 - Step5: Navigate to Ticket Price Tab.");
        homePage.goToTickPrice();

        System.out.println("FTTC 703 - Step6: Click link Ticket Price.");
        ticketPrice.clickLinkTicketPrice(depart_station, arrive_station);

        System.out.println("FTTC 703 - Step7: Click link Book Ticket with Hard seat.");
        ticketPrice.clickLinkBookTicket(seat_type);

        System.out.println("FTTC 703 - Step7: Book Ticket.");
        ticketPrice.bookTicket(ticket_amount);

        System.out.println("FTTC 703 - Step8: Check point success book ticket message.");
        String actualMsg = bookTicketPage.getLBLSuccessMSG().getText();
        Assert.assertEquals(actualMsg, successBookTicketMsg, "Success message is not displayed as expected.");

        System.out.println("FTTC 703 - Step9: Check point depart info message.");
        String actualDepartStation = bookTicketPage.getLblBookedDepartStationInfo(depart_station).getText();
        Assert.assertEquals(actualDepartStation, depart_station, "Depart info is not displayed as expected.");

        System.out.println("FTTC 703 - Step10: Check point arrvier info message.");
        String actualArriverStation = bookTicketPage.getLblBookedArriverStationInfo(arrive_station).getText();
        Assert.assertEquals(actualArriverStation, arrive_station, "Arriver info is not displayed as expected.");

        System.out.println("FTTC 703 - Step11: Check point seat type info message.");
        String actualSeatType = bookTicketPage.getLblBookedSeatTypeInfo(seat_type).getText();
        Assert.assertEquals(actualSeatType, seat_type, "Seat type info is not displayed as expected.");

        System.out.println("FTTC 703 - Step12: Check point ticket amount info message.");
        String actualTicketAmount = bookTicketPage.getLblBookedTicketAmountInfo(ticket_amount).getText();
        Assert.assertEquals(actualTicketAmount, ticket_amount, "Ticket Amount info is not displayed " +
                "as expected.");
    }

    @DataProvider(name = "data-bookTicket")
    public Object[][] dataProvider() {
        String filePath = Utilities.getProjectPathDataJson();
        JsonObject jsonObject = JsonHelper.getJsonObject(filePath);
        JsonObject dataFTTC03 = jsonObject.getAsJsonObject("FTTC03");
        String departStationFTTC03 = dataFTTC03.get("departStation").getAsString();
        String arriveStationFTTC03 = dataFTTC03.get("arriveStation").getAsString();
        String seatTypeFTTC03 = dataFTTC03.get("seatType").getAsString();
        String ticketAmountFTTC03 = dataFTTC03.get("ticketAmount").getAsString();

        Object[][] object = new Object[][]{
                {departStationFTTC03, arriveStationFTTC03, seatTypeFTTC03, ticketAmountFTTC03}
        };

        return object;
    }
}
