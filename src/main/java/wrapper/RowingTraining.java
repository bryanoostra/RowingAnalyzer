package wrapper;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import methods.Util;

/**
 * Created by stersteeg on 29/03/2017.
 */
public class RowingTraining {

    private final String name;
    private final List<RowTrainingPart> parts = new LinkedList<RowTrainingPart>();

    public RowingTraining(String name) {
        this.name = name;
    }

    public boolean add(RowTrainingPart part) {
        return parts.add(part);
    }

    @Override
    public String toString() {
        return "Training on: " + this.name + ", " + parts.size() + " records";
    }

    public List<RowTrainingPart> getParts(int minStrokeRate, int maxStrokeRate) {
        List<RowTrainingPart> list = new LinkedList<RowTrainingPart>();
        for(RowTrainingPart part : parts) {
            if(part.getStrokeRate() >= minStrokeRate && part.getStrokeRate() < maxStrokeRate) {
                list.add(part);
            }
        }
        return list;
    }

    public long getPaceForBin(int minStrokeRate, int maxStrokeRate) {
        List<RowTrainingPart> list = getParts(minStrokeRate, maxStrokeRate);
        Collections.sort(list);
        int middle = list.size() / 2;
        long minAvr = Util.getAvrangePace(list.subList(0, middle));
        long maxAvr = Util.getAvrangePace(list.subList(middle, list.size()));
        return (int) ((3 * maxAvr + minAvr) / 4D);
    }
}
