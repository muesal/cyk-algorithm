import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Grammar {
    Integer[][][] rules;

    Character[][] terminal_rules_lit;
    HashMap<Character, Integer[]> terminal_rules_term = new HashMap<>();
    HashMap<Character, Integer> non_terminals = new HashMap<>();

    /**
     * Initialise the grammar, by constructing the grammars terminals and non-terminal rules using the provided input file
     * @param input_file the path to the txt file, where the rules are written line by line
     * @throws IOException if something with opening and reading the input file does not work as expected
     */
    Grammar(String input_file) throws IOException {

        // Rules defined as array lists, these are later converted to arrays
        ArrayList<ArrayList<Character>> terminal_rules_lit = new ArrayList<>();
        HashMap<Character, ArrayList<Integer>> terminal_rules_term = new HashMap<>();
        ArrayList<ArrayList<Integer[]>> rules = new ArrayList<>();

        // number of non_terminals
        int nr_non_terminals = 0;

        // read the input file line by line (every line is a new rule)
        BufferedReader br = new BufferedReader(new FileReader(input_file));
        String line;   // current line
        String[] rule; // current rule
        Integer left;  // left side of current rule

        while ((line = br.readLine()) != null) {

            rule = line.split(" ");
            if (rule.length == 2) { // ignore empty / wrong formatted lines

                // get number of left-hand side or add to list of non_terminals
                if (!non_terminals.containsKey(rule[0].charAt(0))) {
                    non_terminals.put(rule[0].charAt(0), non_terminals.size());
                    rules.add(nr_non_terminals, new ArrayList<>());
                    terminal_rules_lit.add(nr_non_terminals, new ArrayList<>());
                    nr_non_terminals++;
                }
                left = non_terminals.get(rule[0].charAt(0));

                if (rule[1].length() == 1) {
                    char terminal = rule[1].charAt(0);

                    // add to terminal rules ordered by terminals
                    if(!terminal_rules_term.containsKey(terminal)) {
                        terminal_rules_term.put(terminal, new ArrayList<>());
                    }
                    terminal_rules_term.get(terminal).add(left);

                    // add to terminal rules ordered by non-terminals
                    terminal_rules_lit.get(left).add(terminal);

                } else {
                    // non-terminal rule

                    // add both non_terminals to list if necessary
                    if (!non_terminals.containsKey(rule[1].charAt(0))) {
                        non_terminals.put(rule[1].charAt(0), nr_non_terminals);
                        rules.add(nr_non_terminals, new ArrayList<>());
                        terminal_rules_lit.add(nr_non_terminals, new ArrayList<>());
                        nr_non_terminals++;
                    }
                    if (!non_terminals.containsKey(rule[1].charAt(1))) {
                        non_terminals.put(rule[1].charAt(1), nr_non_terminals);
                        rules.add(nr_non_terminals, new ArrayList<>());
                        terminal_rules_lit.add(nr_non_terminals, new ArrayList<>());
                        nr_non_terminals++;
                    }

                    // add rule to set of non-terminal rules
                    rules.get(left).add(new Integer[]{
                            non_terminals.get(rule[1].charAt(0)),
                            non_terminals.get(rule[1].charAt(1))}
                    );

                }
            }
        }

        // Convert terminal-rules to array
        // ordered by terminal
        for (HashMap.Entry<Character, ArrayList<Integer>> terminal : terminal_rules_term.entrySet()) {
            this.terminal_rules_term.put(terminal.getKey(), terminal.getValue().toArray(new Integer[0]));
        }

        // ordered by non-terminal
        this.terminal_rules_lit = new Character[nr_non_terminals][];
        for (int i = 0; i < nr_non_terminals; i++) {
            this.terminal_rules_lit[i] = terminal_rules_lit.get(i).toArray(new Character[0]);
        }

        // Convert the non-terminal rules to Array
        ArrayList<Integer[][]> non_term = new ArrayList<>();
        this.rules = new Integer[nr_non_terminals][][];
        for (int i = 0; i < nr_non_terminals; i++) {
            this.rules[i] = rules.get(i).toArray(new Integer[0][0]);
        }
    }

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
