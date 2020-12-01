package services.comporators.Operating_systems;

import os.Operating_systems;

import java.util.Comparator;

public class Operating_systemsTypeComporator implements Comparator <Operating_systems> {

    @Override
    public int compare(Operating_systems o1, Operating_systems o2) {
        return o1.getType().name().compareTo(o2.getType().name());
    }
}
