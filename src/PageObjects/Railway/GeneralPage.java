package Railway;

import Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class GeneralPage {

    //locators
    private final By tabLogin = By.xpath("//*[@id=\"menu\"]//a[@href='/Account/Login.cshtml']");
    private final By tabLogout = By.xpath("//*[@id=\"menu\"]//a[@href='/Account/Logout']");
    private final By lblWelcomeMessage = By.xpath("//div[@class='account']/strong");

    //Elements
    protected WebElement getTabLogin()
    {
        return Constant.WEBDRIVER.findElement(tabLogin);
    }

    protected WebElement getTabLogout()
    {
        return Constant.WEBDRIVER.findElement(tabLogout);
    }

    protected WebElement getLblWelcomeMessage()
    {
        return Constant.WEBDRIVER.findElement(lblWelcomeMessage);
    }

    //Methods
    public String getWelcomeMessage()
    {
        return this.getLblWelcomeMessage().getText();
    }

    public LoginPage gotoLoginPage()
    {
        this.getTabLogin().click();
        return new LoginPage();
    }
}
