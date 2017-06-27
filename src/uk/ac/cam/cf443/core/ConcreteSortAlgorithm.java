package uk.ac.cam.cf443.core;

import java.util.Objects;

/**
 * Implements the getName functionality for all sort classes.
 * 
 * @author cf443
 */

public abstract class ConcreteSortAlgorithm implements SortAlgorithm {
	
	private final String name;
	
	protected ConcreteSortAlgorithm(String name) { 
		this.name = Objects.requireNonNull(name);
	}
	
	@Override
	public String getName() {return name;}

}
