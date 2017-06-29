package uk.ac.cam.cf443.algs;

import uk.ac.cam.cf443.core.*;

public final class GnomeSort extends ConcreteSortAlgorithm {
	
	//Singleton instance and private constructor
	public static final SortAlgorithm INSTANCE = new GnomeSort();
	private GnomeSort() {super("Gnome sort");}
	
	/**
	 * The gnome sort algorithm. A variant of insertion sort in which moving an element to its
	 * proper position is accomplished by a series of swaps, as in bubble sort.
	 * 
	 * Time complexity: O(n^2)
	 */
	@Override
	public void sort(SortArray array) {
		
		int length = array.getLength();
		array.setRange(0, length, SortArray.ElementState.INACTIVE);
		
		for (int i = 0; i < length - 1;) {
			if (!array.compareAndSwap(i, i+1) || i == 0) i++;
			else i--;
		}
		
		array.setRange(0, length, SortArray.ElementState.DONE);
	}
}