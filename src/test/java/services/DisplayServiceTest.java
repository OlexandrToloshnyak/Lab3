package services;

import display.Display;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import services.DisplayService;

public class DisplayServiceTest {

    DisplayService service = new DisplayService();

    @Test
    public void findByIdTest() {
        Display expected = service.getValidDisplay(4,"blue","FirstType","SecondResolution");
        Assertions.assertEquals(service.getById(4L), expected);
    }

    @Test
    public void findByName() {
        Assertions.assertEquals(service.getByColor("blue").size(), 2);
    }

    @Test
    public void findByOS_type() {
        Assertions.assertEquals(service.getByType("FirstType").size(), 3);
    }

    @Test
    public void sortByColor() {
        System.out.println("sortByColor");
        service.sortByColor().forEach(System.out::println);
    }

    @Test
    public void sortByDefault() {
        System.out.println("sortByDefault");
        service.sortByDefault().forEach(System.out::println);
    }

    @Test
    public void sortBySrgb() {
        System.out.println("sortBySrgb");
        service.sortBySrgb().stream().forEach(System.out::println);
    }
}
