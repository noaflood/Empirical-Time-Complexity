import java.util.ArrayList;
import java.util.Random;
import java.time.Duration;
import java.time.Instant;
import java.io.*;

/**
 * Includes an insertion sort algorithm that can be used to run
 * trials of sorting arrays N = array size. Each trial is stored in a csv
 * file that can be used to graph a plot using an R script.
 * 
 * To measure the time complecity of a different type of sorting algorthm:
 * 1. Write the algorthm in a new method.
 * 3. Call that method in place of insertionSort() on line ~128
 * 
 * For a smoother curve, increase the array size and decrease the "countBy" variable.
 * 
 * For a curve with more variation that shows just how much variation can occur from trial
 * to trial, use smaller array lengths.
 * 
 * Generally, to mess with the data output, you can change how big N gets, how much
 * N increases from trial to trial, and how random the numbers (or objects) are in each array.
 * 
 * Not sure how true the Random class is, so maybe a better source of random could be used.
 * 
 * 
 * TO GET A GRAPH OF YOUR OUTPUT DATA:
 * - Simply run the R script in R studio, ensuring that the source file path is correct.
 * 
 * ***You may have to install a package in R.***
 * 
 * @author Noah Flood
 * @version 3/14/2023
 * 
 * 
 */
public class TestingTime<T extends Comparable<T>>  {

   private static Random randomGenerator = new Random();

   /**
    * Take a duration object and return a formatted string displaying time in a regular format.
    * @param duration
    * @return
    */
   private static String formatDuration(Duration duration) {
      long seconds = duration.getSeconds();
      long absSeconds = Math.abs(seconds);
      int nano = duration.getNano();
      String sign = seconds < 0 ? "-" : "";
      
      // Format the duration as "hh:mm:ss.nnnnnnnnn"
      return String.format("%s%02d:%02d:%02d.%09d", sign, absSeconds / 3600, (absSeconds % 3600) / 60, absSeconds % 60, nano);
  }

  /**
   * Takes an array of any type and prints each value in the array
   * separated by spaces (for display/testing)
   * @param a
   */
   public void printArray(T[] a) {
      for (T num : a) {
         System.out.print(num + "  ");
      }
      System.out.print("\n");

   }

   /*
    * Used to determine natural order of two comparable objects.
    */
   public boolean less(T x, T y) {
      return x.compareTo(y) < 0;
   }

   /*
    * Used in the insertion sort algorithm to do an exchange between two values.
    */
   public void swap(T[] a, int i, int j) {
      T temp = a[i];
      a[i] = a[j];
      a[j] = temp; 
   }

   /**
    * An insertion sort algorithm of O(N^2) time complexity. (or is it??)
    * @param a
    */
   public void insertionSort(T[] a) {
      for (int i = 0; i < a.length; i++) {
         for (int j = i; j > 0; j--) {
            if (less(a[j], a[j-1]))
            {
               swap(a, j, j - 1);
               //printArray(a);
            }
            else
            {
               break;
            }
         }
      }
   }

   // YOUR ALTERNATE SORTING ALGORTHIM HERE ------------------------------------

   // public void quickSort(int[] array) {
   //    
   // }

   // ---------------------------------------------------------------------------

   /**
    * Creates and returns a new array of specified length
    * filled with random integers.
    *
    * @param length the length of the array created
    * @param range the maximum value that a random value could be
    */
   public static Integer[] fill(int length, int range) {
      Integer[] a = new Integer[length];

      for (int i = 0; i < a.length; i++) {
         a[i] = randomGenerator.nextInt(range) + 1;
      }

      return a;
   }

   //====================================================================================
   public static void main(String[] args) {

      TestingTime<Integer> runnerObj = new TestingTime<Integer>();
      
      // first, create all the arrays we need and store them in an ArrayList--------------------------------------------------------------------------------------------------
      ArrayList<Integer[]> sortingList = new ArrayList<Integer[]>();
      int maxLength = 30_000;
      int countBy = 2_000;
      int randomNumberRange = 30_000; // this probably effects sort time in some way. find out through expirmentation.
      
      
      
      for (int i = 0; i <= maxLength; i += countBy) {

         sortingList.add(fill(i, randomNumberRange));
         
      }

      System.out.println("\n--Created " + (maxLength / countBy) + " arrays, size increasing by " + countBy);

      // then, sort each array and store the time to completion for each one in a new ArrayList
      ArrayList<Duration> durations = new ArrayList<Duration>();
      System.out.println("\n--Sorting all arrays...\n");
      int j = 0;

      // all of the sorting work is done in one place with minimal code in between each sort,
      // so that it scales a little bit better.
      for (Integer[] array : sortingList) {




         //----------------------------------
         Instant startTime = Instant.now();
         runnerObj.insertionSort(array); // CALL A DIFFERENT SORTING METHOD OF CHOICE HERE
         Instant endTime = Instant.now();
         //----------------------------------




         // store the time it took to run this trial
         Duration sortTime = Duration.between(startTime, endTime);
         durations.add(sortTime);

         System.out.print((j + 1) + ". Sorted N = " + array.length + " in ");
         System.out.printf("%.6f", ((sortTime.getSeconds() + (sortTime.getNano() / 1e9))));
         System.out.println(" seconds.");

         j++;
         
      }

      System.out.println("\n--Sorted all arrays.");
      System.out.println("\n--Printing data to console...\n");

      // then, output the data to console
      System.out.println("-------------");
      System.out.println("   Summary   ");
      System.out.println("-------------");
      
      // print each N size and it's time take to be sorted
      for (int i = 0; i < sortingList.size(); i++) {
         System.out.println(sortingList.get(i).length + ", " + formatDuration(durations.get(i)));
      }

      System.out.println("\n--Ouput data completed.\n");

      System.out.println("--Printing data to csv file...\n");

      // open the file for writing

      PrintWriter writer = null;
      try {
          writer = new PrintWriter(new File("output_data.csv"));
      } catch (FileNotFoundException e) {
          e.printStackTrace();
      }

      writer.write("N,time\n");
      for (int i = 0; i < sortingList.size(); i++) {
         writer.write(sortingList.get(i).length + ",");
         writer.write(String.format("%.4f", durations.get(i).getSeconds() + durations.get(i).getNano() / 1e9) + "\n");
      }

      // close the file
      writer.close();

      System.out.println("--Done.");

   }



}
