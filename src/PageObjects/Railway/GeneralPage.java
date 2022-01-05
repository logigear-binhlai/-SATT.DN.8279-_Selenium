package Railway;

import Common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
    protected final WebDriverWait wait = new WebDriverWait(Constant.WEBDRIVER, 10);

    //Elements
    protected WebElement getTabLogin()
    {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(tabLogin));
    }

    protected WebElement getTabLogout()
    {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(tabLogout));
    }

    protected WebElement getTabBookTicket()
    {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(tabBookTicket));
    }

    protected WebElement getTabMyTicket()
    {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(tabMyTicket));
    }

    protected WebElement getTabChangePassword()
    {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(tabChangePassword));
    }

    protected WebElement getLblWelcomeMessage()
    {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(lblWelcomeMessage));
    }

    protected WebElement getTabRegister()
    {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(tabRegister));
    }

    protected WebElement getTabTrainTimeTable()
    {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(tabTrainTableTime));
    }

    protected WebElement getTabContact()
    {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(tabContact));
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
