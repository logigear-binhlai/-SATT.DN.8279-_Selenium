package Railway;

import Common.Constant;
import Common.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ChangePasswordPage {

//    Locator
    public final By txtCurrentPassword = By.id("currentPassword");
    public final By txtNewPassword = By.id("newPassword");
    public final By txtConfirmPassword = By.id("confirmPassword");
    public final By btnChangePassword = By.xpath("//input[@value='Change Password']");
    public final By lblErrorMsg = By.xpath("//p[@class='message error']");
    public final By lblConfirmPasswordErrorMsg = By.xpath("//p[@class='validation-error']");

//    Element
    public WebElement getTxtCurrentPassword()
    {
        return Utilities.waitForElement(10, txtCurrentPassword);
    }

    public WebElement getTxtNewPassword()
    {
        return Utilities.waitForElement(10, txtNewPassword);
    }

    public WebElement getTxtConfirmPassword()
    {
        return Utilities.waitForElement(10, txtConfirmPassword);
    }

    public WebElement getBtnChangePassword()
    {
        return Utilities.waitForElement(10, btnChangePassword);
    }

    public WebElement getLblErrorMSG()
    {
        return Utilities.waitForElement(10, lblErrorMsg);
    }

    public WebElement getLblConfirmErrorMSG()
    {
        return Utilities.waitForElement(10, lblConfirmPasswordErrorMsg);
    }

//    Methods
    public void changePassword(String currentPassword, String newPassword, String confirmPassword)
    {
        this.getTxtCurrentPassword().sendKeys(currentPassword);
        this.getTxtNewPassword().sendKeys(newPassword);
        this.getTxtConfirmPassword().sendKeys(confirmPassword);
        this.getBtnChangePassword().click();
    }
}
