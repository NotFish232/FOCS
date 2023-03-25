import java.util.Arrays;

public class SelectionSorter extends MeasureSorter {
   public SelectionSorter(String filename) throws Exception {
      super(filename);
   }

   public int findMinIndex(int startingIndex) // Write and test this first!
   {
      int min = startingIndex;
      for (int i = startingIndex + 1; i < measures.length; i++) {
         if (measures[min].compareTo(measures[i]) == 1)
            min = i;
      }
      return min;
   }

   public void sortMe() // For SelectionSorter to compile, this class needs to implement the abstract
                        // method sortMe() in MeasureSorter. Right now the implementation is empty, but
                        // it will compile! This allows you to test findMinIndex separately.
   {
      System.out.println(Arrays.toString(measures));
      for (int i = 0; i < measures.length; i++) {
         swap(i, findMinIndex(i));
         System.out.println(Arrays.toString(measures));
      }
   }
}