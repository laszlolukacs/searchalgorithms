/**
 * See LICENSE file
 */

package hu.laszlolukacs.searchalgorithms;

import java.util.Comparator;

public class ComparatorCombined implements Comparator<Node> {

	public int compare(Node n1, Node n2) {
		if ((n1.getHeuristicDistance() + n1.getDistance()) < (n2.getHeuristicDistance() + n2.getDistance()))
			return -1;
		else if ((n1.getHeuristicDistance() + n1.getDistance()) == (n2.getHeuristicDistance() + n2.getDistance())) {
			if (n1.getId() < n2.getId())
				return -1;
			else if (n1.getId() == n2.getId())
				return 0;
			else
				return 1;
		} else
			return 1;
	}
}
