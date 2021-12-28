package Railway;

import Constant.Constant;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Testcase03 extends TestBase {

    @Test(description = "TC 03 - User cannot log into Railway with invalid password.")
    public void TC03()
    {
        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();

        System.out.println("TC 03 - Step1: Navigate to Home Page.");
        homePage.navigateToHomePage();
        homePage.gotoLoginPage();

        System.out.println("TC 03 - Step2: Login with valid username and invalid password.");
        loginPage.login(Constant.USERNAME, Constant.INVALIDPASSWORD);

        System.out.println("TC 03 - Step3: Check point");
        String actualMsg = loginPage.getLblLoginErrorMsg().getText();
        String expectedMsg = Constant.ERROR_LOGIN_INVALID_PASSWORD;
        Assert.assertEquals(actualMsg, expectedMsg, "Welcome message is not displayed as expected");

    }
}

