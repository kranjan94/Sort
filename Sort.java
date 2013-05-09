import list.*;

/**
 * Testing class for sorting algorithms; user specifies algorithm, sample size, and range of 
 * values, or chooses to see a detailed report of runtimes for all sorting algorithms.
 * @author 	Kushal Ranjan
 * @version	050813
 */
public class Sort {

	/**
	 * Tests sorting algorithms on lists of randomly generated positive integers.
	 * To test a single algorithm:
	 * java Sort <name> <size> <range>
	 * 		<name>:		"merge", "insertion", "quick", etc.
	 * 		<size>:		number of values to generate and sort
	 * 		<range>:	upper bound on positive integers to generate
	 * To test all algorithms:
	 * java Sort full <trials> <range>
	 * 		<trials>:	number of trials for each sample size; 30 by default
	 * 		<range>:	upper bound on positive integers to generate; 100 by default
	 */
	public static void main(String[] args) {
		if(args.length != 0 && args[0].equals("full")) {
			detailedTest(args);
		} else if(args.length == 3){
			singleTest(args);
		} else {
			System.out.println("Invalid number of arguments. Arguments should be <name> <size> <range>.");
		}
	}
	
	/**
	 * Tests a single sorting algorithm by generating random integers and sorting them. Records
	 * the time needed for each sort.
	 * @param args	arguments passed from main(); args[0] is the name of the search, args[1] is
	 * 				the number of values to generate and sort, args[1] is the range of integer
	 * 				values to generate
	 */
	private static void singleTest(String[] args) {
		int numInts = Integer.parseInt(args[1]);
		LinkedList<Comparable> input = new LinkedList<Comparable>();
		System.out.println("Generating...");
		for(int i = 0; i < numInts; i++) {
			input.add(new Integer((int)(Math.random()*Integer.parseInt(args[2]))));
		}
		Timer t = new Timer();
		System.out.println(input + "\nSorting...");
		LinkedList<Comparable> output = new LinkedList<Comparable>();
		t.start();
		output = sortByName(input, args[0]);
		long time = t.stop();
		System.out.println(output + "\nTime: " + time + " milliseconds");
	}
	
	/**
	 * Runs a detailed test of the sorting algorithms. Tests each algorithm with a specified
	 * number of trials of sets of 10, 100, 1000, and 10000 randomly generated integers. Excludes
	 * Bogo sort because of the unreasonably long times needed for n > 10.
	 * @param args	arguments passed from main(); args[0] should be "full", args[1] is the number of
	 * 				trials to use for each sample size, args[2] is the range of values to use
	 */
	private static void detailedTest(String[] args) {
		//Set up parameters
		String[] sorts = {"insertion", "selection", "quick", "merge"};
		int trials = 30;
		if(args.length > 1) {
			trials = Integer.parseInt(args[1]);
		}
		int range = 100;
		if(args.length > 2) {
			range = Integer.parseInt(args[2]);
		}
		
		//Perform and print tests
		Timer t = new Timer();
		System.out.println("Testing sorts: " + trials + " trials, values in [0, " + range + ")");
		for(String name: sorts) {
			System.out.println("\tTesting " + name + "sort:");
			for(int power = 1; power <= 4; power++) { //Set values for n
				int n = (int)Math.pow(10, power);
				long[] times = new long[trials]; //Set number of trials
				System.out.print("\t\tn = " + n + "... ");
				for(int run = 0; run < times.length; run++){
					LinkedList<Comparable> input = new LinkedList<Comparable>();
					for(int j = 0; j < n; j++) {
						input.add(new Integer((int)(Math.random()*range)));
					}
					t.start();
					sortByName(input, name);
					long time = t.stop();
					t.reset();
					times[run] = time; //Record runtimes
				}
				double avg = getAverageTime(times);
				System.out.print("average = " + avg + " milliseconds.\n");
			}
		}
	}
	
	/**
	 * Performs the sort specified by name on the input list and returns the result.
	 * @param input	LinkedList<Comparable> of unsorted input data
	 * @param name	name of the sorting algorithm to use
	 * @return		sorted version of input
	 */
	private static LinkedList<Comparable> sortByName(LinkedList<Comparable> input, String name) {
		LinkedList<Comparable> output;
		if(name.equals("merge")) {
			output = MergeSort.sort(input);
		} else if(name.equals("insertion")) {
			output = InsertionSort.sort(input);
		} else if(name.equals("quick")) {
			output = QuickSort.sort(input);
		} else if(name.equals("selection")) {
			output = SelectionSort.sort(input);
		} else if(name.equals("bogo")) {
			output = BogoSort.sort(input);
		} else {
			throw new RuntimeException(name + " is not a supported sort.");
		}
		return output;
	}
	
	/**
	 * Calculates the average time from a set of given times.
	 * @param times	a long[] containing the times
	 * @return		the average time in times, rounded to three decimal places
	 */
	private static double getAverageTime(long[] times) {
		double out = 0;
		for(long t: times) {
			out += ((double)t)/((double)times.length);
		}
		return Double.parseDouble(String.format("%.4g%n", out));
	}
}
