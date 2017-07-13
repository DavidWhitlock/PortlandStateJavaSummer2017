package edu.pdx.cs410J.fizzbuzz;

import edu.pdx.cs410J.InvokeMainTestCase;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * An integration test for the {@link FizzBuzzMain} main class.
 */
public class FizzBuzzMainIT extends InvokeMainTestCase {

    /**
     * Invokes the main method of {@link FizzBuzzMain} with the given arguments.
     */
    private MainMethodResult invokeMain(String... args) {
        return invokeMain( FizzBuzzMain.class, args );
    }

  @Test
  public void invokingMainMethodPrintFizzBuzz1to100() {
    MainMethodResult result = invokeMain();
    String out = result.getTextWrittenToStandardOut();
    String expected = "1\n" +
      "2\n" +
      "Fizz\n" +
      "4\n" +
      "Buzz\n" +
      "Fizz\n" +
      "7\n" +
      "8\n" +
      "Fizz\n" +
      "Buzz\n" +
      "11\n" +
      "Fizz\n" +
      "13\n" +
      "14\n" +
      "FizzBuzz\n" +
      "16\n" +
      "17\n" +
      "Fizz\n" +
      "19\n" +
      "Buzz";
    assertThat(out, containsString(expected));
  }
}