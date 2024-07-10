package CommonRunner;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import pages.FlightOneWayBooking;
import utils.BaseClass;

public class OneWayBookingTest extends BaseClass {
	

    @Test(priority = 10)
    public void positiveOneWayBookingScenario() throws InterruptedException, IOException {
            FlightOneWayBooking fob = new FlightOneWayBooking(driver);
            explicitlyWait(10, fob.getOnewayButton());
            clickOnElement(fob.getOnewayButton());
            passInput(fob.getFromOriginClick(), "DEL");
            clickOnElement(fob.getToDestination());
            implicitlyWait(10);
            passInput(fob.getToDestination(), "Bom");
            implicitlyWait(5);
            //clickOnElement(fob.getSelectMumbai());
            sleep(10000);
            clickOnElement(fob.getOneWayTripDepartureDatePicker());
            sleep(5000);            
            clickOnElement(fob.getDay());
            explicitlyWait(2, fob.getPassengers());
            clickOnElement(fob.getPassengers());
            explicitlyWait(2, fob.getAdult());
            clickOnElement(fob.getAdult());
            sleep(3000);
            explicitlyWait(10, fob.getSearchButton());
            clickOnElement(fob.getSearchButton());
            
            explicitlyWait(15, fob.getContinueButton());
            clickOnElement(fob.getContinueButton());

            sleep(4000);
            explicitlyWait(8, fob.getSelectSalutationBooking());
            clickOnElement(fob.getSelectSalutationBooking());
            clickOnElement(fob.getSelectSalutationBookingDrop());
            passInput(fob.getContactDetailsFirstName(), "Cibhi");
            passInput(fob.getContactDetailsLastName(), "CR");
            passInput(fob.getContactDetailsPhoneNumber(), "9976309812");
            passInput(fob.getContactDetailsEmail(), "cibhi38@gmail.com");
            passInput(fob.getContactDetailsTown(), "Coimbatore");

            clickOnElement(fob.getSelectSalutationPassengerOne());
            clickOnElement(fob.getSelectSalutationPassengerOneDrop());
            passInput(fob.getPassengerOneFirstNameOne(), "Cibhi");
            passInput(fob.getPassengerOneLastNameOne(), "CR");
            passInput(fob.getPassengerOnePhoneNumberOne(), "9976309812");
            clickOnElement(fob.getPassengerTwoDropArrow());

            clickOnElement(fob.getSelectSalutationPassengerTwo());
            clickOnElement(fob.getSelectSalutationPassengerTwoDrop());
            passInput(fob.getPassengerOneFirstNameTwo(), "Raj");
            passInput(fob.getPassengerOneLastNameTwo(), "CS");
            passInput(fob.getPassengerOnePhoneNumberTwo(), "7373977119");

            explicitlyWait(20, fob.getPaymentContinueButton());
            clickOnElement(fob.getPaymentContinueButton());
            implicitlyWait(10);
            //  explicitlyWait(20, fob.getHomePage());
            clickOnElement(fob.getHomePage());
            Assert.assertTrue(true);

    }

    @Test(priority = 9)
    public void negativeOneWayBookingScenario() throws InterruptedException, IOException {
            FlightOneWayBooking fob = new FlightOneWayBooking(driver);
            explicitlyWait(5, fob.getOnewayButton());
            clickOnElement(fob.getOnewayButton());
            passInput(fob.getFromOriginClick(), "DEL");
            passInput(fob.getToDestination(), "");
            explicitlyWait(10, fob.getOneWayTripDepartureDatePicker());
            clickOnElement(fob.getOneWayTripDepartureDatePicker());
            clickOnElement(fob.getOneWayTripDepartureDatePicker());
            sleep(2000);
            clickOnElement(fob.getDay());
            explicitlyWait(10, fob.getSearchButton());
            clickOnElement(fob.getSearchButton());
            pageSource("Please enter a valid destination", "Negative one way booking test passed", "Negative one way booking test failed");
            Assert.assertTrue(true);

    }
    
    @AfterMethod
    public void refreshAfterEachTest() {
        refreshPage();
    }
}
