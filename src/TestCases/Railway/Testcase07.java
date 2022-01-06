package Railway;

import Common.Constant;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Testcase07 extends TestBase {

    //    Register info
    private String email = Constant.EMAIL_REGISTER;
    private String password = Constant.PASSWORD_REGISTER;
    private String confirm_password = Constant.CONFIRM_PASSWORD_REGISTER;
    private String pid = Constant.PID;

    //    Check point
    public String welcomeMsg = "Thank you for registering your account";

    //    Create Object
    public HomePage homePage = new HomePage();
    public LoginPage loginPage = new LoginPage();
    public RegisterPage registerPage = new RegisterPage();

    @Test(description = "TC 07 - User can create new account.")
    public void TC07()
    {
        System.out.println("TC 07 - Step1: Navigate to Register Page.");
        homePage.navigateToHomePage();
        homePage.goToRegister();

        System.out.println("TC 07 - Step2: Create an account.");
        registerPage.registerAccount(email, password, confirm_password, pid);

        System.out.println("TC 07 - Step3: Check point.");
        String actualMsg = registerPage.getTxtWelcomeMsg().getText();
        Assert.assertEquals(actualMsg, welcomeMsg, "Welcome message is not displayed as expected");
    }
}

