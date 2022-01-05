package Railway;

import Common.Constant;
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
    public final WebDriverWait wait = new WebDriverWait(Constant.WEBDRIVER, 10);
    public final By lblErrorMsg = By.xpath("//p[@class='message error']");
    public final By lblErrorTicketAmountMsg = By.xpath("//label[@class='validation-error']");

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

    public WebElement getErrorMsg()
    {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(lblErrorMsg));
    }

    public WebElement getErrorTicketAmountMsg()
    {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(lblErrorTicketAmountMsg));
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

    public void bookTicketWithDataProvider(String depart_date, String depart_station, String arrive_station,
                                           String seat_type, String ticket_amount) {
        getDdlDepartDate().selectByVisibleText(depart_date);
        getDdlDepartStation().selectByVisibleText(depart_station);
        getDdlArriveStation().selectByVisibleText(arrive_station);
        getDdlSeatType().selectByVisibleText(seat_type);
        getDdlTicketAmount().selectByVisibleText(ticket_amount);
        getBtnBookTicket().click();
    }

    public void bookTicketMultipleTimes(String depart_date, String depart_station, String arrive_station,
                                        String seat_type, String ticket_amount, int times)
    {
        for(int i = 0; i < times; i++)
        {
            HomePage homePage = new HomePage();
            homePage.goToBookTicket();

            getDdlDepartDate().selectByVisibleText(depart_date);
            getDdlDepartStation().selectByVisibleText(depart_station);
            getDdlArriveStation().selectByVisibleText(arrive_station);
            getDdlSeatType().selectByVisibleText(seat_type);
            getDdlTicketAmount().selectByVisibleText(ticket_amount);
            getBtnBookTicket().click();
        }

    }
}
