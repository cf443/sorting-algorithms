package uk.ac.cam.cf443.algs;

import uk.ac.cam.cf443.core.*;

public final class InsertionSortBinary extends ConcreteSortAlgorithm {

	//Singleton instance and private constructor
	public static final SortAlgorithm INSTANCE = new InsertionSortBinary();
	private InsertionSortBinary() {super("Insertion sort (binary search)");}
	
	/**
	 * A binary insertion sort algorithm. Sorts by gradually building up a sorted portion of the
	 * by swapping the next unsorted item into the correct position. The correct position for the
	 * next unsorted item is selected by binary search in the sorted portion.
	 * 
	 * The number of comparisons necessary is reduced to O(n log n) via the binary search method,
	 * but the time complexity remains the same since the number of swaps per pass is still O(n).
	 * 
	 * Time complexity: O(n^2)
	 */
	@Override
	public void sort(SortArray array) {
		int length = array.getLength();
		
		array.setRange(0,length,SortArray.ElementState.INACTIVE);
		
		for (int i = 0; i < length; i++) {
			
			/*
			 * Get the correct position of the next unsorted element within the sorted portion
			 * by binary search, and then insert it into place by performing a series of swaps.
			 */
			int index = binarySearch(array, i, 0, i);
			for (int j = i; j - 1 >= index; j--) 
				array.swap(j, j-1);
		}
	}
	
	//Returns the correct position for the element arr[index] in the range [arr[start],arr[end])
	private static int binarySearch(SortArray array, int index, int start, int end) {
		while (start != end) {
			int mid = (start + end) / 2; //Midpoint of the two bounds
			
			switch (array.compare(index, mid)) {
				case -1: end = mid;       break; //Use left partition
				case  1: start = mid + 1; break; //Use right partition
				case  0: return mid;             //Identical element found
			}
		}
		
		return start;
	}
}
