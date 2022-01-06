package Railway;

import Common.Constant;
import Common.JsonHelper;
import Common.Utilities;
import com.google.gson.JsonObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Testcase14Set3 extends TestBase {

//    Register info
    private String email = Constant.EMAIL_REGISTER;
    private String password = Constant.PASSWORD_REGISTER;
    private String confirm_password = Constant.CONFIRM_PASSWORD_REGISTER;
    private String pid = Constant.PID;

//    Check point
    public String errorMsg = "There're errors in the form. Please correct the errors and try again.";
    public String errorTicketAmountMsg = "You have booked 10 tickets. You can book no more.";

//    Create Object
    public HomePage homePage = new HomePage();
    public LoginPage loginPage = new LoginPage();
    public RegisterPage registerPage = new RegisterPage();
    BookTicketPage bookTicketPage = new BookTicketPage();

    @Test(description = "TC 14 Set 3 - User can't book more than 10 tickets.", dataProvider = "data-bookTicketMultiple")
    public void TC14Set3(String depart_station, String arrive_station, String seat_type,
                         String ticket_amount)
    {
//        Pre-condition
        System.out.println("TC 14 - Step1: Navigate to Register Page.");
        homePage.navigateToHomePage();
        homePage.goToRegister();

        System.out.println("TC 14 - Step2: Create an account.");
        registerPage.registerAccount(email, password, confirm_password, pid);

        System.out.println("TC 14 - Step3: Navigate to Login Page.");
        homePage.goToLoginPage();

        System.out.println("TC 14 - Step4: Login with valid account.");
        loginPage.login(email, password);

        System.out.println("TC 14 - Step5: Navigate to Book Ticket Page.");
        homePage.goToBookTicket();

        System.out.println("TC 14 - Step6: Book Ticket 10 Tickets.");
        bookTicketPage.bookTicketMore10Tickets(depart_station, arrive_station, seat_type, ticket_amount);

        System.out.println("TC 14 - Step7: Navigate to Book Ticket Page.");
        homePage.goToBookTicket();

        System.out.println("TC 14 - Step8: Book Ticket 1 Tickets.");
        bookTicketPage.bookTicketWithDataProvider(depart_station, arrive_station, seat_type, ticket_amount);

        System.out.println("TC 14 - Step9: Check point.");
        String actualMsg = bookTicketPage.getErrorMsg().getText();
        Assert.assertEquals(actualMsg, errorMsg, "An message is not displayed as design.");

        String actualTicketAmountMsg = bookTicketPage.getErrorTicketAmountMsg().getText();
        Assert.assertEquals(actualTicketAmountMsg, errorTicketAmountMsg, "An message is not displayed as design.");
    }

    @DataProvider(name = "data-bookTicketMultiple")
    public Object[][] dataProvider() {
        String filePath = Utilities.getProjectPathDataJson();
        JsonObject jsonObject = JsonHelper.getJsonObject(filePath);
        JsonObject dataTC17 = jsonObject.getAsJsonObject("TC17");
        String departStation17 = dataTC17.get("departStation").getAsString();
        String arriveStation17 = dataTC17.get("arriveStation").getAsString();
        String seatType17 = dataTC17.get("seatType").getAsString();
        String ticketAmount17 = dataTC17.get("ticketAmount").getAsString();

        Object[][] object = new Object[][]{
                {departStation17, arriveStation17, seatType17, ticketAmount17}
        };

        return object;
    }
}

