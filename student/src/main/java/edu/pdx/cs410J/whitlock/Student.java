package edu.pdx.cs410J.whitlock;

import edu.pdx.cs410J.lang.Human;

import java.util.List;

/**                                                                                 
 * This class is represents a <code>Student</code>.                                 
 */                                                                                 
public class Student extends Human {

  static final String MALE = "male";
  static final String FEMALE = "female";
  private final String gender;
  private final double gpa;
  private final List<String> classes;

  /**
   * Creates a new <code>Student</code>                                             
   *                                                                                
   * @param name                                                                    
   *        The student's name                                                      
   * @param classes                                                                 
   *        The names of the classes the student is taking.  A student              
   *        may take zero or more classes.                                          
   * @param gpa                                                                     
   *        The student's grade point average                                       
   * @param gender                                                                  
   *        The student's gender ("male" or "female", case insensitive)             
   */                                                                               
  public Student(String name, List<String> classes, double gpa, String gender) {
    super(name);

    this.gender = gender;
    this.gpa = gpa;
    this.classes = classes;
  }

  /**                                                                               
   * All students say "This class is too much work"
   */
  @Override
  public String says() {                                                            
    return "This class is too much work";
  }
                                                                                    
  /**                                                                               
   * Returns a <code>String</code> that describes this                              
   * <code>Student</code>.                                                          
   */                                                                               
  public String toString() {
    return this.name + " has a GPA of " + this.gpa + " and is taking " +
      getNumberOfClasses() + ".  " +
      getGenderPronoun() + " says \"" + says() + "\".";
  }

  private String getNumberOfClasses() {
    if (this.classes.isEmpty()) {
      return "no classes";

    } else if (this.classes.size() == 1) {
      return "1 class: " + this.classes.get(0);

    } else {
      String phrase = this.classes.size() + " classes: ";

      if (this.classes.size() == 2) {
        phrase += this.classes.get(0) + " and " + this.classes.get(1);

      } else {
        for (int i = 0; i < classes.size() - 1; i++) {
          String className = classes.get(i);
          phrase += className;
          phrase += ", ";
        }

        phrase += "and " + classes.get(classes.size() - 1);
      }

      return phrase;
    }
  }

  private String getGenderPronoun() {
    switch (this.gender) {
      case MALE:
        return "He";

      case FEMALE:
        return "She";

      default:
        throw new UnknownGenderException(this.gender);
    }
  }

  /**
   * Main program that parses the command line, creates a
   * <code>Student</code>, and prints a description of the student to
   * standard out by invoking its <code>toString</code> method.
   */
  public static void main(String[] args) {
    System.err.println("Missing command line arguments");
    System.exit(1);
  }
}