package uk.ac.cam.cf443.algs;

import uk.ac.cam.cf443.core.*;

public final class SelectionSort extends ConcreteSortAlgorithm {

	//Singleton instance and private constructor
	public static final SortAlgorithm INSTANCE = new SelectionSort();
	private SelectionSort() {super("Selection sort");}
	
	/**
	 * The selection sort algorithm. Sorts by repeatedly selecting the smallest item in the
	 * unsorted portion and switching it into the end of the sorted portion.
	 * 
	 * Time complexity: O(n^2)
	 */
	@Override
	public void sort(SortArray array) {
		int length = array.getLength();
		
		for (int i = 0; i < length; i++) { 
			int minPos = i;
			
			for (int j = i+1; j < length; j++) {
				if (array.compare(j, minPos) < 0) minPos = j;
			}
			
			array.swap(i,minPos);
			array.setElement(i, SortArray.ElementState.DONE);
		}
	}

}