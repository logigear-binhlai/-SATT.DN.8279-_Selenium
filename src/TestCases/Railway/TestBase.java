package Railway;

import Common.Utilities;
import Common.Constant;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase
{
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
}
