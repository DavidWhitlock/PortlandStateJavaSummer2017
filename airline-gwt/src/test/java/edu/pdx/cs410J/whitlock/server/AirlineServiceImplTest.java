package edu.pdx.cs410J.whitlock.server;

import edu.pdx.cs410J.whitlock.client.Airline;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class AirlineServiceImplTest {

  @Test
  public void getAirlineWithNameReturnsAirlineWithName() {
    AirlineServiceImpl service = new AirlineServiceImpl();
    String name = "My Airline";
    Airline airline = service.getAirline(name);
    assertThat(airline.getName(), equalTo(name));
  }
}
