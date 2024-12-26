import java.util.Objects;

public class Devices {
    private final String cpu;
    private final String screen;

    public Devices(String cpu, String screen) {
        this.cpu = cpu;
        this.screen = screen;
    }

    public Devices() {
        this.cpu = "default cpu";
        this.screen = "default screen";
    }

    public String getCpu() {
        return cpu;
    }

    public String getScreen() {
        return screen;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Devices devices = (Devices) o;
        return Objects.equals(cpu, devices.cpu) && Objects.equals(screen, devices.screen);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cpu, screen);
    }

    @Override
    public String toString() {
        return "Devices{" +
                "cpu='" + cpu + '\'' +
                ", screen='" + screen + '\'' +
                '}';
    }

    public void start() {
        System.out.println("Start");
    }

    public void start(String mode) {
        System.out.println("Starting device in" + mode + " mode");
    }
}


