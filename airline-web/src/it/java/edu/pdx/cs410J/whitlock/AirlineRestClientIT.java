package edu.pdx.cs410J.whitlock;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.io.IOException;

/**
 * Integration test that tests the REST calls made by {@link AirlineRestClient}
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AirlineRestClientIT {
  private static final String HOSTNAME = "localhost";
  private static final String PORT = System.getProperty("http.port", "8080");

  private AirlineRestClient newAirlineRestClient() {
    int port = Integer.parseInt(PORT);
    return new AirlineRestClient(HOSTNAME, port);
  }

  @Test
  public void test0RemoveAirline() throws IOException {
    AirlineRestClient client = newAirlineRestClient();
    client.removeAirline();
  }

  @Test
  public void test1AddOneFlight() throws IOException {
    AirlineRestClient client = newAirlineRestClient();

    String airlineName = "My Airline";
    Flight flight = new Flight("PDX", "LAX", 123);
    client.addFlight(airlineName, flight);
  }

}
