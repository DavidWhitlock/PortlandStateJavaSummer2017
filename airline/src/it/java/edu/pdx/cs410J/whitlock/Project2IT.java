package edu.pdx.cs410J.whitlock;

import edu.pdx.cs410J.InvokeMainTestCase;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.io.*;
import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * An integration test that demonstrates the expected behavior of
 * creating a new airline file.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Project2IT extends InvokeMainTestCase {

  private static File airlineFile;

  @BeforeClass
  public static void createTempDirectoryForAirlineFile() throws IOException {
    File tmpDirectory = new File(System.getProperty("java.io.tmpdir"));
    airlineFile = new File(tmpDirectory, "airline.txt");
  }

  @AfterClass
  public static void deleteTempDirectoryForAirlineFile() {
    if (airlineFile.exists()) {
      assertTrue(airlineFile.delete());
    }
  }

  private MainMethodResult invokeProject2(String... args) {
    return invokeMain(Project2.class, args);
  }

  private String readFile(File file) throws FileNotFoundException {
    BufferedReader br = new BufferedReader(new FileReader(file));
    StringBuilder sb = new StringBuilder();
    Stream<String> lines = br.lines();
    lines.forEach(line -> {
      sb.append(line).append("\n");
    });

    return sb.toString();
  }

  @Test
  public void test1CreateNewAirlineFileWhenFileDoesNotExist() throws FileNotFoundException {
    assertThat(airlineFile.exists(), equalTo(false));

    MainMethodResult result =
      invokeProject2("-textFile", airlineFile.getAbsolutePath(), "MyAirline",
        "123", "PDX", "7/16/2017 15:00", "LAX", "7/16/2017", "18:00");
    assertThat(result.getExitCode(), equalTo(0));

    String fileContents = readFile(airlineFile);
    assertThat(fileContents, containsString("123"));
  }

  @Test
  public void test2AddFlightToExistingAirlineFile() throws FileNotFoundException {
    assertThat(airlineFile.exists(), equalTo(true));

    MainMethodResult result =
      invokeProject2("-textFile", airlineFile.getAbsolutePath(), "MyAirline",
        "234", "PDX", "7/17/2017 15:00", "LAX", "7/17/2017", "18:00");
    assertThat(result.getExitCode(), equalTo(0));

    String fileContents = readFile(airlineFile);
    assertThat(fileContents, containsString("123"));
    assertThat(fileContents, containsString("234"));
  }
}
