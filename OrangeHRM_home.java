package Practice;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class OrangeHRM_home extends OrangeHRM_testbase{

    
    @FindBy(xpath = "//a[@class='oxd-brand']")
    WebElement dashboard_logo;
    
    @FindBy(xpath = "//i[@class='oxd-icon bi-caret-down-fill oxd-userdropdown-icon']")
    WebElement dropdown;
    
    @FindBy(xpath = "(//a[@class='oxd-userdropdown-link'])[4]")
    WebElement logout;

    public OrangeHRM_home() {
        PageFactory.initElements(driver, this);
    }

    public String verifyHomePageTitle() {
        return driver.getTitle();
    }
    
    public boolean verifyDashboardPage() {
    	return dashboard_logo.isDisplayed();
    }
    
    public void logout() {
        dropdown.click(); // Click on the dropdown to open the menu
        logout.click(); // Click on the logout option

        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(500));

        wait.until(ExpectedConditions.titleIs("OrangeHRM")); // Wait until the page title is "OrangeHRM"
    }
}


