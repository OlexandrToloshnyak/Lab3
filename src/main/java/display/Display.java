package display;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;
import java.io.Serializable;

public class Display implements Serializable, Comparable < Display > { // added   Comparable < Display >
    /**
     * Клас в якому міститься інформація про дисплей
     */
    private int Display_id;
    private String Matrix_type;
    private String Resolution;
    private boolean Touch_surface;
    private String Color_certification;
    private String sRGB_coverage;

    @Override
    public int compareTo(Display o) {
        return Matrix_type.compareTo(o.Matrix_type);
    }

    public int getDisplay_id() {
        return Display_id;
    }

    public String getMatrix_type() {
        return Matrix_type;
    }

    public String getResolution() {
        return Resolution;
    }

    public boolean isTouch_surface() {
        return Touch_surface;
    }

    public String getColor_certification() {
        return Color_certification;
    }

    public String getsRGB_coverage() {
        return sRGB_coverage;
    }


































    public static class Builder {
        private Display newDisplay;

        public Builder() {
            newDisplay = new Display();
        }

        public Builder withDisplay_id(int id) {
            newDisplay.Display_id = id;
            return this;
        }

        public Builder withMatrix_type(String Name) {
            newDisplay.Matrix_type = Name;
            return this;
        }

        public Builder withResolution(String Resolution) {
            newDisplay.Resolution = Resolution;
            return this;
        }

        public Builder withTouch_surface(boolean Touch) {
            newDisplay.Touch_surface = Touch;
            return this;
        }

        public Builder withColor_certification(String Color) {
            newDisplay.Color_certification = Color;
            return this;
        }

        public Builder withSRGB_coverage(String Percentage) {
            newDisplay.sRGB_coverage = Percentage;
            return this;
        }

        public Display build() {
            return newDisplay;
        }
    }

    @Override
    public String toString() {
        return "Display{" +
                "Display_id=" + Display_id +
                ", Matrix_type='" + Matrix_type + '\'' +
                ", Resolution='" + Resolution + '\'' +
                ", Touch_surface=" + Touch_surface +
                ", Color_certification='" + Color_certification + '\'' +
                ", sRGB_coverage='" + sRGB_coverage + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Display display = (Display) o;
        return Display_id == display.Display_id &&
                Touch_surface == display.Touch_surface &&
                Matrix_type.equals(display.Matrix_type) &&
                Resolution.equals(display.Resolution) &&
                Objects.equals(Color_certification, display.Color_certification) &&
                sRGB_coverage.equals(display.sRGB_coverage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Display_id, Matrix_type, Resolution, Touch_surface, Color_certification, sRGB_coverage);
    }

    public void toJson() {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        String json = gson.toJson(this);

        try (FileWriter file = new FileWriter("src/main/java/lab2/output/display" + this.Display_id + ".json")) {

            file.write(json);
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Display fromJson() {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        try {

            System.out.println("\nReading JSON from a file");
            System.out.println("----------------------------");

            BufferedReader br = new BufferedReader(
                    new FileReader("src/main/java/lab2/output/display" + this.Display_id + ".json"));

            //convert the json string back to object
            Display displayObj = gson.fromJson(br, Display.class);
//            System.out.println(cameraObj.toString());
            return displayObj;
        } catch (IOException e) {
            e.printStackTrace();
            return this;
        }
    }
}
