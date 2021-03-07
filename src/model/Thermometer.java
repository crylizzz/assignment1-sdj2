package model;

public class Thermometer implements Runnable
{
    private double lastMeasuredTemperature;
    private double outdoorTemperature;
    private int heaterPower;
    private String thermometerId;
    private int distance;
    private boolean running;
    private Thread runningThread;

    public Thermometer(String thermometerId, double lastMeasuredTemperature, int distance)
    {
        this.thermometerId = thermometerId;
        this.lastMeasuredTemperature = lastMeasuredTemperature;
        this.distance = distance;
        this.heaterPower = 0;
        this.outdoorTemperature = 0.0;
    }

    @Override public void run()
    {
        running = true;
        runningThread = Thread.currentThread();
        while (running)
        {
            try
            {
                int seconds = (int) (Math.random() * 4 + 4);
                Thread.sleep(seconds * 1000);
                lastMeasuredTemperature = temperature(lastMeasuredTemperature, heaterPower, distance, outdoorTemperature, seconds);
                System.out.printf(thermometerId + " %.1f\n", lastMeasuredTemperature);
            }
            catch (InterruptedException e)
            {
                //
            }
        }
    }

    public void stop()
    {
        running = false;
        if (runningThread != null)
        {
            runningThread.interrupt();
        }
    }

    /**
     * Calculating the temperature measured in one of two locations.
     * This includes a term from a heater (depending on location and
     * heaters power), and a term from an outdoor heat loss.
     * Values are only valid in the outdoor temperature range [-20; 20]
     * and when s, the number of seconds between each measurements are
     * between 4 and 8 seconds.
     *
     * @param lastMeasuredTemperature  the last measured temperature
     * @param heaterPower  the heaters power {0, 1, 2 or 3} where 0 is turned off,
     *           1 is low, 2 is medium and 3 is high
     * @param distance  the distance between heater and measurements {1 or 7}
     *           where 1 is close to the heater and 7 is in the opposite corner
     * @param outdoorTemperature the outdoor temperature (valid in the range [-20; 20])
     * @param timeSinceLastMeasurement  the number of seconds since last measurement [4; 8]
     * @return the temperature
     */
    private double temperature(double lastMeasuredTemperature, int heaterPower, int distance, double outdoorTemperature, int timeSinceLastMeasurement)
    {
        double tMax = Math.min(11 * heaterPower + 10, 11 * heaterPower + 10 + outdoorTemperature);
        tMax = Math.max(Math.max(lastMeasuredTemperature, tMax), outdoorTemperature);
        double heaterTerm = 0;
        if (heaterPower > 0)
        {
            double den = Math.max((tMax * (20 - 5 * heaterPower) * (distance + 5)), 0.1);
            heaterTerm = 30 * timeSinceLastMeasurement * Math.abs(tMax - lastMeasuredTemperature) / den;
        }
        double outdoorTerm = (lastMeasuredTemperature - outdoorTemperature) * timeSinceLastMeasurement / 250.0;
        lastMeasuredTemperature = Math.min(Math.max(lastMeasuredTemperature - outdoorTerm + heaterTerm, outdoorTemperature), tMax);
        return lastMeasuredTemperature;
    }

}
