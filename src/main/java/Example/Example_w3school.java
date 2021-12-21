package Example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Example_w3school {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "/Users/laitieuquynh/Desktop/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.w3schools.com/java/java_for_loop.asp");
        System.out.println(driver.getTitle());
        driver.quit();
    }
}
