package Practice;


import java.util.concurrent.TimeUnit;
import java.time.Duration;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

public class OrangeHRM_addVaccancy extends OrangeHRM_testbase{
	
	//login and go to vaccancy tab
	
	@FindBy(xpath= "(//input[@placeholder='Username'])")
    WebElement username;

    @FindBy(xpath = "(//input[@placeholder='Password'])")
    WebElement password;

    @FindBy(css = ".oxd-button.oxd-button--medium.oxd-button--main.orangehrm-login-button")
    WebElement LoginBtn;
    
	@FindBy(xpath ="(//span[@class= 'oxd-text oxd-text--span oxd-main-menu-item--name'])[5]")//.click();  //*[text()='Recruitment']
	WebElement recruitment;
	
	@FindBy(xpath ="//*[text()='Vacancies']")//.click();
	WebElement vacancies;
	
	// click on add button and add a vaccancy
	
	@FindBy(xpath ="//i[@class='oxd-icon bi-plus oxd-button-icon']")//.click();
	WebElement add_vaccancy;
	
	@FindBy(xpath ="(//input[@class='oxd-input oxd-input--active'])[2]")//.sendKeys("Account Assistant");
	WebElement vaccancy_name;
	
	@FindBy(xpath ="(//div[@class='oxd-select-text--after'])")//.click();
	WebElement vaccancyjobTitle_dropdown;
	
	@FindBy(xpath ="//*[text()='Account Assistant']")//.click();
	WebElement jobVaccancy;
	
	@FindBy(xpath ="//textarea[@placeholder='Type description here']")//.sendKeys("the positon is for chief executive officer");
	WebElement description;
	
	@FindBy(xpath ="//input[@placeholder='Type for hints...']")//.sendKeys("Dominic ");
	WebElement hiringmanager;

	@FindBy(xpath ="(//input[@class='oxd-input oxd-input--active'])[3]")//.sendKeys("4");
	WebElement num_of_position;
	
	//by default the checkbox are selected
	
//	@FindBy(xpath ="(//span[@class='oxd-switch-input oxd-switch-input--active --label-right'])[1]")//.click();
//	WebElement active_checkbox;
//	
//	@FindBy(xpath ="(//span[@class='oxd-switch-input oxd-switch-input--active --label-right'])[2]")//.click();
//	WebElement publish_checkbox;
	
	@FindBy(xpath ="//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']")//.click();
	WebElement submit;
	
	
	// confirm added vaccancy
	
	@FindBy(xpath ="//*[text()='Vacancies']")//.click();
    WebElement vaccancyTab;

    @FindBy(xpath ="/html/body/div/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[1]/div/div[2]/div/div/div[1]")//.click();
    WebElement jobDropdown;//(//div[@class='oxd-select-text-input'])[1]
    
    @FindBy(xpath ="//*[text()='Account Assistant']")//.click();
	WebElement job_name;
    
	@FindBy(xpath ="(//div[@class='oxd-select-text-input'])[2]")//.click();
	WebElement vaccancyDropdown;
	
	@FindBy(xpath ="//*[text()='Junior Account Assistant']")//.click();
	WebElement vaccancyName;
	
	@FindBy(xpath ="(//div[@class='oxd-select-text-input'])[3]")//.click();
	WebElement hiringManagerDropdown;
	
	@FindBy(xpath ="//*[text()='Dominic Chase']")//.click();
	WebElement hiringManager;
	
	
	@FindBy(xpath ="(//div[@class='oxd-select-text-input'])[4]")//.click();
	WebElement satusDropdown;
	
	@FindBy(xpath ="//*[text()='Active']")//.click();
	WebElement statusActive;

	@FindBy(xpath ="//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']")//.click();
	WebElement searchVaccancy;
	

	// functions
	public OrangeHRM_addVaccancy() {
        PageFactory.initElements(driver, this);
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
	
	public void add_a_vaccancy() {
		recruitment.click();
		vacancies.click();
        add_vaccancy.click();
        vaccancy_name.sendKeys("Junior Account Assistant");
        vaccancyjobTitle_dropdown.click();
        jobVaccancy.click();
        description.sendKeys("the positon is for chief executive officer");
        hiringmanager.sendKeys("Dominic");//sendKeys("Dominic Chase");
        

     // Wait for 3 seconds for the user to manually click on the Hiring Manager dropdown
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        

        num_of_position.sendKeys("4");
//        active_checkbox.click();
//        publish_checkbox.click();
        submit.click();
	} 
	
	public void confirm_vaccancy() {
        vaccancyTab.click();
        jobDropdown.click();
        job_name.click();
        vaccancyDropdown.click();
        vaccancyName.click();
        hiringManagerDropdown.click();
        hiringManager.click();
        satusDropdown.click();
        statusActive.click();
        searchVaccancy.click();
    }
	
}
