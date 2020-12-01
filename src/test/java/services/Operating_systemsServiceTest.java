package services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import os.Accessibility;
import os.OS_types;
import os.Operating_systems;
import services.Operating_systemsService;

public class Operating_systemsServiceTest {

    Operating_systemsService service = new Operating_systemsService();

    @Test
    public void findByIdTest() {
        Operating_systems expected = service.getValidOperating_systems(3,"seconsName", OS_types.Hybrid, Accessibility.Free);
        Assertions.assertEquals(service.getById(3L), expected);
    }

    @Test
    public void findByName() {
        Assertions.assertEquals(service.getByName("firstName").size(), 3);
    }

    @Test
    public void findByOS_type() {
        Assertions.assertEquals(service.getByOS_type(OS_types.Hybrid).size(), 2);
    }

    @Test
    public void sortByAccessibility() {
        System.out.println("sortByAccessibility");
        service.sortByAccessibility().forEach(System.out::println);
    }

    @Test
    public void sortByDefault() {
        System.out.println("sortByDefault");
        service.sortByDefault().forEach(System.out::println);
    }

    @Test
    public void sortByType() {
        System.out.println("sortByType");
        service.sortByType().forEach(System.out::println);
    }

}
