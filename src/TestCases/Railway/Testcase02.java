package Railway;

import Common.Constant;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Testcase02 extends TestBase {

    public String blankUsername = "";
    public String errorLoginBlankUsername = "There was a problem with your login and/or errors exist in your form.";

//    Register info
    private String email = Constant.EMAIL_REGISTER;
    private String password = Constant.PASSWORD_REGISTER;
    private String confirm_password = Constant.CONFIRM_PASSWORD_REGISTER;
    private String pid = Constant.PID;

//    Create Object
    public HomePage homePage = new HomePage();
    public LoginPage loginPage = new LoginPage();
    public RegisterPage registerPage = new RegisterPage();

    @Test(description = "TC 02 - User can't login with blank \'Username\' textbox.")
    public void TC02()
    {
//        Pre-condition
        System.out.println("TC 02 - Step1: Navigate to Register Page.");
        homePage.navigateToHomePage();
        homePage.goToRegister();

        System.out.println("TC 02 - Step2: Create an account.");
        registerPage.registerAccount(email, password, confirm_password, pid);

        System.out.println("TC 02 - Step3: Navigate to Login Page");
        homePage.goToLoginPage();

        System.out.println("TC 02 - Step4: Login with blank username.");
        loginPage.login(blankUsername, password);

        System.out.println("TC 02 - Step5: Check point.");
        String actualMsg = loginPage.getLblLoginErrorMsg().getText();
        Assert.assertEquals(actualMsg, errorLoginBlankUsername, "Welcome message is not displayed as expected");
    }
}
