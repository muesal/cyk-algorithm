import java.io.*;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Objects;

public class CYK {

    static Grammar grammar;
    static Parser parser;
    static String[] test_set;

    public static void main(String[] args) {

        // set the algorithm and the input files (Grammar and test set of strings) as given arguments or default
        String algorithm = args.length > 0 ? args[0] : "td";
        String grammar_file = args.length > 1 ? args[1] : "grammar.txt";
        String test_set_file = args.length > 2 ? args[2] : "test_set.txt";

        // uncomment to generate a test set of strings and write to test_set.txt (and maybe adapt the method)
        //generate_test_set(5000, "(", ")");

        // construct grammar and test set from the input files, initialise parser with grammar
        try {
            grammar = new Grammar(grammar_file);
            parser = new Parser(grammar);
            test_set = readTestSet(test_set_file);
        } catch (Exception e) {
            // Something at opening one of the files went wrong, abort
            System.out.println("One of the input files could not be read/opened:");
            e.printStackTrace();
            return;
        }

        parse(algorithm);
    }

    /**
     * Parse the set of strings, i.e., check for every string whether it is in the language of the grammar using the chosen algorithm
     * @param algorithm the chosen algorithm (naive, bottom up or top down
     */
    private static void parse(String algorithm) {

        // print info and head of table
        String alg = algorithm.equals("naive") ? "naive" : algorithm.equals("bd") ? "bottom-down" : "top-down";
        System.out.print("\nStarting computation with the " + alg + " algorithm for " + test_set.length + " input strings:\n\n");
        System.out.printf("%-7s| %-15s | %-15s | %-7s \n", "Length", "Time in seconds", "Counter", "Truth-Value");
        System.out.print("---------------------------------------------------------\n");

        boolean in_language;
        Instant start;
        int end;

        // parse and measure all strings
        for (String s : test_set) {

            // start time measurement
            start = Instant.now();

            // parse the current string
            in_language = parser.parse(s, algorithm);

            // compute duration of execution
            end = Duration.between(start ,Instant.now()).toSecondsPart();

            // TODO: maybe run parser multiple times and take average (in this case the input string should be parsed beforehand
            // print result
            System.out.printf("%-7d|  %-15d|  %-15d|  %-7b\n", s.length(), end, Parser.counter, in_language);
        }

        // TODO: visualize
    }

    /**
     * This method can be used to generate a set of strings till size max_length, in steps of 100.
     */
    private static void generate_test_set(int max_length, String left, String right) {
        try {
            FileWriter myWriter = new FileWriter("test_set.txt");
            StringBuilder l = new StringBuilder();
            StringBuilder r = new StringBuilder();
            StringBuilder string = new StringBuilder();

            // build left and wight haf of string
            for (int i = 0; i < 50; i++) {
                l.append(left);
                r.append(right);
            }

            do {
                // build strings by adding left and rigth side
                string = new StringBuilder(l + string.toString() + r);
                // and write to file
                myWriter.write(string + "\n");
            } while (string.length() < max_length);

            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    /**
     * Read the set of given test strings from an input file, each line is one string to test
     * @param input_file txt file with the strings
     * @return the array containing the strings
     * @throws IOException if reading the file does not behave as expected
     */
    private static String[] readTestSet(String input_file) throws IOException {
        // read the input file (every line is an input string,
        BufferedReader br = new BufferedReader(new FileReader(input_file));
        ArrayList<String> set = new ArrayList<>();
        String line;

        while ((line = br.readLine()) != null) {
            set.add(line);
        }

        return set.toArray(new String[0]);
    }

}
