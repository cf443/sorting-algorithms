package uk.ac.cam.cf443.algs;

import uk.ac.cam.cf443.core.*;

public final class HeapSort extends ConcreteSortAlgorithm {

	//Singleton instance and private constructor
	public static final SortAlgorithm INSTANCE = new HeapSort();
	private HeapSort() {super("Heap sort");}
	
	/**
	 * The heapsort algorithm. Sorts by first constructing a min-heap in place within the input
	 * array in O(n) time. The left child of an element at position i is at position 2*i + 1,
	 * and the right child is at position 2*i + 2. The heap is built from the bottom up by
	 * repeatedly sinking a new root node into the correct position amongst its children.
	 * 
	 * Given the formed heap, the minimum item is extracted from the root node and the final
	 * element (which has no children) is chosen to replace it. The reduced heap is reformed
	 * in O(log n) time by sinking the new root node to its correct position.
	 * 
	 * Time complexity: O(n log n)
	 */
	@Override
	public void sort(SortArray array) {
		
		//Heapify
		int length = array.getLength();
		array.setRange(0, length, SortArray.ElementState.INACTIVE);
		for (int i = length -1; i >= 0; i--) sift(array, i, length);
		
		//Extract minimum repeatedly
		for (int i = length - 1; i >= 0; i--) {
			array.swap(0,i);
			array.setElement(i, SortArray.ElementState.DONE);
			sift(array, 0, i); //Sink the new root node into the correct position in the heap
		}
	}
	
	//Sift the element at arr[node] down into the correct position in an almost formed heap
	private static void sift(SortArray array, int node, int end) {
		while (node*2+1 < end) {//i.e. while node has a left child
			
			int child = node*2 +1; //Left child
			
			//Use right child if it is greater
			if (child + 1 < end && array.compare(child + 1,  child) > 0) child++;
			
			if (!array.compareAndSwap(child, node)) break;
			node = child;
		}
	}
}
