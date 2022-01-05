package Railway;

import Common.Constant;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;

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
            wait.until(ExpectedConditions.visibilityOfElementLocated(tabLogout)).isDisplayed();
        } catch(TimeoutException ex) {
            System.out.println(ex);
        }
        return false;
    }
}
