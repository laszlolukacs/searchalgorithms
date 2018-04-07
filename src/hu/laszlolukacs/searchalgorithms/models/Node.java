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
	private int id;

	/**
	 * The optional description label of the node.
	 */
	private String label;

	/**
	 * The X coordinate of the node.
	 */
	private int x;

	/**
	 * The Y coordinate of the node.
	 */
	private int y;

	/**
	 * A value that indicates whether this node has been visited during the
	 * execution of a search algorithm.
	 */
	private boolean hasBeenVisited = false;

	/**
	 * A value that indicates whether this node has been processed during the
	 * execution of a search algorithm.
	 */
	private boolean hasBeenProcessed = false;

	/**
	 * Represents the node's distance.
	 */
	private int distance = 0;

	/**
	 * Represents the node's heuristic distance.
	 */
	private double heuristicDistance = 0;

	/**
	 * References the parent node in the graph.
	 */
	private Node parentNode;

	/**
	 * A collection of child nodes in the graph.
	 */
	private LinkedList<Node> childNodes;

	/**
	 * A collection of edges which are connected to this node.
	 */
	private CopyOnWriteArrayList<Edge> connectedEdges;

	/**
	 * Initializes a new instance of the `Node` class.
	 * 
	 * @param id
	 *            The numerical identifier of the node.
	 * @param label
	 *            The label of the node.
	 * @param x
	 *            The X coordinate on the graph.
	 * @param y
	 *            The Y coordinate on the graph.
	 */
	public Node(int id, String label, int x, int y) {
		this.id = id;
		this.label = label;
		this.x = x;
		this.y = y;

		this.parentNode = null;
		this.childNodes = new LinkedList<Node>();
		this.connectedEdges = new CopyOnWriteArrayList<Edge>();
	}

	public static Node fromStrings(String id, String label, String x, String y) throws NumberFormatException {
		return new Node(Integer.parseInt(id), label, Integer.parseInt(x), Integer.parseInt(y));
	}

	/**
	 * Gets the numerical identifier of the node.
	 * 
	 * @return The numerical identifier of the node.
	 */
	public int getId() {
		return this.id;
	}

	/**
	 * Gets the optional description of the node.
	 * 
	 * @return The description of the node.
	 */
	public String getLabel() {
		return this.label;
	}

	/**
	 * Gets the X coordinate of the node.
	 * 
	 * @return The X coordinate of the node.
	 */
	public int getX() {
		return this.x;
	}

	/**
	 * Gets the Y coordinate of the node.
	 * 
	 * @return The Y coordinate of the node.
	 */
	public int getY() {
		return this.y;
	}

	/**
	 * Gets a value that indicates whether this node has been visited during a
	 * search algorithm.
	 * 
	 * @return True, if this node has been visited, otherwise false.
	 */
	public boolean getHasBeenVisited() {
		return this.hasBeenVisited;
	}

	/**
	 * Gets a value that indicates whether this node has been processed during a
	 * search algorithm.
	 * 
	 * @return True, if this node has been processed, otherwise false.
	 */
	public boolean getHasBeenProcessed() {
		return this.hasBeenProcessed;
	}

	/**
	 * Gets the node's distance.
	 * 
	 * @return The distance of the node.
	 */
	public int getDistance() {
		return this.distance;
	}

	/**
	 * Gets the node's heuristic distance.
	 * 
	 * @return The heuristic distance of the node.
	 */
	public double getHeuristicDistance() {
		return this.heuristicDistance;
	}

	/**
	 * Gets the parent node of the current instance.
	 * 
	 * @return The (possibly null) parent node of the current instance.
	 */
	public Node getParentNode() {
		return this.parentNode;
	}

	/**
	 * Gets the child nodes of the current instance.
	 * 
	 * @return A (possibly empty) collection of the child nodes.
	 */
	public List<Node> getChildNodes() {
		return this.childNodes;
	}

	/**
	 * Gets the edges which are connected to the current instance.
	 * 
	 * @return A (possibly empty) collection of the connected edges.
	 */
	public List<Edge> getConnectedEdges() {
		return this.connectedEdges;
	}

	/**
	 * Sets whether this node has been visited during a search algorithm.
	 * 
	 * @param hasBeenVisited
	 *            A value that indicates whether this node has been visited.
	 */
	public void setHasBeenVisited(boolean hasBeenVisited) {
		this.hasBeenVisited = hasBeenVisited;
	}

	/**
	 * Sets whether this node has been processed during a search algorithm.
	 * 
	 * @param hasBeenProcessed
	 *            A value that indicates whether this node has been processed.
	 */
	public void setHasBeenProcessed(boolean hasBeenProcessed) {
		this.hasBeenProcessed = hasBeenProcessed;
	}

	/**
	 * Sets the node's distance.
	 * 
	 * @param distance
	 *            The distance of the node.
	 */
	public void setDistance(int distance) {
		if (!hasBeenProcessed) {
			this.distance = distance;
		}
	}

	/**
	 * Sets the node's heuristic distance.
	 * 
	 * @param distance
	 *            The heuristic distance of the node.
	 */
	public void setHeuristicDistance(double distance) {
		if (!hasBeenProcessed) {
			this.heuristicDistance = distance;
		}
	}

	/**
	 * Sets the parent node of the current `Node` instance.
	 * 
	 * @param parentNode
	 *            The parent node.
	 */
	public void setParentNode(Node parentNode) {
		if (!hasBeenProcessed) {
			this.parentNode = (Node) parentNode;
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
		if (this.id < other.getId()) {
			return -1;
		} else if (this.id == other.getId()) {
			return 0;
		} else {
			return 1;
		}
	}
}
