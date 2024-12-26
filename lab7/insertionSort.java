public class insertionSort implements lab7 {
    @Override
    public void Sorting(double[] array) {
        int n = array.length;
        for (int i = 1; i < n; ++i) {
            int key = (int) array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = key;

        }
    }
}
