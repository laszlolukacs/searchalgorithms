/**
 * See LICENSE file
 */

package hu.laszlolukacs.searchalgorithms;

import hu.laszlolukacs.searchalgorithms.implementations.SearchAlgorithm;
import hu.laszlolukacs.searchalgorithms.models.Graph;

import java.util.ArrayList;
import java.util.List;

/**
 * Contains all the relevant parameters which are needed to successfully execute a search algorithm.
 */
public class SearchContext {

    private SearchAlgorithm searchAlgorithm = null;

    private Graph graph = null;

    private int startNodeId = -1;

    private List<Integer> objectiveNodeIds = new ArrayList<Integer>();

    public List<Integer> getTargetNodeIds() {
        return this.objectiveNodeIds;
    }

    public void setSearchAlgorithm(final SearchAlgorithm searchAlgorithm) {
        this.searchAlgorithm = searchAlgorithm;
    }

    public void setGraph(final Graph graph) {
        this.graph = graph;
    }

    public void setStartingNodeId(final int startNodeId) {
        this.startNodeId = startNodeId;
    }

    public List<Integer> executeSearchAlgorithm() {
        if (this.searchAlgorithm != null) {
            return this.searchAlgorithm.execute(this.graph, this.startNodeId, this.objectiveNodeIds);
        }

        return null;
    }
}
