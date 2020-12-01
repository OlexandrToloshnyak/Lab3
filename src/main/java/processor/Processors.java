package processor;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.util.Objects;
import java.io.Serializable;

public class Processors implements Serializable {

    /**
     * Клас в якому міститься інформація про центральний процесор дивайсу
     */
    private int Processor_id;
    private String Name;
    private Architectures Architecture;
    private lab2.processor.GPU Gpu;
    private String Producer;
    private Long Cores;
    private float Frequency;

    public Processors(int processor_id, String name, Architectures architecture, lab2.processor.GPU gpu, String producer, Long cores, float frequency) {
        Processor_id = processor_id;
        Name = name;
        Architecture = architecture;
        Gpu = gpu;
        Producer = producer;
        Cores = cores;
        Frequency = frequency;
    }

    @Override
    public String toString() {
        return "Processors{" +
                "Processor_id=" + Processor_id +
                ", Name='" + Name + '\'' +
                ", Architecture=" + Architecture +
                ", Gpu=" + Gpu +
                ", Producer='" + Producer + '\'' +
                ", Cores=" + Cores +
                ", Frequency=" + Frequency +
                '}';
    }


    public void toJson() {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        String json = gson.toJson(this);

        try (FileWriter file = new FileWriter("src/main/java/lab2/output/" + this.Producer +this.Name + ".json")) {

            file.write(json);
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Processors fromJson() {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        try {

            System.out.println("\nReading JSON from a file");
            System.out.println("----------------------------");

            BufferedReader br = new BufferedReader(
                    new FileReader("src/main/java/lab2/output/" + this.Producer + this.Name + ".json"));

            //convert the json string back to object
            Processors processorObj = gson.fromJson(br, Processors.class);
//            System.out.println(cameraObj.toString());
            return processorObj;
        } catch (IOException e) {
            e.printStackTrace();
            return this;
        }
    }

}
