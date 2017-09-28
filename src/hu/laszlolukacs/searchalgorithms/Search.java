/**
 * See LICENSE file
 */

package hu.laszlolukacs.searchalgorithms;

import hu.laszlolukacs.searchalgorithms.models.SearchRepository;

/**
 * The main class which contains the static entry point method.
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
		SearchRepository repository;
		InputHelper inputHelper;
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
		if (args.length == 2) {
			sourceFilePath = args[0];
			destinationFilePath = args[1];
		}
		// fails when there are no valid command-line parameters
		else {
			System.out.println("ERROR: Invalid arguments were specified.");
			return;
		}

		// instances the repository (the class in which the elements of a search
		// will be stored)
		repository = new SearchRepository();
		// instances the input helper (the class which processes and parses the
		// source text file)
		inputHelper = new InputHelper(sourceFilePath, repository);
		// instances the output helper
		outputHelper = new OutputHelper(destinationFilePath);
		// parses the source text file
		inputHelper.process();
		// executes the search
		repository.getCurrentSearch().execute();
		outputHelper.setResults(repository.getCurrentSearch().getResult());
		outputHelper.store();
	}
}
