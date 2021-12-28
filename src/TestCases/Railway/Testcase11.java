package Railway;

import Constant.Constant;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Testcase11 extends TestBase {
    @Test(description = "TC 11 - User can't create account while password and PID fields are empty.")
    public void TC11()
    {
        HomePage homePage = new HomePage();
        RegisterPage registerPage = new RegisterPage();

        System.out.println("TC 11 - Step1: Navigate to Register Page.");
        homePage.navigateToHomePage();
        homePage.goToRegister();

        System.out.println("TC 11 - Step2: Create an account with password and PID fields are empty.");
        registerPage.registerAccount(Constant.EMAIL_REGISTER, Constant.BLANK_PASSWORD,
                Constant.CONFIRM_PASSWORD_REGISTER, Constant.BLANK_PID);

        System.out.println("TC 11 - Step3: Check point.");
        String actualMsg = registerPage.getLblErrorMsg().getText();
        String actualPasswordMsg = registerPage.getLblErrorPasswordMsg().getText();
        String actualPidMsg = registerPage.getLblErrorPidMsg().getText();

        String expectedMsg = Constant.ERROR_MSG;
        String expectedPasswordMsg = Constant.ERROR_PASSWORD_MSG;
        String expectedPidMsg = Constant.ERROR_PID_MSG;

        Assert.assertEquals(actualMsg, expectedMsg, "Welcome message is not displayed as expected");
        Assert.assertEquals(actualPasswordMsg, expectedPasswordMsg, "Welcome message is not displayed as expected");
        Assert.assertEquals(actualPidMsg, expectedPidMsg, "Welcome message is not displayed as expected");
    }
}

