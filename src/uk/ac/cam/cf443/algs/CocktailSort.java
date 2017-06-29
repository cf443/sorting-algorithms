package uk.ac.cam.cf443.algs;

import uk.ac.cam.cf443.core.*;

public final class CocktailSort extends ConcreteSortAlgorithm {
	
	//Singleton instance and private constructor
	public static final SortAlgorithm INSTANCE = new CocktailSort();
	private CocktailSort() {super("Cocktail sort");}
	
	
	/**
	 * The Cocktail shaker sort. A variant of bubble sort which scans the array in both directions
	 * on each pass through the list. The algorithm provides a marginal improvement over
	 * bubble sort, as it solves the problem of small elements taking many passes to reach the
	 * front of the list (turtles).
	 * 
	 *  Time complexity: O(n^2)
	 */
	@Override
	public void sort(SortArray array) {
		
		int left = 0,
			right = array.getLength(),
			i = 0;
		
		while (left < right) {
			
			//Scan right
			for (; i+1 < right; i++) array.compareAndSwap(i, i+1);
			array.setElement(i, SortArray.ElementState.DONE);
			
			right--; i--;
			
			if (left == right) break;
			
			//Scan left
			for (; i > left; i--) array.compareAndSwap(i-1, i);
			array.setElement(i, SortArray.ElementState.DONE);
			
			left++; i++;
		}
		
	}
}