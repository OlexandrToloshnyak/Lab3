package models.camera;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.util.Objects;
import java.io.Serializable;

public class Camera_module implements Serializable, Comparable <Camera_module> {
    /**
     * Клас в якому міститься інформація про модуль основної камери пристрою
     */
    private int Camera_id;
    private String Name;
    private String Type_of_lens;
    private String Producer;

    @Override
    public int compareTo(Camera_module o) {
        return Name.compareTo(o.Name);
    }

    public int getCamera_id() {
        return Camera_id;
    }

    public void setCamera_id(int camera_id) {
        Camera_id = camera_id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getType_of_lens() {
        return Type_of_lens;
    }

    public void setType_of_lens(String type_of_lens) {
        Type_of_lens = type_of_lens;
    }

    public String getProducer() {
        return Producer;
    }

    public void setProducer(String producer) {
        Producer = producer;
    }

    public static class Builder {
        private Camera_module newCamera;

        public Builder() {
            newCamera = new Camera_module();
        }

        public Builder withCamera_id(int id) {
            newCamera.Camera_id = id;
            return this;
        }

        public Builder withName(String Name) {
            newCamera.Name = Name;
            return this;
        }

        public Builder withType_of_lens(String Type) {
            newCamera.Type_of_lens = Type;
            return this;
        }

        public Builder withProducer(String Producer) {
            newCamera.Producer = Producer;
            return this;
        }

        public Camera_module build() {
            return newCamera;
        }
    }

    @Override
    public String toString() {
        return "Camera_module{" +
                "Camera_id=" + Camera_id +
                ", Name='" + Name + '\'' +
                ", Type_of_lens='" + Type_of_lens + '\'' +
                ", Producer='" + Producer + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Camera_module that = (Camera_module) o;
        return Camera_id == that.Camera_id &&
                Name.equals(that.Name) &&
                Type_of_lens.equals(that.Type_of_lens) &&
                Producer.equals(that.Producer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Camera_id, Name, Type_of_lens, Producer);
    }

    public void toJson() {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        String json = gson.toJson(this);

        try (FileWriter file = new FileWriter("src/main/java/lab2/output/" + this.Producer + this.Name + ".json")) {

            file.write(json);
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Camera_module fromJson() {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        try {

            System.out.println("\nReading JSON from a file");
            System.out.println("----------------------------");

            BufferedReader br = new BufferedReader(
                    new FileReader("src/main/java/lab2/output/" + this.Producer + this.Name + ".json"));

            //convert the json string back to object
            Camera_module cameraObj = gson.fromJson(br, Camera_module.class);
//            System.out.println(cameraObj.toString());
            return cameraObj;
        } catch (IOException e) {
            e.printStackTrace();
            return this;
        }
    }
}
