package edu.pdx.cs410J.whitlock;

import edu.pdx.cs410J.ParserException;
import org.junit.Test;

import java.io.StringReader;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class TextParserTest {

  @Test
  public void flightNumberIsReadByTextParser() throws ParserException {
    int flightNumber = 123;
    String text = flightNumber + "\n";

    TextParser parser = new TextParser(new StringReader(text));
    Airline airline = parser.parse();

    assertThat(airline.getFlights().size(), equalTo(1));
    Flight flight = airline.getFlights().iterator().next();
    assertThat(flight.getNumber(), equalTo(flightNumber));
  }
}
