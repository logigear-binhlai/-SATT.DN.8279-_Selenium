package Railway;

import Common.Constant;
import Common.JsonHelper;
import Common.Utilities;
import com.google.gson.JsonObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.awt.*;

public class Testcase16 extends TestBase {

//    Register info
    private String email = Constant.EMAIL_REGISTER;
    private String password = Constant.PASSWORD_REGISTER;
    private String confirm_password = Constant.CONFIRM_PASSWORD_REGISTER;
    private String pid = Constant.PID;

//    Create Object
    public HomePage homePage = new HomePage();
    public LoginPage loginPage = new LoginPage();
    public RegisterPage registerPage = new RegisterPage();
    MyTicketPage myTicketPage = new MyTicketPage();
    BookTicketPage bookTicketPage= new BookTicketPage();

    @Test(description = "TC 16 - User can cancel a ticket.", dataProvider = "data-bookTicket")
    public void TC16(String depart_station, String arrive_station, String seat_type,
                     String ticket_amount) throws InterruptedException, AWTException {
//        Pre-condition
        System.out.println("TC 16 - Step1: Navigate to Register Page.");
        homePage.navigateToHomePage();
        homePage.goToRegister();

        System.out.println("TC 16 - Step2: Create an account.");
        registerPage.registerAccount(email, password, confirm_password, pid);

        System.out.println("TC 16 - Step3: Navigate to Login Page.");
        homePage.goToLoginPage();

        System.out.println("TC 16 - Step4: Login with valid account.");
        loginPage.login(email, password);
        System.out.println("The email: " + email);
        System.out.println("The password: " + password);

        System.out.println("TC 16 - Step5: Navigate to Book Ticket Page.");
        homePage.goToBookTicket();

        System.out.println("TC 16 - Step6: Book a ticket");
        bookTicketPage.bookTicketWithDataProvider(depart_station, arrive_station,
                seat_type, ticket_amount);

        System.out.println("TC 16 - Step7: Navigate to My Ticket.");
        homePage.goToMyTicket();

        System.out.println("TC 16 - Step8: Cancel a ticket");
        myTicketPage.cancelTicket(depart_station, arrive_station);

        System.out.println("TC 16 - Step9: select \'Yes\' on the pop up alert.");
        myTicketPage.acceptAlert();

        System.out.println("TC 16 - Step10: Check point.");
        Assert.assertFalse(myTicketPage.isItemDisplay(depart_station, arrive_station),
                "Deleted Item was displayed. Failed.");
    }

    @DataProvider(name = "data-bookTicket")
    public Object[][] dataProvider() {
        String filePath = Utilities.getProjectPathDataJson();
        JsonObject jsonObject = JsonHelper.getJsonObject(filePath);
        JsonObject dataTC16 = jsonObject.getAsJsonObject("TC16");
        String departStation16 = dataTC16.get("departStation").getAsString();
        String arriveStation16 = dataTC16.get("arriveStation").getAsString();
        String seatType16 = dataTC16.get("seatType").getAsString();
        String ticketAmount16 = dataTC16.get("ticketAmount").getAsString();

        Object[][] object = new Object[][]{
                {departStation16, arriveStation16, seatType16, ticketAmount16}
        };

        return object;
    }
}

