package edu.pdx.cs410J.whitlock;

import edu.pdx.cs410J.AirlineParser;
import edu.pdx.cs410J.ParserException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;

public class TextParser implements AirlineParser<Airline> {
  private final Reader reader;

  public TextParser(Reader reader) {
    this.reader = reader;
  }

  @Override
  public Airline parse() throws ParserException {
    Airline airline = new Airline();
    BufferedReader br = new BufferedReader(reader);

    try {
      for (String line = br.readLine(); line != null; line = br.readLine()) {
        airline.addFlight(new Flight(Integer.parseInt(line)));
      }

    } catch (IOException ex) {
      throw new ParserException("While parsing text", ex);
    }

    return airline;
  }
}
