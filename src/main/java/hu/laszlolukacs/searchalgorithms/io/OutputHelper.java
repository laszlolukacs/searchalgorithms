/**
 * See LICENSE file
 */

package hu.laszlolukacs.searchalgorithms.io;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.LinkedList;
import java.util.List;

/**
 * Contains the methods and logic to emit the results to a text file.
 */
public class OutputHelper {

    private String _outputFilePath;
    private List<Integer> _results;

    /**
     * Initializes a new instance of the `OutputHelper` class.
     *
     * @param outputFilePath The path of the output file.
     */
    public OutputHelper(String outputFilePath) {
        this._outputFilePath = outputFilePath;
        this._results = new LinkedList<Integer>();
    }

    /**
     * Sets the result set to be printed out to a text file.
     *
     * @param results
     */
    public void setResults(List<Integer> results) {
        this._results = results;
    }

    /**
     * Stores the current result set to a text file.
     */
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
