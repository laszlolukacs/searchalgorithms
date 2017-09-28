/**
 * See LICENSE file
 */

package hu.laszlolukacs.searchalgorithms.models;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Represents a node in a graph.
 */
public class Node {

	/**
	 * The unique numerical identifier of the node.
	 */
	private int _id;

	/**
	 * The optional description label of the node.
	 */
	private String _label;

	/**
	 * The X coordinate of the node.
	 */
	private int _xPos;

	/**
	 * The Y coordinate of the node.
	 */
	private int _yPos;

	/**
	 * A value that indicates whether this node is the starting point of a
	 * directed graph.
	 */
	private boolean _isStartingPoint = false;

	/**
	 * A value that indicates whether this node is the drainage (end) point of a
	 * directed graph.
	 */
	private boolean _isEndingPoint = false;

	/**
	 * A value that indicates whether this node has been visited during the
	 * execution of a search algorithm.
	 */
	private boolean _hasBeenVisited = false;

	/**
	 * A value that indicates whether this node has been processed during the
	 * execution of a search algorithm.
	 */
	private boolean _hasBeenProcessed = false;

	/**
	 * Represents the node's distance.
	 */
	protected int _distance = 0;

	/**
	 * Represents the node's heuristic distance.
	 */
	protected double _heuristicDistance = 0;

	/**
	 * References the parent node in the graph.
	 */
	protected Node _parentNode;

	/**
	 * A collection of child nodes in the graph.
	 */
	protected LinkedList<Node> _childNodes;

	/**
	 * A collection of vertices which are connected to this node.
	 */
	protected CopyOnWriteArrayList<Vertex> _connectedVertices;

	/**
	 * Initializes a new instance of the `Node` class.
	 * 
	 * @param id
	 *            The numerical identifier of the node.
	 * @param label
	 *            The label of the node.
	 * @param xPos
	 *            The X coordinate on the graph.
	 * @param yPos
	 *            The Y coordinate on the graph.
	 */
	public Node(int id, String label, int xPos, int yPos) {
		this._id = id;
		this._label = label;
		this._xPos = xPos;
		this._yPos = yPos;

		_parentNode = null;
		_childNodes = new LinkedList<Node>();
		_connectedVertices = new CopyOnWriteArrayList<Vertex>();
	}

	/**
	 * Gets the numerical identifier of the node.
	 * 
	 * @return The numerical identifier of the node.
	 */
	public int getId() {
		return _id;
	}

	/**
	 * Gets the optional description of the node.
	 * 
	 * @return The description of the node.
	 */
	public String getLabel() {
		return _label;
	}

	/**
	 * Gets the X coordinate of the node.
	 * 
	 * @return The X coordinate of the node.
	 */
	public int getX() {
		return _xPos;
	}

	/**
	 * Gets the Y coordinate of the node.
	 * 
	 * @return The Y coordinate of the node.
	 */
	public int getY() {
		return _yPos;
	}

	/**
	 * Gets a value that indicates whether this node is the starting point of a
	 * directed graph.
	 * 
	 * @return True if this node is the starting node, otherwise false.
	 */
	public boolean getStartingPointAttribute() {
		return _isStartingPoint;
	}

	/**
	 * Gets a value that indicates whether this node is the drainage (end) point
	 * of a directed graph.
	 * 
	 * @return True, if this node is the end node, otherwise false.
	 */
	public boolean getEndingPointAttribute() {
		return _isEndingPoint;
	}

	/**
	 * Gets a value that indicates whether this node has been visited during a
	 * search algorithm.
	 * 
	 * @return True, if this node has been visited, otherwise false.
	 */
	public boolean getHasBeenVisited() {
		return _hasBeenVisited;
	}

	/**
	 * Gets a value that indicates whether this node has been processed during a
	 * search algorithm.
	 * 
	 * @return True, if this node has been processed, otherwise false.
	 */
	public boolean getHasBeenProcessed() {
		return _hasBeenProcessed;
	}

	/**
	 * Gets the node's distance.
	 * 
	 * @return The distance of the node.
	 */
	public int getDistance() {
		return _distance;
	}

	/**
	 * Gets the node's heuristic distance.
	 * 
	 * @return The heuristic distance of the node.
	 */
	public double getHeuristicDistance() {
		return _heuristicDistance;
	}

	/**
	 * Gets the parent node of the current instance.
	 * 
	 * @return The (possibly null) parent node of the current instance.
	 */
	public Node getParentNode() {
		return _parentNode;
	}

	/**
	 * Gets the child nodes of the current instance.
	 * 
	 * @return A (possibly empty) collection of the child nodes.
	 */
	public List<Node> getChildNodes() {
		return _childNodes;
	}

	/**
	 * Gets the vertices which are connected to the current instance.
	 * 
	 * @return A (possibly empty) collection of the connected vertices.
	 */
	public List<Vertex> getConnectedVertices() {
		return _connectedVertices;
	}

	/**
	 * Sets whether this node is the starting point of a directed graph.
	 * 
	 * @param isStartingPoint
	 *            A value that indicates whether this node is the starting
	 *            point.
	 */
	public void setStartingPointAttribute(boolean isStartingPoint) {
		this._isStartingPoint = isStartingPoint;
	}

	/**
	 * Sets whether this node is the ending point of a directed graph.
	 * 
	 * @param isEndingPoint
	 *            A value that indicates whether this node is the ending point.
	 */
	public void setEndingPointAttribute(boolean isEndingPoint) {
		this._isEndingPoint = isEndingPoint;
	}

	/**
	 * Sets whether this node has been visited during a search algorithm.
	 * 
	 * @param hasBeenVisited
	 *            A value that indicates whether this node has been visited.
	 */
	public void setHasBeenVisited(boolean hasBeenVisited) {
		this._hasBeenVisited = hasBeenVisited;
	}

	/**
	 * Sets whether this node has been processed during a search algorithm.
	 * 
	 * @param hasBeenProcessed
	 *            A value that indicates whether this node has been processed.
	 */
	public void setHasBeenProcessed(boolean hasBeenProcessed) {
		this._hasBeenProcessed = hasBeenProcessed;
	}

	/**
	 * Sets the node's distance.
	 * 
	 * @param distance
	 *            The distance of the node.
	 */
	public void setDistance(int distance) {
		if (!_hasBeenProcessed) {
			this._distance = distance;
		}
	}

	/**
	 * Sets the node's heuristic distance.
	 * 
	 * @param distance
	 *            The heuristic distance of the node.
	 */
	public void setHeuristicDistance(double distance) {
		if (!_hasBeenProcessed) {
			this._heuristicDistance = distance;
		}
	}

	/**
	 * Sets the parent node of the current `Node` instance.
	 * 
	 * @param parentNode
	 *            The parent node.
	 */
	public void setParentNode(Node parentNode) {
		if (!_hasBeenProcessed) {
			this._parentNode = (Node) parentNode;
		}
	}

	/**
	 * Compares the current instance with another object of the same type and
	 * returns an integer that indicates whether the current instance precedes,
	 * follows, or occurs in the same position in the sort order as the other
	 * object.
	 * 
	 * @param other
	 *            An object to compare with this instance.
	 * @return A value that indicates the relative order of the objects being
	 *         compared.
	 */
	public int compareTo(Node other) {
		if (this._id < other.getId()) {
			return -1;
		} else if (this._id == other.getId()) {
			return 0;
		} else {
			return 1;
		}
	}
}
