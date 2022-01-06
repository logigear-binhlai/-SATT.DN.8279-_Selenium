package Railway;

import Common.Constant;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Testcase15 extends TestBase {

//    Register info
    private String email = Constant.EMAIL_REGISTER;
    private String password = Constant.PASSWORD_REGISTER;
    private String confirm_password = Constant.CONFIRM_PASSWORD_REGISTER;
    private String pid = Constant.PID;

//    Check point
    public String titleTicketPrice = "Safe Railway - Ticket Price";
    public String lblTableTicketPrice = "Ticket price from Đà Nẵng to Nha Trang";

    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    TrainTimeTablePage trainTimeTablePage = new TrainTimeTablePage();
    TicketPrice ticketPrice = new TicketPrice();
    RegisterPage registerPage = new RegisterPage();

    @Test(description = "TC 15 - \'Ticket price\' page displays with ticket details after clicking on \'check price\' " +
            "link in \'Train timetable\' page")
    public void TC15()
    {
//        Pre-condition
        System.out.println("TC 15 - Step1: Navigate to Register Page.");
        homePage.navigateToHomePage();
        homePage.goToRegister();

        System.out.println("TC 15 - Step2: Create an account.");
        registerPage.registerAccount(email, password, confirm_password, pid);

        System.out.println("TC 15 - Step3: Navigate to Login Page.");
        homePage.goToLoginPage();

        System.out.println("TC 15 - Step4: Login with valid account.");
        loginPage.login(email, password);
        System.out.println("The email: " + email);
        System.out.println("The password: " + password);

        System.out.println("TC 15 - Step5: Navigate to Train Time Table Page.");
        homePage.goToTrainTimeTable();

        System.out.println("TC 15 - Step6: Click \'check price\' link to navigate to Ticket Page.");
        trainTimeTablePage.navigateToCheckTicket("Đà Nẵng", "Nha Trang");

        System.out.println("TC 15 - Step7: Check point Ticket Price.");
        String actualMsg = ticketPrice.getTittle();
        Assert.assertEquals(actualMsg, titleTicketPrice, "An message is not displayed as design.");

        System.out.println("TC 15 - Step8: Check point table Ticket Price.");
        String actualTableTicketPriceMsg = ticketPrice.getLblTableTicketPrice().getText();
        Assert.assertEquals(actualTableTicketPriceMsg, lblTableTicketPrice,
                "An message is not displayed as design.");
    }
}

