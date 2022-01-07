package Common;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Utilities {
//  get path project
    public static String getProjectPath() {
        return System.getProperty("user.dir");
    }

//  get path json
    public static String getProjectPathDataJson() {
        return System.getProperty("user.dir") + "/src/DataObjects/data.json";
    }

//  get current time
    public static String getCurrentTime()
    {
        DateTimeFormatter dateTimeFormat = DateTimeFormatter.ofPattern("HHmmss");
        LocalDateTime now = LocalDateTime.now();
        return dateTimeFormat.format(now);
    }

//  random string
    static final String AB = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    static SecureRandom rnd = new SecureRandom();

    public static String randomString(int len){
        StringBuilder sb = new StringBuilder(len);
        for(int i = 0; i < len; i++)
            sb.append(AB.charAt(rnd.nextInt(AB.length())));
        return sb.toString();
    }

//  random get Depart Date
    public static int randomDepartDate(int days)
    {
        int randomDepartDate = (int)((Math.random() * 10) + days);

        return randomDepartDate;
    }

//  random get Seat Type
    public static int randomSeatType()
    {
        int randomSeatType = (int)((Math.random() * 6));

        return randomSeatType;
    }

//  Wait for element
    public static WebElement waitForElement(int times, By locator)
    {
        WebDriverWait wait = new WebDriverWait(Constant.WEBDRIVER, times);

        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    //  Wait for dynamic element
    public static WebElement waitForDynamicElement(int times, String locator, String depart, String arrive)
    {
        WebDriverWait wait = new WebDriverWait(Constant.WEBDRIVER, times);

        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(locator
        , depart, arrive))));
    }

    public static WebElement waitForOneDynamicElement(int times, String locator, String string)
    {
        WebDriverWait wait = new WebDriverWait(Constant.WEBDRIVER, times);

        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(locator
                , string))));
    }

    public static WebElement waitForMultipleDynamicElement(int times, String locator, String depart, String arrive,
                                                           String string)
    {
        WebDriverWait wait = new WebDriverWait(Constant.WEBDRIVER, times);

        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(locator
                , depart, arrive, string))));
    }

//  Scroll Page
    public static void scrollPage(WebElement element)
    {
        ((JavascriptExecutor) Constant.WEBDRIVER).executeScript("arguments[0].scrollIntoView(true);", element);
    }
}
