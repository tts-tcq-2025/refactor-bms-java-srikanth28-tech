package vitals;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;


public class VitalsCheckerTest {

  @Test
  public void testNotOkWhenAnyVitalIsOffRange() throws InterruptedException {
    assertFalse(VitalsChecker.vitalsOk(99f, 102, 70));
    assertTrue(VitalsChecker.vitalsOk(98.1f, 70, 98));
  }
  @Test
  public void testTemperatureOutOfRange() throws InterruptedException {
    assertFalse(VitalsChecker.vitalsOk(103f, 75, 95)); // High temp
    assertFalse(VitalsChecker.vitalsOk(94f, 75, 95));  // Low temp
  }

  @Test
  public void testPulseRateOutOfRange() throws InterruptedException {
    assertFalse(VitalsChecker.vitalsOk(98f, 55, 95));  // Low pulse
    assertFalse(VitalsChecker.vitalsOk(98f, 105, 95)); // High pulse
  }

  @Test
  public void testSpo2OutOfRange() throws InterruptedException {
    assertFalse(VitalsChecker.vitalsOk(98f, 75, 85));  // Low SpO2
  }
}

