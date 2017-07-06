package edu.pdx.cs410J.whitlock;

import edu.pdx.cs410J.InvokeMainTestCase;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.StringContains.containsString;

/**
 * Integration tests for the <code>Student</code> class's main method.
 * These tests extend <code>InvokeMainTestCase</code> which allows them
 * to easily invoke the <code>main</code> method of <code>Student</code>.
 */
public class StudentIT extends InvokeMainTestCase {
  @Test
  public void invokingMainWithNoArgumentsHasExitCodeOf1() {
    InvokeMainTestCase.MainMethodResult result = invokeMain(Student.class);
    assertThat(result.getExitCode(), equalTo(1));
  }

  @Test
  public void invokingMainWithNoArgumentsPrintsMissingArgumentsToStandardError() {
    InvokeMainTestCase.MainMethodResult result = invokeMain(Student.class);
    assertThat(result.getTextWrittenToStandardError(), containsString("Missing command line arguments"));
  }

  @Test
  public void happyPathDaveStudentFromAssignment() {
    MainMethodResult result = invokeMain(Student.class, "Dave", "male", "3.64", "Algorithms", "Operating Systems", "Java");
    assertThat(result.getExitCode(), equalTo(0));

    String expected = "Dave has a GPA of 3.64 and is taking 3 classes: Algorithms, Operating " +
      "Systems, and Java.  He says \"This class is too much work\".\n";
    assertThat(result.getTextWrittenToStandardOut(), equalTo(expected));
    assertThat(result.getTextWrittenToStandardError(), equalTo(""));
  }

  @Test
  public void whenGpaIsNotADoubleExitsWithErrorMessageAndCode1() {
    String invalidGpa = "BAD!!";
    MainMethodResult result = invokeMain(Student.class, "Dave", "male", invalidGpa, "Algorithms", "Operating Systems", "Java");
    assertThat(result.getExitCode(), equalTo(1));
    assertThat(result.getTextWrittenToStandardError(), containsString(invalidGpa));
  }

  @Test
  public void missingGenderExitsWithErrorMessageAndCode1() {
    MainMethodResult result = invokeMain(Student.class, "Dave");
    assertThat(result.getExitCode(), equalTo(1));
    assertThat(result.getTextWrittenToStandardError(), containsString("Missing gender"));
  }

  @Test
  public void unknownGenderExitsWithErrorMessageAndCode1() {
    String unknownGender = "UNKNOWN";
    MainMethodResult result = invokeMain(Student.class, "Dave", unknownGender, "3.64", "Algorithms", "Operating Systems", "Java");
    assertThat(result.getExitCode(), equalTo(1));
    assertThat(result.getTextWrittenToStandardError(), containsString("Unknown gender: " + unknownGender));
  }

  @Test
  public void itsOkayToTakeZeroClasses() {
    MainMethodResult result = invokeMain(Student.class, "Dave", "male", "3.64");
    assertThat(result.getExitCode(), equalTo(0));

    String expected = "Dave has a GPA of 3.64 and is taking no classes.  He says \"This class is too much work\".\n";
    assertThat(result.getTextWrittenToStandardOut(), equalTo(expected));
    assertThat(result.getTextWrittenToStandardError(), equalTo(""));
  }

}
