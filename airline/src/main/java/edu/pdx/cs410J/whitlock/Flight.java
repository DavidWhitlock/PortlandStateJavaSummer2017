package edu.pdx.cs410J.whitlock;

import edu.pdx.cs410J.AbstractFlight;

public class Flight extends AbstractFlight {

  private final int number;

  public Flight(int flightNumber) {
    this.number = flightNumber;
  }

  @Override
  public int getNumber() {
    return number;
  }

  @Override
  public String getSource() {
    throw new UnsupportedOperationException("This method is not implemented yet");
  }

  @Override
  public String getDepartureString() {
    throw new UnsupportedOperationException("This method is not implemented yet");
  }

  @Override
  public String getDestination() {
    throw new UnsupportedOperationException("This method is not implemented yet");
  }

  @Override
  public String getArrivalString() {
    throw new UnsupportedOperationException("This method is not implemented yet");
  }
}
