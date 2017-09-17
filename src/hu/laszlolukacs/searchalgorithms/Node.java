/**
 * See LICENSE file
 */

package hu.laszlolukacs.searchalgorithms;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

// represents a node in a search
public class Node {

	protected int _numericId;
	protected String _label;
	protected int _xPos;
	protected int _yPos;

	// additional necessary attributes which are by default false
	protected boolean _isStartingPoint = false;
	protected boolean _isEndingPoint = false;

	// flag field which indicates if the node is visited in a search
	protected boolean _isVisited = false;
	protected boolean _isProcessed = false;

	protected int _distance = 0;
	protected double _heuristicDistance = 0;
	// returns the ref of the parent node
	protected Node _parentNode;
	// returns the list of the children nodes
	protected LinkedList<Node> _childNodes;
	protected CopyOnWriteArrayList<Vertex> _connectedVertices;

	// ctor - requires a numeric identifier, a label [*], an x coordinate and an
	// y coordinate
	public Node(int numericId, String label, int xPos, int yPos) {
		this._numericId = numericId;
		this._label = label;
		this._xPos = xPos;
		this._yPos = yPos;

		_parentNode = null;
		_childNodes = new LinkedList<Node>();
		_connectedVertices = new CopyOnWriteArrayList<Vertex>();
	}

	public int compareTo(Node other) {
		if (this._numericId < other.getId())
			return -1;
		else if (this._numericId == other.getId())
			return 0;
		else
			return 1;
	}

	public int getId() {
		return _numericId;
	}

	public int getX() {
		return _xPos;
	}

	public int getY() {
		return _yPos;
	}

	public boolean getStartingPointAttribute() {
		return _isStartingPoint;
	}

	public boolean getEndingPointAttribute() {
		return _isEndingPoint;
	}

	public boolean getIsVisitedAttribute() {
		return _isVisited;
	}

	public boolean getIsProcessed() {
		return _isProcessed;
	}

	public int getDistance() {
		return _distance;
	}

	public double getHeuristicDistance() {
		return _heuristicDistance;
	}

	public Node getParentNode() {
		return _parentNode;
	}

	public List<Node> getChildNodes() {
		return _childNodes;
	}

	public List<Vertex> getConnectedVertices() {
		return _connectedVertices;
	}

	public void setStartingPointAttribute(boolean isStartingPoint) {
		this._isStartingPoint = isStartingPoint;
	}

	public void setEndingPointAttribute(boolean isEndingPoint) {
		this._isEndingPoint = isEndingPoint;
	}

	public void setIsVisitedAttribute(boolean isVisited) {
		this._isVisited = isVisited;
	}

	public void setIsProcessed(boolean isProcessed) {
		this._isProcessed = isProcessed;
	}

	public void setDistance(int distance) {
		if (!_isProcessed)
			this._distance = distance;
	}

	public void setHeuristicDistance(double distance) {
		if (!_isProcessed)
			this._heuristicDistance = distance;
	}

	public void setParentNode(Node parentNode) {
		if (!_isProcessed)
			this._parentNode = (Node) parentNode;
	}
}
