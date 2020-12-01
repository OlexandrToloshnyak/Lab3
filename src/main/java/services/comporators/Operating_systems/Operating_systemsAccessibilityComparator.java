package services.comporators.Operating_systems;

import os.Operating_systems;

import java.util.Comparator;

public class Operating_systemsAccessibilityComparator implements Comparator <Operating_systems> {
    @Override
    public int compare(Operating_systems o1, Operating_systems o2) {
        return o1.getAccessibility().name().compareTo(o2.getAccessibility().name());
    }
}
