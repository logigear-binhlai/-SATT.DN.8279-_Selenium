package Railway;

import Constant.Constant;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.KeyEvent;

public class MyTicketPage {

//    Locator
    public final By btnCancel = By.xpath("//*[@id=\"content\"]/form//table[@class='MyTable']/tbody/tr[count(" +
        "//table[@class='MyTable']/tbody/tr)]//input");
    WebDriverWait wait = new WebDriverWait(Constant.WEBDRIVER, 20);

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
        Robot rb = new Robot();
        rb.keyPress(KeyEvent.VK_DOWN);
        Alert alert = Constant.WEBDRIVER.switchTo().alert();
        alert.accept();
    }
}
