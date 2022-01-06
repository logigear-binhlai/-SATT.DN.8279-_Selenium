package Railway;

import Common.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class GeneralPage {

    //locators
    private final By tabLogin = By.xpath("//div[@id=\'menu\']//a[@href='/Account/Login.cshtml']");
    protected final By tabLogout = By.xpath("//div[@id=\'menu\']//a[@href='/Account/Logout']");
    private final By lblWelcomeMessage = By.xpath("//div[@class='account']/strong");
    private final By tabBookTicket = By.xpath("//div[@id=\'menu\']//a[@href='/Page/BookTicketPage.cshtml']/span");
    private final By tabMyTicket = By.xpath("//div[@id=\'menu\']//a[@href='/Page/ManageTicket.cshtml']/span");
    private final By tabChangePassword = By.xpath("//div[@id=\'menu\']//a[@href='/Account/ChangePassword.cshtml']/span");
    private final By tabRegister = By.xpath("//div[@id=\'menu\']//a[@href='/Account/Register.cshtml']/span");
    private final By tabTrainTableTime = By.xpath("//div[@id=\'menu\']//a[@href='TrainTimeListPage.cshtml']/span");
    private final By tabContact = By.xpath("//div[@id=\'menu\']//a[@href='/Page/Contact.cshtml']/span");

//    Elements
    protected WebElement getTabLogin()
    {
        return Utilities.waitForElement(10, tabLogin);
    }

    protected WebElement getTabLogout()
    {
        return Utilities.waitForElement(10, tabLogout);
    }

    protected WebElement getTabBookTicket()
    {
        return Utilities.waitForElement(10, tabBookTicket);
    }

    protected WebElement getTabMyTicket()
    {
        return Utilities.waitForElement(10, tabMyTicket);
    }

    protected WebElement getTabChangePassword()
    {
        return Utilities.waitForElement(10, tabChangePassword);
    }

    protected WebElement getLblWelcomeMessage()
    {
        return Utilities.waitForElement(10, lblWelcomeMessage);
    }

    protected WebElement getTabRegister()
    {
        return Utilities.waitForElement(10, tabRegister);
    }

    protected WebElement getTabTrainTimeTable()
    {
        return Utilities.waitForElement(10, tabTrainTableTime);
    }

    protected WebElement getTabContact()
    {
        return Utilities.waitForElement(10, tabContact);
    }

    //Methods
    public String getWelcomeMessage()
    {
        return this.getLblWelcomeMessage().getText();
    }

    public void goToLoginPage()
    {
        this.getTabLogin().click();
    }

    public void goToBookTicket()
    {
        this.getTabBookTicket().click();
    }

    public void goToMyTicket()
    {
        this.getTabMyTicket().click();
    }

    public void goToChangePassword()
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

    public void goToContact()
    {
        this.getTabContact().click();
    }

    public void goToLogout()
    {
        this.getTabLogout().click();
    }
}
