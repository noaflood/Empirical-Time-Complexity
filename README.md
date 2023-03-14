# Empirical-Time-Complexity
A for-fun tool to experimentally determine the time complexity of a sorting algorithm through randomized time trials and plotting with R. 

### To run: ###
Requirements:
- Java programming language/ the JDK (https://www.javatpoint.com/javafx-how-to-install-java)
- R programming language (https://www.dataquest.io/blog/installing-r-on-your-computer/) 
- Integrated Development Environment of choice (Visual Studio Code: (https://code.visualstudio.com/download)
- R Studio or other R IDE of choice. (https://posit.co/download/rstudio-desktop/)

To run your expirement:
1. Clone this repo on your machine.
2. Run TestingTime.java. (in terminal: 'javac TestingTime.java', 'java TestingTime.java')
(Change the variables of the expirement or write an entirely new sorting alogirthm to test if you want.)
3. Open the R script in R studio.
4. Copy and paste the absolute path of your output data into the R script. (on mac: finder > right click file > hold the option key > "copy as path name")
5. *Run the R script (will probably prompt you to install the ggplot package. this may take 2-3 minutes.)
6. Observe the shiny new plot of your data in the "Plots" panel!

### Testing Time Class ###
 Includes an insertion sort algorithm that can be used to run trials of sorting arrays of N size. After all the sorting work is done, all trial data is stored in a csv file that can be used to graph a simple (x, y) plot using an R script.
 
 To measure the time complecity of a different type of sorting algorthm:
 1. Write the algorthm in a new method.
 3. Call that method in place of insertionSort() on line ~128
  
 For a smoother curve, increase the array size and decrease the "countBy" variable.
 
 For a curve with more variation that shows just how much variation can occur from trial to trial use smaller array lengths.
 
 Generally, to mess with the data output, you can change how big N gets, how much
 N increases from trial to trial, and how random the numbers (or objects) are in each array.
 
 Not sure how true the Random class is, so maybe a better source of random could be used.
 
 ### Future Updates: ###
 - Add a way to update a graph in real time as each trial is executed. 
 - Create a way run run multiple trials at every N, averaging at every N in real time so that the graph can visually be seen becoming more smooth as it approaches its true O(N).
