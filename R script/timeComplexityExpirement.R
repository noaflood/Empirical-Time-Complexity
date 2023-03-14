# Make sure the source file path below is correct for your data location. 

dataframe <- read.csv("/Users/your_username/Desktop/Empirical-Time-Complexity/data/output_data_1.csv", header = TRUE)

library(ggplot2)

# make sure that x and y are equal to variables that exactly match the headers of your file

ggplot(dataframe, aes(x = N, y = time)) +
  geom_line() +
  labs(x = "N", y = "Average Duration (sec)")

# this will produce a default format graph
# using this package, you can alter your graph to your liking but I find the default looks fine.

