# Search Algorithms
###### Homework for 2011 fall A.I. [university course (VIMIAC00)](https://portal.vik.bme.hu/kepzes/targyak/VIMIAC00/en/)

Contains the implementations of some basic search algorithms, originally created in 2011 as a homework for a [course](https://portal.vik.bme.hu/kepzes/targyak/VIMIAC00/en/).

The following algorithms has been implemented:
* Breadth-first search
* Depth-first search
* Uniform cost search
* Greedy (best-first) search
* A\* search

The application requires specifically crafted plain text files which specify the required algorithm and contain the input for a search. The results of the run are also printed out to a specified plain text file. Examples of both, along with the original homework specifications (in hungarian language) can be found in the `/additions` directory.

## Dependencies
* [Java SE Development Kit 6](http://www.oracle.com/technetwork/java/javase/downloads/java-archive-downloads-javase6-419409.html), although a recent JDK is highly recommended

## Summary of set up
* `git clone git@github.com:laszlolukacs/searchalgorithms.git <LOCAL_WORKING_DIR>`
* (Optionally) Open/Import the project with Eclipse (repo has been configured for that) or any other IDE or text editor
* (Optionally) Generate *Java SE 6* compatible bytecode from the CLI, by execute the following from the sources directory: `javac -source 1.6 -target 1.6 -bootclasspath <PATH_TO_JDK6>\lib\rt.jar *.java`, where `<PATH_TO_JDK6>` is the path to the JDK SE 6 home

## Basic Usage
* From the directory where the bytecode (the `*.class` files) is located: `java Search <INPUT_FILE> <OUTPUT_FILE>`, where `<INPUT_FILE>` and `<OUTPUT_FILE>` are paths for the input and output plain text files respectively
