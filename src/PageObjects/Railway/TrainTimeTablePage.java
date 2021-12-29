package Railway;

import Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TrainTimeTablePage {
//    Locator
    public final By lnkCheckPrice = By.xpath("//td[text()='Đà Nẵng']/following-sibling::td[text()='Nha Trang']/../" +
        "td[count(//th[text()='Check Price']/preceding-sibling::th)+1]/a");
    WebDriverWait wait = new WebDriverWait(Constant.WEBDRIVER, 20);

//    Element
    public WebElement getLnkCheckPrice()
    {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(lnkCheckPrice));
    }

//    Methods
    public void navigateToCheckTicket()
    {
        this.getLnkCheckPrice().sendKeys(Keys.ENTER);
    }

    public String getTittle()
    {
        return Constant.WEBDRIVER.getTitle();
    }
}


