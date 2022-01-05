package Common;

import Common.Utilities;
import org.openqa.selenium.WebDriver;

public class Constant
{
//    Webdriver
    public static WebDriver WEBDRIVER;

//    Home page
    public static final String TITLE_HOMEPAGE = "Safe Railway - Selenium Automation";
//    Login
    public static final String RAILWAY_URL = "http://railway.somee.com/Page/HomePage.cshtml";
    public static final String USERNAME = "world11111@gmail.com";
    public static final String PASSWORD = "1111111111";
    public static final String INVALID_PASSWORD = "1111111111123";
    public static final String TITLE_BOOK_TICKET = "Safe Railway - Book Ticket";
    public static final String TITLE_MY_TICKET = "Safe Railway - My Ticket";
    public static final String TITLE_CHANGE_PASSWORD = "Safe Railway - Change Password";
    public static final String BLANK_USERNAME = "";
    public static final String UNACTIVATED_USERNAME = "worl@gmail.com";
    public static final String UNACTIVATED_PASSWORD = "1234567890";
    public static final String ERROR_LOGIN_BLANK_USERNAME = "There was a problem with your login and/or errors exist " +
            "in your form.";
    public static final String ERROR_LOGIN_INVALID_PASSWORD = "Invalid username or password. Please try again.";
    public static final String ERROR_LOGIN_MULTIPLE = "You have used 4 out of 5 login attempts. After all 5 have been " +
            "used, you will be unable to login for 15 minutes.";
    public static final String ERROR_LOGIN_UNACTIVED = "Invalid username or password. Please try again.";

//    Register
    public static final String EMAIL_REGISTER = Utilities.randomString(4) + "@gmail.com";
    public static final String PASSWORD_REGISTER = Utilities.randomString(10);
    public static final String CONFIRM_PASSWORD_REGISTER = PASSWORD_REGISTER;
    public static final String PID = Utilities.randomString(10);
    public static final String WELCOME_MSG = "Registration Confirmed! You can now log in to the site.";
    public static final String CREATED_USERNAME = "world11111@gmail.com";
    public static final String BLANK_PASSWORD = "";
    public static final String BLANK_PID = "";
    public static final String ERROR_USED_MAIL_MSG = "This email address is already in use.";
    public static final String ERROR_MSG = "There're errors in the form. Please correct the errors and try again.";
    public static final String ERROR_PASSWORD_MSG = "Invalid password length";
    public static final String ERROR_PID_MSG = "Invalid ID length";

//  Change password
    public static final String CURRENT_PASSWORD = "1111111111";
    public static final String NEW_PASSWORD = "a123:\'/{}!@$";
    public static final String CONFIRM_PASSWORD = "/{}!@$\\";
    public static final String ERROR_CONFIRM_PASSWORD_MSG = "Password change failed. Please correct the errors and try again.";
    public static final String ERROR_CONFIRM_PASSWORD_FIELD = "The password confirmation does not match the new password.";

//    Book ticket
    public static final int DEPART_DATE = Utilities.randomDepartDate();
    public static final String DEPART_STATION = "Quảng Ngãi";
    public static final String ARRIVE_STATION = "Nha Trang";
    public static final int SEAT_TYPE = Utilities.randomSeatType();
    public static final String TICKET_AMOUNT = "1";
    public static final String TICKET_AMOUNT_MULTIPLE = "1";
    public static final String SUCCESS_MSG = "Ticket booked successfully!";
    public static final String ERROR_TICKET_AMOUNT_MSG = "You have booked 10 tickets. You can book no more.";

//    Ticket price
    public static final String TITLE_TICKET_PRICE = "Safe Railway - Ticket Price";
    public static final String TXT_TABLE_TICKET_PRICE = "Ticket price from Đà Nẵng to Nha Trang";
}

