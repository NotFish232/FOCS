import java.util.Arrays;
public class GnomeSorter extends MeasureSorter{
    public GnomeSorter(String fileName) throws Exception{
        super(fileName);
    }
    public void sortMe() {
        int i=0;
        while (i<measures.length) {
            System.out.println(Arrays.toString(measures));
            if (i==0) i++;
            if (measures[i].compareTo(measures[i-1])>=0) {
                i++;
            }
            else {
                swap(i,i-1);
                i--;
            }
        }
    }
}
