package Railway;

import Common.Constant;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Testcase10 extends TestBaseWithPreCondition {
    @Test(description = "TC 10 - User can't create account with an already in-use email.")
    public void TC10()
    {
        HomePage homePage = new HomePage();
        RegisterPage registerPage = new RegisterPage();

        System.out.println("TC 10 - Step3: Navigate to Register Page.");
        homePage.navigateToHomePage();
        homePage.goToRegister();

        System.out.println("TC 10 - Step4: Create an account with an already in-use email.");
        registerPage.registerAccount(email, password, confirm_password, pid);

        System.out.println("TC 10 - Step5: Check point.");
        String actualMsg = registerPage.getLblErrorMsg().getText();
        String expectedMsg = Constant.ERROR_USED_MAIL_MSG;
        Assert.assertEquals(actualMsg, expectedMsg, "Welcome message is not displayed as expected");
    }
}

