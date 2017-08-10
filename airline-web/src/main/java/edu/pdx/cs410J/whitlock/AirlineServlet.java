package edu.pdx.cs410J.whitlock;

import com.google.common.annotations.VisibleForTesting;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * This servlet ultimately provides a REST API for working with an
 * <code>Airline</code>.  However, in its current state, it is an example
 * of how to use HTTP and Java servlets to store simple key/value pairs.
 */
public class AirlineServlet extends HttpServlet {
  static final String SUCCESSFULLY_ADDED_A_FLIGHT = "Successfully added a flight";
  private Airline airline;

  /**
   * Handles an HTTP GET request from a client by writing the value of the key
   * specified in the "key" HTTP parameter to the HTTP response.  If the "key"
   * parameter is not specified, all of the key/value pairs are written to the
   * HTTP response.
   */
  @Override
  protected void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException
  {
      response.setContentType( "text/plain" );

    String airlineName = getParameter( "name", request );
    if (airlineName == null) {
        missingRequiredParameter(response, "name");
        return;
    }

    String source = getParameter( "src", request );
    if ( source == null) {
        missingRequiredParameter( response, "src" );
        return;
    }

    String destination = getParameter( "dest", request );
    if ( destination == null) {
        missingRequiredParameter( response, "dest" );
        return;
    }

    if (!createOrValidateAirlineWithName(airlineName)) {
      nonMatchingAirlineName(airlineName, response);
      return;
    }

    String pretty = prettyPrintFlightsBetween(source, destination);
    response.getWriter().println(pretty);
    response.setStatus( HttpServletResponse.SC_OK);

  }

  private String prettyPrintFlightsBetween(String source, String destination) {
    StringBuilder sb = new StringBuilder();
    sb.append("Flights between ").append(source).append(" and ").append(destination).append(":\n");
    this.airline.getFlights().stream()
      .filter(f -> f.getSource().equals(source) && f.getDestination().equals(destination))
      .forEach(f -> sb.append("  ").append(f).append("\n"));

    return sb.toString();
  }

  /**
   * Handles an HTTP POST request by storing the key/value pair specified by the
   * "key" and "value" request parameters.  It writes the key/value pair to the
   * HTTP response.
   */
  @Override
  protected void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException
  {
      response.setContentType( "text/plain" );

      String airlineName = getParameter( "name", request );
      if (airlineName == null) {
          missingRequiredParameter(response, "name");
          return;
      }

      String source = getParameter( "src", request );
      if ( source == null) {
          missingRequiredParameter( response, "src" );
          return;
      }

      String destination = getParameter( "dest", request );
      if ( destination == null) {
          missingRequiredParameter( response, "dest" );
          return;
      }

      String numberAsString = getParameter( "number", request );
      if ( numberAsString == null) {
          missingRequiredParameter( response, "number" );
          return;
      }

      int number;
      try {
        number = Integer.parseInt(numberAsString);

      } catch (NumberFormatException ex) {
        invalidFlightNumber(numberAsString, response);
        return;
      }

      if (!createOrValidateAirlineWithName(airlineName)) {
        nonMatchingAirlineName(airlineName, response);
        return;
      }

      Flight flight = new Flight(source, destination, number);
      airline.addFlight(flight);

      response.getWriter().println(SUCCESSFULLY_ADDED_A_FLIGHT);
      response.setStatus( HttpServletResponse.SC_OK);
  }

  private void nonMatchingAirlineName(String airlineName, HttpServletResponse response) throws IOException {
    String message = "Airline not named " + airlineName;
    response.sendError(HttpServletResponse.SC_PRECONDITION_FAILED, message);
  }

  private boolean createOrValidateAirlineWithName(String airlineName) {
    if (this.airline != null) {
      return this.airline.getName().equals(airlineName);

    } else {
      this.airline = new Airline(airlineName);
      return true;
    }
  }

  private void invalidFlightNumber(String numberAsString, HttpServletResponse response) throws IOException {
    String message = "Invalid flight number" + numberAsString;
    response.sendError(HttpServletResponse.SC_EXPECTATION_FAILED, message);
  }

  /**
   * Handles an HTTP DELETE request by removing all key/value pairs.  This
   * behavior is exposed for testing purposes only.  It's probably not
   * something that you'd want a real application to expose.
   */
  @Override
  protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      response.setContentType("text/plain");

      this.airline = null;

      response.setStatus(HttpServletResponse.SC_OK);

  }

  /**
   * Writes an error message about a missing parameter to the HTTP response.
   *
   * The text of the error message is created by {@link Messages#missingRequiredParameter(String)}
   */
  private void missingRequiredParameter( HttpServletResponse response, String parameterName )
      throws IOException
  {
      String message = Messages.missingRequiredParameter(parameterName);
      response.sendError(HttpServletResponse.SC_PRECONDITION_FAILED, message);
  }

  /**
   * Returns the value of the HTTP request parameter with the given name.
   *
   * @return <code>null</code> if the value of the parameter is
   *         <code>null</code> or is the empty string
   */
  private String getParameter(String name, HttpServletRequest request) {
    String value = request.getParameter(name);
    if (value == null || "".equals(value)) {
      return null;

    } else {
      return value;
    }
  }

  @VisibleForTesting
  Airline getAirline() {
    return airline;
  }
}
