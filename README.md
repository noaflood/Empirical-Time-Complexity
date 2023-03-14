# Empirical-Time-Complexity
A for-fun tool to experimentally determine the time complexity of a sorting algorithm through randomized time trials and plotting with R. 

### Testing Time Class ###
 Includes an insertion sort algorithm that can be used to run trials of sorting arrays N = array size. Each trial is stored in a csv file that can be used to graph a plot using an R script.
 
 To measure the time complecity of a different type of sorting algorthm:
 1. Write the algorthm in a new method.
 3. Call that method in place of insertionSort() on line ~128
  
 For a smoother curve, increase the array size and decrease the "countBy" variable.
 
 For a curve with more variation that shows just how much variation can occur from trial to trial use smaller array lengths.
 
 Generally, to mess with the data output, you can change how big N gets, how much
 N increases from trial to trial, and how random the numbers (or objects) are in each array.
 
 Not sure how true the Random class is, so maybe a better source of random could be used.
 

TO GET A GRAPH OF YOUR OUTPUT DATA:
 - Simply run the R script in R studio, ensuring that the source file path is correct.

 * ***You may have to install a package in R.***
