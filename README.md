# cyk-algorithm
Comparison of different implementations of the CYK-algorithm in Java, as part of an Lecture about efficient algorithms

##Usage
This implementation of CYK takes an input grammar in CNF and computes for a set of test strings, whether the strings are in the language of this grammar.
The output is a table containing for each string its length, the computation time in seconds, the counter and the computed value.

The program has three algorithms from which the user can choose, a naive approach ('naive'), the buttom up implementation ('bu') and top-down ('td').
The chosen algorithm can be passed as first program argument, the default is top-down.
For the naive approach, which uses a recursive implementation, counter is the number of calls of the recursive function it took to compute the result.
For bottom-up and top-down it counts how often the inner-most loop is executed.

The second ürogram argument is the text file containing the rules of the grammar.
If none is passed, then input.txt is used, which contains a simple exemplary grammar.
