package edu.pdx.cs410J.whitlock;

import org.junit.Test;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.*;

/**
 * A unit test for the {@link AirlineServlet}.  It uses mockito to
 * provide mock http requests and responses.
 */
public class AirlineServletTest {

  @Test
  public void addOneFlight() throws ServletException, IOException {
    AirlineServlet servlet = new AirlineServlet();

    String airlineName = "My Airline";
    String source = "PDX";
    String destination = "LAX";
    int number = 123;
    String numberAsString = String.valueOf(number);

    HttpServletRequest request = mock(HttpServletRequest.class);
    when(request.getParameter("name")).thenReturn(airlineName);
    when(request.getParameter("src")).thenReturn(source);
    when(request.getParameter("dest")).thenReturn(destination);
    when(request.getParameter("number")).thenReturn(numberAsString);

    HttpServletResponse response = mock(HttpServletResponse.class);
    PrintWriter pw = mock(PrintWriter.class);

    when(response.getWriter()).thenReturn(pw);

    servlet.doPost(request, response);
    verify(response).setStatus(HttpServletResponse.SC_OK);

    Airline airline = servlet.getAirline();
    assertThat(airline.getName(), equalTo(airlineName));

    List<Flight> flights = airline.getFlights();
    assertThat(flights.size(), equalTo(1));
    Flight flight = flights.get(0);
    assertThat(flight.getSource(), equalTo(source));
    assertThat(flight.getDestination(), equalTo(destination));
    assertThat(flight.getNumber(), equalTo(number));
  }
}
