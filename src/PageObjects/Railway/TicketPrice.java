package Railway;

import Common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TicketPrice {

//    Locator
    public final By txtTableTicketPrice = By.xpath("//div[@id='content']//tbody/tr/th[@colspan='7']");
    protected final WebDriverWait wait = new WebDriverWait(Constant.WEBDRIVER, 10);

//    Element
    public WebElement getTxtTableTicketPrice()
    {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(txtTableTicketPrice));
    }

//    Methods
public String getTittle()
{
    return Constant.WEBDRIVER.getTitle();
}
}
