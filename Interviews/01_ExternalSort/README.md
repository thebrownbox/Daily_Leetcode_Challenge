We have 200Gb file filled with text lines divided by "\n". 
Our server has Linux on board, gcc, 8Gb of RAM and unlimited hard disk space. 
Implement in C++ the most efficient way to lexicographically sort lines of this file from your point of view. 
Program should accept 3 parameters as command line argument: input file name, output file name and memory limit in bytes (we will test with different memory limits, not only 8Gb).
Obviously, your program should also be able to work correctly with simple boundary cases, e.g. with small files, empty files, files much bigger than 200Gb etc. It should work well with non-ascii symbols, but you can assume that zero-byte is not present in the file (please, don't try hard to support zero-byte). 
You can also assume, that memory limit is much bigger than the size of the longest line. 
Please, don't try to write complicated code to show that you are able to do advanced stuff. Simple main.cpp solution, which does the job is okay for us.
Notes: "Please, don't try to write complicated code to show that you are able to do advanced stuff. Just a file main.cpp, which does the job is okay for us."
 Consider using External Sort
 Try to care about bottle necks from IO
 Consider using Sorting Algorithms from standard libraries