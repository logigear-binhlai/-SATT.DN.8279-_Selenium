package Railway;

import Common.Constant;
import Common.Utilities;
import org.openqa.selenium.TimeoutException;

public class HomePage extends GeneralPage{

    //Methods
    public void navigateToHomePage()
    {
        Constant.WEBDRIVER.navigate().to(Constant.RAILWAY_URL);
    }

    public String getTitleHomePage()
    {
       return Constant.WEBDRIVER.getTitle();
    }

    public Boolean isDisplayTabLogout()
    {
        try {
            Utilities.waitForElement(10, tabLogout).isDisplayed();
        } catch(TimeoutException ex) {
            System.out.println(ex);
        }
        return false;
    }
}
