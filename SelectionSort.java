import list.*;

/**
 * Implementation of the selection sort algorithm.
 * @author 	Kushal Ranjan
 * @version	042913
 */
public class SelectionSort {
	
	private static final int NUMINTS = 30;
	
	/**
	 * Tests selection sort on a list of randomly generated integers in [0,100) of size NUMINTS.
	 */
	public static void main(String[] args) {
		LinkedList<Comparable> input = new LinkedList<Comparable>();
		for(int i = 0; i < NUMINTS; i++) {
			input.add(new Integer((int)(Math.random()*100)));
		}
		System.out.println(input + "\nSorting...");
		LinkedList<Comparable> output = sort(input);
		System.out.println(output);
	}
	
	/**
	 * Performs a selection sort on a list of input data.
	 * Runtime: O(n^2) for input length n.
	 * @param input	LinkedList<Comparable> of Comparable input items
	 * @return		a sorted version of input
	 */
	public static LinkedList<Comparable> sort(LinkedList<Comparable> input) {
		Iterator<Comparable> it = input.iterator();
		Comparable[] objs = new Comparable[input.size()];
		for(int i = 0; i < objs.length; i++) { //First populate array with objects from input
			objs[i] = it.next();
		}
		for(int i = 0; i < objs.length - 1; i++) {
			int minIndex = i;
			for(int j = i + 1; j < objs.length; j++) {
				if(objs[j].compareTo(objs[minIndex]) < 0) minIndex = j;
			}
			Comparable temp = objs[i]; //Swap objects
			objs[i] = objs[minIndex];
			objs[minIndex] = temp;
		}
		LinkedList<Comparable> out = new LinkedList<Comparable>();
		for(Comparable c: objs) { //Populate output list
			out.add(c);
		}
		return out;
	}


}
