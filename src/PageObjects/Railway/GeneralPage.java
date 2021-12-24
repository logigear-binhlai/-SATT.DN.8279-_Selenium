package Railway;

import Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class GeneralPage {

    //locators
    private final By tabLogin = By.xpath("//*[@id=\"menu\"]//a[@href='/Account/Login.cshtml']");
    private final By tabLogout = By.xpath("//*[@id=\"menu\"]//a[@href='/Account/Logout']");
    private final By lblWelcomeMessage = By.xpath("//div[@class='account']/strong");
    private final By tabBookTicket = By.xpath("//*[@id=\"menu\"]/ul/li[6]/a/span");

    //Elements
    protected WebElement getTabLogin()
    {
        return Constant.WEBDRIVER.findElement(tabLogin);
    }

    protected WebElement getTabLogout()
    {

        return Constant.WEBDRIVER.findElement(tabLogout);
    }

    protected WebElement getTabBookTicket()
    {

        return Constant.WEBDRIVER.findElement(tabBookTicket);
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

    public void gotoLoginPage()
    {

        this.getTabLogin().click();
    }

    public void gotoBookTicket()
    {

        this.getTabBookTicket().click();
    }
}
