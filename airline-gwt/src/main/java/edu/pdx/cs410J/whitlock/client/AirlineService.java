package edu.pdx.cs410J.whitlock.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * A GWT remote service that returns a dummy airline
 */
@RemoteServiceRelativePath("airline")
public interface AirlineService extends RemoteService {

  /**
   * Returns the current date and time on the server
   * @param airlineName
   */
  Airline getAirline(String airlineName);

  /**
   * Always throws an undeclared exception so that we can see GWT handles it.
   */
  void throwUndeclaredException();

  /**
   * Always throws a declared exception so that we can see GWT handles it.
   */
  void throwDeclaredException() throws IllegalStateException;

}
