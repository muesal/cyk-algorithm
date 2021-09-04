import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Grammar {

    Integer[][][] rules;
    Character[][] terminal_rules;
    HashMap<Character, Integer> non_terminals = new HashMap<>();

    Grammar(String input_file) throws IOException {

        // Rules defined as array lists, these are later converted to arrays
        ArrayList<ArrayList<Character>> terminal_rules = new ArrayList<>();
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
                    terminal_rules.add(nr_non_terminals, new ArrayList<>());
                    nr_non_terminals++;
                }
                left = non_terminals.get(rule[0].charAt(0));

                if (rule[1].length() == 1 && (rule[1].charAt(0) < 65 || rule[1].charAt(0) > 90)) {
                    // add to terminal rules
                    terminal_rules.get(left).add(rule[1].charAt(0));

                } else {
                    // non-terminal rule

                    // add both non_terminals to list if necessary
                    if (!non_terminals.containsKey(rule[1].charAt(0))) {
                        non_terminals.put(rule[1].charAt(0), nr_non_terminals);
                        rules.add(nr_non_terminals, new ArrayList<>());
                        terminal_rules.add(nr_non_terminals, new ArrayList<>());
                        nr_non_terminals++;
                    }
                    if (!non_terminals.containsKey(rule[1].charAt(1))) {
                        non_terminals.put(rule[1].charAt(1), nr_non_terminals);
                        rules.add(nr_non_terminals, new ArrayList<>());
                        terminal_rules.add(nr_non_terminals, new ArrayList<>());
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
        this.terminal_rules = new Character[nr_non_terminals][];
        for (int i = 0; i < nr_non_terminals; i++) {
            this.terminal_rules[i] = terminal_rules.get(i).toArray(new Character[0]);
        }

        // Convert the non-terminal rules to Array
        ArrayList<Integer[][]> non_term = new ArrayList<>();
        this.rules = new Integer[nr_non_terminals][][];
        for (int i = 0; i < nr_non_terminals; i++) {
            this.rules[i] = rules.get(i).toArray(new Integer[0][0]);
        }
    }

    public Integer[][] getRules(int non_terminal) {
        return rules[non_terminal];
    }

    public Character[] getTerminalRules(int non_terminal) {
        return terminal_rules[non_terminal];
    }
}
