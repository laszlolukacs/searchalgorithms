/**
 * See LICENSE file
 */

package hu.laszlolukacs.searchalgorithms;

import java.util.ArrayList;
import java.util.LinkedList;

import hu.laszlolukacs.searchalgorithms.models.Node;
import hu.laszlolukacs.searchalgorithms.models.Vertex;

// TODO: finish implementation
public abstract class SearchBase {

	protected int _startId;
	protected ArrayList<Vertex> _vertices;
	protected ArrayList<Node> _nodes;

	protected LinkedList<Node> _open;
	protected LinkedList<Node> _closed;
	protected LinkedList<Integer> _results;

	public SearchBase(ArrayList<Vertex> vertices, ArrayList<Node> nodes) {
		this._vertices = vertices;
		this._nodes = nodes;

		this._open = new LinkedList<Node>();
		this._closed = new LinkedList<Node>();
		this._results = new LinkedList<Integer>();
	}

	public void setStartId(int startId) {
		this._startId = startId;
	}

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

	public abstract void execute();
}
