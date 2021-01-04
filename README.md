# RestaurantDynamicProgramming
Dynamic Programming Problem: There is a list of restaurants, in a straight line, and each has an expected profit value and a distance from a certain starting point. Our goal is to find the optimal group of restaurants that will give us the most expected profits. Each restaurant must be at least distance k away from each other. 

Command line arguments are the number of restaurants (n), the minimum distance between each restaurant (k), the n expected profits of the restaurants, and the n distances from the starting point. 

For example, if we had n=4 restaurants with expected profits (2,5,4,3) and distances (0,2,4,5) with a min distance k=4, our program would output "6 at 3 1" since the maximum profits that can be expected is 6 by making restaurants 1 and 3.
