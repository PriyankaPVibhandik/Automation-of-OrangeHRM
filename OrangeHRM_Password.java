
package Practice;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class OrangeHRM_Password extends OrangeHRM_testbase {

    @FindBy(name = "username")
    WebElement username;

    @FindBy(name = "password")
    WebElement password;

    @FindBy(css = ".oxd-button.oxd-button--medium.oxd-button--main.orangehrm-login-button")
    WebElement loginBtn;

    @FindBy(xpath = "//p[@class='oxd-text oxd-text--p orangehrm-login-forgot-header']")
    WebElement forgotPasswordLink;

    @FindBy(xpath = "//input[@class='oxd-input oxd-input--active']")
    WebElement forgetPwdUsername;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement resetPwdButton;

    @FindBy(xpath = "//p[@class='oxd-userdropdown-name']")
    WebElement profileDropdown;

    @FindBy(xpath = "(//a[@class='oxd-userdropdown-link'])[3]")
    WebElement changePasswordLink;

    @FindBy(xpath = "(//input[@class='oxd-input oxd-input--active'])[2]")//input[@class='oxd-input oxd-input--active'])[1]
    WebElement currentPwd;

    @FindBy(xpath = "/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[1]/div/div[2]/input")//(//input[@class='oxd-input oxd-input--active'])[2]
    WebElement newPwd;

    @FindBy(xpath = "/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[2]/div/div[2]/input")//(//input[@class='oxd-input oxd-input--active'])[3]
    WebElement confirmPwd;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement saveButton;

    public OrangeHRM_Password() {
        PageFactory.initElements(driver, this);
    }

    public void clickForgotPasswordLink() {
        forgotPasswordLink.click();
    }

    public void enterForgetPasswordUsername(String username) {
        forgetPwdUsername.sendKeys(username);
    }

    public void clickResetPasswordButton() {
        resetPwdButton.click();
    }

    public void clickProfileDropdown() {
        profileDropdown.click();
    }

    public void clickChangePasswordLink() {
        changePasswordLink.click();
    }

    public void enterCurrentPassword(String password) {
        currentPwd.sendKeys(password);
    }

    public void enterNewPassword(String password) {
        newPwd.sendKeys(password);
    }

    public void enterConfirmPassword(String password) {
        confirmPwd.sendKeys(password);
    }

    public void clickSaveButton() {
        saveButton.click();
    }

    public void navigateToLoginPage(String url) {
        driver.get(url);
    }

    public OrangeHRM_home login(String user, String pwd) {
        username.sendKeys(user);
        password.sendKeys(pwd);

        loginBtn.click();

        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(500));

        wait.until(ExpectedConditions.titleIs("OrangeHRM")); // Wait until the page title is "OrangeHRM"

        wait.until(ExpectedConditions.urlContains("dashboard")); // Wait until the URL contains "dashboard"

        return new OrangeHRM_home();
    }
    public void changePasswordAfterLogin(String currentPassword, String newPassword) {
        clickProfileDropdown();
        clickChangePasswordLink();
        enterCurrentPassword(currentPassword);
        enterNewPassword(newPassword);
        enterConfirmPassword(newPassword);
        clickSaveButton();
    }
}
