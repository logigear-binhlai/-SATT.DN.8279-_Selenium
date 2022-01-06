package Railway;

import Common.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage extends  GeneralPage{

//    Locator
    public final By txtUsername = By.id("username");
    public final By txtPassword = By.id("password");
    public final By btnLogin = By.xpath("//input[@value='Login']");
    public final By lblLoginErrorMsg = By.xpath("//p[@class='message error LoginForm']");
    public final By lblLoginMsg = By.xpath("//div[@id='content']/h1");

//    Elements
    public WebElement getTxtUsername()
    {
        return Utilities.waitForElement(10, txtUsername);
    }

    public WebElement getTxtPassword()
    {
        return Utilities.waitForElement(10, txtPassword);
    }

    public WebElement getBtnLogin()
    {
        return Utilities.waitForElement(10, btnLogin);
    }

    public WebElement getLblLoginErrorMsg()
    {
        return Utilities.waitForElement(10, lblLoginErrorMsg);
    }

    public WebElement getLblLoginMsg()
    {
        return Utilities.waitForElement(10, lblLoginMsg);
    }

    //Methods
    public void login(String username, String password)
    {
        this.getTxtUsername().sendKeys(username);
        this.getTxtPassword().sendKeys(password);
        this.getBtnLogin().click();
    }

    public void loginMultipleInvalidPassword(String username, String password, int times)
    {
        for(int i = 0; i < times; i++)
        {
            this.login(username,password );
            this.getTxtUsername().clear();
        }
    }
}
