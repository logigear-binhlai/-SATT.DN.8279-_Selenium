package Railway;

import Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BookTicketPage
{
//    Locator
    public final By ddlDepartDate = By.name("Date");
    public final By ddlDepartStation = By.name("DepartStation");
    public final By ddlArriveStation = By.name("ArriveStation");
    public final By ddlSeatType = By.name("SeatType");
    public final By ddlTicketAmount = By.name("TicketAmount");
    public final By btnBookTicket = By.xpath("//input[@value='Book ticket']");
    public final By txtSuccessBookTicket = By.xpath("//div[@id='content']/h1");
    public final WebDriverWait wait = new WebDriverWait(Constant.WEBDRIVER, 20);

//    Element
    public Select getDdlDepartDate()
    {
        Select departDate = new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(ddlDepartDate)));
        return departDate;
    }

    public Select getDdlDepartStation()
    {
        Select departStation = new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(ddlDepartStation)));
        return departStation;
    }

    public Select getDdlArriveStation()
    {
        Select arriveStation = new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(ddlArriveStation)));
        return arriveStation;
    }

    public Select getDdlSeatType()
    {
        Select seatType = new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(ddlSeatType)));
        return seatType;
    }

    public Select getDdlTicketAmount()
    {
        Select ticketAmount = new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(ddlTicketAmount)));
        return ticketAmount;
    }

    public WebElement getBtnBookTicket()
    {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(btnBookTicket));
    }

    public String getTitleBookTicket()
    {
        return Constant.WEBDRIVER.getTitle();
    }

    public WebElement getTxtSuccess()
    {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(txtSuccessBookTicket));
    }

//    Methods
    public void bookTicket()
    {
        getDdlDepartDate().selectByIndex(Constant.DEPART_DATE);
        getDdlDepartStation().selectByVisibleText(Constant.DEPART_STATION);
        getDdlArriveStation().selectByVisibleText(Constant.ARRIVE_STATION);
        getDdlSeatType().selectByIndex(Constant.SEAT_TYPE);
        getDdlTicketAmount().selectByVisibleText(Constant.TICKET_AMOUNT);
        getBtnBookTicket().click();
    }
}
