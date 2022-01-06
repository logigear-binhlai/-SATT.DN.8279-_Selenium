package Railway;

import Common.Constant;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Testcase04 extends TestBase {

//    Register info
    private String email = Constant.EMAIL_REGISTER;
    private String password = Constant.PASSWORD_REGISTER;
    private String confirm_password = Constant.CONFIRM_PASSWORD_REGISTER;
    private String pid = Constant.PID;

//    Check point
    public String titleBookTicket = "Safe Railway - Book Ticket";

//    Create Object
    public HomePage homePage = new HomePage();
    public LoginPage loginPage = new LoginPage();
    public RegisterPage registerPage = new RegisterPage();
    public BookTicketPage bookTicketPage = new BookTicketPage();

    @Test(description = "TC 04 - User is redirected to Book ticket page after logging in.")
    public void TC04()
    {
//        Pre-condition
        System.out.println("TC 04 - Step1: Navigate to Register Page.");
        homePage.navigateToHomePage();
        homePage.goToRegister();

        System.out.println("TC 04 - Step2: Create an account.");
        registerPage.registerAccount(email, password, confirm_password, pid);

        System.out.println("TC 04 - Step3: Navigate to Login Page.");
        homePage.goToLoginPage();

        System.out.println("TC 04 - Step4: Login with valid username, password.");
        loginPage.login(email, password);
        System.out.println("The email: " + email);
        System.out.println("The password: " + password);

        System.out.println("TC 04 - Step5: Navigate to Book Ticket.");
        homePage.goToBookTicket();

        System.out.println("TC 04 - Step6: Check point.");
        String actualMsg = bookTicketPage.getTitleBookTicket();

        Assert.assertEquals(actualMsg, titleBookTicket, "The Book Ticket Page is not opened.");
    }
}

