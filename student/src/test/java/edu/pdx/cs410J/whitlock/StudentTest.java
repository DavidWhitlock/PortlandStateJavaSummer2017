package edu.pdx.cs410J.whitlock;

import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.fail;

/**
 * Unit tests for the Student class.  In addition to the JUnit annotations,
 * they also make use of the <a href="http://hamcrest.org/JavaHamcrest/">hamcrest</a>
 * matchers for more readable assertion statements.
 */
public class StudentTest
{

  private Student getStudentNamed(String name) {
    return new Student(name, new ArrayList(), 0.0, "Doesn't matter");
  }

  @Test
  public void studentNamedPatIsNamedPat() {
    String name = "Pat";
    Student pat = getStudentNamed(name);
    assertThat(pat.getName(), equalTo(name));
  }

  @Test
  public void allStudentsSayThisClassIsTooMuchWork() {
    Student student = getStudentNamed("Name");
    assertThat(student.says(), equalTo("This class is too much work"));
  }

  @Test
  public void maleStudentHasMalePronoun() {
    Student male = getStudentWithGender("male");
    assertThat(male.toString(), containsString("He says"));
  }

  @Test
  public void femaleStudentHasFemalePronoun() {
    Student female = getStudentWithGender("female");
    assertThat(female.toString(), containsString("She says"));
  }

  private Student getStudentWithGender(String gender) {
    return new Student("name", new ArrayList(), 1.23, gender);
  }

  @Test
  public void studentWithUnknownGenderThrowsException() {
    String unknownGender = "unknown";
    Student unknown = getStudentWithGender(unknownGender);
    try {
      unknown.toString();
      fail("Should have thrown an UnknownGenderException");

    } catch (UnknownGenderException ex) {
      assertThat(ex.getUnknownGender(), equalTo(unknownGender));
    }
  }

}
