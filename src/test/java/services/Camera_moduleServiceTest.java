package services;

import models.camera.Camera_module;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import services.Camera_moduleService;

public class Camera_moduleServiceTest {

    Camera_moduleService service = new Camera_moduleService();

    @Test
    public void findByIdTest() {
        Camera_module expected = service.getValidCamera_module(1, "FirstName", "First_type_of_lens", "FirstProducer");
        Assertions.assertEquals(service.getById(1L), expected);
    }

    @Test
    public void findByName() {
        Assertions.assertEquals(service.getByName("FirstName").size(), 3);
    }

    @Test
    public void findByOS_type() {
        Assertions.assertEquals(service.getByType_of_lens("Second_type_of_lens").size(), 2);
    }

    @Test
    public void sortByName() {
        System.out.println("sortByName");
        service.sortByName().forEach(System.out::println);
    }

    @Test
    public void sortByProducer() {
        System.out.println("sortByProducer");
        service.sortByProducer().forEach(System.out::println);
    }

    @Test
    public void sortByType_of_lens() {
        System.out.println("sortByType_of_lens");
        service.sortByType_of_lens().forEach(System.out::println);
    }
}
