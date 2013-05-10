Sort
====

Repo of Java implementations of sorting algorithms. Each sort takes a LinkedList<Comparable> of Comparable objects and returns a LinkedList<Comparable> of the sorted input list.

Each class stores its sort as a public method:

    public static LinkedList<Comparable> sort(LinkedList<Comparable> input)
Thus, the sorts may be utilized by other classes via (for instance):

    LinkedList<Comparable> sorted_list = QuickSort.sort(unsorted_list);

####Testing
The Sort class tests algorithms in two ways: individually, by generating, printing, and sorting a list of randomly generated integers; or by performing a detailed test of all algorithms with varying sample size.  
To test a single algorithm:

    java Sort name size range
    
name: "merge", "insertion", "quick", etc.  
size: number of values to generate and sort  
range: upper bound on positive integers to generate  

To test all algorithms:
	java Sort full trials range

trials: number of trials to use for each sample size; 30 by default  
range: upper bound on positive integers to generate; 100 by default  
The full test performs each algorithm a number of times on randomly generated sets of 10, 100, 1000, and 10000 integers and records the average running time of the algorithm for each sample size.