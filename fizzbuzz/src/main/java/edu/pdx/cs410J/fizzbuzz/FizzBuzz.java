package edu.pdx.cs410J.fizzbuzz;

import edu.pdx.cs410J.AbstractFlight;

public class FizzBuzz extends AbstractFlight {
  @Override
  public int getNumber() {
    return 42;
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
