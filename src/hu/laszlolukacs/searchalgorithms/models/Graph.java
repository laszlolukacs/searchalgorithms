/**
 * See LICENSE file
 */

package hu.laszlolukacs.searchalgorithms.models;

import java.util.ArrayList;
import java.util.Collections;

import hu.laszlolukacs.searchalgorithms.implementations.SearchBase;
import hu.laszlolukacs.searchalgorithms.models.comparators.ComparatorById;

/**
 * Represents a graph which consists of a collection of nodes connected by
 * vertices.
 */
public class Graph {

	/**
	 * The collection of the graph nodes.
	 */
	private ArrayList<Node> nodes;

	/**
	 * The collection of destination nodes.
	 */
	private ArrayList<Node> destinations;

	/**
	 * The collection of the vertices between the nodes.
	 */
	private ArrayList<Vertex> vertices;

	private SearchBase _currentSearch;

	/**
	 * Initializes a new instance of the `Graph` class.
	 */
	public Graph() {
		this.nodes = new ArrayList<Node>();
		this.destinations = new ArrayList<Node>();
		this.vertices = new ArrayList<Vertex>();
		this._currentSearch = null;
	}

	/**
	 * Gets the (possibly empty) collection of nodes of the graph.
	 * 
	 * @return
	 */
	public ArrayList<Node> getNodesList() {
		return nodes;
	}

	/**
	 * Gets the (possibly empty) collection of destination nodes of the graph.
	 * 
	 * @return
	 */
	public ArrayList<Node> getDestinationsList() {
		return destinations;
	}

	/**
	 * Gets the (possibly empty) collection of vertices of the graph.
	 * 
	 * @return
	 */
	public ArrayList<Vertex> getVerticesList() {
		return vertices;
	}

	public SearchBase getCurrentSearch() {
		return _currentSearch;
	}

	/**
	 * Adds a node with the specified index to the graph.
	 * 
	 * @param node
	 *            The node to be added.
	 * @param index
	 *            The index of the node in the graph.
	 */
	public void addNode(Node node, int index) {
		nodes.add(index, node);
	}

	/**
	 * Adds a destination node to the graph.
	 * 
	 * @param node
	 *            The node to be added as a destination.
	 */
	public void addDestination(Node node) {
		destinations.add(node);
	}

	/**
	 * Adds a vertex to the graph.
	 * 
	 * @param vertex
	 *            The vertex to be added.
	 */
	public void addVertex(Vertex vertex) {
		vertices.add(vertex);
		nodes.get(vertex.getFirstNodeId() - 1).getConnectedVertices().add(vertex);
		nodes.get(vertex.getOtherNodeId() - 1).getConnectedVertices().add(vertex);
	}

	public void setSearch(SearchBase s) {
		_currentSearch = s;
	}

	/**
	 * Sorts the nodes of the graph by their identifiers.
	 */
	public void sortNodes() {
		Collections.sort(this.nodes, new ComparatorById());
	}

	/**
	 * Sets the node with the specified identifier as the starting point of the
	 * graph.
	 * 
	 * @param nodeId
	 *            The id of the node which will be designated as the starting
	 *            point.
	 */
	public void setStartingId(int nodeId) {
		_currentSearch.setStartId(nodeId);
	}
}
