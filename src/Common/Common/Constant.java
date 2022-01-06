package Common;

import org.openqa.selenium.WebDriver;

public class Constant
{
//    Webdriver
    public static WebDriver WEBDRIVER;

//    URL
    public static final String RAILWAY_URL = "http://www.raillog.somee.com/";

//    Register
    public static final String EMAIL_REGISTER = Utilities.randomString(2) + Utilities.getCurrentTime() +
        "@gmail.com";
    public static final String PASSWORD_REGISTER = Utilities.randomString(10);
    public static final String CONFIRM_PASSWORD_REGISTER = PASSWORD_REGISTER;
    public static final String PID = Utilities.randomString(10);

//    Book ticket
    public static final int DEPART_DATE = Utilities.randomDepartDate(4);
    public static final int SEAT_TYPE = Utilities.randomSeatType();
}


