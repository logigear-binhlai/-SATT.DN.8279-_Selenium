package Railway;

import Common.Constant;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Testcase07 extends TestBase {
    @Test(description = "TC 07 - User can create new account.")
    public void TC07()
    {
        HomePage homePage = new HomePage();
        RegisterPage registerPage = new RegisterPage();

        System.out.println("TC 07 - Step1: Navigate to Register Page.");
        homePage.navigateToHomePage();
        homePage.goToRegister();

        System.out.println("TC 07 - Step2: Create an account.");
        registerPage.registerAccount(Constant.EMAIL_REGISTER, Constant.PASSWORD_REGISTER,
                Constant.CONFIRM_PASSWORD_REGISTER, Constant.PID);

        System.out.println("TC 07 - Step3: Check point.");
        String actualMsg = registerPage.getTxtWelcomeMsg().getText();
        String expectedMsg = Constant.WELCOME_MSG;
        Assert.assertEquals(actualMsg, expectedMsg, "Welcome message is not displayed as expected");
    }
}

