package edu.pdx.cs410J.fizzbuzz;

public class FizzBuzz {

  static final String FIZZ = "Fizz";
  static final String BUZZ = "Buzz";
  static final String FIZZBUZZ = "FizzBuzz";


  public static String fizzBuzz(int number) {
    if (number % 15 == 0)
      return FIZZBUZZ;
    else if(number % 3 == 0) {
      return FIZZ;
    } else if (number % 5 == 0) {
      return BUZZ;
    } else {
      return String.valueOf(number);
    }
  }
}
