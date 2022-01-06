package Railway;

import Common.Constant;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Testcase03 extends TestBase {

//    Register info
    private String email = Constant.EMAIL_REGISTER;
    private String password = Constant.PASSWORD_REGISTER;
    private String confirm_password = Constant.CONFIRM_PASSWORD_REGISTER;
    private String pid = Constant.PID;

    private String inValidPassword = "1111111111123";

//    Check point
    public String errorLoginInValidPassword = "Invalid username or password. Please try again.";

//    Create Object
    public HomePage homePage = new HomePage();
    public LoginPage loginPage = new LoginPage();
    public RegisterPage registerPage = new RegisterPage();

    @Test(description = "TC 03 - User cannot log into Railway with invalid password.")
    public void TC03()
    {
//        Pre-condition
        System.out.println("TC 03 - Step1: Navigate to Register Page.");
        homePage.navigateToHomePage();
        homePage.goToRegister();

        System.out.println("TC 03 - Step2: Create an account.");
        registerPage.registerAccount(email, password, confirm_password, pid);

        System.out.println("TC 03 - Step3: Navigate to Login Page.");
        homePage.goToLoginPage();

        System.out.println("TC 03 - Step4: Login with valid username and invalid password.");
        loginPage.login(email, inValidPassword);

        System.out.println("TC 03 - Step5: Check point");
        String actualMsg = loginPage.getLblLoginErrorMsg().getText();
        Assert.assertEquals(actualMsg, errorLoginInValidPassword, "Welcome message is not displayed as expected");
    }
}

