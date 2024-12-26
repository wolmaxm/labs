import java.util.Objects;

public class PC extends Devices {

    private final String gpu;

    public PC(String cpu, String screen, String gpu) {
        super(cpu, screen);
        this.gpu = gpu;
    }

    public PC() {
        super();
        this.gpu = "default gpu";
    }




    @Override
    public void start() {
        System.out.println("To start the tablet press the button on the case");
    }

    public void start(String mode) {
        System.out.println("Starting device in " + mode + " mode");
    }




     public String getGpu() {
        return gpu;
    }





    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PC pc = (PC) o;
        return Objects.equals(gpu, pc.gpu);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), gpu);
    }

    @Override
    public String toString() {
        return "Pc{" +
                "gpu='" + gpu + '\'' +
                '}';
    }


}
