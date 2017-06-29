package uk.ac.cam.cf443.algs;

import uk.ac.cam.cf443.core.*;

public final class BozoSort extends ConcreteSortAlgorithm {
	
	//Singleton instance and private constructor
	public static final SortAlgorithm INSTANCE = new BozoSort();
	private BozoSort() {super("Bozo sort");}
	
	/**
	 * The Bozosort algorithm. Repeatedly checks if the list is in order. If it is not, selects two
	 * random elements in the array and switches them if they are not in the correct order.
	 * 
	 * Time complexity: O(n!) -- "perversely awful" randomised sorting algorithm
	 */
	@Override
	public void sort(SortArray array) {
		int length = array.getLength();
		
		while (!isSorted(array)) {
			int i = ConcreteSortArray.rand.nextInt(length);
			int j = ConcreteSortArray.rand.nextInt(length);
			array.compareAndSwap(Math.min(i, j), Math.max(i, j));
		}
		
		array.setRange(0, length, SortArray.ElementState.DONE);
	}
	
	//Tests whether the entire array is sorted in non-decreasing order
	private static boolean isSorted(SortArray array) {
		for (int i=0; i < array.getLength()-1; i++) {
			if (array.compare(i, i+1)>0) return false;
		}
		return true;
	}
}