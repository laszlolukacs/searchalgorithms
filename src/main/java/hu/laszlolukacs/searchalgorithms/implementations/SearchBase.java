/**
 * See LICENSE file
 */

package hu.laszlolukacs.searchalgorithms.implementations;

import java.util.LinkedList;
import java.util.List;

import hu.laszlolukacs.searchalgorithms.models.SymmetricDirectedGraph;
import hu.laszlolukacs.searchalgorithms.models.Node;

/**
 * Abstract base class for concrete search algorithm implementations. Contains
 * the common necessary data structures.
 */
public abstract class SearchBase implements SearchAlgorithm {

	protected List<Node> _open;
	protected List<Node> _closed;
	protected List<Integer> _results;

	/**
	 * Initializes a new instance of the `SearchBase` abstract class.
	 * 
	 * @param vertices
	 *            The vertices on which the search algorithm will be executed.
	 * @param nodes
	 *            The nodes on which the search algorithm will be executed.
	 */
	public SearchBase() {
		this._open = new LinkedList<Node>();
		this._closed = new LinkedList<Node>();
		this._results = new LinkedList<Integer>();
	}

//	/**
//	 * Gets the results of the search algorithm execution as a linked list.
//	 * 
//	 * @return A (possibly empty) collection of the search results.
//	 */
//	public LinkedList<Integer> getResult() {
//		Node currentNode = _nodes.get(_results.getLast() - 1);
//
//		while (!currentNode.getStartingPointAttribute()) {
//			_results.addFirst(currentNode.getParentNode().getId());
//			System.out.println(currentNode.getId());
//			currentNode = _nodes.get(currentNode.getParentNode().getId() - 1);
//		}
//		// _results.addLast(currentNode.getId());
//		System.out.println(currentNode.getId());
//
//		return _results;
//	}

	/**
	 * Executes the concrete search algorithm.
	 * 
	 * @param graph The target graph on which the algorithm will work.
	 * @param startNodeId The identifier of the starting node.
	 * @param targetNodeIds The identifier of the target nodes.
	 * @return A (possibly empty) collection of the search results.
	 */
	public abstract List<Integer> execute(final SymmetricDirectedGraph graph, final Integer startNodeId, final List<Integer> targetNodeIds);
}
