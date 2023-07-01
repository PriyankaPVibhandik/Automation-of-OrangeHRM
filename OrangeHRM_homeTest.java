package Practice;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import org.testng.Assert;


public class OrangeHRM_homeTest extends OrangeHRM_testbase{
	OrangeHRM_login Login_Page;
	OrangeHRM_home Home_Page;

    public OrangeHRM_homeTest() {
        super();
    }

    @BeforeMethod
    public void setUp() {
        initialize();
        Login_Page = new OrangeHRM_login();
        Home_Page = Login_Page.login(prop.getProperty("username"), prop.getProperty("password"));
    }

    @Test(priority = 1)
    public void loginPageTitleTest() {
        String title = Login_Page.validateLoginPageTitle();
        Assert.assertEquals(title, "OrangeHRM");
    }

 

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}
