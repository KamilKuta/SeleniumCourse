package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By usernameTextBox = By.cssSelector("input[name='username']");
    private final By passwordTextBox = By.cssSelector("input[name='password']");
    private final By loginButton = By.cssSelector("button[type='submit']");
    private final By invalidUsernameOrPasswordMessage = By.cssSelector("p[class='oxd-text oxd-text--p oxd-alert-content-text']");
    private final By usernameRequiredInfo = By.xpath("(//span[contains(@class, 'oxd-input-field-error-message')])[1]");
    private final By passwordRequiredInfo = By.xpath("(//span[contains(@class, 'oxd-input-field-error-message')])[2]");

    public LoginPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void enterUsername(String username){
        WebElement usernameText = wait.until(ExpectedConditions.visibilityOfElementLocated(usernameTextBox));
        usernameText.sendKeys(username);
    }

    public void enterPassword(String password) {
        WebElement passwordText = wait.until(ExpectedConditions.visibilityOfElementLocated(passwordTextBox));
        passwordText.sendKeys(password);
    }

    public void clickLogin(){
        WebElement loginButtonClickable = wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        loginButtonClickable.click();
    }

    public String getExceptionMessage(){
        WebElement exceptionMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(invalidUsernameOrPasswordMessage));
        return exceptionMessage.getText();
    }

    public String getUsernameRequiredException(){
        WebElement usernameException = wait.until(ExpectedConditions.visibilityOfElementLocated(usernameRequiredInfo));
        return usernameException.getText();
    }

    public String getPasswordRequiredException(){
        WebElement passwordException = wait.until(ExpectedConditions.visibilityOfElementLocated(passwordRequiredInfo));
        return passwordException.getText();
    }
}
