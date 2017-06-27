package uk.ac.cam.cf443.algs;

import uk.ac.cam.cf443.core.*;

public final class InsertionSort extends ConcreteSortAlgorithm {

	//Singleton instance and private constructor
	public static final SortAlgorithm INSTANCE = new InsertionSort();
	private InsertionSort() {super("Insertion sort");}
	
	/**
	 * The insertion sort algorithm. Sorts by gradually building up a sorted portion of the array
	 * by swapping the next unsorted item into the correct position. The unsorted segment of the
	 * array decreases in size by 1 per iteration.
	 * 
	 * Time complexity: O(n^2)
	 */
	@Override
	public void sort(SortArray array) {
		int length = array.getLength();
		
		array.setRange(0,length,SortArray.ElementState.INACTIVE);
		
		for (int i = 0; i < length; i++) {
			
			/*
			 * Starting from the end of the sorted portion and working backwards, keep swapping
			 * the next unsorted element until no swap occurs or the start of the array has been
			 * reached.
			 */
			for (int j = i; j >= 1 && array.compareAndSwap(j-1 , j); j--);
		}

	}

}
