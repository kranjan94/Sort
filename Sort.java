import list.*;

/**
 * Testing class for sorting algorithms; user specifies algorithm, sample size, and range of values.
 * @author 	Kushal Ranjan
 * @version	042913
 */
public class Sort {

	/**
	 * Tests a specified sort on a list of randomly generated positive integers.
	 * Input format: java Sort <name> <size> <range>
	 * 		<name>:		"merge", "insertion", "quick", etc.
	 * 		<size>:		number of values to generate and sort
	 * 		<range>:	upper bound on positive integers to generate
	 */
	public static void main(String[] args) {
		int numInts = Integer.parseInt(args[1]);
		LinkedList<Comparable> input = new LinkedList<Comparable>();
		for(int i = 0; i < numInts; i++) {
			input.add(new Integer((int)(Math.random()*Integer.parseInt(args[2]))));
		}
		System.out.println(input + "\nSorting...");
		LinkedList<Comparable> output = new LinkedList<Comparable>();
		if(args[0].equals("merge")) {
			output = MergeSort.sort(input);
		} else if(args[0].equals("insertion")) {
			output = InsertionSort.sort(input);
		} else if(args[0].equals("quick")) {
			output = QuickSort.sort(input);
		} else if(args[0].equals("selection")) {
			output = SelectionSort.sort(input);
		} else if(args[0].equals("bogo")) {
			output = BogoSort.sort(input);
		} else {
			throw new RuntimeException(args[0] + " is not a supported sort.");
		}
		System.out.println(output);
	}

}
