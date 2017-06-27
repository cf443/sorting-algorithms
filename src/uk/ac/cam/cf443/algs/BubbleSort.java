package uk.ac.cam.cf443.algs;

import uk.ac.cam.cf443.core.*;

public final class BubbleSort extends ConcreteSortAlgorithm {
	
	//Singleton instance and private constructor
	public static final SortAlgorithm INSTANCE = new BubbleSort();
	private BubbleSort() {super("Bubble sort");}
	
	/**
	 * The bubble sort algorithm. Sorts by running N many scans through the array and swapping
	 * adjacent elements if they are out of order. The last element in each pass must be the
	 * largest element of the array, and therefore the range of the array to be sorted decreases
	 * by 1 each time.
	 * 
	 * Time complexity: O(n^2)
	 */
	@Override
	public void sort(SortArray array) {
		
		for (int i = array.getLength(); i >= 1; i--) {
			for (int j = 0; j < i - 1 ; j++) {
				
				array.compareAndSwap(i, j+1);
				array.setElement(i - 1, SortArray.ElementState.DONE);
				
			}
		}
	}
}