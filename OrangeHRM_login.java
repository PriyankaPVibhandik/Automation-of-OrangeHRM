package Practice;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class OrangeHRM_login extends OrangeHRM_testbase {

	@FindBy(name = "username")//
    WebElement username;


    @FindBy(name = "password")
    WebElement password;

    @FindBy(css = ".oxd-button.oxd-button--medium.oxd-button--main.orangehrm-login-button")
    WebElement LoginBtn;


    @FindBy(xpath = "/html/body/div/div[1]/div/div[2]")
    WebElement OrangeHRM_Logo;
    
    public OrangeHRM_login() {
        PageFactory.initElements(driver, this);
    }

    public String validateLoginPageTitle() {
        return driver.getTitle();
    }

    public boolean validateImage() {
        return OrangeHRM_Logo.isDisplayed();
    }
    
    
    
    public void navigateToLoginPage(String url) {
        driver.get(url);
    }
    
   
    
    public OrangeHRM_home login(String user, String pwd) {
        username.sendKeys(user);
        password.sendKeys(pwd);

        LoginBtn.click();

        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(500));

        wait.until(ExpectedConditions.titleIs("OrangeHRM")); // Wait until the page title is "OrangeHRM"

        FluentWait<WebDriver> urlWait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(500));

        urlWait.until(ExpectedConditions.urlContains("dashboard")); // Wait until the URL contains "dashboard"

        return new OrangeHRM_home();
    }
    
    
    
    public void loginWithInvalidCredentials(String inv_user, String inv_pwd) {
        username.sendKeys(inv_user);
        password.sendKeys(inv_pwd);

        LoginBtn.click();

        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(500));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class='oxd-text oxd-text--p oxd-alert-content-text']"))); // Wait until the error message is displayed
    }
 
}

