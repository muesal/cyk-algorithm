import java.io.IOException;
import java.util.HashMap;

public abstract class Grammar {
    Integer[][][] rules;

    Character[][] terminal_rules_lit;
    HashMap<Character, Integer[]> terminal_rules_term = new HashMap<>();
    HashMap<Character, Integer> non_terminals = new HashMap<>();

    String form;

    Grammar(String input_file, String form) throws IOException {
        this.form = form;
        parse_grammar(input_file);
    }

    /**
     * Parse the grammar from the input file. Exact parsing depends on the type of grammar
     * @param input_file txt file containing the rules
     * @throws IOException if the file cannot be found or read
     */
    abstract void parse_grammar(String input_file) throws IOException;

    /**
     * Return all non-terminal rules of this grammar
     * @return 3-dimensional Integer array of the rules
     */
    public Integer[][][] getRules() {
        return rules;
    }

    /**
     * Return the non-terminal rules of one non-terminal
     * @param non_terminal for which the rules are wanted
     * @return the rules as 2-dimensional Integer array
     */
    public Integer[][] getRules(int non_terminal) {
        return rules[non_terminal];
    }

    /**
     * Get all terminals the given non-terminal can produce
     * @param non_terminal for which the terminals are wanted
     * @return the terminals as Character array
     */
    public Character[] getTerminalRules(int non_terminal) {
        return terminal_rules_lit[non_terminal];
    }

    /**
     * Return list of non-terminals that may lead to the given terminal, or an empty array if this terminal does not exist.
     * @param terminal char the terminal for which non-terminals are wanted
     * @return Integer[] of non-terminals
     */
    public Integer[] getTerminalRules(char terminal) {
        Integer[] terminalRules = terminal_rules_term.get(terminal);
        if (terminalRules == null) {
            terminalRules = new Integer[0];
        }
        return terminalRules;
    }

    /**
     * Get the number of non-terminals in this grammar
     * @return the number of non-terminals
     */
    public int nr_non_terminals() {
        return non_terminals.size();
    }

}
