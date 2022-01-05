package Railway;

import Common.Constant;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Testcase02 extends TestBase {
    @Test(description = "TC 02 - User can't login with blank \'Username\' textbox.")
    public void TC02()
    {
        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();

        System.out.println("TC 02 - Step1: Navigate to Home Page");
        homePage.navigateToHomePage();
        homePage.goToLoginPage();

        System.out.println("TC 02 - Step2: Login with blank username.");
        loginPage.login(Constant.BLANK_USERNAME, Constant.PASSWORD);

        System.out.println("TC 02 - Step3: Check point.");
        String actualMsg = loginPage.getLblLoginErrorMsg().getText();
        String expectedMsg = Constant.ERROR_LOGIN_BLANK_USERNAME;
        Assert.assertEquals(actualMsg, expectedMsg, "Welcome message is not displayed as expected");
    }
}
