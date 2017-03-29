package wrapper;

import org.omg.CORBA.portable.UnknownException;

import java.text.SimpleDateFormat;

/**
 * Created by stersteeg on 22/03/2017.
 */
public class RowTraining {

    private int id;
    private long time;
    private long cumulative;
    private long movingTime;
    private int distance;
    private int strokeRate;
    private int maxStrokeRate;
    private double avrDisPerStroke;
    private long avrPage;
    private long avrMovingPace;
    private long bestPace;
    private int avrHeartRate;
    private int maxHeartRate;
    private int calories;


    public RowTraining(String input) throws UnknownException {
        try {
            String[] values = input.split("," );
            id = Integer.parseInt(values[0]);
            time = stringToTime(values[1]);
            cumulative = stringToTime(values[2]);
            movingTime = stringToTime(values[3]);
            distance = Integer.parseInt(values[4]);
            strokeRate = Integer.parseInt(values[5]);
            maxStrokeRate = Integer.parseInt(values[6]);
            avrDisPerStroke = Double.parseDouble(values[7]);
            avrPage = stringToTime(values[8]);
            avrMovingPace = stringToTime(values[9]);
            bestPace = stringToTime(values[10]);
            avrHeartRate = Integer.parseInt(values[11]);
            maxHeartRate = Integer.parseInt(values[12]);
            calories = Integer.parseInt(values[13]);

        } catch (Exception e) {
            //e.printStackTrace();
            throw new UnknownException(e);
        }
    }

    private static long stringToTime(String text) {
        long time = 0;
        time += Integer.parseInt(text.substring(0, 2)) * 60000;
        time += Integer.parseInt(text.substring(3, 5)) * 1000;
        if(text.length() > 5) {
            time += Integer.parseInt(text.substring(6, 7)) * 100;
        }
        return time;
    }

    public int getId() {
        return id;
    }

    public long getTime() {
        return time;
    }

    public long getCumulative() {
        return cumulative;
    }

    public long getMovingTime() {
        return movingTime;
    }

    public int getDistance() {
        return distance;
    }

    public int getStrokeRate() {
        return strokeRate;
    }

    public int getMaxStrokeRate() {
        return maxStrokeRate;
    }

    public double getAvrDisPerStroke() {
        return avrDisPerStroke;
    }

    public RowTraining(int id) {
        this.id = id;
    }

    public long getAvrPage() {
        return avrPage;
    }

    public long getAvrMovingPace() {
        return avrMovingPace;
    }

    public long getBestPace() {
        return bestPace;
    }

    public int getAvrHeartRate() {
        return avrHeartRate;
    }

    public int getMaxHeartRate() {
        return maxHeartRate;
    }

    public int getCalories() {
        return calories;
    }
}