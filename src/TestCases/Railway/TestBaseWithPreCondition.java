package Railway;

import Common.Utilities;
import Common.Constant;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBaseWithPreCondition
{
    protected String email = Constant.EMAIL_REGISTER;
    protected String password = Constant.PASSWORD_REGISTER;
    protected String confirm_password = Constant.CONFIRM_PASSWORD_REGISTER;
    protected String pid = Constant.PID;

    @BeforeMethod
    public void beforeMethod()
    {
        System.out.println("Pre-Condition");
        System.setProperty("webdriver.chrome.driver", Utilities.getProjectPath() + "/Executables/chromedriver");
        Constant.WEBDRIVER = new ChromeDriver();
        Constant.WEBDRIVER.manage().window().maximize();

//        Pre-condidion
        HomePage homePage = new HomePage();
        RegisterPage registerPage = new RegisterPage();

        System.out.println("TC 09 - Step1: Navigate to Register Page.");
        homePage.navigateToHomePage();
        homePage.goToRegister();

        System.out.println("TC 09 - Step2: Create an account.");

        registerPage.registerAccount(email, password, confirm_password, pid);
    }

    @AfterMethod
    public void afterMethod()
    {
        System.out.println("Post-Condition");
        Constant.WEBDRIVER.quit();
    }
}

