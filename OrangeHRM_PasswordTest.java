
package Practice;

import org.testng.Assert;
import org.testng.annotations.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class OrangeHRM_PasswordTest extends OrangeHRM_testbase {

    OrangeHRM_Password passwordObj;
    OrangeHRM_login Login_Page;
    OrangeHRM_home Home_Page;
    
  @BeforeMethod
  public void setup() {
     
      initialize();
      passwordObj = new OrangeHRM_Password();

  }

  @BeforeMethod
  public void setUp() {
      initialize();
      passwordObj = new OrangeHRM_Password();
      Login_Page = new OrangeHRM_login();
      Home_Page = Login_Page.login(prop.getProperty("username"), prop.getProperty("password"));
  }

  @Test(priority = 1)
  public void TC01_ForgetPassword() {
	  passwordObj.clickForgotPasswordLink();
	  passwordObj.enterForgetPasswordUsername("Admin");
	  passwordObj.clickResetPasswordButton();
      // Assertion or verification steps 
  	 WebElement messageBox = driver.findElement(By.xpath("//h6[@class='oxd-text oxd-text--h6 orangehrm-forgot-password-title']"));
  	    String messageText = messageBox.getText();

  	    Assert.assertTrue(messageText.contains("Reset Password link sent successfully"), "Reset password message is not displayed.");
  	
  }
  
  @Test(priority = 2)
  public void TC02_ChangePassword_of_user() {
//      Home_Page.logout(); // Logout

      Login_Page.navigateToLoginPage(prop.getProperty("url"));
      WebElement usernameInput = driver.findElement(By.xpath("//input[@placeholder = 'Username']"));
      usernameInput.sendKeys("Charlie");

      WebElement passwordInput = driver.findElement(By.xpath("//input[@placeholder = 'Password']"));
      passwordInput.sendKeys("charlie123");

      WebElement loginButton = driver.findElement(By.xpath("//button[@type = 'submit']"));
      loginButton.click();
//      Home_Page = Login_Page.login("Charlie", "charlie123");
//      passwordObj.changePasswordAfterLogin("charlie123", "charlie1234");

      passwordObj.clickProfileDropdown();
      passwordObj.clickChangePasswordLink();
      passwordObj.enterCurrentPassword("charlie123");
      passwordObj.enterNewPassword("charlie1234");
      passwordObj.enterConfirmPassword("charlie1234");
      passwordObj.clickSaveButton();

      // Assertion or verification steps
      Home_Page.logout(); // Logout

  }

  @Test(priority = 3)
  public void TC03_ChangePassword_of_DefaultAdmin() {

	  Login_Page.navigateToLoginPage(prop.getProperty("url"));
      WebElement usernameInput = driver.findElement(By.xpath("//input[@placeholder = 'Username']"));
      usernameInput.sendKeys("Admin");

      WebElement passwordInput = driver.findElement(By.xpath("//input[@placeholder = 'Password']"));
      passwordInput.sendKeys("admin123");

      WebElement loginButton = driver.findElement(By.xpath("//button[@type = 'submit']"));
      loginButton.click();
//     Home_Page = Login_Page.login("Charlie", "charlie123");
//      passwordObj.changePasswordAfterLogin("admin123", "admin1234");

      passwordObj.clickProfileDropdown();
      passwordObj.clickChangePasswordLink();
      passwordObj.enterCurrentPassword("admin123");
      passwordObj.enterNewPassword("admin1234");
      passwordObj.enterConfirmPassword("admin1234");
      passwordObj.clickSaveButton();

      // Assertion or verification steps
      Home_Page.logout(); // Logout
	
  }
  @Test(priority = 4)
  public void TC04_Check_NewPassword_DefaultAdmin() {
      Login_Page.navigateToLoginPage(prop.getProperty("url"));

      // Update the locator for the username input element
      WebElement usernameInput = driver.findElement(By.xpath("//input[@placeholder = 'Username']"));
      usernameInput.sendKeys("Admin");

      WebElement passwordInput = driver.findElement(By.xpath("//input[@placeholder = 'Password']"));
      passwordInput.sendKeys("admin1234");

      WebElement loginButton = driver.findElement(By.xpath("//button[@type = 'submit']"));
      loginButton.click();

    // Assertion or verification steps
    FluentWait<WebDriver> wait = new FluentWait<>(driver)
            .withTimeout(Duration.ofSeconds(10))
            .pollingEvery(Duration.ofMillis(500));

    WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class='oxd-text oxd-text--p oxd-alert-content-text']")));
    String actualErrorMessage = errorMessage.getText();
    String expectedErrorMessage = "Invalid credentials";
    Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Invalid credentials error message not displayed.");
  
  }
  
  @Test(priority = 5)
  public void TC05_Check_NewPassword_User() {
      Login_Page.navigateToLoginPage(prop.getProperty("url"));

      // Update the locator for the username input element
      WebElement usernameInput = driver.findElement(By.xpath("//input[@placeholder='Username']"));
      usernameInput.sendKeys("Charlie");

      WebElement passwordInput = driver.findElement(By.xpath("//input[@placeholder = 'Password']"));
      passwordInput.sendKeys("charlie1234");

      WebElement loginButton = driver.findElement(By.xpath("//button[@type = 'submit']"));
      loginButton.click();

      // Assertion or verification steps
      FluentWait<WebDriver> wait = new FluentWait<>(driver)
              .withTimeout(Duration.ofSeconds(10))
              .pollingEvery(Duration.ofMillis(500));

      boolean isHomePageDisplayed = wait.until(ExpectedConditions.urlContains("dashboard"));
      Assert.assertTrue(isHomePageDisplayed, "Home page is not displayed for user.");
 
  }
  
    @AfterMethod
    public void teardown() {
        driver.quit();
    }
}
