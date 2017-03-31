package wrapper;

import org.jetbrains.annotations.NotNull;
import org.omg.CORBA.portable.UnknownException;

/**
 * Created by stersteeg on 22/03/2017.
 */
public class RowTrainingPart implements Comparable<RowTrainingPart> {

    private int id;
    private long time;
    private long cumulative;
    private long movingTime;
    private int distance;
    private int strokeRate;
    private int maxStrokeRate;
    private double avrDisPerStroke;
    private long avrPace;
    private long avrMovingPace;
    private long bestPace;
    private int avrHeartRate;
    private int maxHeartRate;
    private int calories;


    public RowTrainingPart(String input) throws UnknownException {
        try {
            String[] values = input.split(",");
            id = Integer.parseInt(values[0]);
            time = stringToTime(values[1]);
            cumulative = stringToTime(values[2]);
            movingTime = stringToTime(values[3]);
            distance = Integer.parseInt(values[4]);
            strokeRate = Integer.parseInt(values[5]);
            maxStrokeRate = Integer.parseInt(values[6]);
            avrDisPerStroke = Double.parseDouble(values[7]);
            avrPace = stringToTime(values[8]);
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
        int index = 0;
        long time = 0;
        try {
            if(text.contains(".")) {
                int i = text.indexOf('.');
                time += Integer.parseInt(text.substring(i + 1, i + 2)) * 100;

            }

            if(text.split(":").length > 2) {
                if(text.charAt(1) == ':') {
                    time += Integer.parseInt(text.substring(index, index=+1)) * 3600000;
                } else {
                    time += Integer.parseInt(text.substring(index, index=+2)) * 3600000;
                }
                index++;
            }
            time += Integer.parseInt(text.substring(index, index+=2)) * 60000;
            time += Integer.parseInt(text.substring(index+=1, index+=2)) * 1000;


        } catch (Exception e) {
            //e.printStackTrace();
            //System.out.println("Error on:");
            //System.out.println(text);
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

    public long getAvrPace() {
        return avrPace;
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

    public int compareTo(@NotNull RowTrainingPart o) {
        return Long.compare(getAvrPace(), o.getAvrPace());
    }
}