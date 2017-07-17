package edu.pdx.cs410J.whitlock;

import org.junit.Test;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

public class TextDumperTest {

  @Test
  public void flightNumberIsDumpedToTextDumper() throws IOException {
    Airline airline = new Airline();
    int flightNumber = 123;
    airline.addFlight(new Flight(flightNumber));

    StringWriter sw = new StringWriter();
    TextDumper dumper = new TextDumper(new PrintWriter(sw));
    dumper.dump(airline);

    assertThat(sw.toString(), containsString(String.valueOf(flightNumber)));
  }
}
