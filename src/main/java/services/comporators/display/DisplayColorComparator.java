package services.comporators.display;

import display.Display;

import java.util.Comparator;

public class DisplayColorComparator implements Comparator <Display> {

    @Override
    public int compare(Display o1, Display o2) {
        return o1.getColor_certification().compareTo(o2.getColor_certification());
    }

}
