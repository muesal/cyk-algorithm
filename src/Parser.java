
public class Parser {

    static long counter;
    Grammar grammar;
    char[] input;
    boolean[][][] tab; // used in top-down (and buttom-up)
    boolean[][][] tab_set; // used in top-down (and buttom-up)

    /**
     * Constructor for the Parser.
     *
     * @param grammar grammar this parser shall use
     */
    Parser(Grammar grammar) {
        this.grammar = grammar;
    }

    /**
     * Parse method of the grammar. Parses the input string with the chosen algorithm
     *
     * @param parser the chosen algorithm
     * @return true if the input is a word of this grammar, false otherwise
     */
    public boolean parse(String parser) {
        // Set the counter to zero
        counter = 0;

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

    /**
     * Recursive function to parse the global input string.
     * @param non_terminal the current non-terminal
     * @param i beginning of the current substring
     * @param j end of th current substring
     * @return truth-value, whether the substring can be reached from this terminal
     */
    private boolean parseNaive(int non_terminal, int i, int j) {
        counter++; // increase counter per call

        if (i == j - 1) {
            // i = j-1 => A -> s[i] must be a terminal rule
            for (Character c : grammar.getTerminalRules(non_terminal)) {
                if (c.equals(input[i])) return true;
            }
        } else {
            // A -> BC => B must form to any left part (i-k), C the corresponding right part (k-j) 
            // iterate through all rules of nonterminal A, for every rule try every splitting point k.
            for (Integer[] rule : grammar.getRules(non_terminal)) {
                for (int k = i + 1; k < j; k++) {
                    if (parseNaive(rule[0], i, k) && parseNaive(rule[1], k, j)) return true;
                }
            }
        }

        return false;
    }

    /**
     * Parse with the Bottom-Down algorithm
     * @param s the input string as an char array
     * @return truth-value whether the string is in the language of this grammar
     */
    private boolean parseBU(char[] s) {
        // allocate table, java initialises bool arrays with false for every cell
        // array: literal, start position, length of substr - 1
        tab = new boolean[grammar.nr_non_terminals()][s.length][s.length];

        // Fill first row of table: enter true for all non-terminal A, row i column 1 if A->s[i] is a terminal rule
        for (int i = 0; i < s.length; i++) {
            for (Integer a : grammar.getTerminalRules(s[i])) {
                tab[a][i][0] = true;
            }
        }

        Integer[][][] rules = grammar.getRules();

        // j = length of substring (2 - n)
        for (int j = 1; j < s.length; j++) {
            // i = start of substring
            for (int i = 0; i < s.length - j; i++) {
                // a = non-terminal
                for (int a = 0; a < rules.length; a++) {
                    // rule = every non-terminal rule of a
                    for (Integer[] rule : rules[a]) {
                        // k = splitting point
                        for (int k = 0; k < j; k++) {
                            // check whether first letter can produce substring i till k and second i+k+1 till j-k-1
                            counter++;
                            if(tab[rule[0]][i][k] && tab[rule[1]][i + k + 1][j - k - 1]) {
                                tab[a][i][j] = true;
                                break;
                            }
                        }
                    }
                }
            }
        }

        // can the start variable (nonterminal 0) construct the whole input string (start 0, length n)?
        return tab[0][0][s.length - 1];
    }

    /**
     * Parse the input string with the top-down algorithm
     * @param s the string to parse as an array of chars
     * @return truth-value whether the string is in the language of this grammar
     */
    private boolean parseTD(char[] s) {
        tab = new boolean[grammar.nr_non_terminals()][s.length][s.length];
        // java initialises bool arrays with false, tab_set is to check whether cell has been allocated before
        tab_set = new boolean[grammar.nr_non_terminals()][s.length][s.length];

        return parseTD(0, 0, s.length - 1);
    }

    /**
     * recursively parse the input string with a top-down algorithm, using memoization
     *
     * @param a a non-terminal
     * @param i the start point of the current substring
     * @param j length of the current substring
     * @return whether a can produce the substring
     */
    private boolean parseTD(int a, int i, int j) {
        counter++;
        if (!tab_set[a][i][j]) {
            // cell has not yet been computed, but will now -> set tab_set to true
            tab_set[a][i][j] = true;

            if (j == 0) {
                // j = 0 => A -> s[i] must be a terminal rule
                for (Character c : grammar.getTerminalRules(a)) {
                    if (c.equals(input[i])) {
                        tab[a][i][j] = true;
                        break;
                    }
                }
            } else {
                // A -> BC => B must form to any left part (i-k), C the corresponding right part (k-j)
                // iterate through all rules of non-terminal A, for every rule try every splitting point k.
                for (Integer[] rule : grammar.getRules(a)) {
                    for (int k = 0; k < j; k++) {
                        // check whether first letter can produce substring i till k and second i+k+1 till j-k-1
                        tab[a][i][j] = tab[a][i][j] ||
                                (parseTD(rule[0], i, k) && parseTD(rule[1], i + k + 1, j - k - 1));
                    }
                }
            }
        }

        return tab[a][i][j];
    }

    /**
     * Set the input string of the parser
     * @param s input string
     */
    public void set_input(String s) {
        input = s.toCharArray();
    }
}
