package Constant;

import org.openqa.selenium.WebDriver;

public class Constant
{
    public static WebDriver WEBDRIVER;
    public static final String RAILWAY_URL = "http://railway.somee.com/Page/HomePage.cshtml";
    public static final String USERNAME = "world11111@gmail.com";
    public static final String PASSWORD = "1111111111";
    public static final String INVALIDPASSWORD = "1111111111123";
    public static final String TITLEBOOKTICKET = "Safe Railway - Book Ticket";

    public static final String[] EXPECTEDBEHAVIOR =
            {
                    "There was a problem with your login and/or errors exist in your form.",
//                    "Invalid username or password. Please try again.",
            };
}
