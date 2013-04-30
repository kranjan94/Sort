Sort
====

Repo of Java implementations of sorting algorithms. Each sort takes a LinkedList<Comparable> of Comparable objects and returns a LinkedList<Comparable> of the sorted input list.

Each class stores its sort as a public method:
  public static LinkedList<Comparable> sort(LinkedList<Comparable> input)
Thus, the sorts may be utilized by other classes via (for instance):
  LinkedList<Comparable> sorted_list = QuickSort.sort(unsorted_list);

The Sort class tests algorithms by generating a list of random non-negative integers and sorting them.
Input format: java Sort name size range
  name: "merge", "insertion", "quick", etc.  
  size: number of values to generate and sort
  range: upper bound on positive integers to generate
