package services.comporators.display;

import display.Display;

import java.util.Comparator;

public class DisplaySrgbComparator implements Comparator<Display> {

    @Override
    public int compare(Display o1, Display o2) {
        return o1.getsRGB_coverage().compareTo(o2.getsRGB_coverage());
    }
}
