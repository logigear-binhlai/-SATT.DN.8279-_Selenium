package Constant;

import Common.Utilities;
import org.openqa.selenium.WebDriver;

public class Constant
{
//    Webdriver
    public static WebDriver WEBDRIVER;

//    Login
    public static final String RAILWAY_URL = "http://railway.somee.com/Page/HomePage.cshtml";
    public static final String USERNAME = "world11111@gmail.com";
    public static final String PASSWORD = "1111111111";
    public static final String INVALIDPASSWORD = "1111111111123";
    public static final String TITLEBOOKTICKET = "Safe Railway - Book Ticket";
    public static final String TITLEMYTICKET = "Safe Railway - My Ticket";
    public static final String TITLECHANGEPASSWORD = "Safe Railway - Change Password";
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
    public static final String WELCOMEMSG = "Registration Confirmed! You can now log in to the site.";
    public static final String CREATED_USERNAME = "world11111@gmail.com";
    public static final String BLANK_PASSWORD = "";
    public static final String BLANK_PID = "";
    public static final String ERROR_USED_MAIL_MSG = "This email address is already in use.";
    public static final String ERROR_MSG = "There're errors in the form. Please correct the errors and try again.";
    public static final String ERROR_PASSWORD_MSG = "Invalid password length";
    public static final String ERROR_PID_MSG = "Invalid ID length";

//  change password
    public static final String CURRENT_PASSWORD = "1111111111";
    public static final String NEW_PASSWORD = "a123:\'/{}!@$\\";
    public static final String CONFIRM_PASSWORD = "/{}!@$\\";
    public static final String ERROR_CONFIRM_PASSWORD_MSG = "Password change failed. Please correct the errors and try again.";
    public static final String ERROR_CONFIRM_PASSWORD_FIELD = "The password confirmation does not match the new password.";

//    Errors
    public static final String[] ERRORS = {
            "There was a problem with your login and/or errors exist in your form.",
            "Invalid username or password. Please try again.",
            "You have used 4 out of 5 login attempts. After all 5 have been used, you will be unable to login for 15 " +
                    "minutes.",
            "Password change failed. Please correct the errors and try again.",
            "The password confirmation does not match the new password.",
            "This email address is already in use.",
            "There're errors in the form. Please correct the errors and try again.",

    };

}


