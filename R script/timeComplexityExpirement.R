# Make sure the source file path below is correct for your data location. 

dataframe <- read.csv("your_file_absolute_path_here", header = TRUE)

library(ggplot2)

# make sure that x and y are equal to variables that exactly match the headers of your file

ggplot(dataframe, aes(x = N, y = time)) +
  geom_line() +
  labs(x = "N", y = "Average Duration (sec)")

# this will produce a default format graph
# using this package, you can alter your graph to your liking but I find the default looks fine.

# save the plot to a file (R Studio will automatically display the plot; 
# use this when using ggplot2 with visual studio code's R extension.)
filename <- "myplot.png"
ggsave(filename)