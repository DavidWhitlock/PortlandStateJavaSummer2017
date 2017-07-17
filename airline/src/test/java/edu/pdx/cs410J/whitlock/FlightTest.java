package edu.pdx.cs410J.whitlock;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Unit tests for the {@link Flight} class.
 */
public class FlightTest {
  
  @Test(expected = UnsupportedOperationException.class)
  public void getArrivalStringNeedsToBeImplemented() {
    Flight flight = new Flight(42);
    flight.getArrivalString();
  }

  @Test
  public void initiallyAllFlightsHaveTheSameNumber() {
    Flight flight = new Flight(42);
    assertThat(flight.getNumber(), equalTo(42));
  }

  @Test
  public void forProject1ItIsOkayIfGetDepartureTimeReturnsNull() {
    Flight flight = new Flight(42);
    assertThat(flight.getDeparture(), is(nullValue()));
  }
  
}
