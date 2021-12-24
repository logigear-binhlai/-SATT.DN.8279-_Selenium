package Railway;

import Common.Utilities;
import Constant.Constant;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Testcase02 {

    @BeforeMethod
    public void beforeMethod()
    {
        System.out.println("Pre-Condition");
        System.setProperty("webdriver.chrome.driver", Utilities.getProjectPath() + "/Executables/chromedriver");
        Constant.WEBDRIVER = new ChromeDriver();
        Constant.WEBDRIVER.manage().window().maximize();
    }

    @AfterMethod
    public void afterMethod()
    {
        System.out.println("Post-Condition");
        Constant.WEBDRIVER.quit();
    }

    @Test
    public void TC02()
    {
        System.out.println("TC 02 - User can't login with blank \"Username\" textbox.");

//        navigate to Home Page
        HomePage homePage = new HomePage();
        homePage.navigateToHomePage();
        homePage.gotoLoginPage();

//        login into system
        LoginPage loginPage = new LoginPage();
        loginPage.loginWithBlankUsername(Constant.PASSWORD);

//        verify check point
        String actualMsg = loginPage.getLblLoginErrorMsg().getText();
        for (String value: Constant.EXPECTEDBEHAVIOR)
        {
                Assert.assertEquals(actualMsg, value, "An error message is not displayed as expected");
        }
    }
}
