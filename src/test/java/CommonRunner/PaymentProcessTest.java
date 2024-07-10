package CommonRunner;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pages.PaymentAndCheckoutprocess;
import utils.BaseClass;

public class PaymentProcessTest extends BaseClass {

    @Test(priority = 14)
    public void testPaymentProcess() throws InterruptedException {
        PaymentAndCheckoutprocess pp = new PaymentAndCheckoutprocess(driver);

        explicitlyWait(10, pp.getOnewayButton());
        clickOnElement(pp.getOnewayButton());
        passInput(pp.getFromOriginClick(), "DEL");
        clickOnElement(pp.getToDestination());
        implicitlyWait(10);
        passInput(pp.getToDestination(), "Bom");
        implicitlyWait(5);
       // clickOnElement(pp.getSelectMumbai());
        sleep(10000);
        clickOnElement(pp.getoneWayTripDepartureDatePickerForPayment());
        sleep(5000);            
        clickOnElement(pp.getDay());
        explicitlyWait(2, pp.getPassengers());
        clickOnElement(pp.getPassengers());
        explicitlyWait(2, pp.getAdult());
        clickOnElement(pp.getAdult());
        sleep(3000);
        explicitlyWait(10, pp.getSearchButton());
        clickOnElement(pp.getSearchButton());
        
        explicitlyWait(15, pp.getContinueButton());
        clickOnElement(pp.getContinueButton());

        sleep(4000);
        explicitlyWait(8, pp.getSelectSalutationBooking());
        clickOnElement(pp.getSelectSalutationBooking());
        clickOnElement(pp.getSelectSalutationBookingDrop());
        passInput(pp.getContactDetailsFirstName(), "Cibhi");
        passInput(pp.getContactDetailsLastName(), "CR");
        passInput(pp.getContactDetailsPhoneNumber(), "9976309812");
        passInput(pp.getContactDetailsEmail(), "cibhi38@gmail.com");
        passInput(pp.getContactDetailsTown(), "Coimbatore");

        clickOnElement(pp.getSelectSalutationPassengerOne());
        clickOnElement(pp.getSelectSalutationPassengerOneDrop());
        passInput(pp.getPassengerOneFirstNameOne(), "Cibhi");
        passInput(pp.getPassengerOneLastNameOne(), "CR");
        passInput(pp.getPassengerOnePhoneNumberOne(), "9976309812");
        clickOnElement(pp.getPassengerTwoDropArrow());

        clickOnElement(pp.getSelectSalutationPassengerTwo());
        clickOnElement(pp.getSelectSalutationPassengerTwoDrop());
        passInput(pp.getPassengerOneFirstNameTwo(), "Raj");
        passInput(pp.getPassengerOneLastNameTwo(), "CS");
        passInput(pp.getPassengerOnePhoneNumberTwo(), "7373977119");

        explicitlyWait(20, pp.getPaymentContinueButton());
        clickOnElement(pp.getPaymentContinueButton());
        implicitlyWait(10);
        clickOnElement(pp.getPaymentContinueButtonPayment());
        implicitlyWait(10);
        clickOnElement(pp.getSkipAndContinue());
        implicitlyWait(10);
        
        System.out.println("All Done");

        Assert.assertTrue(true);
      }
    
    @AfterMethod
    public void refreshAfterEachTest() {
        refreshPage();
    }
}
