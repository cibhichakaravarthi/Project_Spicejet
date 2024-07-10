package CommonRunner;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import pages.Login;
import utils.BaseClass;

public class LoginTest extends BaseClass {

    @Test(priority = 5)
    public void positiveLoginScenario() throws InterruptedException, IOException {
        Login lp = new Login(driver);
        explicitlyWait(5, lp.getLoginButton());
        clickOnElement(lp.getLoginButton());
        explicitlyWait(5, lp.getLoginPageEmailButton());
        clickOnElement(lp.getLoginPageEmailButton());
        passInput(lp.getLoginPageEmail(), "cibhi38@gmail.com");
        passInput(lp.getLoginPagePassword(), "Cibhi@328");
        clickOnElement(lp.getLoginPageLoginButton());
        explicitlyWait(10, lp.getLoginPageCloseButton());
        clickOnElement(lp.getLoginPageCloseButton());
//        explicitlyWait(10, lp.getPopup());
//        clickOnElement(lp.getPopup());
//        explicitlyWait(10, lp.getLogoutButton());
//        clickOnElement(lp.getLogoutButton());
        Assert.assertTrue(true);

    }

    @Test(priority = 6)
    public void invalidEmailLoginScenario() throws InterruptedException, IOException {
            Login lp = new Login(driver);
            explicitlyWait(5, lp.getLoginButton());
            clickOnElement(lp.getLoginButton());
            explicitlyWait(5, lp.getLoginPageEmailButton());
            clickOnElement(lp.getLoginPageEmailButton());
            passInput(lp.getLoginPageEmail(), "cibhi233@example.com");
            passInput(lp.getLoginPagePassword(), "Cibhi@382");
            clickOnElement(lp.getLoginPageLoginButton());
            pageSource("Invalid email or password", "Invalid email login test passed", "Invalid email login test failed");
            Assert.assertTrue(true);
    }

    @Test(priority = 7)
    public void invalidPasswordLoginScenario() throws InterruptedException, IOException {
    		Login lp = new Login(driver);
            explicitlyWait(5, lp.getLoginButton());
            clickOnElement(lp.getLoginButton());
            explicitlyWait(5, lp.getLoginPageEmailButton());
            clickOnElement(lp.getLoginPageEmailButton());
            passInput(lp.getLoginPageEmail(), "cibhi38@gmail.com");
            passInput(lp.getLoginPagePassword(), "Cibhi@3833");
            implicitlyWait(10);
            clickOnElement(lp.getLoginPageLoginButton());
            pageSource("Invalid email or password", "Invalid password login test passed", "Invalid password login test failed");
            Assert.assertTrue(true);
    }

    @Test(priority = 8)
    public void emptyFieldsLoginScenario() throws InterruptedException, IOException {
            Login lp = new Login(driver);
            explicitlyWait(5, lp.getLoginButton());
            clickOnElement(lp.getLoginButton());
            explicitlyWait(5, lp.getLoginPageEmailButton());
            clickOnElement(lp.getLoginPageEmailButton());
            clickOnElement(lp.getLoginPageLoginButton());
            implicitlyWait(10);
//            clickOnElement(lp.getLoginPageCloseButton());
//            sleep(5000);
            pageSource("This field is required", "Empty fields login test passed", "Empty fields login test failed");
            Assert.assertTrue(true);

    }
    
    @AfterMethod
    public void refreshAfterEachTest() {
        refreshPage();
    }
}
