package Railway;

import Common.Utilities;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class TrainTimeTablePage {
//    Locator
    String lnkCheckPrice = "//td[text()='%s']/following-sibling::td[text()='%s']/../" +
        "td[count(//th[text()='Check Price']/preceding-sibling::th)+1]/a";

//    Element
    public WebElement getLnkCheckPrice(String depart, String arrive)
    {
        return Utilities.waitForDynamicElement(10, lnkCheckPrice, depart, arrive);
    }

//    Methods
    public void navigateToCheckTicket(String depart, String arrive)
    {
        this.getLnkCheckPrice(depart, arrive).sendKeys(Keys.ENTER);
    }
}


