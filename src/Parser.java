import java.util.ArrayList;

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

    private static boolean parseBU(char[] s) {
        // TODO
        // increase counter per most inner loop
        return false;
    }

    private static boolean parseTD(char[] s) {
        // TODO
        // increase counter per most inner loop
        return false;
    }

}
