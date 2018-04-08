/**
 * See LICENSE file
 */

package hu.laszlolukacs.searchalgorithms;

import hu.laszlolukacs.searchalgorithms.io.SearchInputParser;

import java.util.List;

import hu.laszlolukacs.searchalgorithms.io.OutputHelper;

/**
 * The main class of the application which contains the static entry point method.
 */
public class Search {

	/**
	 * The entry point for the application.
	 * 
	 * @param args
	 *            Array of strings containing the arguments that were passed to
	 *            the application.
	 */
	public static void main(String[] args) {

		String sourceFilePath, destinationFilePath;
		SearchContext context;
		SearchInputParser inputHelper;
		OutputHelper outputHelper;

		// howdy
		System.out.println(
				"Artifical Intelligence - Search algorithms homework\nCreated by Laszlo Lukacs (ENWBD4), 2011 fall semester");
		System.out.println("Command-line parameters:");
		// just to check which files have been opened
		for (String argument : args) {
			System.out.println("- " + argument);
		}

		// checks the number of the command-line parameters
		if (args.length >= 2) {
			sourceFilePath = args[0];
			destinationFilePath = args[1];
		}
		// fails when there are no valid command-line parameters
		else {
			System.out.println("ERROR: Too few arguments were specified.");
			return;
		}

		context = new SearchContext();
		// instances the input helper (the class which processes and parses the
		// source text file)
		inputHelper = new SearchInputParser();
		context = inputHelper.parseInputFile(sourceFilePath);
		// instances the output helper
		outputHelper = new OutputHelper(destinationFilePath);
		// executes the search
		List<Integer> results = context.executeSearchAlgorithm();
		outputHelper.setResults(results);
		outputHelper.store();
	}
}
