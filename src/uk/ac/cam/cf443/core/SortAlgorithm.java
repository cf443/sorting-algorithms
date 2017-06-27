package uk.ac.cam.cf443.core;

/**
 * A sorting algorithm, represented as a stateless function object. It operates on a SortArray,
 * sorting it completely in non-descending order (not necessarily stable).
 * 
 * @author cf443
 */

public interface SortAlgorithm {

	//Sorts the given array using this algorithm
	public void sort(SortArray array);
	
	//Returns the name of this sorting algorithm
	public String getName();
	
}
