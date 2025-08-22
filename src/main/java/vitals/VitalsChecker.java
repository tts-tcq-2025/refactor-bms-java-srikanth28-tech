package vitals;


public abstract class VitalsChecker {

  public static boolean vitalsOk(float temperature, float pulseRate, float spo2) throws InterruptedException {
    boolean tempOk = isTemperatureOk(temperature);
    boolean pulseOk = isPulseRateOk(pulseRate);
    boolean spo2Ok = isSpo2Ok(spo2);

    if (!tempOk) {
      showWarning("Temperature is critical!");
    } else if (!pulseOk) {
        showWarning("Pulse Rate is critical!");
    } else if (!spo2Ok) {
      showWarning("Oxygen Saturation out of range!");
    }

    return tempOk && pulseOk && spo2Ok;
  }

  // Pure functions
  public static boolean isTemperatureOk(float temperature) {
    return temperature >= 95 && temperature <= 102;
  }

  public static boolean isPulseRateOk(float pulseRate) {
    return pulseRate >= 60 && pulseRate <= 100;
  }

  public static boolean isSpo2Ok(float spo2) {
    return spo2 >= 90;
  }

  // I/O separated
  private static void showWarning(String message) throws InterruptedException {
    System.out.println(message);
    blinkWarning();
  }

  private static void blinkWarning() throws InterruptedException {
    for (int i = 0; i < 6; i++) {
      System.out.print("\r* ");
      Thread.sleep(1000);
      System.out.print("\r *");
      Thread.sleep(1000);
    }
    System.out.println(); // Clean newline after blinking
  }
}
