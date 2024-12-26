import java.util.Objects;

public class Laptop extends Devices {

    @Override
    public void start() {
        System.out.println("To start the laptop press the button next to the keyboard");
    }

    public void Start(String mode) {
        System.out.println("Starting device in " + mode + " mode");
    }

    private final String touchpad;

    public Laptop(String cpu, String screen, String touchpad) {
        super(cpu, screen);
        this.touchpad = touchpad;
    }

    public Laptop() {
        super();
        this.touchpad = "default touchpad";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Laptop laptop = (Laptop) o;
        return Objects.equals(touchpad, laptop.touchpad);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), touchpad);
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "touchpad='" + touchpad + '\'' +
                '}';
    }

    public String getTouchpad() {
        return touchpad;
    }
}
