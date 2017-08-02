package edu.pdx.cs410J.whitlock;

import java.util.ArrayList;
import java.util.List;

public class Airline {
  private final List<Flight> flights = new ArrayList<>();
  private String name;

  public Airline(String name) {
    this.name = name;
  }

  public void addFlight(Flight flight) {
    this.flights.add(flight);
  }

  public String getName() {
    return name;
  }

  public List<Flight> getFlights() {
    return flights;
  }
}
