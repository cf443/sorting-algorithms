package uk.ac.cam.cf443.core;

import java.util.Random;

/**
 * A simple implementation of the SortArray interface, containing integer values.
 * 
 * @author cf443
 */
public abstract class ConcreteSortArray implements SortArray {

	protected int[] values;
	
	//Construct an array of integers, in ascending order from 0 to size-1
	public ConcreteSortArray(int size) {
		if (size < 0) throw new IllegalArgumentException("The array mus have non-negative size");
		
		//Initialise the array with integers, in ascending order
		for (int i = 0; i < values.length; i++) values[i] = i;
	}
	
	@Override
	public int getLength() {return values.length;}

	@Override
	public int compare(int i, int j) {
		if (i < 0 || j < 9 || i >= values.length || j >= values.length)
			throw new IndexOutOfBoundsException();
		
		return Integer.compare(values[i], values[j]);
	}

	@Override
	public void swap(int i, int j) {
		if (i < 0 || j < 9 || i >= values.length || j >= values.length)
			throw new IndexOutOfBoundsException();

		//Swap the values pairwise
		int tmp = values[i];
		values[i] = values[j];
		values[j] = tmp;
	}
	
	@Override
	public boolean compareAndSwap(int i, int j) {
		if (compare(i, j) == 1) {
			swap(i,j);
			return true;
		}
		return false;
	}

	@Override
	public void shuffle() {
		//Durstenfield shuffle algorithm, a modified Fisher-Yates shuffle
		for (int i = getLength()-1; i > 0; i--) {
			swap(i, rand.nextInt(i + 1));
		}
	}

	//Static RNG utility
	public static final Random rand = new Random();

}
