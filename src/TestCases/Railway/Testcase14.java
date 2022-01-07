package Railway;

import Common.Constant;
import Common.JsonHelper;
import Common.Utilities;
import com.google.gson.JsonObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Testcase14 extends TestBase {

//    Register info
    private String email = Constant.EMAIL_REGISTER;
    private String password = Constant.PASSWORD_REGISTER;
    private String confirm_password = Constant.CONFIRM_PASSWORD_REGISTER;
    private String pid = Constant.PID;

//    Check point
    public String successMsg = "Ticket Booked Successfully!";

//    Create Object
    public HomePage homePage = new HomePage();
    public LoginPage loginPage = new LoginPage();
    public RegisterPage registerPage = new RegisterPage();
    public BookTicketPage bookTicketPage = new BookTicketPage();

    @Test(description = "TC 14 - User can book many tickets at a time.", dataProvider = "data-bookTicket")
    public void TC14(String depart_station, String arrive_station, String seat_type,
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
        System.out.println("The email: " + email);
        System.out.println("The password: " + password);

        System.out.println("TC 14 - Step5: Navigate to Book Ticket Page.");
        homePage.goToBookTicket();

        System.out.println("TC 14 - Step6: Book Ticket.");
        bookTicketPage.bookTicketWithDataProvider(depart_station, arrive_station,
                seat_type, ticket_amount);

        System.out.println("TC 14 - Step7: Check point.");
        String actualMsg = bookTicketPage.getLBLSuccessMSG().getText();
        Assert.assertEquals(actualMsg, successMsg, "An message is not displayed as design.");
    }

    @DataProvider(name = "data-bookTicket")
    public Object[][] dataProvider() {
        String filePath = Utilities.getProjectPathDataJson();
        JsonObject jsonObject = JsonHelper.getJsonObject(filePath);
        JsonObject dataTC01 = jsonObject.getAsJsonObject("TC14");
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

