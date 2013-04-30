import list.*;

/**
 * Implementation of the insertion sort algorithm.
 * @author 	Kushal Ranjan
 * @version	042813
 */
public class InsertionSort {
	
	private static final int NUMINTS = 30;
	
	/**
	 * Tests merge sort on a list of randomly generated integers in [0,100) of size NUMINTS.
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
	 * Performs an insertion sort on a list of input data.
	 * Runtime: O(n^2) for input length n.
	 * @param input	LinkedList<Comparable> of Comparable input items
	 * @return		a sorted version of input
	 */
	public static LinkedList<Comparable> sort(LinkedList<Comparable> input) {
		LinkedList<Comparable> out = new LinkedList<Comparable>();
		Iterator<Comparable> it = input.iterator();
		if(!it.hasNext()) return out;
		out.add(it.next());
		while(it.hasNext()) {
			Comparable val = it.next();
			boolean added = false;
			Iterator<Comparable> outIt = out.iterator();
			while(outIt.hasNext()) {
				if(val.compareTo(outIt.next()) <= 0) {
					outIt.insert(val);
					added = true;
					break;
				}
			}
			if(!added) out.add(val); //Adds object if larger than everything else in out
		}
		return out;
	}


}
