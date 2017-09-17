/**
 * See LICENSE file
 */

package hu.laszlolukacs.searchalgorithms;

import java.util.ArrayList;
import java.util.Collections;

public class SearchAStar extends SearchBase {

	private byte _heuristicId;
	private ArrayList<Node> _destinations;

	public SearchAStar(ArrayList<Vertex> vertices, ArrayList<Node> nodes, ArrayList<Node> destinations,
			byte heuristicId) {
		super(vertices, nodes);

		this._heuristicId = heuristicId;
		this._destinations = destinations;
	}

	public void execute() {
		int i = 1;
		Node currentNode = (Node) _nodes.get(_startId - 1);

		switch (_heuristicId) {
		case 1:
			System.out.println("*****\nExecuting A* search with constant 0 heuristics\n*****");
			break;
		case 2:
			System.out.println("*****\nExecuting A* search with Manhattan distance heuristics\n*****");
			break;
		case 3:
			System.out.println("*****\nExecuting A* search with Displacement distance heuristics\n*****");
			break;
		}

		_open.add(currentNode);
		currentNode.setIsProcessed(true);

		while (!_open.isEmpty()) {
			System.out.println("X After step: " + i);

			currentNode = (Node) _open.remove();
			currentNode.setIsVisitedAttribute(true);
			_closed.add(currentNode);

			System.out.println("i 'Closed' node:");
			for (Node n : _closed) {
				System.out.print(n.getId() + " (" + n.getHeuristicDistance() + "+" + n.getDistance() + "), ");
			}
			System.out.println();

			if (currentNode.getEndingPointAttribute()) {
				System.out.println("! Result found: " + currentNode.getId() + " STOPPED.");
				_results.addLast(currentNode.getId());
				return;
			} else {
				for (Vertex v : currentNode.getConnectedVertices()) {
					if (v.getFirstEndId() == currentNode.getId()) {
						if (!_nodes.get(v.getOtherEndId() - 1).getIsProcessed()
								&& !_nodes.get(v.getOtherEndId() - 1).getIsVisitedAttribute()) {
							_nodes.get(v.getOtherEndId() - 1).setParentNode(currentNode);
							_nodes.get(v.getOtherEndId() - 1).setDistance(currentNode.getDistance() + v.getCost());
							_nodes.get(v.getOtherEndId() - 1).setHeuristicDistance(Heuristics.calculate(_destinations,
									_nodes.get(v.getOtherEndId() - 1), _heuristicId));
							currentNode.getChildNodes().add(_nodes.get(v.getOtherEndId() - 1));
							_nodes.get(v.getOtherEndId() - 1).setIsProcessed(true);
						}
					} else {
						if (!_nodes.get(v.getFirstEndId() - 1).getIsProcessed()
								&& !_nodes.get(v.getFirstEndId() - 1).getIsVisitedAttribute()) {
							_nodes.get(v.getFirstEndId() - 1).setParentNode(currentNode);
							_nodes.get(v.getFirstEndId() - 1).setDistance(currentNode.getDistance() + v.getCost());
							_nodes.get(v.getFirstEndId() - 1).setHeuristicDistance(Heuristics.calculate(_destinations,
									_nodes.get(v.getFirstEndId() - 1), _heuristicId));
							currentNode.getChildNodes().add(_nodes.get(v.getFirstEndId() - 1));
							_nodes.get(v.getFirstEndId() - 1).setIsProcessed(true);
						}
					}
				}
				if (!currentNode.getChildNodes().isEmpty()) {
					Collections.sort(currentNode.getChildNodes(), new ComparatorCombined());
					for (Node n : currentNode.getChildNodes()) {
						if (n.getIsVisitedAttribute() == false) {
							_open.add((Node) n);
							System.out.println("Added to 'Open': " + n.getId() + " (" + n.getHeuristicDistance() + "+"
									+ n.getDistance() + ")");
						}
					}
				}
				Collections.sort(_open, new ComparatorCombined());

				System.out.println("i 'Open' array contains: ");
				for (Node n : _open) {
					System.out.print(n.getId() + " (" + n.getHeuristicDistance() + "+" + n.getDistance() + "), ");
				}
				System.out.println();
			}
			i++;
		}
	}
}
