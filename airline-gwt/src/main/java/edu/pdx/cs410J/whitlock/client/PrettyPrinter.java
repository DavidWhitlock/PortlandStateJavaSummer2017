package edu.pdx.cs410J.whitlock.client;

import com.google.common.annotations.VisibleForTesting;
import com.google.gwt.i18n.shared.DateTimeFormat;
import edu.pdx.cs410J.AirlineDumper;

import java.io.IOException;
import java.util.Collection;
import java.util.Date;

public class PrettyPrinter implements AirlineDumper<Airline> {

  @VisibleForTesting
  static final String DATE_FORMAT_PATTERN = "MM/dd/yyyy hh:mm a";
  private final DateFormatter dateFormatter;
  private StringBuilder prettyText = new StringBuilder();

  public PrettyPrinter() {
    this(new DateFormatter() {
      @Override
      public String format(Date date) {
        DateTimeFormat format = DateTimeFormat.getFormat(DATE_FORMAT_PATTERN);
        return format.format(date);
      }
    });
  }

  @VisibleForTesting
  PrettyPrinter(DateFormatter dateFormatter) {
    this.dateFormatter = dateFormatter;
  }

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
    return this.dateFormatter.format(date);
  }

  public String getPrettyText() {
    return prettyText.toString();
  }

  interface DateFormatter {
    String format(Date date);
  }
}
