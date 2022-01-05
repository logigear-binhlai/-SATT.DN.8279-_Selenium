package Common;

import org.openqa.selenium.JavascriptExecutor;

import java.security.SecureRandom;

public class Utilities {
    //    get path project
    public static String getProjectPath() {
        return System.getProperty("user.dir");
    }
    //get path json
    public static String getProjectPathDataJson() {
        return System.getProperty("user.dir") + "/src/DataObjects/data.json";
    }

    //    random string
    static final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    static SecureRandom rnd = new SecureRandom();

    public static String randomString(int len){
        StringBuilder sb = new StringBuilder(len);
        for(int i = 0; i < len; i++)
            sb.append(AB.charAt(rnd.nextInt(AB.length())));
        return sb.toString();
    }

//    random get Depart Date
    public static int randomDepartDate()
    {
        int randomDepartDate = (int)((Math.random() * 10) + 3);

        return randomDepartDate;
    }

    //    random get Seat Type
    public static int randomSeatType()
    {
        int randomSeatType = (int)((Math.random() * 5) + 1);

        return randomSeatType;
    }

//    Scroll Page
    public static void scrollPage(int height)
    {
        String scroll = "window.scroll(0, %s)";
        JavascriptExecutor js = ((JavascriptExecutor) Constant.WEBDRIVER);
        js.executeScript(String.format(scroll, height));
    }
}
