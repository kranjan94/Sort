import list.*;

/**
 * Implementation of the mergesort algorithm using Queues of Comparable objects.
 * @author 	Kushal Ranjan
 * @version	042713
 */
public class MergeSort {
	
	private static final int NUMINTS = 30;
	
	/**
	 * Tests mergesort on a list of randomly generated integers in [0,100) of size NUMINTS.
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
	 * Performs a mergesort on a list of input data.
	 * Runtime: O(n log n) for input length n.
	 * @param input	LinkedList<Comparable> of Comparable input items
	 * @return		a sorted version of input
	 */
	public static LinkedList<Comparable> sort(LinkedList<Comparable> input) {
		Queue<Queue<Comparable>> sort = queueOfQueues(new Queue<Comparable>(input));
		while(sort.size() > 1) {
			Queue<Comparable> first = sort.pop();
			Queue<Comparable> second = sort.pop();
			sort.push(merge(first, second));
		}
		return sort.pop().getObjects();
	}
	
	/**
	 * Breaks an input Queue into another Queue in which each element of the original Queue is
	 * in a length 1 Queue containing only itself.
	 * @param in	input Queue<Comparable>
	 * @return		a Queue<Queue<Comparable>> with each element from in in its own Queue
	 */
	private static Queue<Queue<Comparable>> queueOfQueues(Queue<Comparable> in) {
		Queue<Queue<Comparable>> out = new Queue<Queue<Comparable>>();
		while(in.peek() != null) {
			Queue<Comparable> newQ = new Queue<Comparable>();
			newQ.push(in.pop());
			out.push(newQ);
		}
		return out;
	}
	
	/**
	 * Merges two ordered Queue<Comparable>s.
	 * @param a,b	sorted input Queue<Comparable>s
	 * @return		sorted Queue<Comparable> containing all elements from a and b
	 */
	private static Queue<Comparable> merge(Queue<Comparable> a, Queue<Comparable> b) {
		Queue<Comparable> newQ = new Queue<Comparable>();
		while(a.size() != 0 && b.size() != 0) {
			if(a.peek().compareTo(b.peek()) <= 0) {
				newQ.push(a.pop());
			} else {
				newQ.push(b.pop());
			}
		}
		if(a.peek() != null) {
			newQ.concatenate(a);
		} else if(b.peek() != null) {
			newQ.concatenate(b);
		}
		return newQ;
	}
}
