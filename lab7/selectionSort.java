public class selectionSort implements lab7 {
    @Override
    public void Sorting(double[] arr) {
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
}