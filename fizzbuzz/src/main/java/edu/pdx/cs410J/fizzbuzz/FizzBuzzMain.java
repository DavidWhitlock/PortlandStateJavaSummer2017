package edu.pdx.cs410J.fizzbuzz;

/**
 * The main class for the CS410J airline Project
 */
public class FizzBuzzMain {

  public static void main(String[] args) {
    for(int i = 1; i <= 100; i++)
    {
      System.out.println(FizzBuzz.fizzBuzz(i));
    }
  }

}