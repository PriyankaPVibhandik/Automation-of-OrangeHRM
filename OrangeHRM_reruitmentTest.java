package Practice;

import java.time.Duration;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import org.testng.Assert;
import org.testng.annotations.*;

public class OrangeHRM_reruitmentTest extends OrangeHRM_testbase{
	
	OrangeHRM_addVaccancy vaccancyObj;
	OrangeHRM_addCandidate candidateObj;
    OrangeHRM_login Login_Page;
    OrangeHRM_home Home_Page;
    
  @BeforeMethod
  public void setup() {
     
      initialize();
      vaccancyObj = new OrangeHRM_addVaccancy();
      candidateObj = new OrangeHRM_addCandidate();
  }

  @BeforeMethod
  public void setUp() {
      initialize();
      vaccancyObj = new OrangeHRM_addVaccancy();
      candidateObj = new OrangeHRM_addCandidate();
      Login_Page = new OrangeHRM_login();
      Home_Page = Login_Page.login("Admin", "admin123");
  }

  @Test(priority = 1)
  public void TC01_addVaccancy() {
	  vaccancyObj.login("Admin", "admin123");
	  vaccancyObj.add_a_vaccancy(); 
      // Assertion or verification steps 
	  vaccancyObj.confirm_vaccancy();
	  WebElement record = driver.findElement(By.xpath("//div[@class=\"oxd-table-card\"]"));
	  // Assertion: Check if the record is present
      Assert.assertTrue(record.isDisplayed(), "Record is not present on the page. Test case failed.");
  }
	
  @Test(priority = 2)
  public void TC02_addCandidate() {
	  vaccancyObj.login("Admin", "admin123");
	  candidateObj.add_a_candidate();
	  
	  FluentWait<WebDriver> wait = new FluentWait<>(driver)
              .withTimeout(Duration.ofSeconds(30))
              .pollingEvery(Duration.ofMillis(500))
              .ignoring(org.openqa.selenium.NoSuchElementException.class);

	  wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--success']")));
	  
	  candidateObj.shortlist_candidate();
	//Assertion
	  wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--success']")));
	  WebElement schedule_interview = driver.findElement(By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--success']"));
	  Assert.assertTrue(schedule_interview.isDisplayed(), "Record is not present on the page. Test case failed.");
  }
}
