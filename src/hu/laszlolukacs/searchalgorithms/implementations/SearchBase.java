/**
 * See LICENSE file
 */

package hu.laszlolukacs.searchalgorithms.implementations;

import java.util.ArrayList;
import java.util.LinkedList;

import hu.laszlolukacs.searchalgorithms.models.Node;
import hu.laszlolukacs.searchalgorithms.models.Vertex;

/**
 * Abstract base class for concrete search algorithm implementations. Contains
 * the common necessary data structures.
 */
public abstract class SearchBase implements SearchAlgorithm {

	protected int _startId;
	protected ArrayList<Vertex> _vertices;
	protected ArrayList<Node> _nodes;

	protected LinkedList<Node> _open;
	protected LinkedList<Node> _closed;
	protected LinkedList<Integer> _results;

	/**
	 * Initializes a new instance of the `SearchBase` abstract class.
	 * 
	 * @param vertices
	 *            The vertices on which the search algorithm will be executed.
	 * @param nodes
	 *            The nodes on which the search algorithm will be executed.
	 */
	public SearchBase(ArrayList<Vertex> vertices, ArrayList<Node> nodes) {
		this._vertices = vertices;
		this._nodes = nodes;

		this._open = new LinkedList<Node>();
		this._closed = new LinkedList<Node>();
		this._results = new LinkedList<Integer>();
	}

	/**
	 * Sets the node with the specified identifier as the starting point of the
	 * algorithm execution.
	 * 
	 * @param nodeId
	 *            The id of the node which will be designated as the starting
	 *            point.
	 */
	public void setStartId(int startId) {
		this._startId = startId;
	}

	/**
	 * Gets the results of the search algorithm execution as a linked list.
	 * 
	 * @return A (possibly empty) collection of the search results.
	 */
	public LinkedList<Integer> getResult() {
		Node currentNode = _nodes.get(_results.getLast() - 1);

		while (!currentNode.getStartingPointAttribute()) {
			_results.addFirst(currentNode.getParentNode().getId());
			System.out.println(currentNode.getId());
			currentNode = _nodes.get(currentNode.getParentNode().getId() - 1);
		}
		// _results.addLast(currentNode.getId());
		System.out.println(currentNode.getId());

		return _results;
	}

	/**
	 * Executes the concrete search algorithm implementation.
	 */
	public abstract void execute();
}
