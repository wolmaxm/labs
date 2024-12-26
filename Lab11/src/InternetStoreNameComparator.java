import java.util.Comparator;

public class InternetStoreNameComparator implements Comparator<InternetStore> {
    @Override
    public int compare(InternetStore store1, InternetStore store2) {
        return store1.getStoreName().compareToIgnoreCase(store2.getStoreName());
    }
}