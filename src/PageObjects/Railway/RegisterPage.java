package Railway;

import Common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterPage {
    //    Locator
    public final By txtEmail = By.id("email");
    public final By txtPassword = By.id("password");
    public final By txtConfirmPassword = By.id("confirmPassword");
    public final By txtPID = By.id("pid");
    public final By btnRegister = By.xpath("//input[@value='Register']");
    public final By txtWelcomeMsg = By.xpath("//div[@id='content']/p");
    public final WebDriverWait wait = new WebDriverWait(Constant.WEBDRIVER,10);
    public final By lblErrorMsg = By.xpath("//p[@class='message error']");
    public final By lblErrorPasswordMsg = By.xpath("//label[text()='Invalid password length']");
    public final By lblErrorPidMsg = By.xpath("//label[text()='Invalid ID length']");

//    Elements
    public WebElement getTxtWelcomeMsg(){
        return Constant.WEBDRIVER.findElement(txtWelcomeMsg);
    }

    public WebElement getTxtEmail(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(txtEmail));
    }

    public WebElement getTxtPassword(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(txtPassword));
    }

    public WebElement getTxtConfirmPassword(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(txtConfirmPassword));
    }

    public WebElement getTxtPID(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(txtPID));
    }

    public WebElement getBtnRegister(){
        return wait.until(ExpectedConditions.elementToBeClickable(btnRegister));
    }

    public WebElement getLblErrorMsg(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(lblErrorMsg));
    }

    public WebElement getLblErrorPasswordMsg(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(lblErrorPasswordMsg));
    }

    public WebElement getLblErrorPidMsg(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(lblErrorPidMsg));
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
