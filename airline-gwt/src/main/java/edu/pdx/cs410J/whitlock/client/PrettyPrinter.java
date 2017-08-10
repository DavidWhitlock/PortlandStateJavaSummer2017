package edu.pdx.cs410J.whitlock.client;

import edu.pdx.cs410J.AirlineDumper;

import java.io.IOException;
import java.util.Collection;

public class PrettyPrinter implements AirlineDumper<Airline> {

  private StringBuilder prettyText = new StringBuilder();

  @Override
  public void dump(Airline airline) throws IOException {
    prettyText.append(airline.toString());
    Collection<Flight> flights = airline.getFlights();
    for (Flight flight : flights) {
      prettyText.append(flight);
      prettyText.append("\n");
    }
  }

  public String getPrettyText() {
    return prettyText.toString();
  }
}
