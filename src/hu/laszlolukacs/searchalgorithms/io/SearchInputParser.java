/**
 * See LICENSE file
 */

package hu.laszlolukacs.searchalgorithms.io;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.security.InvalidParameterException;

import hu.laszlolukacs.searchalgorithms.SearchContext;
import hu.laszlolukacs.searchalgorithms.implementations.AStarSearch;
import hu.laszlolukacs.searchalgorithms.implementations.BreadthFirstSearch;
import hu.laszlolukacs.searchalgorithms.implementations.DepthFirstSearch;
import hu.laszlolukacs.searchalgorithms.implementations.GreedySearch;
import hu.laszlolukacs.searchalgorithms.implementations.SearchAlgorithm;
import hu.laszlolukacs.searchalgorithms.implementations.UniformCostSearch;
import hu.laszlolukacs.searchalgorithms.models.Edge;
import hu.laszlolukacs.searchalgorithms.models.Graph;
import hu.laszlolukacs.searchalgorithms.models.Node;

/**
 * Contains the methods and logic to parse the task specific input text files.
 */
public class SearchInputParser {

	private DataInputStream inputStream = null;

	private boolean newSection = false;
	private int currentSectionId = 0;

	private Graph graph = new Graph();
	private SearchContext context = new SearchContext();
	private int heuristicId = -1;

	public SearchContext parseInputFile(final String inputFilePath) {
		try {
			BufferedReader reader = this.openInputFile(inputFilePath);
			this.processInputFileContents(reader);

			this.context.setGraph(graph);

			this.inputStream.close();
			return this.context;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			// TODO Auto-generated catch blockghbbbbg
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Attempts to open the file at the specified location and returns a Reader
	 * instance.
	 * 
	 * @param inputFilePath
	 *            The path of the input file.
	 * @return Reader which can be used to access the content of the file.
	 * @throws FileNotFoundException
	 */
	private BufferedReader openInputFile(final String inputFilePath) throws FileNotFoundException {
		FileInputStream fis = new FileInputStream(inputFilePath);
		this.inputStream = new DataInputStream(fis);
		BufferedReader reader = new BufferedReader(new InputStreamReader(this.inputStream));
		return reader;
	}

	/**
	 * Processes the source text file.
	 */
	public void processInputFileContents(BufferedReader reader) throws NullPointerException {
		if (reader == null) {
			throw new NullPointerException("The reader cannot be null.");
		}

		try {
			// iterates through the source text file line by line
			String currentLine;
			while ((currentLine = reader.readLine()) != null) {
				this.parseCurrentLine(currentLine);
			}
		} catch (Exception ex) {
			System.out.println(
					"ERROR: Couldn't parse source text file. Exception details:\n" + ex.toString() + "\nStack trace: ");
			ex.printStackTrace();
		}
	}

	private void parseCurrentLine(final String currentLine) {
		// monitors for section separator characters ('#' or empty line)
		if (!this.toggleSectionSeparators(currentLine)) {
			/*
			 * rolls the flag back to false thus the section can be changed at
			 * the next line if necessary
			 */
			this.newSection = false;
			// examines the section
			switch (this.currentSectionId) {
			/*
			 * section 1 contains node informations, e.g. id label[*] xPos yPos
			 */
			case 1:
				Node node = this.parseNode(currentLine);
				this.graph.addNode(node, node.getId());
				break;
			/*
			 * section 2 contains vertex informations, e.g. end1 end2 cost
			 */
			case 2:
				Edge edge = this.parseEdge(currentLine);
				this.graph.addEdge(edge);
				break;

			/* section 3 contains starting node id */
			case 3:
				int startingNodeId = Integer.parseInt(currentLine);
				this.context.setStartingNodeId(startingNodeId);
				break;

			/* section 4 contains the objective nodes */
			case 4:
				int objectiveNodeId = Integer.parseInt(currentLine);
				this.context.getTargetNodeIds().add(objectiveNodeId);
				break;

			/*
			 * section 5 determines the search heuristic (only for the informed
			 * search algorithms)
			 */
			case 5:
				int heuristicMethodId = Integer.parseInt(currentLine);
				this.heuristicId = (byte) this.parseHeuristicsMethod(heuristicMethodId);
				break;

			/* section 6 selects the search algorithm */
			case 6:
				int algorithmId = Integer.parseInt(currentLine);
				SearchAlgorithm algorithm = this.parseAlgorithm(algorithmId, this.heuristicId);
				this.context.setSearchAlgorithm(algorithm);
				break;
			}
		}
	}

	private boolean toggleSectionSeparators(final String currentLine) {
		if ((currentLine.startsWith("#") || currentLine.contentEquals(""))) {
			if (!this.newSection) {
				/*
				 * sets the flag true to prevent any further changes to
				 * sectionId when separators are located in neighboring lines
				 */
				this.newSection = true;
				this.currentSectionId++;
			}

			return true;
		}
		/*
		 * processes the content of the source text file depending on the
		 * current section
		 */
		else {
			/*
			 * rolls the flag back to false thus the section can be changed at
			 * the next line if necessary
			 */
			this.newSection = false;
			return false;
		}
	}

	private Node parseNode(final String currentLine) throws InvalidParameterException {
		String[] nodeStrings = currentLine.split("\t");
		if (nodeStrings.length != 4) {
			// nodes can be created only with 4 parameters: id label[*] xPos
			// yPos
			throw new InvalidParameterException(
					"The input string describing a Node must contain exactly 4 substrings after splitting");
		}

		return Node.fromStrings(nodeStrings[0], nodeStrings[1], nodeStrings[2], nodeStrings[3]);
	}

	private Edge parseEdge(final String currentLine) throws InvalidParameterException {
		String[] edgeStrings = currentLine.split("\t");
		if (edgeStrings.length != 3) {
			// edges can be created only with 3 parameters: node1id, node2id,
			// cost
			throw new InvalidParameterException(
					"The input string describing an Edge must contain exactly 3 substrings after splitting");
		}

		return Edge.fromStrings(edgeStrings[0], edgeStrings[1], edgeStrings[2]);
	}

	private int parseHeuristicsMethod(final int heuristicId) throws InvalidParameterException {
		switch (heuristicId) {
		case 1:
			// Constant 0 heuristics
			return heuristicId;
		case 2:
			// Manhattan distance heuristics
			return heuristicId;
		case 3:
			// Displacement distance heuristics
			return heuristicId;
		default:
			throw new InvalidParameterException("The heuristic method id must be between 1 and 3.");
		}
	}

	private SearchAlgorithm parseAlgorithm(final int algorithmId, final int heuristicId)
			throws InvalidParameterException {
		SearchAlgorithm algorithm = null;
		switch (algorithmId) {
		case 1:
			algorithm = new BreadthFirstSearch();
			break;
		case 2:
			algorithm = new DepthFirstSearch();
			break;
		case 3:
			algorithm = new UniformCostSearch();
			break;
		case 4:
			algorithm = new GreedySearch(heuristicId);
			break;
		case 5:
			algorithm = new AStarSearch(heuristicId);
			break;
		default:
			throw new InvalidParameterException("The search algorithm id must be between 1 and 5.");
		}

		return algorithm;
	}
}
