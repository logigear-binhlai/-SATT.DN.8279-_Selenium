package Railway;

import Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.Objects;

public class LoginPage extends  GeneralPage{

//    Locator
    public final By txtUsername = By.id("username");
    public final By txtPassword = By.id("password");
    public final By btnLogin = By.xpath("//input[@value='login']");
    public final By lblLoginErrorMsg = By.xpath("//p[@class='message error LoginForm']");

//    Elements
    public WebElement getTxtUsername()
    {
        return Constant.WEBDRIVER.findElement(txtUsername);
    }

    public WebElement getTxtPassword()
    {
        return Constant.WEBDRIVER.findElement(txtPassword);
    }

    public WebElement getBtnLogin()
    {
        return Constant.WEBDRIVER.findElement(btnLogin);
    }

    public WebElement getLblLoginErrorMsg()
    {
        return Constant.WEBDRIVER.findElement(lblLoginErrorMsg);
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
