package Railway;

import Common.Constant;
import Common.Utilities;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;


public class MyTicketPage {

//    Locator
    String btnDynamicCancel = "//td[text()='%s']/following-sibling::td[text()='%s']/../td/" +
        "input[@type='button']";
    public final By txtDepartDateFilter = By.xpath("//form[@name='FilterForm']/div[@class='Filter']/table/tbody//" +
            "input[@name='FilterDpDate']");
    public final By ddlArriverFilter = By.xpath("//form[@name='FilterForm']/div[@class='Filter']/table/tbody//" +
            "select[@name='FilterArStation']");
    public final By lblTableFilter = By.xpath("//div[@id='content']//form//table[@class='MyTable']");
    public final By btnFilter = By.xpath("//form[@name='FilterForm']/div[@class='Filter']//input[@value='Apply Filter']");
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

    public Select getDdlArriverFilter()
    {
        Select arriverFilter = new Select(Utilities.waitForElement(10, ddlArriverFilter));
        return arriverFilter;
    }

    public WebElement getTxtDepartDateFilter()
    {
        return Utilities.waitForElement(10, txtDepartDateFilter);
    }

    public WebElement getBtnFilter()
    {
        return Utilities.waitForElement(10, btnFilter);
    }

    public WebElement getLblTableFilter()
    {
        return Utilities.waitForElement(10, lblTableFilter);
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
        return true;
    }

    public void filter(String arriver, String departDate)
    {
        getDdlArriverFilter().selectByVisibleText(arriver);
        getTxtDepartDateFilter().sendKeys(departDate);
        getBtnFilter().sendKeys(Keys.ENTER);
    }

    public Boolean isTableDisplay()
    {
        try {
            Utilities.waitForElement(10, lblTableFilter).isDisplayed();
        } catch(TimeoutException ex) {
            System.out.println(ex);
        }
        return false;
    }
}
