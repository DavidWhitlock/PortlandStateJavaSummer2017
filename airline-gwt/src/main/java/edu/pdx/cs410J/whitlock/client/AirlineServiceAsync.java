package edu.pdx.cs410J.whitlock.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * The client-side interface to the airline service
 */
public interface AirlineServiceAsync {

  /**
   * Return an airline created on the server
   */
  void getAirline(String airlineName, AsyncCallback<Airline> async);

  /**
   * Always throws an exception so that we can see how to handle uncaught
   * exceptions in GWT.
   */
  void throwUndeclaredException(AsyncCallback<Void> async);

  /**
   * Always throws a declared exception so that we can see GWT handles it.
   */
  void throwDeclaredException(AsyncCallback<Void> async);
}
