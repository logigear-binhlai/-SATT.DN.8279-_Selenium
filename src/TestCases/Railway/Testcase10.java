package Railway;

import Common.Constant;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Testcase10 extends TestBase {

//    Register info
    private String email = Constant.EMAIL_REGISTER;
    private String password = Constant.PASSWORD_REGISTER;
    private String confirm_password = Constant.CONFIRM_PASSWORD_REGISTER;
    private String pid = Constant.PID;

//    Check point
    public String errorUsedEmailMsg = "This email address is already in use.";

//    Create Object
    public HomePage homePage = new HomePage();
    public RegisterPage registerPage = new RegisterPage();
    @Test(description = "TC 10 - User can't create account with an already in-use email.")
    public void TC10()
    {
//        Pre-condition
        System.out.println("TC 10 - Step1: Navigate to Register Page.");
        homePage.navigateToHomePage();
        homePage.goToRegister();

        System.out.println("TC 10 - Step2: Create an account.");
        registerPage.registerAccount(email, password, confirm_password, pid);

        System.out.println("TC 10 - Step3: Navigate to Register Page.");
        homePage.goToRegister();

        System.out.println("TC 10 - Step4: Create an account with an already in-use email.");
        registerPage.registerAccount(email, password, confirm_password, pid);

        System.out.println("TC 10 - Step5: Check point.");
        String actualMsg = registerPage.getLblErrorMsg().getText();
        Assert.assertEquals(actualMsg, errorUsedEmailMsg, "Welcome message is not displayed as expected");
    }
}

