package Railway;

import Common.Constant;
import Common.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class BookTicketPage
{
//    Locator
    public final By ddlDepartDate = By.name("Date");
    public final By ddlDepartStation = By.name("DepartStation");
    public final By ddlArriveStation = By.name("ArriveStation");
    public final By ddlSeatType = By.name("SeatType");
    public final By ddlTicketAmount = By.name("TicketAmount");
    public final By btnBookTicket = By.xpath("//input[@value='Book ticket']");
    public final By lblSuccessBookTicket = By.xpath("//div[@id='content']/h1");
    public final By lblErrorMsg = By.xpath("//p[@class='message error']");
    public final By lblErrorTicketAmountMsg = By.xpath("//label[@class='validation-error']");

//    Element
    public Select getDdlDepartDate()
    {
        Select departDate = new Select(Utilities.waitForElement(10, ddlDepartDate));
        return departDate;
    }

    public Select getDdlDepartStation()
    {
        Select departStation = new Select(Utilities.waitForElement(10, ddlDepartStation));
        return departStation;
    }

    public Select getDdlArriveStation()
    {
        Select arriveStation = new Select(Utilities.waitForElement(10, ddlArriveStation));
        return arriveStation;
    }

    public Select getDdlSeatType()
    {
        Select seatType = new Select(Utilities.waitForElement(10, ddlSeatType));
        return seatType;
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

    public String getTitleBookTicket()
    {
        return Constant.WEBDRIVER.getTitle();
    }

    public WebElement getTxtSuccess()
    {
        return Utilities.waitForElement(10, lblSuccessBookTicket);
    }

    public WebElement getErrorMsg()
    {
        return Utilities.waitForElement(10, lblErrorMsg);
    }

    public WebElement getErrorTicketAmountMsg()
    {
        return Utilities.waitForElement(10, lblErrorTicketAmountMsg);
    }

//    Methods
    public void bookTicketWithDataProvider(String depart_station, String arrive_station,
                                           String seat_type, String ticket_amount) {
        
        getDdlDepartDate().selectByIndex(Constant.DEPART_DATE);
        getDdlDepartStation().selectByVisibleText(depart_station);
        getDdlArriveStation().selectByVisibleText(arrive_station);
        getDdlSeatType().selectByVisibleText(seat_type);
        getDdlTicketAmount().selectByVisibleText(ticket_amount);
        getBtnBookTicket().click();
    }

    public void bookTicketMore10Tickets(String depart_station, String arrive_station,
                                        String seat_type, String ticket_amount)
    {
            getDdlDepartDate().selectByIndex(Constant.DEPART_DATE);
            getDdlDepartStation().selectByVisibleText(depart_station);
            getDdlArriveStation().selectByVisibleText(arrive_station);
            getDdlSeatType().selectByVisibleText(seat_type);
            getDdlTicketAmount().selectByVisibleText(ticket_amount);
            getBtnBookTicket().click();
    }
}
