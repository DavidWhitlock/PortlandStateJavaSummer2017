package edu.pdx.cs410J.whitlock;

import edu.pdx.cs410J.AirlineDumper;

import java.io.IOException;
import java.io.PrintWriter;

public class TextDumper implements AirlineDumper<Airline> {
  private final PrintWriter writer;

  public TextDumper(PrintWriter writer) {
    this.writer = writer;
  }

  @Override
  public void dump(Airline airline) throws IOException {
    for(Flight flight : airline.getFlights()) {
      this.writer.println(flight.getNumber());
    }

    this.writer.flush();
  }
}
