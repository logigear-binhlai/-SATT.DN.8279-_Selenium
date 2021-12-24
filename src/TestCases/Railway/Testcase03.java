package Railway;

import Common.Utilities;
import Constant.Constant;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Testcase03 {

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
    public void TC03()
    {
        System.out.println("TC 03 - User cannot log into Railway with invalid password ");

//        navigate to Home Page
        HomePage homePage = new HomePage();
        homePage.navigateToHomePage();
        homePage.gotoLoginPage();

//        login into system
        LoginPage loginPage = new LoginPage();
        loginPage.loginWithInValidPassword(Constant.USERNAME, Constant.INVALIDPASSWORD);

//        verify check point
        String actualMsg = loginPage.getLblLoginErrorMsg().getText();
        for (String value: Constant.EXPECTEDBEHAVIOR)
        {
                Assert.assertEquals(actualMsg, value, "An error message is not displayed as expected");
        }
    }
}

