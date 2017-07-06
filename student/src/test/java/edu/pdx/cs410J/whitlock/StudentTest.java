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
    return new Student(name, new ArrayList(), 0.0, Student.MALE);
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
    Student male = getStudentWithGender(Student.MALE);
    assertThat(male.toString(), containsString("He says"));
  }

  @Test
  public void femaleStudentHasFemalePronoun() {
    Student female = getStudentWithGender(Student.FEMALE);
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

  @Test
  public void toStringContainsSaysThisClassIsTooMuchWork() {
    Student student = getStudentWithGender(Student.FEMALE);
    assertThat(student.toString(), containsString("says \"This class is too much work\"."));
  }

  @Test
  public void nameOfStudentIsInToString() {
    String name = "Dave";
    Student dave = getStudentNamed(name);
    assertThat(dave.toString(), containsString(name));
  }

  @Test
  public void gpaOfStudentIsInToString() {
    double gpa = 3.45;
    Student student = new Student("name", new ArrayList(), gpa, Student.FEMALE);
    assertThat(student.toString(), containsString("has a GPA of " + gpa));
  }
}
