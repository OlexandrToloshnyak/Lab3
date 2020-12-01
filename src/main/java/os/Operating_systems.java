package os;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.Objects;

public class Operating_systems implements Serializable, Comparable<Operating_systems> {
    /**
     * Клас в якому міститься інформація про операційну систему
     */
    private int OS_id;
    private String Name;
    private OS_types Type;
    private Accessibility accessibility;

    @Override
    public int compareTo(Operating_systems o) {
        return Name.compareTo(o.Name);
    }

    public int getOS_id() {
        return OS_id;
    }

    public String getName() {
        return Name;
    }

    public OS_types getType() {
        return Type;
    }

    public Accessibility getAccessibility() {
        return accessibility;
    }

    public void setOS_id(int OS_id) {
        this.OS_id = OS_id;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setType(OS_types type) {
        Type = type;
    }

    public void setAccessibility(Accessibility accessibility) {
        this.accessibility = accessibility;
    }






























    public Operating_systems(int OS_id, String name, OS_types type, Accessibility accessibility) {
        this.OS_id = OS_id;
        Name = name;
        Type = type;
        this.accessibility = accessibility;
    }

    @Override
    public String toString() {
        return "Operating_systems{" +
                "OS_id=" + OS_id +
                ", Name='" + Name + '\'' +
                ", Type=" + Type +
                ", accessibility=" + accessibility +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Operating_systems that = (Operating_systems) o;
        return OS_id == that.OS_id &&
                Name.equals(that.Name) &&
                Type == that.Type &&
                accessibility == that.accessibility;
    }

    @Override
    public int hashCode() {
        return Objects.hash(OS_id, Name, Type, accessibility);
    }

    public void toJson() {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        String json = gson.toJson(this);

        try (FileWriter file = new FileWriter("src/main/java/lab2/output/" + this.Name + ".json")) {

            file.write(json);
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Operating_systems fromJson() {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        try {

            System.out.println("\nReading JSON from a file");
            System.out.println("----------------------------");

            BufferedReader br = new BufferedReader(
                    new FileReader("src/main/java/lab2/output/" + this.Name + ".json"));

            //convert the json string back to object
            Operating_systems osObj = gson.fromJson(br, Operating_systems.class);
//            System.out.println(cameraObj.toString());
            return osObj;
        } catch (IOException e) {
            e.printStackTrace();
            return this;
        }
    }

}
