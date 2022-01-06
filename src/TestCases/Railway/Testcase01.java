package Railway;

import Common.Constant;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Testcase01 extends TestBase {

//    Register info
    private String email = Constant.EMAIL_REGISTER;
    private String password = Constant.PASSWORD_REGISTER;
    private String confirm_password = Constant.CONFIRM_PASSWORD_REGISTER;
    private String pid = Constant.PID;

//    Check point
    public String expectedMsg = "Welcome " + email;

//    Create Object
    public HomePage homePage = new HomePage();
    public LoginPage loginPage = new LoginPage();
    public RegisterPage registerPage = new RegisterPage();

    @Test(description = "TC 01 - User can login to Railway with valid username and password.")
    public void TC01() {

//        Pre-condition
        System.out.println("TC 01 - Step1: Navigate to Register Page.");
        homePage.navigateToHomePage();
        homePage.goToRegister();

        System.out.println("TC 01 - Step2: Create an account.");
        registerPage.registerAccount(email, password, confirm_password, pid);

        System.out.println("TC 01 - Step3: Navigate to Login Page");
        homePage.goToLoginPage();

        System.out.println("TC 01 - Step4: Login with valid username, password.");
        loginPage.login(email, password);
        System.out.println("The email: " + email);
        System.out.println("The password: " + password);

        System.out.println("TC 01 - Step5: Check point.");
        String actualMsg = homePage.getWelcomeMessage();
        Assert.assertEquals(actualMsg, expectedMsg, "Welcome message is not displayed as expected");
    }
}
