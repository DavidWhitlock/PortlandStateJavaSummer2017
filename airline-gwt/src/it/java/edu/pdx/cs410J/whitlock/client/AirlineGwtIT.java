package edu.pdx.cs410J.whitlock.client;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.NativeEvent;
import com.google.gwt.event.dom.client.DomEvent;
import com.google.gwt.junit.client.GWTTestCase;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.Button;
import org.junit.Test;

/**
 * An integration test for the airline GWT UI.  Remember that GWTTestCase is JUnit 3 style.
 * So, test methods names must begin with "test".
 * And since this test code is compiled into JavaScript, you can't use hamcrest matchers.  :(
 */
public class AirlineGwtIT extends GWTTestCase {
  @Override
  public String getModuleName() {
    return "edu.pdx.cs410J.whitlock.AirlineIntegrationTests";
  }

  @Test
  public void testClickingShowAirlineButtonDisplaysPrettyAirline() {
    final String airlineName = "My Airline";

    final AirlineGwt ui = new AirlineGwt();
    ui.onModuleLoad();

    // Wait for UI widgets to be created
    waitBeforeRunning(500, new Runnable() {
      @Override
      public void run() {
        ui.airlineName.setText(airlineName);
        click(ui.showAirlineButton);
      }
    });

    // Wait for the RPC call to return
    waitBeforeRunning(500, new Runnable() {
      @Override
      public void run() {
        String pretty = ui.airlinePrettyText.getText();
        assertNotNull(pretty);
        assertTrue(pretty, pretty.contains(airlineName));
        finishTest();
      }
    });

    delayTestFinish(1000);
  }

  private void waitBeforeRunning(int delayMillis, final Runnable operation) {
    Timer click = new Timer() {
      @Override
      public void run() {
        operation.run();
      }
    };
    click.schedule(delayMillis);
  }

  /**
   * Clicks a <code>Button</code>
   *
   * One would think that you could testing clicking a button with Button.click(), but it looks
   * like you need to fire the native event instead.  Lame.
   *
   * @param button
   *        The button to click
   */
  private void click(final Button button) {
    assertNotNull("Button is null", button);
    NativeEvent event = Document.get().createClickEvent(0, 0, 0, 0, 0, false, false, false, false);
    DomEvent.fireNativeEvent(event, button);
  }

  private class CapturingAlerter implements AirlineGwt.Alerter {
    private String message;

    @Override
    public void alert(String message) {
      this.message = message;
    }

    public String getMessage() {
      return message;
    }
  }
}
