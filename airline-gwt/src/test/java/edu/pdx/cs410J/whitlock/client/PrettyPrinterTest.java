package edu.pdx.cs410J.whitlock.client;

import org.junit.Test;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

public class PrettyPrinterTest {

  @Test
  public void airlineNameIncludedInPrettyPrinterOutput() throws IOException {
    String name = "My Airline";
    Airline airline = new Airline(name);
    PrettyPrinter pretty = new PrettyPrinter();
    pretty.dump(airline);
    String output = pretty.getPrettyText();
    assertThat(output, containsString(name));
  }

  @Test
  public void flightNumberIsIncludedInPrettyPrinterOutput() throws IOException {
    Airline airline = new Airline("My Airline");
    Flight flight = new Flight();
    airline.addFlight(flight);

    PrettyPrinter pretty = new PrettyPrinter(new PrettyPrinter.DateFormatter() {
      @Override
      public String format(Date date) {
        return new SimpleDateFormat(PrettyPrinter.DATE_FORMAT_PATTERN).format(date);
      }
    });
    pretty.dump(airline);
    String output = pretty.getPrettyText();
    assertThat(output, containsString(String.valueOf(flight.getNumber())));
  }
}
