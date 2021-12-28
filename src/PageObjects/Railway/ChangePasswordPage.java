package Railway;

import Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.Objects;

public class ChangePasswordPage {
//    Locator
    public final By txtCurrentPassword = By.id("currentPassword");
    public final By txtNewPassword = By.id("newPassword");
    public final By txtConfirmPassword = By.id("confirmPassword");
    public final By btnChangePassword = By.xpath("//input[@value='Change Password']");
    public final By lblErrorMsg = By.xpath("//p[@class='message error']");
    public final By lblConfirmPasswordErrorMsg = By.xpath("//p[@class='validation-error']");
    public final WebDriverWait wait = new WebDriverWait(Constant.WEBDRIVER,10);

//    Element
    public WebElement getTxtCurrentPassword()
    {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(txtCurrentPassword));
    }

    public WebElement getTxtNewPassword()
    {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(txtNewPassword));
    }

    public WebElement getTxtConfirmPassword()
    {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(txtConfirmPassword));
    }

    public WebElement getBtnChangePassword()
    {
        return wait.until(ExpectedConditions.elementToBeClickable(btnChangePassword));
    }

    public WebElement getLblErrorMSG()
    {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(lblErrorMsg));
    }

    public WebElement getLblConfirmErrorMSG()
    {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(lblConfirmPasswordErrorMsg));
    }

    public String getTitleChangePassword()
    {
        return Constant.WEBDRIVER.getTitle();
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
