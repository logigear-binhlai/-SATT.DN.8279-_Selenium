package Railway;

import Constant.Constant;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Testcase01 extends TestBase {
    @Test(description = "TC 01 - User can login to Railway with valid username and password.")
    public void TC01()
    {
        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();

        System.out.println("TC 01 - Step1: Navigate to HomePage");
        homePage.navigateToHomePage();
        homePage.gotoLoginPage();

        System.out.println("TC 01 - Step2: Login with valid username, password.");
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);

        System.out.println("TC 01 - Step3: Check point");
        String actualMsg = homePage.getWelcomeMessage();
        String expectedMsg = "Welcome " + Constant.USERNAME;
        Assert.assertEquals(actualMsg, expectedMsg, "Welcome message is not displayed as expected");
    }
}
