/**
 * See LICENSE file
 */

package hu.laszlolukacs.searchalgorithms;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;

// processes and parses the source text file
public class InputHelper {

	private byte _heuristicId;
	private int _tempStartingId;
	private String _inputFilePath;
	private SearchRepository _repository;

	// ctor - requires the source text file's path and an instance of a
	// repository
	public InputHelper(String inputFilePath, SearchRepository r) {
		this._inputFilePath = inputFilePath;
		this._repository = r;
	}

	// processes the source text file
	public void process() {
		try {
			boolean isNewSectionStarted = false;
			byte sectionId = 0;
			String currentLine;
			String[] processed = null;

			System.out.println("Reading & parsing source text file (" + _inputFilePath + ")...");

			FileInputStream fis = new FileInputStream(_inputFilePath);
			DataInputStream dis = new DataInputStream(fis);
			BufferedReader br = new BufferedReader(new InputStreamReader(dis));

			// iterates through the source text file line by line
			while ((currentLine = br.readLine()) != null) {
				// monitors for section separator characters ('#' or empty line)
				// [*]
				if (currentLine.startsWith("#") || currentLine.contentEquals("")) {
					if (!isNewSectionStarted) {
						// sets the flag true to prevent any further changes to
						// sectionId when separators are located in neighbouring
						// lines
						isNewSectionStarted = true;
						sectionId++;
						System.out.println("# Section " + sectionId);
					}
				}
				// processes the content of the source text file depending on
				// the current section
				else {
					// rolls the flag back to false thus the section can be
					// changed at the next line if necessary
					isNewSectionStarted = false;
					// examines the section
					switch (sectionId) {

					/*
					 * section 1 contains node informations id label[*] xPos
					 * yPos
					 */
					case 1:
						// splits the text line by the 'tab' character
						processed = currentLine.split("\t");
						// nodes can be created only with 4 parameters
						if (processed.length == 4) {
							_repository.addNode(
									new Node(Integer.parseInt(processed[0]), processed[1],
											Integer.parseInt(processed[2]), Integer.parseInt(processed[3])),
									Integer.parseInt(processed[0]) - 1);
							System.out.println("* Node #" + processed[0] + " stored.");
						}
						break;

					/*
					 * section 2 contains vertex informations end1 end2 cost
					 */
					case 2:
						processed = currentLine.split("\t");
						// vertices can be created only with 3 parameters
						if (processed.length == 3) {
							_repository.addVertex(new Vertex(Integer.parseInt(processed[0]),
									Integer.parseInt(processed[1]), Integer.parseInt(processed[2])));
							System.out.println("* Vertex between " + processed[0] + "-" + processed[1] + " stored.");
						}
						break;

					/* section 3 contains starting node id */
					case 3:
						/*
						 * gets from the repository the node list then gets from
						 * the list the specified node and finally sets it's
						 * starting point attribute to true
						 */
						_repository.getNodesList().get(Integer.parseInt(currentLine) - 1)
								.setStartingPointAttribute(true);
						_tempStartingId = Integer.parseInt(currentLine);
						System.out.println("* Starting node (#" + currentLine + ") set.");
						break;

					/* section 4 contains the ending nodes */
					case 4:
						_repository.getNodesList().get(Integer.parseInt(currentLine) - 1).setEndingPointAttribute(true);
						_repository.addDestination(_repository.getNodesList().get(Integer.parseInt(currentLine) - 1));
						System.out.println("* Ending node (#" + currentLine + ") stored.");
						break;

					/*
					 * section 5 determines the search heuristic (for the
					 * informated search algorithms)
					 */
					// TODO: implementation!
					case 5:
						/*
						 * 1: constant 0 heuristic h1 2: Manhattan distance
						 * heuristic h2 3: displacement distance h3
						 */
						switch (Integer.parseInt(currentLine)) {
						case 1:
							_heuristicId = 1;
							System.out.println("* Constant 0 heuristics selected.");
							break;
						case 2:
							_heuristicId = 2;
							System.out.println("* Manhattan distance heuristics selected.");
							break;
						case 3:
							_heuristicId = 3;
							System.out.println("* Displacement distance heuristics selected.");
							break;
						}
						break;

					/* section 6 selects the search algorithm */
					// TODO: implementation!
					case 6:
						/*
						 * 1: BFS b 2: DFS d 3: Uniform cost search u 4: Greedy
						 * algorithm g 5: A* search a
						 */
						switch (Integer.parseInt(currentLine)) {
						case 1:
							_repository.setSearch(
									new SearchBreadthFirst(_repository.getVerticesList(), _repository.getNodesList()));
							System.out.println("* Breath-first search algorithm selected.");
							break;
						case 2:
							_repository.setSearch(
									new SearchDepthFirst(_repository.getVerticesList(), _repository.getNodesList()));
							System.out.println("* Depth-first search algorithm selected.");
							break;
						case 3:
							_repository.setSearch(
									new SearchUniformCost(_repository.getVerticesList(), _repository.getNodesList()));
							System.out.println("* Uniform cost search algorithm selected.");
							break;
						case 4:
							_repository.setSearch(new SearchGreedy(_repository.getVerticesList(),
									_repository.getNodesList(), _repository.getDestinationsList(), _heuristicId));
							System.out.println("* Greedy algorithm selected.");
							break;
						case 5:
							_repository.setSearch(new SearchAStar(_repository.getVerticesList(),
									_repository.getNodesList(), _repository.getDestinationsList(), _heuristicId));
							System.out.println("* A* search algorithm selected.");
							break;
						}
						break;
					}
				}
			}

			// sorts the nodes by their id
			_repository.getCurrentSearch().setStartId(_tempStartingId);
			_repository.sortNodes();
			System.out.println("* Nodes were sorted by id.");

			// closes the stream, as it's obligatory!
			dis.close();
			System.out.println("Source text file parsed successfully.");
		} catch (Exception ex) {
			System.out.println(
					"ERROR: Couldn't parse source text file. Exception details:\n" + ex.toString() + "\nStack trace: ");
			ex.printStackTrace();
		}
	}
}
