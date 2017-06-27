package uk.ac.cam.cf443.core;

/**
 * An array that can be sorted, allowing the process to be visualised.
 * 
 * Array elements can only be compared and swapped, ensuring that all implementations of sorting
 * algorithms are in-place comparison sorts.
 * 
 * @author cf443
 */

public interface SortArray {
	
	//Must be a constant positive integer
	public int getLength();
	
	//Compares the values arr[i] and arr[j], and returns a corresponding integer:
	//   arr[i] < arr[j]   =>   -1
	//	 arr[i] = arr[j]   =>   0
	//	 arr[i] > arr[j]   =>   1
	public int compare(int i, int j);
	
	//Swaps the elements arr[i] and arr[j]
	public void swap(int i, int j);
	
	//Swaps the elements arr[i] and arr[j] iff arr[i] > arr[j], returning true if a swap occured
	public boolean compareAndSwap(int i, int j);
	
	//Randomises the order of all of the elements in the array
	public void shuffle();
	
	//The set of possible states of an element in the array
	public enum ElementState {ACTIVE, INACTIVE, COMPARING, DONE}
	
	//Sets the element arr[i] to the given state
	public void setElement(int index, ElementState state);
	
	//Sets all elements in the range [start, end) to the given state
	public void setRange(int start, int end, ElementState state);
	
}
