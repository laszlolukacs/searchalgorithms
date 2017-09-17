/**
 * See LICENSE file
 */

package hu.laszlolukacs.searchalgorithms;

import java.util.ArrayList;
import java.util.Collections;

public class SearchBreadthFirst extends SearchBase {

	public SearchBreadthFirst(ArrayList<Vertex> vertices, ArrayList<Node> nodes) {
		super(vertices, nodes);
	}

	public void execute() {
		int i = 1;
		Node currentNode = (Node) _nodes.get(_startId - 1);

		System.out.println("*****\nExecuting Breadth-first search...\n*****");

		_open.add(currentNode);
		currentNode.setIsProcessed(true);

		while (!_open.isEmpty()) {
			System.out.println("X After step: " + i);

			currentNode = (Node) _open.remove();
			currentNode.setIsVisitedAttribute(true);
			_closed.add(currentNode);

			System.out.println("i 'Closed' array contains:");
			for (Node n : _closed) {
				System.out.print(n.getId() + ", ");
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
							currentNode.getChildNodes().add(_nodes.get(v.getOtherEndId() - 1));
							_nodes.get(v.getOtherEndId() - 1).setIsProcessed(true);
						}
					} else {
						if (!_nodes.get(v.getFirstEndId() - 1).getIsProcessed()
								&& !_nodes.get(v.getFirstEndId() - 1).getIsVisitedAttribute()) {
							_nodes.get(v.getFirstEndId() - 1).setParentNode(currentNode);
							currentNode.getChildNodes().add(_nodes.get(v.getFirstEndId() - 1));
							_nodes.get(v.getFirstEndId() - 1).setIsProcessed(true);
						}
					}
				}
				if (!currentNode.getChildNodes().isEmpty()) {
					Collections.sort(currentNode.getChildNodes(), new ComparatorById());
					for (Node n : currentNode.getChildNodes()) {
						if (n.getIsVisitedAttribute() == false) {
							_open.add(n);
							System.out.println("Added to 'open': " + n.getId());
						}
					}
				}

				System.out.println("i 'Open' array contains: ");
				for (Node n : _open) {
					System.out.print(n.getId() + ", ");
				}
				System.out.println();
			}
			i++;
		}
	}
}
