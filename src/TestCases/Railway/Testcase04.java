package Railway;

import Common.Utilities;
import Constant.Constant;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Testcase04 {

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
    public void TC04()
    {
        System.out.println("TC 04 - User is redirected to Book ticket page after logging in.");

//        navigate to Home Page
        HomePage homePage = new HomePage();
        homePage.navigateToHomePage();
        homePage.gotoLoginPage();

//        login into system
        LoginPage loginPage = new LoginPage();
        loginPage.loginWithInValidPassword(Constant.USERNAME, Constant.PASSWORD);

//        navigate to Book Ticket
        homePage.gotoBookTicket();

//        verify check point
        BookTicketPage bookTicket = new BookTicketPage();
        String actualMsg = bookTicket.getTitleBookTicket();
        String expectedMsg = Constant.TITLEBOOKTICKET;

        Assert.assertEquals(actualMsg, expectedMsg, "The Book Ticket Page is not opened.");
    }
}

