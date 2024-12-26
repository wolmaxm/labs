public class Selection_sort {
    public static void selectiosort(double[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[min]) {
                    min = j;

                }
            }
            double temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }
    }
    public static void main(String[] args) {
        double[] arr = {15.5, 4.6, 12.3, 3.3, 7.5};
        selectiosort(arr);
        System.out.println("Відсортований масив:");
        for (double num : arr) {
            System.out.print(num + " ");
        }
    }
}
