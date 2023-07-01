package Practice;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.Set;

public class OrangeHRM_LogoTest extends OrangeHRM_testbase {
	
	
    OrangeHRM_login Login_Page;
    OrangeHRM_home Home_Page;
    OrangeHRM_Logos logoObj ;
    
  @BeforeMethod
  public void setup() {
     
      initialize();
      logoObj = new OrangeHRM_Logos();

  }
 
    
  @Test
  public void verifyLinkedInLogoRedirection() {
      OrangeHRM_Logos logoObj = new OrangeHRM_Logos();
      logoObj.navigateToLoginPage(prop.getProperty("url"));

      if (logoObj.isLinkedInLogoDisplayed()) {
          logoObj.clickLinkedInLogo();

          // Switch to the new window
          String parentWindow = driver.getWindowHandle();
          Set<String> windows = driver.getWindowHandles();
          windows.remove(parentWindow);
          String newWindow = windows.iterator().next();
          driver.switchTo().window(newWindow);

          FluentWait<WebDriver> wait = new FluentWait<>(driver)
                  .withTimeout(Duration.ofSeconds(10))
                  .pollingEvery(Duration.ofMillis(500));

          By linkedInLogoLocator = By.xpath("/html/body/header/nav/a");//li-icon[@type='app-linkedin-bug-color-icon']  ,//a[@href='/?trk=seo-authwall-base_nav-header-logo'] , /html/body/header/nav/a
          WebElement linkedInLogo = wait.until(ExpectedConditions.visibilityOfElementLocated(linkedInLogoLocator));

          // Assertion for the successful find of the LinkedIn logo element
          Assert.assertNotNull(linkedInLogo, "LinkedIn logo element is not found.");

          // Add assertions or verification steps for the LinkedIn logo redirection in the new window

          driver.close();
          driver.switchTo().window(parentWindow);
      } else {
          Assert.fail("LinkedIn logo is not displayed.");
      }
  }


  @Test
  public void verifyFacebookLogoRedirection() {
      OrangeHRM_Logos logoObj = new OrangeHRM_Logos();
      logoObj.navigateToLoginPage(prop.getProperty("url"));

      if (logoObj.isFacebookLogoDisplayed()) {
          logoObj.clickFacebookLogo();        
          
       // Switch to the new window
          String parentWindow = driver.getWindowHandle();
          Set<String> windows = driver.getWindowHandles();
          windows.remove(parentWindow);
          String newWindow = windows.iterator().next();
          driver.switchTo().window(newWindow);
          FluentWait<WebDriver> wait = new FluentWait<>(driver)
                  .withTimeout(Duration.ofSeconds(10))
                  .pollingEvery(Duration.ofMillis(500));

          By facebookLogoLocator = By.xpath("//a[@aria-label=\"Facebook\"]");
          WebElement linkedInLogo = wait.until(ExpectedConditions.visibilityOfElementLocated(facebookLogoLocator));

          // Assertion for the successful find of the LinkedIn logo element
          Assert.assertNotNull(linkedInLogo, "Facebook logo element is not found.");

          // Add assertions or verification steps for the LinkedIn logo redirection in the new window

          driver.close();
          driver.switchTo().window(parentWindow);
          
      } else {
          Assert.fail("Facebook logo is not displayed.");
      }
  }

  @Test
  public void verifyTwitterLogoRedirection() {
      OrangeHRM_Logos logoObj = new OrangeHRM_Logos();
      logoObj.navigateToLoginPage(prop.getProperty("url"));

      if (logoObj.isTwitterLogoDisplayed()) {
          logoObj.clickTwitterLogo();
  
       // Switch to the new window
          String parentWindow = driver.getWindowHandle();
          Set<String> windows = driver.getWindowHandles();
          windows.remove(parentWindow);
          String newWindow = windows.iterator().next();
          driver.switchTo().window(newWindow);
          FluentWait<WebDriver> wait = new FluentWait<>(driver)
                  .withTimeout(Duration.ofSeconds(10))
                  .pollingEvery(Duration.ofMillis(500));

          By twitterLogoLocator = By.xpath("(//span[@class=\"css-901oao css-16my406 r-poiln3 r-bcqeeo r-qvutc0\"])[1] ");//a[@aria-label='Twitter'],  //div[@class=\"css-1dbjc4n r-1awozwy r-16y2uox r-1wbh5a2 r-1pi2tsx r-1777fci\"]
          WebElement linkedInLogo = wait.until(ExpectedConditions.visibilityOfElementLocated(twitterLogoLocator));

          // Assertion for the successful find of the LinkedIn logo element
          Assert.assertNotNull(linkedInLogo, "Twitter logo element is not found.");

          // Add assertions or verification steps for the LinkedIn logo redirection in the new window

          driver.close();
          driver.switchTo().window(parentWindow);
          
          
      } else {
          Assert.fail("Twitter logo is not displayed.");
      }
  }

  @Test
  public void verifyYouTubeLogoRedirection() {
      OrangeHRM_Logos logoObj = new OrangeHRM_Logos();
      logoObj.navigateToLoginPage(prop.getProperty("url"));

      if (logoObj.isYouTubeLogoDisplayed()) {
          logoObj.clickYouTubeLogo();
    
          
       // Switch to the new window
          String parentWindow = driver.getWindowHandle();
          Set<String> windows = driver.getWindowHandles();
          windows.remove(parentWindow);
          String newWindow = windows.iterator().next();
          driver.switchTo().window(newWindow);
          FluentWait<WebDriver> wait = new FluentWait<>(driver)
                  .withTimeout(Duration.ofSeconds(10))
                  .pollingEvery(Duration.ofMillis(500));

          By youtubeLogoLocator = By.xpath("//div[@id='start']");
          WebElement linkedInLogo = wait.until(ExpectedConditions.visibilityOfElementLocated(youtubeLogoLocator));

          // Assertion for the successful find of the LinkedIn logo element
          Assert.assertNotNull(linkedInLogo, "Youtube logo element is not found.");

          // Add assertions or verification steps for the LinkedIn logo redirection in the new window

          driver.close();
          driver.switchTo().window(parentWindow);
          
          
          
      } else {
          Assert.fail("YouTube logo is not displayed.");
      }
  }
}

