import java.util.Arrays;

public class BrickSorter extends MeasureSorter {
    public BrickSorter(String fileName) throws Exception {
        super(fileName);
    }

    public void sortMe() {
        boolean isSorted = false;
        System.out.println(Arrays.toString(measures));
        while (!isSorted) {
            isSorted = true;
            for (int i = 1; i < measures.length - 1; i+=2)  {
                if (measures[i].compareTo(measures[i + 1]) > 0) {
                    swap(i, i + 1);
                    isSorted=false;
                }
            }
            for (int i = 0; i < measures.length - 1; i+=2)  {
                if (measures[i].compareTo(measures[i + 1]) > 0) {
                    swap(i, i + 1);
                    isSorted=false;
                }
            }
            System.out.println(Arrays.toString(measures));
        }

    }
}
