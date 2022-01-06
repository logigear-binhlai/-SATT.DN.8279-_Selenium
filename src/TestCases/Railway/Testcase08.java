package Railway;

import Common.Constant;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Testcase08 extends TestBase {

//    Register info
    private String email = Constant.EMAIL_REGISTER;
    private String password = Constant.PASSWORD_REGISTER;
    private String confirm_password = Constant.CONFIRM_PASSWORD_REGISTER;
    private String pid = Constant.PID;

//    Check point
    public String errorLoginUnActive = "Invalid username or password. Please try again.";

//    Create Object
    public HomePage homePage = new HomePage();
    public LoginPage loginPage = new LoginPage();
    public RegisterPage registerPage = new RegisterPage();

    @Test(description = "TC 08 - User can't login with an account hasn't been activated.")
    public void TC08()
    {
//        Pre-condition
        System.out.println("TC 08 - Step1: Navigate to Register Page.");
        homePage.navigateToHomePage();
        homePage.goToRegister();

        System.out.println("TC 08 - Step2: Create an account.");
        registerPage.registerAccount(email, password, confirm_password, pid);

        System.out.println("TC 08 - Step3: Navigate to Login Page");
        homePage.goToLoginPage();


        System.out.println("TC 08 - Step4: Login with account hasn't been activated.");
        loginPage.login(email, password);
        System.out.println("The email: " + email);
        System.out.println("The password: " + password);

        System.out.println("TC 08 - Step5: Check point");
        String actualMsg = loginPage.getLblLoginMsg().getText();
        Assert.assertEquals(actualMsg, errorLoginUnActive, "Welcome message is not displayed as expected");
    }
}
