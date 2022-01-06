package Railway;

import Common.Constant;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Testcase09 extends TestBase{

//    Register info
    private String email = Constant.EMAIL_REGISTER;
    private String password = Constant.PASSWORD_REGISTER;
    private String confirm_password = Constant.CONFIRM_PASSWORD_REGISTER;
    private String pid = Constant.PID;

    private String newPassword = "a123:\'/{}!@$";
    private String confirmPassword = "/{}!@$\\";

//    Check point
    public String errorChangePasswordMsg = "Password change failed. Please correct the errors and try again.";
    public String errorConfirmPasswordFieldMsg = "The password confirmation does not match the new password.";

//    Create Object
    public HomePage homePage = new HomePage();
    public LoginPage loginPage = new LoginPage();
    public RegisterPage registerPage = new RegisterPage();
    public ChangePasswordPage changePasswordPage = new ChangePasswordPage();

    @Test(description = "TC 09 - User can't change password when \'New Password\' and \'Confirm Password\' " +
            "are different.")

    public void TC09()
    {
//        Pre-condition
        System.out.println("TC 09 - Step1: Navigate to Register Page.");
        homePage.navigateToHomePage();
        homePage.goToRegister();

        System.out.println("TC 09 - Step2: Create an account.");
        registerPage.registerAccount(email, password, confirm_password, pid);

        System.out.println("TC 09 - Step3: Navigate to Login Page.");
        homePage.goToLoginPage();

        System.out.println("TC 09 - Step4: Login with valid username, password.");
        loginPage.login(email, password);
        System.out.println("The email: " + email);
        System.out.println("The password: " + password);

        System.out.println("TC 09 - Step5: Navigate to Change Password.");
        homePage.goToChangePassword();

        System.out.println("TC 09 - Step6: Change password.");
        changePasswordPage.changePassword(password, newPassword, confirmPassword);

        System.out.println("TC 09 - Step7: Check point Change Password Message.");
        String actualMsg = changePasswordPage.getLblErrorMSG().getText();
        Assert.assertEquals(actualMsg, errorChangePasswordMsg, "Welcome message is not displayed as expected");

        System.out.println("TC 09 - Step7: Check point Confirm Password Field Message.");
        String actualConfirmPasswordMsg = changePasswordPage.getLblConfirmErrorMSG().getText();
        Assert.assertEquals(actualConfirmPasswordMsg, errorConfirmPasswordFieldMsg,
                "Welcome message is not displayed as expected");
    }
}

