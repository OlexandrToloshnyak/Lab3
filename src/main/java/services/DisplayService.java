package services;

import display.Display;
import services.comporators.display.DisplayColorComparator;
import services.comporators.display.DisplaySrgbComparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class DisplayService {

    private List <Display> processorsList = new ArrayList<>();

    {
        processorsList.add(getValidDisplay(1,"green","FirstType","FirstResolution"));
        processorsList.add(getValidDisplay(2,"red","SecondType","SecondResolution"));
        processorsList.add(getValidDisplay(3,"blue","FirstType","FirstResolution"));
        processorsList.add(getValidDisplay(4,"blue","FirstType","SecondResolution"));
    }

    public Display getById(Long id) {
        return processorsList.stream()
                .filter(item -> item.getDisplay_id() == id)
                .findFirst()
                .orElse(null);
    }

    public List <Display> getByColor(String color) {
        return processorsList.stream()
                .filter(item -> item.getColor_certification().equals(color))
                .collect(Collectors.toList());
    }

    public List <Display> getByType(String Type) {
        return processorsList.stream()
                .filter(item -> item.getMatrix_type().equals(Type))
                .collect(Collectors.toList());
    }

    public List<Display> sortByDefault() {
        Collections.sort(processorsList);
        return processorsList;
    }

    public List<Display> sortByColor() {
        processorsList.sort(new DisplayColorComparator());
        return processorsList;
    }

    public List<Display> sortBySrgb() {
        processorsList.sort(new DisplaySrgbComparator());
        return processorsList;
    }

    public  Display getValidDisplay(int id, String color, String type, String resol){
        return new Display.Builder()
                .withDisplay_id(id)
                .withColor_certification(color)
                .withMatrix_type(type)
                .withResolution(resol)
                .withSRGB_coverage("coverage")
                .withTouch_surface(true)
                .build();
    }
}
