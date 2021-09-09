# cyk-algorithm
This implementation of CYK takes information on how to build the set of test strings, an algorithm and an input grammar in CNF.
It computes for each of the test strings whether the string is in the language of the given grammar.
Each string is parsed 10 times, and the averaged time without the best and worst time is computed. 
The output is a table containing for each string its length, the averaged time in seconds, the counter and the computed value.

After parsing all strings the values of the table are printed again as lists, which makes it easier to copy-paste them into a tool for creating graphs, e.g. in *plot.py*.


##Usage

The program takes up to three input arguments:

1. Information on the set of test strings
2. Which algorithm should be used; *naive* for the naive apporach, *bu* for the bottom-up and *td* for the top-down algorithm, top-down is the default.
3. The path to the text-file with the grammar, if none is passed then grammar.txt is used. 

### The test strings

The program builds the set of substrings, according to the information provided by the user:
>prefix,suffix,n,maxlength[,initialstring]

Between the arguments should be a comma, no space.
Prefix is the left-hand side of the string, while suffix is the right-hand side.
For each new String, they both get appended resp. prepended n times.
The strings are generated as long as the last generated string is smaller than maxlength.
If the string should contain anything else than the suffix and prefix, use the optional initial string, which will be in the center of the string.

To generate a set of strings of the form "((..))" from size 100 to 5000 in steps of 100 use;
>(,),50,5000

To generate a set of strings of the form "()..()" from size 100 to 5000 in steps if 100 use;
>(),(),25,5000

To generate a set of strings of the form "()..()(" from  size 101 to 5001 in steps of 100 make use of the initial string:
>(),)(,25,5001,(

Same goes for the set of strings of the form ")()..()" from size 101 to 5001 in steps of 100:
>)(,(),25,5001,)



### The algorithms

The naive approach is a recursive algorithm.
The counter holds the number of times the parser is called.

Bottom-up is the original CYK-algorithm.
It is not recursive and uses a table to store solutions to sub-problems.
The counter counts how often the inner-most loop is executed.

Top-down is recursive and thus very similar to the naive approach.
It uses however a table for memoization, such that every sub-problem is only solved once.
Here, counter holds the amount of executions of the innermost loop as well.


### The grammar

The grammar must be in cnf.
The input file should hold all rules, each on a single line, and the left and right-hand side of the rule separated by a space.

The file grammar.txt holds the language for the Dyck language in this form.