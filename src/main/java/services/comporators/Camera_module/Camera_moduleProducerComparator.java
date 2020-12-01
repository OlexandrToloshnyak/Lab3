package services.comporators.Camera_module;

import models.camera.Camera_module;

import java.util.Comparator;

public class Camera_moduleProducerComparator implements Comparator<Camera_module> {

    @Override
    public int compare(Camera_module o1, Camera_module o2) {
        return o1.getProducer().compareTo(o2.getProducer());
    }
}
