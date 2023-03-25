import java.util.Arrays;

public class InsertionSorter extends MeasureSorter {
    public InsertionSorter(String filename) throws Exception {
        super(filename);
    }

    public void sortMe() {
        System.out.println(Arrays.toString(measures));
        for (int i = 1; i < measures.length; i++) {
            int j = i;
            while (j > 0 && measures[j].compareTo(measures[j - 1]) == -1) {
                swap(j, j - 1);
                j--;
            }
            System.out.println(Arrays.toString(measures));
        }
    }

}
