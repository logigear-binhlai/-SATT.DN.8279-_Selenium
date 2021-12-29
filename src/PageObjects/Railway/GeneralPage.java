package Railway;

import Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class GeneralPage {

    //locators
    private final By tabLogin = By.xpath("//div[@id=\'menu\']//a[@href='/Account/Login.cshtml']");
    private final By tabLogout = By.xpath("//div[@id=\'menu\']//a[@href='/Account/Logout']");
    private final By lblWelcomeMessage = By.xpath("//div[@class='account']/strong");
    private final By tabBookTicket = By.xpath("//div[@id=\'menu\']//a[@href='/Page/BookTicketPage.cshtml']/span");
    private final By tabMyTicket = By.xpath("//div[@id=\'menu\']//a[@href='/Page/ManageTicket.cshtml']/span");
    private final By tabChangePassword = By.xpath("//div[@id=\'menu\']//a[@href='/Account/ChangePassword.cshtml']/span");
    private final By tabRegister = By.xpath("//div[@id=\'menu\']//a[@href='/Account/Register.cshtml']/span");
    private final By tabTrainTableTime = By.xpath("//div[@id='menu']//a[@href='TrainTimeListPage.cshtml']/span");

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

    protected WebElement getTabMyTicket()
    {
        return Constant.WEBDRIVER.findElement(tabMyTicket);
    }

    protected WebElement getTabChangePassword()
    {
        return Constant.WEBDRIVER.findElement(tabChangePassword);
    }

    protected WebElement getLblWelcomeMessage()
    {
        return Constant.WEBDRIVER.findElement(lblWelcomeMessage);
    }

    protected WebElement getTabRegister()
    {
        return Constant.WEBDRIVER.findElement(tabRegister);
    }

    protected WebElement getTabTrainTimeTable()
    {
        return Constant.WEBDRIVER.findElement(tabTrainTableTime);
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

    public void gotoMyTicket()
    {
        this.getTabMyTicket().click();
    }

    public void gotoChangePassword()
    {
        this.getTabChangePassword().click();
    }

    public void goToRegister()
    {
        this.getTabRegister().click();
    }

    public void goToTrainTimeTable()
    {
        this.getTabTrainTimeTable().click();
    }
}
