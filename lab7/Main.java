public class Main {
    public static void main(String[] args) {
        double[] arr = new double[] {15.5, 4.6, 12.3, 3.3, 7.5};
        notMain notMain = new notMain();

        notMain.setLab7(new bubbleSort());
        notMain.executelab7(arr);
        System.out.println("bubbleSort");
        selection(arr);

        notMain.setLab7(new selectionSort());
        notMain.executelab7(arr);
        System.out.println("selectionSort");
        selection(arr);

        notMain.setLab7(new insertionSort());
        notMain.executelab7(arr);
        System.out.println("insertionSort");
        selection(arr);
    }
    public static void selection(double[] arr){
    for (double num : arr) {
        System.out.print(num + " ");
    }
    System.out.println();
}
}
