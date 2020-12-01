package services;

import os.Accessibility;
import os.OS_types;
import os.Operating_systems;
import services.comporators.Operating_systems.Operating_systemsAccessibilityComparator;
import services.comporators.Operating_systems.Operating_systemsTypeComporator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Operating_systemsService {

    private List<Operating_systems> operating_systemsList = new ArrayList<>();

    {
        operating_systemsList.add(getValidOperating_systems(1,"firstName",OS_types.Hybrid, Accessibility.Paid));
        operating_systemsList.add(getValidOperating_systems(2,"firstName",OS_types.Monolithic, Accessibility.Free));
        operating_systemsList.add(getValidOperating_systems(3,"seconsName",OS_types.Hybrid, Accessibility.Free));
        operating_systemsList.add(getValidOperating_systems(4,"firstName",OS_types.Monolithic, Accessibility.Paid));
    }

    public Operating_systems getById(Long id) {
        return operating_systemsList.stream()
                .filter(item -> item.getOS_id() == id)
                .findFirst()
                .orElse(null);
    }

    public List <Operating_systems> getByName(String name) {
        return operating_systemsList.stream()
                .filter(item -> item.getName().equals(name))
                .collect(Collectors.toList());
    }

    public List <Operating_systems> getByOS_type(OS_types type) {
        return operating_systemsList.stream()
                .filter(item -> item.getType().equals(type))
                .collect(Collectors.toList());
    }

    public List<Operating_systems> sortByDefault() {
        Collections.sort(operating_systemsList);
        return operating_systemsList;
    }

    public List<Operating_systems> sortByType() {
        operating_systemsList.sort(new Operating_systemsTypeComporator());
        return operating_systemsList;
    }

    public List<Operating_systems> sortByAccessibility() {
        operating_systemsList.sort(new Operating_systemsAccessibilityComparator());
        return operating_systemsList;
    }

    public Operating_systems getValidOperating_systems(int id, String name, OS_types type, Accessibility accessibility) {
        return new Operating_systems(id, name, type, accessibility);
    }
}
