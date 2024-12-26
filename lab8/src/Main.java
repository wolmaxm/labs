public class Main   {

      public static void main(String[] args) {
        Devices device1 = new Laptop("Intel i7", "2K", "built-in");
        Devices device2 = new PC("Intel i9", "4K", "RTX 4060");
        Devices device3 = new Tablet("Qualcomm Snapdragon 695", "FHD", "12MP");

        Devices device4 = new Laptop("Intel i7", "2K", "built-in");

        Devices device5 = new Laptop();
        Devices device6 = new PC();
        Devices device7 = new Tablet();

        device1.start();
        device2.start();
        device3.start();

        System.out.println("----------------------------------------------------------------------------------------------------");

        device5.start("Eco");
        device6.start("Perfomance");
        device7.start("Balance");

        System.out.println("----------------------------------------------------------------------------------------------------");

        System.out.println("device1 equals device4 " + device1.equals(device4));
        System.out.println("device1 equals device2 " + device1.equals(device2));

        System.out.println(device1);
        System.out.println(device2);
        System.out.println(device3);

        System.out.println("Laptop CPU: " + device1.getCpu());
        System.out.println("Laptop Screen: " + device1.getScreen());
        System.out.println("Laptop Touchpad: " + ((Laptop) device1).getTouchpad());

        System.out.println("PC CPU: " + device2.getCpu());
        System.out.println("PC Screen: " + device2.getScreen());
        System.out.println("PC Touchpad: " + ((PC) device2).getGpu());

        System.out.println("Tablet CPU: " + device3.getCpu());
        System.out.println("Tablet Screen: " + device3.getScreen());
        System.out.println("Tablet Touchpad: " + ((Tablet) device3).getRear_camera());
    }




}
