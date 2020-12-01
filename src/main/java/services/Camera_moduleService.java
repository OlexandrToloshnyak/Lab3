package services;

import models.camera.Camera_module;
import services.comporators.Camera_module.Camera_moduleProducerComparator;
import services.comporators.Camera_module.Camera_moduleTypeOfLensComparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Camera_moduleService {

    private List<Camera_module> camera_modules = new ArrayList<>();

    {
        camera_modules.add(getValidCamera_module(1, "FirstName", "First_type_of_lens", "FirstProducer"));
        camera_modules.add(getValidCamera_module(2, "FirstName", "Second_type_of_lens", "SecondProducer"));
        camera_modules.add(getValidCamera_module(3, "SecondName", "First_type_of_lens", "FirstProducer"));
        camera_modules.add(getValidCamera_module(4, "FirstName", "Second_type_of_lens", "FirstProducer"));
    }

    public Camera_module getById(Long id) {
        return camera_modules.stream()
                .filter(item -> item.getCamera_id() == id)
                .findFirst()
                .orElse(null);
    }

    public List<Camera_module> getByName(String name) {
        return camera_modules.stream()
                .filter(item -> item.getName().equals(name))
                .collect(Collectors.toList());
    }

    public List<Camera_module> getByType_of_lens(String type_of_lens) {
        return camera_modules.stream()
                .filter(item -> item.getType_of_lens().equals(type_of_lens))
                .collect(Collectors.toList());
    }

    public List<Camera_module> sortByName() {
        Collections.sort(camera_modules);
        return camera_modules;
    }

    public List<Camera_module> sortByProducer() {
        camera_modules.sort(new Camera_moduleProducerComparator());
        return camera_modules;
    }

    public List<Camera_module> sortByType_of_lens() {
        camera_modules.sort(new Camera_moduleTypeOfLensComparator());
        return camera_modules;
    }

    public Camera_module getValidCamera_module(int camera_id, String name, String type_of_lens, String producer) {
        return new Camera_module.Builder()
                .withCamera_id(camera_id)
                .withName(name)
                .withType_of_lens(type_of_lens)
                .withProducer(producer)
                .build();
    }
}
