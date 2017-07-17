package edu.pdx.cs410J.whitlock;

import edu.pdx.cs410J.ParserException;

import java.io.*;

/**
 * A very dump implementation of Project 2 to make the integration tests
 * pass.  It only writes the flight numbers to the text file.  Obviously,
 * you don't want to implement your project this way.
 */
public class Project2 {

  public static void main(String[] args) throws IOException, ParserException {
    String textFileName = args[1];
    String flightNumber = args[3];

    File textFile = new File(textFileName);

    Airline airline;
    if (textFile.exists()) {
      TextParser parser = new TextParser(new FileReader(textFile));
      airline = parser.parse();

    } else {
      airline = new Airline();
    }

    airline.addFlight(new Flight(Integer.parseInt(flightNumber)));

    TextDumper dumper = new TextDumper(new PrintWriter(new FileWriter(textFile)));
    dumper.dump(airline);
  }

}
