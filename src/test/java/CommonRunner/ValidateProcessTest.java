package CommonRunner;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pages.ValidateBookingPage;
import utils.BaseClass;

public class ValidateProcessTest extends BaseClass {

    @Test(priority = 13)
    public void validateBookingPage() {
        ValidateBookingPage vp = new ValidateBookingPage(driver);

        clickOnElement(vp.getCheckIn());
        if (driver.getPageSource().contains("Web Check-In")) {
            Assert.assertTrue(true);
        } else {
            Assert.assertTrue(false);
        }

        clickOnElement(vp.getFlightStatus());
        if (driver.getPageSource().contains("Flight Status")) {
            Assert.assertTrue(true);
        } else {
            Assert.assertTrue(false);
        }

        clickOnElement(vp.getManageBooking());
        if (driver.getPageSource().contains("View / Manage Booking")) {
            Assert.assertTrue(true);
        } else {
            Assert.assertTrue(false);
        }

        System.out.println("All Done");
    }
    
    @AfterMethod
    public void refreshAfterEachTest() {
        refreshPage();
    }
}
