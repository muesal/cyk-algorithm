import java.util.ArrayList;
import java.util.Arrays;

public class Parser {

    static int counter;
    Grammar grammar;
    char[] input;

    /**
     * Constructor for the Parser.
     * @param grammar grammar this parser shall use
     */
    Parser (Grammar grammar) {
        this.grammar = grammar;
    }

    /**
     * Parse method of the grammar. Parses the input string with the chosen parser, if it contains only terminal characters.
     * @param s input string
     * @return true if the input is a word of this grammar, false otherwise
     */
    public boolean parse(String s, String parser) {
        // Set the counter to zero
        counter = 0;

        // parse input string to array of chars
        input = s.toCharArray();

        // parse with the chosen algorithm and return result
        switch (parser) {
            case "naive":
                return parseNaive(0, 0, input.length);
            case "bu":
                return parseBU(input);   // Bottom-up
            default:
                return parseTD(input);   // Top-down (set as default)
        }
    }

    private boolean parseNaive(int non_terminal, int i, int j) {
        counter++; // increase counter per call

        if (i == j - 1) {
            // i = j-1 => A -> s[i] must be a terminal rule
            for (Character c : grammar.getTerminalRules(non_terminal)) {
                if ( c.equals(input[i])) return true;
            }
        } else {
            // A -> BC => B must form to any left part (i-k), C the corresponding right part (k-j) 
            // iterate through all rules of nonterminal A, for every rule try every splitting point k.
            for (Integer[] rule: grammar.getRules(non_terminal)) {
                for (int k = i + 1; k < j; k++) {
                    if (parseNaive(rule[0], i, k) && parseNaive(rule[1], k , j)) return true;
                }
            }
        }

        return false;
    }

    private boolean parseBU(char[] s) {
        boolean[][][] tab = new boolean[grammar.nr_non_terminals()][s.length][s.length];
        // array: literal, start position, length of substr - 1
        // Fill first row of table: enter true for all non-terminal A, row i column 1 if A->s[i] is a terminal rule
        for (int i = 0; i < s.length; i++) {
            for (Integer a: grammar.getTerminalRules(s[i])) {
                tab[a][i][0] = true;
            }
        }

        Integer[][][] rules = grammar.getRules();

        // j = length of substring (2 - n)
       for (int j = 1; j < s.length; j++) {
            // i = start of substing
            for (int i = 0; i < s.length - j; i++) {
                // k = splitting point
                for (int k = 0; k < j; k++) {
                    // a = non-terminal
                    for (int a = 0; a < rules.length; a++) {
                        // rule = every non-terminal rule of a
                        for (Integer[] rule : rules[a]) {
                            // check whether first letter can produce substring i till k and second i+k+1 till j-k-1
                            boolean both_sides = tab[rule[0]][i][k] && tab[rule[1]][i+k+1][j-k-1];
                            tab[a][i][j] = tab[a][i][j] || both_sides;
                            counter++;
                        }
                    }
                }
            }
        }

        // can the start variable (nonterminal 0) construct the whole input string (start 0, length n)?
        return tab[0][0][s.length - 1];
    }

    private boolean parseTD(char[] s) {
        // TODO
        // increase counter per most inner loop
        return false;
    }

}
