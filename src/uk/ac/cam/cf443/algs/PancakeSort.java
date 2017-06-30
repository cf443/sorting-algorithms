package uk.ac.cam.cf443.algs;

import uk.ac.cam.cf443.core.*;

public final class PancakeSort extends ConcreteSortAlgorithm {
	
	//Singleton instance and private constructor
	public static final SortAlgorithm INSTANCE = new PancakeSort();
	private PancakeSort() {super("Pancake sort");}
	
	/**
	 * The pancake sort algorithm. Attempts to sort an array using the minimum number of reversals.
	 * The algorithm is a variation of selection sort: we bring the largest pancake not yet sorted
	 * to the top with one flip and take it down to its final position with one more flip. At most
	 * 2n-3 flips are necessary.
	 * 
	 * Time complexity: O(n^2)
	 */
	@Override
	public void sort(SortArray array) {
		
		for (int i = array.getLength() - 1; i >= 0; i--) {
			int maxIndex = 0;
			
			for (int j = 1; j <= i; j++) {
				if (array.compare(j, maxIndex) > 0) maxIndex = j;
			}
			
			reverse(array, 0, maxIndex + 1);
			reverse(array, 0, i + 1);
			
			array.setElement(i, SortArray.ElementState.DONE);
		}
	}
	
	//Reverses the element in the subarray [start, end).
	private static void reverse(SortArray array, int start, int end) {
		for (end--; start < end; start++, end--) array.swap(start,end);
	}
}