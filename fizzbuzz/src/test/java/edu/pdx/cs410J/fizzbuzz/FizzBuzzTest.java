package edu.pdx.cs410J.fizzbuzz;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

/**
 * Unit tests for the {@link FizzBuzz} class.
 */
public class FizzBuzzTest {

  private void assertThatFizzBuzzOfNumberEquals(int number, String expected) {
    assertThat(FizzBuzz.fizzBuzz(number), equalTo(expected));
  }

  @Test
  public void fizzBuzzOf1Is1() {
    assertThatFizzBuzzOfNumberEquals(1, "1");
  }

  @Test
  public void fizzBuzzOf3isFizzI() {
    assertThatFizzBuzzOfNumberEquals(3, FizzBuzz.FIZZ);
  }

  @Test
  public void fizzBuzzOf5IsBuzz() {
    assertThatFizzBuzzOfNumberEquals(5, FizzBuzz.BUZZ);
  }

  @Test
   public void fizzBuzzOf15IsFizzBuzz() {
     assertThatFizzBuzzOfNumberEquals(15, FizzBuzz.FIZZBUZZ);
   }
}
