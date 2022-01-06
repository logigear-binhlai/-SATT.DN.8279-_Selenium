package Railway;

import Common.Constant;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Testcase05 extends TestBase {

//    Register info
    private String email = Constant.EMAIL_REGISTER;
    private String password = Constant.PASSWORD_REGISTER;
    private String confirm_password = Constant.CONFIRM_PASSWORD_REGISTER;
    private String pid = Constant.PID;

    public String inValidPassword = "1111111111123";

//    Check point
    public String errorLoginMultiple = "You have used 4 out of 5 login attempts. After all 5 have been " +
        "used, you will be unable to login for 15 minutes.";

//    Create Object
    public HomePage homePage = new HomePage();
    public LoginPage loginPage = new LoginPage();
    public RegisterPage registerPage = new RegisterPage();

    @Test(description = "TC 05 - System shows message when user enters wrong password several times.")
    public void TC05()
    {
//        Pre-condition
        System.out.println("TC 05 - Step1: Navigate to Register Page.");
        homePage.navigateToHomePage();
        homePage.goToRegister();

        System.out.println("TC 05 - Step2: Create an account.");
        registerPage.registerAccount(email, password, confirm_password, pid);

        System.out.println("TC 05 - Step3: Navigate to Home Page.");
        homePage.goToLoginPage();

        System.out.println("TC 05 - Step4: Login multiple times with valid username, invalid password.");
        loginPage.loginMultipleInvalidPassword(email, inValidPassword, 5);

        System.out.println("TC 05 - Step5: Check point.");
        String actualMsg = loginPage.getLblLoginErrorMsg().getText();
        Assert.assertEquals(actualMsg, errorLoginMultiple, "Welcome message is not displayed as expected");
    }
}

