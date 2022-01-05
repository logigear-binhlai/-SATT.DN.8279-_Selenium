package Railway;

import Common.Constant;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Testcase05 extends TestBase {
    @Test(description = "TC 05 - System shows message when user enters wrong password several times.")
    public void TC05()
    {
        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();

        System.out.println("TC 05 - Step1: Navigate to Home Page.");
        homePage.navigateToHomePage();
        homePage.goToLoginPage();

        System.out.println("TC 05 - Step2: Login multiple times with valid username, invalid password.");
        loginPage.loginMultipleInvalidPassword(Constant.USERNAME, Constant.INVALID_PASSWORD, 5);

        System.out.println("TC 05 - Step4: Check point.");
        String actualMsg = loginPage.getLblLoginErrorMsg().getText();
        String expectedMsg = Constant.ERROR_LOGIN_MULTIPLE;
        Assert.assertEquals(actualMsg, expectedMsg, "Welcome message is not displayed as expected");
    }
}

