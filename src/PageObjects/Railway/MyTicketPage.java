package Railway;

import Common.Constant;
import Common.Utilities;
import org.openqa.selenium.*;
import java.awt.*;


public class MyTicketPage {

//    Locator
    String btnDynamicCancel = "//td[text()='%s']/following-sibling::td[text()='%s']/../td/" +
        "input[@type='button']";
    public final By lblElementScroll = By.xpath("//div[@id='content']//form//div[@class='error message']");

//    Elments
    public WebElement getLblElementScroll()
    {
        return Utilities.waitForElement(10, lblElementScroll);
    }

    public WebElement getBtnCancel(String depart, String arrive)
    {
        return Utilities.waitForDynamicElement(10, btnDynamicCancel, depart, arrive);
    }

//    Methods
    public void cancelTicket(String depart, String arrive)
    {
        this.getBtnCancel(depart, arrive).sendKeys(Keys.ENTER);
    }

    public void acceptAlert() throws InterruptedException, AWTException {
        Alert alert = Constant.WEBDRIVER.switchTo().alert();
        alert.accept();
        Utilities.scrollPage(getLblElementScroll());
    }

    public Boolean isItemDisplay(String depart, String arrive)
    {
        try {
            Utilities.waitForDynamicElement(10, btnDynamicCancel, depart, arrive);
        } catch(TimeoutException ex) {
            System.out.println(ex);
        }
        return false;
    }
}
