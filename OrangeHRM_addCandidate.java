package Practice;

import java.time.Duration;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

public class OrangeHRM_addCandidate extends OrangeHRM_testbase{
	

	//login and go to recruitment tab
	
	@FindBy(xpath= "(//input[@class='oxd-input oxd-input--active'])[1]")
    WebElement username;

	@FindBy(xpath = "(//input[@placeholder='Password'])")
    WebElement password;
    
    @FindBy(css = ".oxd-button.oxd-button--medium.oxd-button--main.orangehrm-login-button")
    WebElement LoginBtn;
    
    @FindBy(xpath ="(//span[@class= 'oxd-text oxd-text--span oxd-main-menu-item--name'])[5]")//.click();  //*[text()='Recruitment']
	WebElement recruitment;
	
	// go to candidates tab and add a candidate


	@FindBy(xpath ="(//*[text()='Candidates'])[1]")//.click();
	WebElement candidatesTab;
	
	@FindBy(xpath ="//button[@class='oxd-button oxd-button--medium oxd-button--secondary']")//.click();
	WebElement addcandidate;
	
	@FindBy(xpath ="//input[@name='firstName']")//.sendKeys("Rokade");
	WebElement candidateFirstName;
	
	@FindBy(xpath ="//input[@name='middleName']")//.sendKeys("Tejas");
	WebElement candidateMiddleName;
	
	@FindBy(xpath ="//input[@name='lastName']")//.sendKeys("parasnath");
	WebElement candidateLastName;
	
	@FindBy(xpath ="//div[@class='oxd-select-text-input']")//.click();
	WebElement vaccancyDrop;
	
	@FindBy(xpath ="//*[text()='Associate IT Manager']")//.click();
	WebElement vacc;
	
	@FindBy(xpath ="(//input[@placeholder='Type here'])[1]")//.sendKeys("rokadetejas6@gmail.com");
	WebElement email;
	
	@FindBy(xpath ="(//input[@placeholder='Type here'])[2]")//.sendKeys("7894561232");
	//@FindBy(xpath ="//*[text()='Browse']")//.click();
	WebElement phone;
	
	@FindBy(xpath ="//input[@placeholder='Enter comma seperated words...']")//.sendKeys("java,python");
	WebElement keyWords;
	
	@FindBy(xpath ="//div[@class='oxd-date-input']")//.click();
	WebElement dateOfAppDrop;
	
	@FindBy(xpath ="//*[text()='1']")//.click();
	WebElement dateOfApp;
	
	@FindBy(xpath ="//textarea[@placeholder='Type here']")//.sendKeys("im good in python");
	WebElement notes;
	
	@FindBy(xpath ="//i[@class='oxd-icon bi-check oxd-checkbox-input-icon']")//.click();
	WebElement concentCheckbox;
	
	@FindBy(xpath ="//button[@type='submit']")//.click();
	WebElement submitData;
	
	
	//add wait
	
	
	@FindBy(xpath ="//button[@class='oxd-button oxd-button--medium oxd-button--success']")//.click();
	WebElement shortlistButton;
	
	@FindBy(xpath ="//textarea[@placeholder='Type here']")//.sendKeys("shortlisted for interview");
	WebElement notesForShortlist;
	
	
	@FindBy(xpath ="//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']")//.click();
	WebElement save;

	//add wait
	
	@FindBy(xpath ="//button[@class='oxd-button oxd-button--medium oxd-button--success']")
	WebElement schedule_interview;
	
	
	
	
	
	//functions
	
	public OrangeHRM_addCandidate() {
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
	
	
	public void add_a_candidate() {
        recruitment.click();
        candidatesTab.click();
        addcandidate.click();
        candidateFirstName.sendKeys("Rokade");
        candidateMiddleName.sendKeys("Tejas");
        candidateLastName.sendKeys("parasnath");
        vaccancyDrop.click();
        vacc.click();
        email.sendKeys("rokadetejas6@gmail.com");
        phone.sendKeys("7894561232");
        keyWords.sendKeys("java,python");
        dateOfAppDrop.click();
        dateOfApp.click();
        notes.sendKeys("im good in python");
        concentCheckbox.click();
        submitData.click();
    }

	
	public void shortlist_candidate() {
		
		shortlistButton.click();
		notesForShortlist.sendKeys("shortlisted for interview");
		save.click();
	}
	
	
}