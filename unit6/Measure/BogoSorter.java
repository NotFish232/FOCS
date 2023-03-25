import java.util.Arrays;
import java.util.Collections;
public class BogoSorter extends MeasureSorter {
    public BogoSorter(String fileName) throws Exception{
        super(fileName);
    }
    private boolean isSorted() {
        for (int i=1;i<measures.length;i++) {
            if (measures[i].compareTo(measures[i-1])<0) return false;
        }
        return true;
    }
    public void sortMe() {
        
        while (!isSorted()) {
            System.out.println(Arrays.toString(measures));
            Collections.shuffle(Arrays.asList(measures));
        }
        System.out.println(Arrays.toString(measures));
    }
}

