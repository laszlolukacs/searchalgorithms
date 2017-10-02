package hu.laszlolukacs.searchalgorithms.implementations;

import java.util.LinkedList;

/**
 * Defines the contracts for a search algorithm implementation.
 */
public interface SearchAlgorithm {

	/**
	 * Sets the node with the specified identifier as the starting point of the
	 * algorithm execution.
	 * 
	 * @param nodeId
	 *            The id of the node which will be designated as the starting
	 *            point.
	 */
	void setStartId(int nodeId);

	/**
	 * Gets the results of the search algorithm execution as a linked list.
	 * 
	 * @return A (possibly empty) collection of the search results.
	 */
	LinkedList<Integer> getResult();

	/**
	 * Executes the current search algorithm.
	 */
	void execute();
}
