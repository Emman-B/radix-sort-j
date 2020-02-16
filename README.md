# RadixSorter
This is an implementation of RadixSort in java.

## Usage
Once git repository is cloned, run ```make tests``` to let the Makefile compile the java source files.

### Miscellaneous - Large Update Notes
This creation was started about 2 years back and now I am making changes to improve upon its organization and clarity. Initially, it was just a single .java file with the sorting algorithm as well as a main function that ran a test. This would not work very well, so I separted it so that ```RadixSorter.java``` was only for the sorting algorithm and ```TestA.java``` would contain the main function with the test.