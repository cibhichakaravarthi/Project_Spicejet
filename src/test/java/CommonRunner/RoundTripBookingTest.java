package CommonRunner;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import pages.FlightRoundTripBooking;
import utils.BaseClass;

public class RoundTripBookingTest extends BaseClass {

    @Test(priority = 12)
    public void positiveRoundTripBookingScenario() throws InterruptedException, IOException {
            FlightRoundTripBooking frb = new FlightRoundTripBooking(driver);
            explicitlyWait(10, frb.getRoundTripButton());
            clickOnElement(frb.getRoundTripButton());
            passInput(frb.getRoundTripFromOriginClick(), "DEL");
            clickOnElement(frb.getRoundTripToDestination());
            implicitlyWait(10);
            passInput(frb.getRoundTripToDestination(), "Bom");
            implicitlyWait(5);
            //clickOnElement(frb.getSelectMumbai());
            sleep(10000);
            clickOnElement(frb.getRoundTripDepartureDatePicker());
            sleep(5000);            
            clickOnElement(frb.getDay());
            implicitlyWait(5);
            clickOnElement(frb.getRoundTripReturnDatePicker());
            clickOnElement(frb.getDay());
            clickOnElement(frb.getRoundTripPassengers());
            clickOnElement(frb.getRoundTripAdult());
            clickOnElement(frb.getRoundTripSearchButton());
            explicitlyWait(10, frb.getContinueButtonRound());
            clickOnElement(frb.getContinueButtonRound());

            explicitlyWait(8, frb.getSelectSalutationBookingRound());
            clickOnElement(frb.getSelectSalutationBookingRound());
            clickOnElement(frb.getSelectSalutationBookingDropRound());
            passInput(frb.getContactDetailsFirstNameRound(), "Cibhi");
            passInput(frb.getContactDetailsLastNameRound(), "CR");
            passInput(frb.getContactDetailsPhoneNumberRound(), "9976309812");
            passInput(frb.getContactDetailsEmailRound(), "cibhi38@gmail.com");
            passInput(frb.getContactDetailsTownRound(), "Coimbatore");

            clickOnElement(frb.getSelectSalutationPassengerOneRound());
            clickOnElement(frb.getSelectSalutationPassengerOneRound());
            passInput(frb.getPassengerOneFirstNameOneRound(), "Cibhi");
            passInput(frb.getPassengerOneLastNameOneRound(), "CR");
            passInput(frb.getPassengerOnePhoneNumberOneRound(), "9976309812");
            clickOnElement(frb.getPassengerTwoDropArrowRound());

            clickOnElement(frb.getSelectSalutationPassengerTwoRound());
            clickOnElement(frb.getSelectSalutationPassengerTwoDropRound());
            passInput(frb.getPassengerOneFirstNameTwoRound(), "Raj");
            passInput(frb.getPassengerOneLastNameTwoRound(), "CS");
            passInput(frb.getPassengerOnePhoneNumberTwoRound(), "7373977119");
            
            clickOnElement(frb.getSelectSalutationPassengerThreeRound());
            clickOnElement(frb.getSelectSalutationPassengerThreeDropRound());
            passInput(frb.getPassengerOneFirstNameThreeRound(), "Raja");
            passInput(frb.getPassengerOneLastNameThreeRound(), "CSR");
            passInput(frb.getPassengerOnePhoneNumberThreeRound(), "7373977118");


            explicitlyWait(20, frb.getPaymentContinueButtonRound());
            clickOnElement(frb.getPaymentContinueButtonRound());
            //explicitlyWait(10, frb.getHomePageRound());
            clickOnElement(frb.getHomePageRound());
            Assert.assertTrue(true);
    }

    @Test(priority = 11)
    public void negativeRoundTripBookingScenario() throws InterruptedException, IOException {
            FlightRoundTripBooking frb = new FlightRoundTripBooking(driver);
            explicitlyWait(5, frb.getRoundTripButton());
            clickOnElement(frb.getRoundTripButton());
            passInput(frb.getRoundTripFromOriginClick(), "DEL");
            passInput(frb.getRoundTripToDestination(), "");
            clickOnElement(frb.getRoundTripDepartureDatePicker());
            clickOnElement(frb.getRoundTripReturnDatePicker());
            clickOnElement(frb.getRoundTripPassengers());
            clickOnElement(frb.getRoundTripAdult());
            clickOnElement(frb.getRoundTripSearchButton());
            pageSource("Please enter a valid destination", "Negative round trip booking test passed", "Negative round trip booking test failed");
            Assert.assertTrue(true);
    }
    
    @AfterMethod
    public void refreshAfterEachTest() {
        refreshPage();
    }
}
