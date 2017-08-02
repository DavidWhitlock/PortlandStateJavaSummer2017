package edu.pdx.cs410J.whitlock;

import edu.pdx.cs410J.InvokeMainTestCase;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.core.IsEqual.equalTo;

/**
 * An integration test for {@link Project4} that invokes its main method with
 * various arguments
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Project4IT extends InvokeMainTestCase {
    private static final String HOSTNAME = "localhost";
    private static final String PORT = System.getProperty("http.port", "8080");

    @Test
    public void test0RemoveAirline() throws IOException {
      AirlineRestClient client = new AirlineRestClient(HOSTNAME, Integer.parseInt(PORT));
        client.removeAirline();
    }

    @Test
    public void test1AddOneFlight() {
        MainMethodResult result = invokeMain(Project4.class, HOSTNAME, PORT, "My Airline", "PDX", "LAX", "123");
        assertThat(result.getTextWrittenToStandardError(), result.getExitCode(), equalTo(0));
    }

    @Test
    public void test2AddMoreFlights() {
        MainMethodResult result;
        result = invokeMain(Project4.class, HOSTNAME, PORT, "My Airline", "PDX", "LAS", "234");
        assertThat(result.getTextWrittenToStandardError(), result.getExitCode(), equalTo(0));
        result = invokeMain(Project4.class, HOSTNAME, PORT, "My Airline", "PDX", "LAX", "345");
        assertThat(result.getTextWrittenToStandardError(), result.getExitCode(), equalTo(0));

        result = invokeMain(Project4.class, HOSTNAME, PORT, "My Airline", "PDX", "LAX");
        assertThat(result.getTextWrittenToStandardError(), result.getExitCode(), equalTo(0));

        String pretty = result.getTextWrittenToStandardOut();

        assertThat(pretty, containsString("123"));
        assertThat(pretty, containsString("345"));
        assertThat(pretty, not(containsString("LAS")));
    }

}