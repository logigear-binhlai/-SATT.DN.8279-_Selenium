package Railway;

import Common.Constant;
import Common.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class TicketPrice {

//    Locator
    public final By ddlTicketAmount = By.name("TicketAmount");
    public final By btnBookTicket = By.xpath("//input[@value='Book ticket']");
    public final By lblTableTicketPrice = By.xpath("//div[@id='content']//tbody/tr/th[@colspan='7']");
    String lnkTicketPrice = "//div[@id='content']/table/tbody//li[text()='%s to %s']/../..//a";
    String lnkBookTicket = "//div[@id='content']/table/tbody//td[text()='Hard seat']/..//a";

//    Element
    public WebElement getLblTableTicketPrice()
    {
        return Utilities.waitForElement(10, lblTableTicketPrice);
    }

    public WebElement getLnkTicketPrice(String depart, String arrive)
    {
        return Utilities.waitForDynamicElement(10, lnkTicketPrice, depart, arrive);
    }

    public WebElement getLnkBookTicket(String seatType)
    {
        return Utilities.waitForOneDynamicElement(10, lnkBookTicket, seatType);
    }

    public Select getDdlTicketAmount()
    {
        Select ticketAmount = new Select(Utilities.waitForElement(10, ddlTicketAmount));
        return ticketAmount;
    }

    public WebElement getBtnBookTicket()
    {
        return Utilities.waitForElement(10, btnBookTicket);
    }

//    Methods
    public String getTittle()
{
    return Constant.WEBDRIVER.getTitle();
}

    public void clickLinkTicketPrice(String depart, String arrive)
    {
        getLnkTicketPrice(depart, arrive).sendKeys(Keys.ENTER);
    }

    public void clickLinkBookTicket(String seatType)
    {
        getLnkBookTicket(seatType).sendKeys(Keys.ENTER);
    }

    public void bookTicket(String ticket_amount)
    {
        getDdlTicketAmount().selectByVisibleText(ticket_amount);
        getBtnBookTicket().click();
    }
}
