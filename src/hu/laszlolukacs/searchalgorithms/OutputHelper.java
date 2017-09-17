/**
 * See LICENSE file
 */

package hu.laszlolukacs.searchalgorithms;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.LinkedList;

public class OutputHelper {

	private String _outputFilePath;
	private LinkedList<Integer> _results;

	public OutputHelper(String outputFilePath) {
		this._outputFilePath = outputFilePath;
		this._results = new LinkedList<Integer>();
	}

	public void setResults(LinkedList<Integer> results) {
		this._results = results;
	}

	public void store() {
		try {
			File outputFile = new File(_outputFilePath);
			FileWriter fwr = new FileWriter(outputFile, false);
			BufferedWriter bw = new BufferedWriter(fwr);
			bw.flush();

			if (!_results.isEmpty()) {
				for (int i = 0; i < _results.size(); i++) {
					bw.write(_results.get(i).toString());
					if (i != _results.size() - 1)
						bw.newLine();
				}

			} else
				bw.newLine();

			bw.flush();
			bw.close();

		} catch (Exception ex) {
			System.out.println(
					"ERROR: Couldn't write output text file. Exception details:\n" + ex.toString() + "\nStack trace: ");
			ex.printStackTrace();
		}
	}
}
