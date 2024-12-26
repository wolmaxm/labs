import java.util.Objects;

public class Tablet extends Devices {

    @Override
    public void start() {
        System.out.println("To start the tablet press the button on the side of the tablet");
    }

    public void start(String mode) {
        System.out.println("Starting device in " + mode + " mode");
    }

    private final String rear_camera;

    public Tablet(String cpu, String screen, String rear_camera) {
        super(cpu, screen);
        this.rear_camera = rear_camera;
    }

    public Tablet() {
        super();
        this.rear_camera = "default rear_camera";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Tablet tablet = (Tablet) o;
        return Objects.equals(rear_camera, tablet.rear_camera);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), rear_camera);
    }

    @Override
    public String toString() {
        return "Tablet{" +
                "rear_camera='" + rear_camera + '\'' +
                '}';
    }

    public String getRear_camera() {
        return rear_camera;
    }
}
