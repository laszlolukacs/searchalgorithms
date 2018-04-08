/**
 * See LICENSE file
 */

package hu.laszlolukacs.searchalgorithms.models;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Heuristics {

	public static double calculate(List<Node> destinations, Node currentNode, byte heuristicId) {
		// constant 0 heuristics
		if (heuristicId == 1)
			return 0.0;

		LinkedList<Double> results = new LinkedList<Double>();
		for (Node d : destinations) {
			switch (heuristicId) {
			// Manhattan distance heuristics
			case 2:
				results.add(
						(double) (Math.abs((d.getX() - currentNode.getX()) + Math.abs(d.getY() - currentNode.getY()))));
				break;
			// displacement distance heuristics
			case 3:
				results.add(Math.sqrt((d.getX() - currentNode.getX()) * (d.getX() - currentNode.getX())
						+ (d.getY() - currentNode.getY()) * (d.getY() - currentNode.getY())));
				break;
			}
		}
		Collections.sort(results);
		return results.getFirst();
	}
}
