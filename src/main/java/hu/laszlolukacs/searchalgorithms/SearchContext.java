package hu.laszlolukacs.searchalgorithms;

import java.util.ArrayList;
import java.util.List;

import hu.laszlolukacs.searchalgorithms.implementations.SearchAlgorithm;
import hu.laszlolukacs.searchalgorithms.models.SymmetricDirectedGraph;

public class SearchContext {

	private SearchAlgorithm searchAlgorithm = null;
	private SymmetricDirectedGraph graph = null;
	private int startNodeId = -1;
	private List<Integer> objectiveNodeIds = new ArrayList<Integer>();
	
	public List<Integer> getTargetNodeIds() {
		return this.objectiveNodeIds;
	}

	public void setSearchAlgorithm(final SearchAlgorithm searchAlgorithm) {
		this.searchAlgorithm = searchAlgorithm;
	}

	public void setGraph(final SymmetricDirectedGraph graph) {
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
