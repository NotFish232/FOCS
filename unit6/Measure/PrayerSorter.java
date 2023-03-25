import java.util.Arrays;

public class PrayerSorter extends MeasureSorter{
    public PrayerSorter(String fileName) throws Exception{
        super(fileName);
    }
    public void sortMe() {
        /*
        I pray that the array is already sorted
        1/n! that the array is already sorted
        and we are so lucky that it happens
        */
        System.out.println(Arrays.toString(measures));
    }
}
