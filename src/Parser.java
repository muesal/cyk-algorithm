
public class Parser {

    static long counter;
    Grammar grammar;
    char[] input;
    boolean[][][] tab; // used in top-down and buttom-up)
    boolean[][][] tab_set; // used in top-down
    int[][][][] tab_c; // used in bottom up with error correction
    int errors;

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
                return grammar.form.equals("linear") ? parseBU_linear() : parseBU();   // Bottom-up
            default:
                return parseTD();   // Top-down (set as default)
        }
    }

    /**
     * Recursive function to parse the global input string.
     *
     * @param non_terminal the current non-terminal
     * @param i            beginning of the current substring
     * @param j            end of th current substring
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
            // iterate through all rules of non-terminal A, for every rule try every splitting point k.
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
     *
     * @return truth-value whether the string is in the language of this grammar
     */
    private boolean parseBU() {
        // allocate table, java initialises bool arrays with false for every cell
        // array: literal, start position, length of substr - 1
        tab = new boolean[grammar.nr_non_terminals()][input.length][input.length];

        // Fill first row of table: enter true for all non-terminal A, row i column 1 if A->s[i] is a terminal rule
        for (int i = 0; i < input.length; i++) {
            for (Integer a : grammar.getTerminalRules(input[i])) {
                tab[a][i][0] = true;
            }
        }

        Integer[][][] rules = grammar.getRules();

        // j = length of substring (2 - n)
        for (int j = 1; j < input.length; j++) {
            // i = start of substring
            for (int i = 0; i < input.length - j; i++) {
                // a = non-terminal
                for (int a = 0; a < rules.length; a++) {
                    // rule = every non-terminal rule of a
                    //rules_of_a:
                    for (Integer[] rule : rules[a]) {
                        // k = splitting point
                        for (int k = 0; k < j; k++) {
                            // check whether first letter can produce substring i till k and second i+k+1 till j-k-1
                            counter++;
                            if (tab[rule[0]][i][k] && tab[rule[1]][i + k + 1][j - k - 1]) {
                                tab[a][i][j] = true;
                                break;
                                // break rules_of_a; This would make the algorithm about 15% more efficient
                            }
                        }
                    }
                }
            }
        }

        // can the start variable (nonterminal 0) construct the whole input string (start 0, length n)?
        return tab[0][0][input.length - 1];
    }

    /**
     * Parse linear grammars with the Bottom-Down algorithm. for every non-terminal rule there is only one
     * splitting point that must be tried.
     *
     * @return truth-value whether the string is in the language of this grammar
     */
    private boolean parseBU_linear() {
        // allocate table, java initialises bool arrays with false for every cell
        // array: literal, start position, length of substr - 1
        tab = new boolean[grammar.nr_non_terminals()][input.length][input.length];

        // Fill first row of table: enter true for all non-terminal A, row i column 1 if A->s[i] is a terminal rule
        for (int i = 0; i < input.length; i++) {
            for (Integer a : grammar.getTerminalRules(input[i])) {
                tab[a][i][0] = true;
            }
        }

        Integer[][][] rules = grammar.getRules();

        // j = length of substring (2 - n)
        for (int j = 1; j < input.length; j++) {
            // i = start of substring
            for (int i = 0; i < input.length - j; i++) {
                // a = non-terminal
                for (int a = 0; a < rules.length; a++) {
                    // rule = every non-terminal rule of a
                    for (Integer[] rule : rules[a]) {
                        // k = splitting point

                        if (rule[2] == 1) {
                            // left variable is a terminal. Only possible splitting point is k = 0
                            counter++;
                            if (((int) input[i]) == rule[0] && tab[rule[1]][i + 1][j - 1]) {
                                tab[a][i][j] = true;
                                break;
                            }
                        } else if (rule[3] == 1) {
                            // both variables are non-terminals
                            counter++;
                            if (((int) input[i + j]) == rule[1] && tab[rule[0]][i][j - 1]) {
                                tab[a][i][j] = true;
                                break;
                            }
                        }
                    }
                }
            }
        }

        // can the start variable (non-terminal 0) construct the whole input string (start 0, length n)?
        return tab[0][0][input.length - 1];
    }

    public int parse_error() {
        counter = 0;
        // allocate table, array:
        // literal, start position, length of substr - 1 , [errors, B, C, k] (conf that produces most similar substring)
        tab_c = new int[grammar.nr_non_terminals()][input.length][input.length][4];

        // Fill first row of table: enter true for all non-terminal A, row i column 1 if A->s[i] is a terminal rule
        for (int a = 0; a < grammar.nr_non_terminals(); a++) {
            // If the variable has no terminal-rule, initialise it with a high value, such that it will not
            // be considered as a otional solution to change strings later on
            int e = grammar.getTerminalRules(a).length > 0 ? 1 : (input.length);
            for (int i = 0; i < input.length; i++) {
                tab_c[a][i][0][0] = e;
            }
        }

        for (int i = 0; i < input.length; i++) {
            for (Integer a : grammar.getTerminalRules(input[i])) {
                tab_c[a][i][0][0] = 0;
            }
        }

        Integer[][][] rules = grammar.getRules();

        // j = length of substring (2 - n)
        for (int j = 1; j < input.length; j++) {
            // i = start of substring
            for (int i = 0; i < input.length - j; i++) {
                // a = non-terminal
                for (int a = 0; a < rules.length; a++) {
                    tab_c[a][i][j][0] = j + 1; // max num of errors

                    // rule = every non-terminal rule of a
                    rules_of_a:
                    for (Integer[] rule : rules[a]) {
                        // k = splitting point
                        for (int k = 0; k < j; k++) {
                            // check whether first letter can produce substring i till k and second i+k+1 till j-k-1
                            counter++;
                            int e = tab_c[rule[0]][i][k][0] + tab_c[rule[1]][i + k + 1][j - k - 1][0];
                            if (e < tab_c[a][i][j][0]) {
                                // save the new minimal error counter, as well as the rules and splitting point that caused it
                                tab_c[a][i][j][0] = e;
                                tab_c[a][i][j][1] = rule[0];
                                tab_c[a][i][j][2] = rule[1];
                                tab_c[a][i][j][3] = k;

                                if (e == 0)
                                    break rules_of_a; // do not consider further k or rules
                            }
                        }
                    }
                }
            }
        }

        // can the start variable (non-terminal 0) construct the whole input string (start 0, length n)?
        return tab_c[0][0][input.length - 1][0];
    }

    public int getErrors() {
        return errors;
    }

    public String correct_string() {
        counter = 0;
        errors = 0;
        String correct = "";
        try {
            correct = correct_string(0, 0, input.length - 1);
        } catch (IndexOutOfBoundsException e) {
            //e.printStackTrace();
        }

        return correct;
    }

    public String correct_string(int a, int i, int j) throws IndexOutOfBoundsException {
        counter++;

        // the substring can be yielded, is therefore correct
        if (tab_c[a][i][j][0] == 0) {
            return String.valueOf(input).substring(i, i + j + 1);
        }

        // the substring has length one, but can not be yielded. replace by terminal this non-terminal can derive
        if (j == 0) {
            errors++;
            // If a has no non-terminal rule, this produces an array out of bound array, and the solution can not be found
            return String.valueOf(grammar.getTerminalRules(a)[0]);
        }

        int first = tab_c[a][i + 1][j - 1][0];
        int last = tab_c[a][i][j - 1][0];

        if (first < last) {
            // the substrings first terminal should be deleted
            if (first < tab_c[a][i][j][0] - 1) {
                errors++;
                return correct_string(a, i + 1, j - 1);
            }
        } else if (last < tab_c[a][i][j][0] - 1) {
            // the substrings first terminal should be deleted
            errors++;
            return correct_string(a, i, j - 1);
        }

        // continue by find correct substrings by applying the rule to a
        int b = tab_c[a][i][j][1];
        int c = tab_c[a][i][j][2];
        int k = tab_c[a][i][j][3];

        return correct_string(b, i, k) + correct_string(c, i + k + 1, j - k - 1);
    }

    /**
     * Parse the input string with the top-down algorithm
     *
     * @return truth-value whether the string is in the language of this grammar
     */
    private boolean parseTD() {
        tab = new boolean[grammar.nr_non_terminals()][input.length][input.length];
        // java initialises bool arrays with false, tab_set is to check whether cell has been allocated before
        tab_set = new boolean[grammar.nr_non_terminals()][input.length][input.length];

        return grammar.form.equals("linear") ? parseTD_linear(0, 0, input.length - 1) : parseTD(0, 0, input.length - 1);
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
     * recursively parse the input string with a top-down algorithm, using memoization. for every non-terminal rule
     * there is only one splitting point that must be tried.
     *
     * @param a a non-terminal
     * @param i the start point of the current substring
     * @param j length of the current substring
     * @return whether a can produce the substring
     */
    private boolean parseTD_linear(int a, int i, int j) {
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
                    if (rule[2] == 1) {
                        tab[a][i][j] = tab[a][i][j] ||
                                (((int) input[i]) == rule[0] && parseTD_linear(rule[1], i + 1, j - 1));
                    } else {
                        tab[a][i][j] = tab[a][i][j] ||
                                (((int) input[i + j]) == rule[1] && parseTD_linear(rule[0], i, j - 1));
                    }
                }
            }
        }

        return tab[a][i][j];
    }

    /**
     * Set the input string of the parser
     *
     * @param s input string
     */
    public void set_input(String s) {
        input = s.toCharArray();
    }


}
