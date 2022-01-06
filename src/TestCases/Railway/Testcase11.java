package Railway;

import Common.Constant;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Testcase11 extends TestBase {

//    Register info
    private String email = Constant.EMAIL_REGISTER;
    private String password = Constant.PASSWORD_REGISTER;
    private String confirm_password = Constant.CONFIRM_PASSWORD_REGISTER;
    private String pid = Constant.PID;

    public String blankPassword = "";
    public String blankPId = "";

//    Check point
    public String errorMsg = "There're errors in the form. Please correct the errors and try again.";
    public String erorPasswordFieldMsg = "Invalid password length";
    public String errorPIdFieldMsg = "Invalid ID length";

//    Create Object
    public HomePage homePage = new HomePage();
    public RegisterPage registerPage = new RegisterPage();

    @Test(description = "TC 11 - User can't create account while password and PID fields are empty.")
    public void TC11()
    {
//        Pre-condition
        System.out.println("TC 11 - Step1: Navigate to Register Page.");
        homePage.navigateToHomePage();
        homePage.goToRegister();

        System.out.println("TC 11 - Step2: Create an account.");
        registerPage.registerAccount(email, blankPassword, confirm_password, blankPId);

        System.out.println("TC 11 - Step3: Check point error msg.");
        String actualMsg = registerPage.getLblErrorMsg().getText();
        Assert.assertEquals(actualMsg, errorMsg, "Create account successfully.");

        System.out.println("TC 11 - Step4: Check point error password field msg.");
        String actualPasswordMsg = registerPage.getLblErrorPasswordMsg().getText();
        Assert.assertEquals(actualPasswordMsg, erorPasswordFieldMsg, "No errors.");

        System.out.println("TC 11 - Step5: Check point error pid field msg.");
        String actualPidMsg = registerPage.getLblErrorPidMsg().getText();
        Assert.assertEquals(actualPidMsg, errorPIdFieldMsg, "No errors.");
    }
}

