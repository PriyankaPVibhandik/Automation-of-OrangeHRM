package Practice;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import org.testng.annotations.BeforeMethod;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;


public class OrangeHRM_loginTest extends OrangeHRM_testbase{
	OrangeHRM_login Login_Page;
	OrangeHRM_home Home_Page;

    public OrangeHRM_loginTest() {
        super();
    }

    @BeforeMethod
    public void setup() {
        initialize();
        Login_Page = new OrangeHRM_login();
    }

    @Test(priority = 1 , description = "Verify that the Orange HRM Page title is visible")
    public void loginPageTitleTest() {
        String title = Login_Page.validateLoginPageTitle();
        Assert.assertEquals(title, "OrangeHRM");
    }

    @Test(priority = 2 , description = "Verify that the Orange HRM logo is visible")
    public void imageTest() {
        boolean flag = Login_Page.validateImage();
        Assert.assertTrue(flag);
    }
 
    @Test(priority = 3 , description = "Verify that the correct login credentials should give access to the user")
    public void loginWithCorrectCredentialsTest() {
    	Login_Page.navigateToLoginPage(prop.getProperty("url"));
    	Home_Page = Login_Page.login(prop.getProperty("username"), prop.getProperty("password"));
        // Assert the login success here, e.g., verify the presence of an element on the home page
    	boolean flag = Home_Page.verifyDashboardPage();
        Assert.assertTrue(flag, "Login was not successful.");
    }

    @Test(priority = 4, description = "Verify that the correct login (case-insensitive username) credentials should give access to the user")
    public void loginWithCaseInsensitiveUsernameTest() {
    	Login_Page.navigateToLoginPage(prop.getProperty("url"));
    	Home_Page = Login_Page.login(prop.getProperty("case_username"), prop.getProperty("password"));
        // case-insensitive user name is allowed
    	boolean flag = Home_Page.verifyDashboardPage();
        Assert.assertTrue(flag, "Login was not successful.");
    	
    }
        
    @Test(priority = 5, description = "Verify that the correct login (case-insensitive username and password) credentials should give error message to the user")
    public void loginWithCaseInsensitiveUsernameAndPasswordTest() {
    	Login_Page.navigateToLoginPage(prop.getProperty("url"));
    	Login_Page.loginWithInvalidCredentials(prop.getProperty("case_username"), prop.getProperty("case_password"));

    	    FluentWait<WebDriver> wait = new FluentWait<>(driver)
    	            .withTimeout(Duration.ofSeconds(10))
    	            .pollingEvery(Duration.ofMillis(500));

    	    WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class='oxd-text oxd-text--p oxd-alert-content-text']")));
    	    String actualErrorMessage = errorMessage.getText();
    	    String expectedErrorMessage = "Invalid credentials";
    	    Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Invalid credentials error message not displayed.");
    	
    }

    @Test(priority = 6, description = "Verify that the invalid login credentials should gve error message to the user")
    public void loginWithInvalidCredentialsTest() {
    	Login_Page.navigateToLoginPage(prop.getProperty("url"));
    	Login_Page.loginWithInvalidCredentials(prop.getProperty("invalid_username"), prop.getProperty("invalid_password"));

        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(500));

        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class='oxd-text oxd-text--p oxd-alert-content-text']")));
        String actualErrorMessage = errorMessage.getText();
        String expectedErrorMessage = "Invalid credentials";
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Invalid credentials error message not displayed.");
    	
    }

    @Test(priority = 7, description = "Verify that on clicking on the logout tab the user gets logged out successfully")
    public void logoutTest() {
    	Login_Page.navigateToLoginPage(prop.getProperty("url"));
    	Home_Page = Login_Page.login(prop.getProperty("username"), prop.getProperty("password"));
       
        Assert.assertTrue(Home_Page.verifyDashboardPage(), "Login was not successful. Dashboard logo not found.");

        // Perform logout
        Home_Page.logout();

        // Assert the successful logout 
        String pageTitle = Login_Page.validateLoginPageTitle();
        Assert.assertEquals(pageTitle, "OrangeHRM");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
