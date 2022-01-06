package Railway;

import Common.Constant;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Testcase06 extends TestBase {

//    Register info
    private String email = Constant.EMAIL_REGISTER;
    private String password = Constant.PASSWORD_REGISTER;
    private String confirm_password = Constant.CONFIRM_PASSWORD_REGISTER;
    private String pid = Constant.PID;

//    Check point
    public String titleHomePage = "Safe Railway - Selenium Automation";

//    Create Object
    public HomePage homePage = new HomePage();
    public LoginPage loginPage = new LoginPage();
    public RegisterPage registerPage = new RegisterPage();

    @Test(description = "TC 06 - User is redirected to Home page after logging out")
    public void TC06()
    {
//        Pre-condition
        System.out.println("TC 06 - Step1: Navigate to Register Page.");
        homePage.navigateToHomePage();
        homePage.goToRegister();

        System.out.println("TC 06 - Step2: Create an account.");
        registerPage.registerAccount(email, password, confirm_password, pid);

        System.out.println("TC 06 - Step3: Navigate to Home Page.");
        homePage.navigateToHomePage();
        homePage.goToLoginPage();

        System.out.println("TC 06 - Step4: Login with valid username, password.");
        loginPage.login(email, password);
        System.out.println("The email: " + email);
        System.out.println("The password: " + password);

        System.out.println("TC 06 - Step5: Navigate to Contact Page.");
        homePage.goToContact();

        System.out.println("TC 06 - Step6: Navigate to Logout.");
        homePage.goToLogout();

        System.out.println("TC 06 - Step7: Check point Home Page.");
        String actualMsgMyTicket = homePage.getTitleHomePage();
        Assert.assertEquals(actualMsgMyTicket, titleHomePage, "The My Ticket Page is not opened.");

        System.out.println("TC 06 - Step8: Check point Logout.");
        Assert.assertFalse(homePage.isDisplayTabLogout(), "Tab Logout was displayed. Failed !!!");
    }
}

