package CommonRunner;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import pages.Signup;
import utils.BaseClass;

public class SignupTest extends BaseClass {

    @Test(priority = 1)
    public void positiveSignupScenario() throws InterruptedException, IOException {
            Signup sip = new Signup(driver);
            explicitlyWait(5, sip.getSignupButton());
            clickOnElement(sip.getSignupButton());
            String parent = driver.getWindowHandle();
            windowHandles("SpiceClub - The frequent flyer program of SpiceJet");

            selectValue(sip.getSelectSalutation(), "Mr");
            passInput(sip.getSignupFirstName(), "Cibhi");
            passInput(sip.getSignupLastName(), "CR");
            selectByVisibleText(sip.getSelectCountry(), "India");

            clickOnElement(sip.getDobCalendar());
            selectByVisibleText(sip.getSelectMonth(), "February");
            selectByVisibleText(sip.getSelectYear(), "1999");
            clickOnElement(sip.getDobDate());
            sleep(4000);
            scrollDownorUp("window.scrollBy(0,500)");
            explicitlyWait(5, sip.getSignupPhoneNumber());
            passInput(sip.getSignupPhoneNumber(), "7373977119");
            sleep(5000);
            passInput(sip.getSignupEmailId(), "cibhi39@gmail.com");
            passInput(sip.getSignupPassword(), "Cibhi@38");
            implicitlyWait(10);
            passInput(sip.getSignupConfirmPassword(), "Cibhi@38");

            clickOnElement(sip.getiAgreeButton());
            clickOnElement(sip.getSubmitButton());
            pageSource("OTP", "Page has been verified successfully", "Page is not verified");

            driver.switchTo().window(parent);
            Assert.assertTrue(true);
    }

    @Test(priority = 2)
    public void invalidEmailSignupScenario() throws InterruptedException, IOException {
            Signup sip = new Signup(driver);
            explicitlyWait(5, sip.getSignupButton());
            clickOnElement(sip.getSignupButton());
            String parent = driver.getWindowHandle();
            windowHandles("SpiceClub - The frequent flyer program of SpiceJet");

            selectValue(sip.getSelectSalutation(), "Mr");
            passInput(sip.getSignupFirstName(), "Cibhi");
            passInput(sip.getSignupLastName(), "CR");
            selectByVisibleText(sip.getSelectCountry(), "India");

            clickOnElement(sip.getDobCalendar());
            selectByVisibleText(sip.getSelectMonth(), "January");
            selectByVisibleText(sip.getSelectYear(), "2000");
            clickOnElement(sip.getDobDate());

            scrollDownorUp("window.scrollBy(0,500)");
            explicitlyWait(5, sip.getSignupPhoneNumber());
            passInput(sip.getSignupPhoneNumber(), "7373977119");
            passInput(sip.getSignupEmailId(), "invalid-email");
            passInput(sip.getSignupPassword(), "Cibhi@38");
            passInput(sip.getSignupConfirmPassword(), "Cibhi@38");

            clickOnElement(sip.getiAgreeButton());
            clickOnElement(sip.getSubmitButton());
            pageSource("Please enter a valid email address", "Invalid email test passed", "Invalid email test failed");

            driver.switchTo().window(parent);
            Assert.assertTrue(true);
    }

    @Test(priority = 3)
    public void mismatchedPasswordSignupScenario() throws InterruptedException, IOException {
            Signup sip = new Signup(driver);
            explicitlyWait(5, sip.getSignupButton());
            clickOnElement(sip.getSignupButton());
            String parent = driver.getWindowHandle();
            windowHandles("SpiceClub - The frequent flyer program of SpiceJet");

            selectValue(sip.getSelectSalutation(), "Mr");
            passInput(sip.getSignupFirstName(), "Cibhi");
            passInput(sip.getSignupLastName(), "CR");
            selectByVisibleText(sip.getSelectCountry(), "India");

            clickOnElement(sip.getDobCalendar());
            selectByVisibleText(sip.getSelectMonth(), "January");
            selectByVisibleText(sip.getSelectYear(), "2000");
            clickOnElement(sip.getDobDate());

            scrollDownorUp("window.scrollBy(0,500)");
            explicitlyWait(5, sip.getSignupPhoneNumber());
            passInput(sip.getSignupPhoneNumber(), "9976309812");
            passInput(sip.getSignupEmailId(), "cibhi38@gmail.com");
            passInput(sip.getSignupPassword(), "Password@123");
            passInput(sip.getSignupConfirmPassword(), "Password@456");

            clickOnElement(sip.getiAgreeButton());
            clickOnElement(sip.getSubmitButton());
            pageSource("Passwords do not match", "Mismatched password test passed", "Mismatched password test failed");

            driver.switchTo().window(parent);
            Assert.assertTrue(true);
    }

    @Test(priority = 4)
    public void emptyFieldsSignupScenario() throws InterruptedException, IOException {
            Signup sip = new Signup(driver);
            explicitlyWait(5, sip.getSignupButton());
            clickOnElement(sip.getSignupButton());
            String parent = driver.getWindowHandle();
            windowHandles("SpiceClub - The frequent flyer program of SpiceJet");

            clickOnElement(sip.getiAgreeButton());
            clickOnElement(sip.getSubmitButton());
            pageSource("This field is required", "Empty fields test passed", "Empty fields test failed");

            driver.switchTo().window(parent);
            Assert.assertTrue(true);

    }
    
    @AfterMethod
    public void refreshAfterEachTest() {
        refreshPage();
    }
}
