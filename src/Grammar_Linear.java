import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Grammar_Linear extends Grammar{


    /**
     * Standard compiler (pares the grammar form the input file), transform to cnf says whether it should be transformed
     * or be kept as linear grammar
     * @param input_file txt file containing the rules
     * @param transform_to_cnf boolean, whether the grammar should be transformed
     * @throws IOException if the file cannot be found or read
     */
    Grammar_Linear(String input_file, boolean transform_to_cnf)  throws IOException {
        super(input_file, transform_to_cnf ? "cnf" : "linear" );
    }

    /**
     * parse the grammar, such that it is in CNF form. Therefore, all terminals which appear in a non-terminal rule,
     * are also stored as non-terminals, and the terminal rule of them pointing on themselves is added.
     * @param input_file the path to the txt file, where the rules are written line by line
     * @throws IOException if something with opening and reading the input file does not work as expected
     */
    void parse_grammar(String input_file) throws IOException {
        if (form.equals("cnf")) {
            parse_grammar_cnf(input_file);
        } else {
            //parse_grammar_linear(input_file);
        }
    }

    private void parse_grammar_cnf(String input_file) throws IOException {
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
            // ignore empty / wrong formatted lines
            if (rule.length == 2 && rule[0].length() == 1 && (64 < rule[0].charAt(0) && rule[0].charAt(0) < 91) ) {

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
                    if ((64 < terminal && terminal < 91)) {

                        // add to terminal rules ordered by terminals
                        if (!terminal_rules_term.containsKey(terminal)) {
                            terminal_rules_term.put(terminal, new ArrayList<>());
                        }
                        terminal_rules_term.get(terminal).add(left);

                        // add to terminal rules ordered by non-terminals
                        terminal_rules_lit.get(left).add(terminal);
                    }

                } else {
                    // non-terminal rule

                    char char1 = rule[1].charAt(0);
                    char char2 = rule[1].charAt(1);

                    // only uppercase letters are non-terminals, there must be exactly one non-terminal.
                    if (((64 < char1 && char1 < 91) ^ (64 < char2 && char2 < 91))) {

                        if (64 < char1 && char1 < 91) {
                            // add non_terminal to list if necessary
                            if (!non_terminals.containsKey(char1)) {
                                non_terminals.put(char1, nr_non_terminals);
                                rules.add(nr_non_terminals, new ArrayList<>());
                                terminal_rules_lit.add(nr_non_terminals, new ArrayList<>());
                                nr_non_terminals++;
                            }

                            // second char is terminal
                            if (!non_terminals.containsKey(char2)) {
                                // Add terminal to the non-terminals. This works, since it is lowercase, thus cannot be a duplicate
                                non_terminals.put(char2, nr_non_terminals);
                                rules.add(nr_non_terminals, new ArrayList<>());
                                terminal_rules_lit.add(nr_non_terminals, new ArrayList<>());

                                // Add the rule to the terminal rules (a->a)
                                terminal_rules_lit.get(nr_non_terminals).add(char2);
                                if (!terminal_rules_term.containsKey(char2)) {
                                    terminal_rules_term.put(char2, new ArrayList<>());
                                }
                                terminal_rules_term.get(char2).add(nr_non_terminals);
                                nr_non_terminals++;
                            }

                        } else {

                            if (!non_terminals.containsKey(char1)) {
                                // Add terminal to the non-terminals. This works, since it is lowercase, thus cannot be a duplicate
                                non_terminals.put(char1, nr_non_terminals);
                                rules.add(nr_non_terminals, new ArrayList<>());
                                terminal_rules_lit.add(nr_non_terminals, new ArrayList<>());

                                // Add the rule to the terminal rules (a->a)
                                terminal_rules_lit.get(nr_non_terminals).add(char1);
                                if (!terminal_rules_term.containsKey(char1)) {
                                    terminal_rules_term.put(char1, new ArrayList<>());
                                }
                                terminal_rules_term.get(char1).add(nr_non_terminals);
                                nr_non_terminals++;
                            }

                            // second char is non-terminal
                            // add non_terminal to list if necessary
                            if (!non_terminals.containsKey(char2)) {
                                non_terminals.put(char2, nr_non_terminals);
                                rules.add(nr_non_terminals, new ArrayList<>());
                                terminal_rules_lit.add(nr_non_terminals, new ArrayList<>());
                                nr_non_terminals++;
                            }
                        }

                        // add rule to set of non-terminal rules
                        rules.get(left).add(new Integer[]{
                                non_terminals.get(char1),
                                non_terminals.get(char2)}
                        );
                    }

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
        this.rules = new Integer[nr_non_terminals][][];
        for (int i = 0; i < nr_non_terminals; i++) {
            this.rules[i] = rules.get(i).toArray(new Integer[0][0]);
        }
    }
}
