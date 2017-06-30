package uk.ac.cam.cf443.algs;

import uk.ac.cam.cf443.core.*;

public final class WeightlessPancakeSort extends ConcreteSortAlgorithm {
	
	//Singleton instance and private constructor
	public static final SortAlgorithm INSTANCE = new WeightlessPancakeSort();
	private WeightlessPancakeSort() {super("Weightless pancake sort");}
	
	/**
	 * The weightless pancake sort algorithm. A variant of the pancake sort algorithm for sorting
	 * an array using the minimum number of reversals. In the weightless pancake sort, sections
	 * of the pancake stack can be reversed between any two pancakes (not necessarily from the
	 * top of the stack downwards).
	 * 
	 * Time complexity: O(n^2)
	 */
	@Override
	public void sort(SortArray array) {
		
		for (int i = 1; i < array.getLength(); i++) {
			int j = i;
			
			while (j >= 1 && array.compare(j - 1, i) > 0) j--;
			
			reverse(array, j, i);
			reverse(array, j, i + 1);
		}
		
		array.setRange(0, array.getLength(), SortArray.ElementState.DONE);
	}
	
	//Reverses the element in the subarray [start, end).
	private static void reverse(SortArray array, int start, int end) {
		for (end--; start < end; start++, end--) array.swap(start,end);
	}

}
