/**
 * See LICENSE file
 */

package hu.laszlolukacs.searchalgorithms;

import java.util.ArrayList;
import java.util.Collections;

// stores the elements of a search
public class SearchRepository {

	private ArrayList<Node> _nodes;
	private ArrayList<Node> _destinations;
	private ArrayList<Vertex> _vertices;

	private SearchBase _currentSearch;

	// ctor - requires nothing since it constructs an empty repository
	public SearchRepository() {
		this._nodes = new ArrayList<Node>();
		this._destinations = new ArrayList<Node>();
		this._vertices = new ArrayList<Vertex>();
		this._currentSearch = null;
	}

	public ArrayList<Node> getNodesList() {
		return _nodes;
	}

	public ArrayList<Node> getDestinationsList() {
		return _destinations;
	}

	public ArrayList<Vertex> getVerticesList() {
		return _vertices;
	}

	public SearchBase getCurrentSearch() {
		return _currentSearch;
	}

	public void addNode(Node n, int index) {
		_nodes.add(index, n);
	}

	public void addDestination(Node d) {
		_destinations.add(d);
	}

	public void addVertex(Vertex v) {
		_vertices.add(v);
		_nodes.get(v.getFirstEndId() - 1).getConnectedVertices().add(v);
		_nodes.get(v.getOtherEndId() - 1).getConnectedVertices().add(v);
	}

	public void setSearch(SearchBase s) {
		_currentSearch = s;
	}

	public void sortNodes() {
		Collections.sort(this._nodes, new ComparatorById());
	}

	public void setStartingId(int startId) {
		_currentSearch.setStartId(startId);
	}
}
