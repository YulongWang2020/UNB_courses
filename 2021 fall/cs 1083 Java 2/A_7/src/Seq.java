import java.lang.reflect.Array;
import java.util.ArrayList;

/**
Seq.java
A utility class that provide methods to compute elements of the
recursive sequence.
*/
public class Seq {
	private static ArrayList<Integer> memory;

	/**
	 * Recursively computes seq(n)
	 *
	 * @param n Non-negative integer.
	 * @return int Element n in the recursive sequence.
	 */
	public static int seqR(int n) {
		if (n == 0) {
			return 1;
		} else if (n == 1) {
			return 3;
		} else {
			return seqR(n - 1) - seqR(n - 2) * 2;
		}
	}

	/**
	 * Recursively computes seq(n) using memory.
	 *
	 * @param n Non-negative integer.
	 * @return int Element n in the recursive sequence.
	 */
	public static int seqM(int n) {
		// if array not initialized, create an arraylist and add init value.
		if (memory == null) {
			memory = new ArrayList<>();
			memory.add(1);
			memory.add(3);
		}
		if (n+1 > memory.size()) {
			memory.add(seqM(n - 1) - seqM(n - 2) * 2);
		}
		return memory.get(n);
	}

	/**
	 * Iteratively computes seq(n) with memory.
	 *
	 * @param n Non-negative integer.
	 * @return int Element n in the recursive sequence.
	 */
	public static int seqI(int n) {
		//init an array and add init value.
		int[] cache = new int[n+1];
		if(n>-1){
			cache[0] = 1;
		}
		if(n>0){
			cache[1] = 3;
		}
		for(int i=2;i<=n;i++){
			cache[i] = cache[i-1] - cache[i-2]*2;
		}
		return cache[n];
	}
}
