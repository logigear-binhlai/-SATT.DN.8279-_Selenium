package Railway;

import Common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TrainTimeTablePage {
//    Locator
    String lnkCheckPrice = "//td[text()='%s']/following-sibling::td[text()='%s']/../" +
        "td[count(//th[text()='Check Price']/preceding-sibling::th)+1]/a";
    WebDriverWait wait = new WebDriverWait(Constant.WEBDRIVER, 10);

//    Element
    public WebElement getLnkCheckPrice(String depart, String arrive)
    {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
                String.format(lnkCheckPrice, depart, arrive))));
    }

//    Methods
    public void navigateToCheckTicket(String depart, String arrive)
    {
        this.getLnkCheckPrice(depart, arrive).sendKeys(Keys.ENTER);
    }

    public String getTittle()
    {
        return Constant.WEBDRIVER.getTitle();
    }
}


