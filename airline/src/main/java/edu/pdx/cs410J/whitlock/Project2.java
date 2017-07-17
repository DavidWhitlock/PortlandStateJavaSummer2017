package edu.pdx.cs410J.whitlock;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * A very dump implementation of Project 2 to make the integration tests
 * pass.  It only writes the flight numbers to the text file.  Obviously,
 * you don't want to implement your project this way.
 */
public class Project2 {

  public static void main(String[] args) throws IOException {
    String textFileName = args[1];
    String flightNumber = args[3];

    File textFile = new File(textFileName);

    List<String> flightNumbers;  // This is like your Airline
    if (textFile.exists()) {
      flightNumbers = parseFlightNumbersFromTextFile(textFile);

    } else {
      // This is like "creating a new airline"
      flightNumbers = new ArrayList<>();
    }

    flightNumbers.add(flightNumber);
    dumpFlightNumbersToTextFile(flightNumbers, textFile);
  }

  private static List<String> parseFlightNumbersFromTextFile(File textFile) throws IOException {
    // This is similar to what your TextParser does
    return Files.lines(textFile.toPath()).collect(Collectors.toList());
  }

  private static void dumpFlightNumbersToTextFile(List<String> flightNumber, File textFile) throws IOException {
    // This is similar to what your TextDumper does
    PrintWriter pw = new PrintWriter(new FileWriter(textFile));
    pw.println(flightNumber);
    pw.flush();
  }
}
