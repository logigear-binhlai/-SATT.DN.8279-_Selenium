package Railway;

import Constant.Constant;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Testcase09 extends TestBase {
    @Test(description = "TC 09 - User can't change password when \'New Password\' and \'Confirm Password\' " +
            "are different.")

    public void TC09()
    {
        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();
        ChangePasswordPage changePasswordPage = new ChangePasswordPage();

        System.out.println("TC 09 - Step1: Navigate to Login Page.");
        homePage.navigateToHomePage();
        homePage.gotoLoginPage();

        System.out.println("TC 09 - Step2: Login with valid username, password.");
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);

        System.out.println("TC 09 - Step3: Navigate to Change Password.");
        homePage.gotoChangePassword();

        System.out.println("TC 09 - Step4: Change password with valid info.");
        changePasswordPage.changePassword(Constant.CURRENT_PASSWORD, Constant.NEW_PASSWORD, Constant.CONFIRM_PASSWORD);

        System.out.println("TC 09 - Step5: Check point Change Password Page.");
        String actualMsg = changePasswordPage.getLblErrorMSG().getText();
        String actualConfirmPasswordMsg = changePasswordPage.getLblConfirmErrorMSG().getText();
        String expectedMsg = Constant.ERROR_CONFIRM_PASSWORD_MSG;
        String expectedConfirmPasswordMsg = Constant.ERROR_CONFIRM_PASSWORD_FIELD;
        Assert.assertEquals(actualMsg, expectedMsg, "Welcome message is not displayed as expected");
        Assert.assertEquals(actualConfirmPasswordMsg, expectedConfirmPasswordMsg,
                "Welcome message is not displayed as expected");
    }
}

