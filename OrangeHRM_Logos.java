package Practice;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrangeHRM_Logos extends OrangeHRM_testbase {

    @FindBy(xpath = "//div[@class='orangehrm-login-footer-sm']")
    WebElement logo_footer;

    @FindBy(xpath = "//div[@class='orangehrm-login-footer-sm'] //a[@href='https://www.linkedin.com/company/orangehrm/mycompany/']")
    WebElement linkedin_logo;

    @FindBy(xpath = "//div[@class='orangehrm-login-footer-sm'] //a[@href='https://www.facebook.com/OrangeHRM/'] ")
    WebElement facebook_logo;

    @FindBy(xpath = "//div[@class='orangehrm-login-footer-sm'] //a[@href='https://twitter.com/orangehrm?lang=en'] ")
    WebElement twitter_logo;

    @FindBy(xpath = "//div[@class='orangehrm-login-footer-sm'] //a[@href='https://www.youtube.com/c/OrangeHRMInc'] ")
    WebElement youtube_logo;

    public OrangeHRM_Logos() {
        PageFactory.initElements(driver, this);
    }

    public boolean isLinkedInLogoDisplayed() {
        return linkedin_logo.isDisplayed();
    }

    public boolean isFacebookLogoDisplayed() {
        return facebook_logo.isDisplayed();
    }

    public boolean isTwitterLogoDisplayed() {
        return twitter_logo.isDisplayed();
    }

    public boolean isYouTubeLogoDisplayed() {
        return youtube_logo.isDisplayed();
    }

    public void clickLinkedInLogo() {
        linkedin_logo.click();
    }

    public void clickFacebookLogo() {
        facebook_logo.click();
    }

    public void clickTwitterLogo() {
        twitter_logo.click();
    }

    public void clickYouTubeLogo() {
        youtube_logo.click();
    }
    
    
    public void navigateToLoginPage(String url) {
        driver.get(url);

    }


}

