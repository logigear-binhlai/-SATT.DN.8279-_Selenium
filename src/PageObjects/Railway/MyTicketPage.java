package Railway;

import Common.Constant;
import Common.Utilities;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.awt.*;


public class MyTicketPage {

//    Locator
    public final By btnCancel = By.xpath("//*[@id=\"content\"]/form//table[@class='MyTable']/tbody/tr//td/" +
        "input[@onclick='DeleteTicket(4658);']");
    WebDriverWait wait = new WebDriverWait(Constant.WEBDRIVER, 10);

//    Elments
    public WebElement getBtnCancel()
    {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(btnCancel));
    }

    public String getTitleMyTicket()
    {
        return Constant.WEBDRIVER.getTitle();
    }

//    Methods
    public void cancelTicket()
    {
        this.getBtnCancel().sendKeys(Keys.ENTER);
    }

    public void acceptAlert() throws InterruptedException, AWTException {
        Alert alert = Constant.WEBDRIVER.switchTo().alert();
        alert.accept();
        Utilities.scrollPage(400);
    }

    public Boolean isItemDisplay()
    {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(btnCancel)).isDisplayed();
        } catch(TimeoutException ex) {
            System.out.println(ex);
        }
        return false;
    }

}
