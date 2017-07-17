package edu.pdx.cs410J.whitlock;

import edu.pdx.cs410J.AbstractAirline;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Airline extends AbstractAirline<Flight> {

  private final List<Flight> flights = new ArrayList<>();

  @Override
  public String getName() {
    throw new UnsupportedOperationException("This method is not implemented yet");
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
