package edu.pdx.cs410J.whitlock;

public class Flight {
  private final String source;
  private final String destination;
  private final int number;

  public Flight(String source, String destination, int number) {
    this.source = source;
    this.destination = destination;
    this.number = number;
  }

  public String getSource() {
    return source;
  }

  public String getDestination() {
    return destination;
  }

  public int getNumber() {
    return number;
  }

  @Override
  public String toString() {
    return "Flight " + number + " from " + source + " to " + destination;
  }
}
