package edu.pdx.cs410J.whitlock.client;

import edu.pdx.cs410J.AbstractAirline;

import java.util.ArrayList;
import java.util.Collection;

public class Airline extends AbstractAirline<Flight>
{
  private String airlineName;

  /**
   * In order for GWT to serialize this class (so that it can be sent between
   * the client and the server), it must have a zero-argument constructor.
   */
  public Airline() {

  }

  public Airline(String airlineName) {
    this.airlineName = airlineName;
  }

  private Collection<Flight> flights = new ArrayList<>();

  @Override
  public String getName() {
    return this.airlineName;
  }

  @Override
  public void addFlight(Flight flight) {
    this.flights.add(flight);
  }

  @Override
  public Collection<Flight> getFlights() {
    return this.flights;
  }
}
