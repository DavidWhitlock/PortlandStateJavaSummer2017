package edu.pdx.cs410J.whitlock.client;

import com.google.gwt.i18n.shared.DateTimeFormat;
import edu.pdx.cs410J.AirlineDumper;

import java.io.IOException;
import java.util.Collection;
import java.util.Date;

public class PrettyPrinter implements AirlineDumper<Airline> {

  private StringBuilder prettyText = new StringBuilder();

  @Override
  public void dump(Airline airline) throws IOException {
    prettyText.append(airline.toString());
    prettyText.append("\n");

    Collection<Flight> flights = airline.getFlights();
    for (Flight flight : flights) {
      prettyFlight(flight);
    }
  }

  private void prettyFlight(Flight flight) {
    prettyText.append("  Flight ").append(flight.getNumber()).append("\n");
    prettyText.append("      Departing ").append(flight.getSource()).append("\n");
    prettyText.append("        At ").append(prettyDate(flight.getDeparture())).append("\n");
    prettyText.append("      Arriving ").append(flight.getDestination()).append("\n");
    prettyText.append("        At ").append(prettyDate(flight.getArrival())).append("\n");
    prettyText.append("\n");
  }

  private String prettyDate(Date date) {
    DateTimeFormat format = DateTimeFormat.getFormat("MM/dd/yyyy hh:mm a");
    return format.format(date);
  }

  public String getPrettyText() {
    return prettyText.toString();
  }
}
