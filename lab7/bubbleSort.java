public class bubbleSort implements lab7 {
    @Override
    public void Sorting(double[] arr) {
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
}