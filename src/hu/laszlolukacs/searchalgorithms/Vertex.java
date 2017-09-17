/**
 * See LICENSE file
 */

package hu.laszlolukacs.searchalgorithms;

// represents a vertex in a search which always bears a predefined cost
public class Vertex {

	private int _firstEndId, _otherEndId;
	private int _cost;

	// ctor - requires the two end nodes of the vertex and its cost
	public Vertex(int firstEndId, int otherEndId, int cost) {
		this._firstEndId = firstEndId;
		this._otherEndId = otherEndId;
		this._cost = cost;
	}

	public int getFirstEndId() {
		return _firstEndId;
	}

	public int getOtherEndId() {
		return _otherEndId;
	}

	public int getCost() {
		return _cost;
	}
}
