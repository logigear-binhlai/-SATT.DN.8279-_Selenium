package Railway;

import Common.Constant;
import Common.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RegisterPage {
    //    Locator
    public final By txtEmail = By.id("email");
    public final By txtPassword = By.id("password");
    public final By txtConfirmPassword = By.id("confirmPassword");
    public final By txtPId = By.id("pid");
    public final By btnRegister = By.xpath("//input[@value='Register']");
    public final By txtWelcomeMsg = By.xpath("//div[@id='content']/p");
    public final By lblErrorMsg = By.xpath("//p[@class='message error']");
    public final By lblErrorPasswordMsg = By.xpath("//label[text()='Invalid password length']");
    public final By lblErrorPidMsg = By.xpath("//label[text()='Invalid ID length']");

//    Elements
    public WebElement getTxtWelcomeMsg(){
        return Constant.WEBDRIVER.findElement(txtWelcomeMsg);
    }

    public WebElement getTxtEmail(){
        return Utilities.waitForElement(10, txtEmail);
    }

    public WebElement getTxtPassword(){
        return Utilities.waitForElement(10, txtPassword);
    }

    public WebElement getTxtConfirmPassword(){
        return Utilities.waitForElement(10, txtConfirmPassword);
    }

    public WebElement getTxtPID(){
        return Utilities.waitForElement(10, txtPId);
    }

    public WebElement getBtnRegister(){
        return Utilities.waitForElement(10, btnRegister);
    }

    public WebElement getLblErrorMsg(){
        return Utilities.waitForElement(10, lblErrorMsg);
    }

    public WebElement getLblErrorPasswordMsg(){
        return Utilities.waitForElement(10, lblErrorPasswordMsg);
    }

    public WebElement getLblErrorPidMsg(){
        return Utilities.waitForElement(10, lblErrorPidMsg);
    }

//    Methods
    public void registerAccount(String email, String password, String confirmPassword, String pid)
    {
        this.getTxtEmail().sendKeys(email);
        this.getTxtPassword().sendKeys(password);
        this.getTxtConfirmPassword().sendKeys(confirmPassword);
        this.getTxtPID().sendKeys(pid);
        this.getBtnRegister().click();
    }
}
