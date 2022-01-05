package Railway;

import Common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends  GeneralPage{

//    Locator
    public final By txtUsername = By.id("username");
    public final By txtPassword = By.id("password");
    public final By btnLogin = By.xpath("//input[@value='login']");
    public final By lblLoginErrorMsg = By.xpath("//p[@class='message error LoginForm']");
    public final WebDriverWait wait = new WebDriverWait(Constant.WEBDRIVER, 10);

//    Elements
    public WebElement getTxtUsername()
    {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(txtUsername));
    }

    public WebElement getTxtPassword()
    {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(txtPassword));
    }

    public WebElement getBtnLogin()
    {
        return wait.until(ExpectedConditions.elementToBeClickable(btnLogin));
    }

    public WebElement getLblLoginErrorMsg()
    {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(lblLoginErrorMsg));
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
