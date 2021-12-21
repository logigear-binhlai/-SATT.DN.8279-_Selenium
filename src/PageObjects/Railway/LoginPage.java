package Railway;

import Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage extends  GeneralPage{

    //Locators:
    public final By _txtUsername = By.xpath("//input[@id='username']");
    public final By _txtPassword = By.xpath("//input[@id='password']");
    public final By _btnLogin = By.xpath("//input[@value='login']");
    public final By _lblLoginErrorMsg = By.xpath("//p[@class='message error LoginForm']");

//    Elements
    public WebElement getTxtUsername()
    {
        return Constant.WEBDRIVER.findElement(_txtUsername);
    }
    public WebElement getTxtPassword()
    {
        return Constant.WEBDRIVER.findElement(_txtPassword);
    }
    public WebElement getBtnLogin()
    {
        return Constant.WEBDRIVER.findElement(_btnLogin);
    }
    public WebElement getLblLoginErrorMsg()
    {
        return Constant.WEBDRIVER.findElement(_lblLoginErrorMsg);
    }

    //Methods
    public HomePage login(String username, String password)
    {
        //Submit login
        this.getTxtUsername().sendKeys(username);
        this.getTxtPassword().sendKeys(password);
        this.getBtnLogin().click();

        //Land on Home Page
        return new HomePage();
    }
}
