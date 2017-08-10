package edu.pdx.cs410J.whitlock.client;

import edu.pdx.cs410J.AbstractFlight;

import java.util.Date;

public class Flight extends AbstractFlight
{

  private int number = 42;
  private String source = "PDX";
  private Date departure = new Date();
  private String destination = "MHT";
  private Date arrival = new Date();

  /**
   * In order for GWT to serialize this class (so that it can be sent between
   * the client and the server), it must have a zero-argument constructor.
   */
  public Flight() {

  }

  @Override
  public int getNumber() {
    return number;
  }

  @Override
  public String getSource() {
    return source;
  }

  @Override
  public Date getDeparture() {
    return departure;
  }

  public String getDepartureString() {
    return "DEPART " + getDeparture();
  }

  public String getDestination() {
    return destination;
  }

  public Date getArrival() {
    return arrival;
  }

  public String getArrivalString() {
    return "ARRIVE " + getArrival();
  }

}
