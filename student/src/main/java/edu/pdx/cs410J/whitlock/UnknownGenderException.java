package edu.pdx.cs410J.whitlock;

public class UnknownGenderException extends RuntimeException {
  private final String unknownGender;

  public UnknownGenderException(String unknownGender) {
    this.unknownGender = unknownGender;
  }

  public String getUnknownGender() {
    return unknownGender;
  }
}
