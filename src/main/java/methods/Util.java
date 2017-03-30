package methods;

import wrapper.RowTrainingPart;

import java.util.List;

/**
 * Created by stersteeg on 30/03/2017.
 */
public class Util {

    public static String timeToString(long millis) {
        String value = null;
        long second = (millis / 1000) % 60;
        long minute = (millis / (1000 * 60)) % 60;
        long hour = (millis / (1000 * 60 * 60)) % 24;
        if(hour > 0) {
            value = String.format("%02d:%02d:%02d.%d", hour, minute, second, millis % 1000);
        } else {
            value = String.format("%02d:%02d.%d", minute, second, millis % 1000);
        }
        return value.length() < 8 ? value + "\t" : value;
    }

    public static long getAvrangePace(List<RowTrainingPart> list) {
        double total = 0;
        for(RowTrainingPart p : list) {
            total += p.getAvrPace();
        }
        return (long) (total / list.size() + 0.5D);
    }
}
