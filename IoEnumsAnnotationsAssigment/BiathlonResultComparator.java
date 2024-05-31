package IoEnumsAnnotationsAssigment;

import java.util.Comparator;

public class BiathlonResultComparator implements Comparator<BiathlonResult> {
    @Override
    public int compare(BiathlonResult o1, BiathlonResult o2) {
        return o1.calculateFinalTime().compareTo(o2.calculateFinalTime());

        //o1<o2 rez < 0
        // o1=o2 rez 0
        // o1>o2 rez > 0
    }
}

