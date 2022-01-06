package Railway;

import Common.Constant;
import Common.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TicketPrice {

//    Locator
    public final By lblTableTicketPrice = By.xpath("//div[@id='content']//tbody/tr/th[@colspan='7']");

//    Element
    public WebElement getLblTableTicketPrice()
    {
        return Utilities.waitForElement(10, lblTableTicketPrice);
    }

//    Methods
    public String getTittle()
{
    return Constant.WEBDRIVER.getTitle();
}
}
