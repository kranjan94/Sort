import list.*;

/**
 * Implementation of the bogo sort algorithm.
 * @author 	Kushal Ranjan
 * @version	042813
 */
public class BogoSort {
	
	private static final int NUMINTS = 10; //Anything larger than 10 takes a very long time
	
	/**
	 * Tests bogo sort on a list of randomly generated integers in [0,100) of size NUMINTS.
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
	 * Performs a bogo sort on a list of input data.
	 * Runtime: O(n!) for input length n.
	 * @param input	LinkedList<Comparable> of Comparable input items
	 * @return		a sorted version of input
	 */
	public static LinkedList<Comparable> sort(LinkedList<Comparable> input) {
		if(input.size() <= 1) return input;
		LinkedList<Comparable> test = input.copy();
		LinkedList<Comparable> out = randomize(test);
		while(true) {
			boolean bad = false;
			Iterator<Comparable> outIt = out.iterator();
			Comparable last = outIt.next();
			while(outIt.hasNext()) { //Check whether this version of out is sorted
				Comparable curr = outIt.next();
				if(last.compareTo(curr) > 0) {
					bad = true; //Signal to not return out
					break;
				}
				last = curr;
			}
			if(!outIt.hasNext() && !bad) {
				return out;
			} else {
				test = input.copy();
				out = randomize(test);
			}
		}
	}
	
	/**
	 * Returns a randomized version of the input list.
	 * @param in	input list
	 * @return		randomized version of in
	 */
	private static LinkedList<Comparable> randomize(LinkedList<Comparable> in) {
		LinkedList<Comparable> out = new LinkedList<Comparable>();
		while(in.size() > 0) {
			int random = (int)(Math.random()*in.size());
			out.add(in.remove(random));
		}
		return out;
	}

}
