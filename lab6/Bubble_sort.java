public class Bubble_sort {
    public static void Bubblesort(double[] arr) {
        int n = arr.length;
        for (int i = 0 ; i < n-1 ; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    double temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
    public static void main(String[] args) {
        double[] arr = {15.5, 4.6, 12.3, 3.3, 7.5};

        Bubblesort(arr);
        System.out.println("Відсортований масив:");
        for (double num : arr) {
            System.out.print(num + " ");
        }
    }
}
