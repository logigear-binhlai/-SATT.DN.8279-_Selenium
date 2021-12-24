package Railway;

import Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage extends  GeneralPage{

    //Locators:
    public final By txtUsername = By.xpath("//input[@id='username']");
    public final By txtPassword = By.xpath("//input[@id='password']");
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
    public void loginValidData(String username, String password)
    {
        //Login with valid username and password
        this.getTxtUsername().sendKeys(username);
        this.getTxtPassword().sendKeys(password);
        this.getBtnLogin().click();
    }

    public void loginWithBlankUsername(String password)
    {
        //Login with blank username
        this.getTxtPassword().sendKeys(password);
        this.getBtnLogin().click();
    }

    public void loginWithInValidPassword(String username ,String password)
    {
        //Login with valid username and invalid password
        this.getTxtUsername().sendKeys(username);
        this.getTxtPassword().sendKeys(password);
        this.getBtnLogin().click();
    }
}
