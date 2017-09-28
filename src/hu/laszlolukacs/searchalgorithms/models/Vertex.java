/**
 * See LICENSE file
 */

package hu.laszlolukacs.searchalgorithms.models;

/**
 * Represents a vertex in a graph, which always has a predefined cost.
 */
public class Vertex {

	/**
	 * The identifier of the first node.
	 */
	private int firstNodeId;

	/**
	 * The identifier of the other node.
	 */
	private int otherNodeId;

	/**
	 * The cost of the vertex.
	 */
	private int cost;

	/**
	 * Initializes a new instance of the `Vertex` class.
	 * 
	 * @param firstNodeId
	 *            The identifier of the first node.
	 * @param otherNodeId
	 *            The identifier of the other node.
	 * @param cost
	 *            The cost of the vertex.
	 */
	public Vertex(int firstNodeId, int otherNodeId, int cost) {
		this.firstNodeId = firstNodeId;
		this.otherNodeId = otherNodeId;
		this.cost = cost;
	}

	/**
	 * Gets the identifier of the first node to which this vertex is connected.
	 * 
	 * @return The identifier of the first node.
	 */
	public int getFirstNodeId() {
		return firstNodeId;
	}

	/**
	 * Gets the identifier of the other node to which this vertex is connected.
	 * 
	 * @return The identifier of the other node.
	 */
	public int getOtherNodeId() {
		return otherNodeId;
	}

	/**
	 * Gets the cost of this vertex.
	 * 
	 * @return The cost of the vertex.
	 */
	public int getCost() {
		return cost;
	}
}
