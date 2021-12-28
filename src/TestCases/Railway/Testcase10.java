package Railway;

import Constant.Constant;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Testcase10 extends TestBase {
    @Test(description = "TC 10 - User can't create account with an already in-use email.")
    public void TC10()
    {
        HomePage homePage = new HomePage();
        RegisterPage registerPage = new RegisterPage();

        System.out.println("TC 10 - Step1: Navigate to Register Page.");
        homePage.navigateToHomePage();
        homePage.goToRegister();

        System.out.println("TC 10 - Step2: Create an account with an already in-use email.");
        registerPage.registerAccount(Constant.CREATED_USERNAME, Constant.PASSWORD_REGISTER,
                Constant.CONFIRM_PASSWORD_REGISTER, Constant.PID);

        System.out.println("TC 10 - Step3: Check point.");
        String actualMsg = registerPage.getLblErrorMsg().getText();
//        String actualPasswordMsg = registerPage.getLblErrorPasswordMsg().getText();
//        String actualPidMsg = registerPage.getLblErrorPidMsg().getText();

        String expectedMsg = Constant.ERROR_USED_MAIL_MSG;
//        String expectedPasswordMsg = Constant.ERROR_PASSWORD_MSG;
//        String expectedPidMsg = Constant.ERROR_PID_MSG;

        Assert.assertEquals(actualMsg, expectedMsg, "Welcome message is not displayed as expected");
//        Assert.assertEquals(actualPasswordMsg, expectedPasswordMsg, "Welcome message is not displayed as expected");
//        Assert.assertEquals(actualPidMsg, expectedPidMsg, "Welcome message is not displayed as expected");


    }
}

