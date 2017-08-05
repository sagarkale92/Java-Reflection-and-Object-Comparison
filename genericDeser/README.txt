CS542 Design Patterns
Fall 2016
ASSIGNMENT 5 README FILE

Due Date: Thursday, December 15, 2016
Submission Date: Tuesday, December 15, 2016
Author(s): Sagar Kale
e-mail(s): skale4@binghamton.edu

PURPOSE:

[
  Java Reflection and Object Comparison in Java
]

PERCENT COMPLETE:

[
	100%
]


DATASTRUCTURE CHOICE:
[
	HashSet to store the First and Second object.
	Set interface is it does not allow the elements in duplicates.
	Worst time complexity for Insert and search is O(1).
]

SAMPLE OUTPUT:

[
	Number of unique First objects: 4952
    Total Number of First objects: 4952
    Number of unique Second objects: 5018
    Total Number of Second objects: 5048
]

TO COMPILE:

[
 	ant -buildfile build.xml all
]

TO RUN:

[
  	ant -buildfile src/build.xml run -Darg0=<input_file_name> -Darg1=<DEBUG_VALUE>
  	Example:
  	ant run -buildfile build.xml -Darg0=input.txt -Darg1=0
]

TO CLEAN:

[
  	ant -buildfile src/build.xml clean
]