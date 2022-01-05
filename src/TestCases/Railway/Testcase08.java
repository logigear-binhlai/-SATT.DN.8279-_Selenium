package Railway;

import Common.Constant;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Testcase08 extends TestBase {
    @Test(description = "TC 08 - User can't login with an account hasn't been activated.")
    public void TC08()
    {
        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();

        System.out.println("TC 08 - Step1: Navigate to Login Page");
        homePage.navigateToHomePage();
        homePage.goToLoginPage();

        System.out.println("TC 08 - Step2: Login with account hasn't been activated.");
        loginPage.login(Constant.UNACTIVATED_USERNAME, Constant.UNACTIVATED_PASSWORD);

        System.out.println("TC 08 - Step3: Check point");
        String actualMsg = loginPage.getLblLoginErrorMsg().getText();
        String expectedMsg = Constant.ERROR_LOGIN_UNACTIVED;
        Assert.assertEquals(actualMsg, expectedMsg, "Welcome message is not displayed as expected");
    }
}
