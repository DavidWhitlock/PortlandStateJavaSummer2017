package edu.pdx.cs410J.whitlock;

import java.io.IOException;
import java.io.PrintStream;

/**
 * The main class that parses the command line and communicates with the
 * Airline server using REST.
 */
public class Project4 {

    public static final String MISSING_ARGS = "Missing command line arguments";

    public static void main(String... args) {
        String hostName = null;
        String portString = null;
        String airlineName = null;
        String source = null;
        String destination = null;
        String flightNumberAsString = null;

        for (String arg : args) {
            if (hostName == null) {
                hostName = arg;

            } else if ( portString == null) {
                portString = arg;

            } else if (airlineName == null) {
                airlineName = arg;

            } else if (source == null) {
                source = arg;

            } else if (destination == null) {
                destination = arg;

            } else if (flightNumberAsString == null) {
                flightNumberAsString = arg;

            } else {
                usage("Extraneous command line argument: " + arg);
            }
        }

        if (hostName == null) {
            usage( MISSING_ARGS );

        } else if ( portString == null) {
            usage( "Missing port" );
        }

        int port;
        try {
            port = Integer.parseInt( portString );
            
        } catch (NumberFormatException ex) {
            usage("Port \"" + portString + "\" must be an integer");
            return;
        }

        AirlineRestClient client = new AirlineRestClient(hostName, port);

        String message;
        try {
            if (source == null) {
                usage("Missing flight source");

            } else if (destination == null) {
                usage("Missing destination");

            } else if (flightNumberAsString == null) {
                String prettyAirline = client.getFlightsBetween(airlineName, source, destination);
                System.out.println(prettyAirline);

            } else {
                int flightNumber;
                try {
                    flightNumber = Integer.parseInt(flightNumberAsString);

                } catch (NumberFormatException ex) {
                    usage("Invalid flight number: " + flightNumberAsString);
                    return;
                }
                Flight flight = new Flight(source, destination, flightNumber);
                client.addFlight(airlineName, flight);
            }

        } catch ( IOException ex ) {
            error("While contacting server: " + ex);
            return;
        }

        System.exit(0);
    }

    private static void error( String message )
    {
        PrintStream err = System.err;
        err.println("** " + message);

        System.exit(1);
    }

    /**
     * Prints usage information for this program and exits
     * @param message An error message to print
     */
    private static void usage( String message )
    {
        PrintStream err = System.err;
        err.println("** " + message);
        err.println();
        err.println("usage: java Project4 host port source destination [number]");
        err.println("  host          Host of web server");
        err.println("  port          Port of web server");
        err.println("  airline       Name of the airline");
        err.println("  source        Departure airport code");
        err.println("  destination   Arrival airport code");
        err.println("  number        Flight number");
        err.println();
        err.println("This is a simple implementation of some of the Project 4 functionality");
        err.println("If no flight number is specified, then the flights from the source to the destination are printed");
        err.println("If a flight number is specified, then a new flight is added to an airline in the server");
        err.println();

        System.exit(1);
    }
}