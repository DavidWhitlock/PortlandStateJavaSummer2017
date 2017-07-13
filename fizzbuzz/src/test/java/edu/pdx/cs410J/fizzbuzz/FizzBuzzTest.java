package edu.pdx.cs410J.fizzbuzz;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Unit tests for the {@link FizzBuzz} class.
 */
public class FizzBuzzTest {
  
  @Test(expected = UnsupportedOperationException.class)
  public void getArrivalStringNeedsToBeImplemented() {
    FizzBuzz flight = new FizzBuzz();
    flight.getArrivalString();
  }

  @Test
  public void initiallyAllFlightsHaveTheSameNumber() {
    FizzBuzz flight = new FizzBuzz();
    assertThat(flight.getNumber(), equalTo(42));
  }

  @Test
  public void forProject1ItIsOkayIfGetDepartureTimeReturnsNull() {
    FizzBuzz flight = new FizzBuzz();
    assertThat(flight.getDeparture(), is(nullValue()));
  }
  
}
