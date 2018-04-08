package hu.laszlolukacs.searchalgorithms.implementations;

import java.util.List;

import hu.laszlolukacs.searchalgorithms.models.Graph;

/**
 * Defines the contracts for a search algorithm implementation.
 */
public interface SearchAlgorithm {
	/**
	 * Executes the current search algorithm.
	 * 
	 * @param graph The target graph on which the algorithm will work.
	 * @param startNodeId The identifier of the starting node.
	 * @param targetNodeIds The identifier of the target nodes.
	 * @return A (possibly empty) collection of the search results.
	 */
	List<Integer> execute(final Graph graph, final Integer startNodeId, final List<Integer> targetNodeIds);
}
