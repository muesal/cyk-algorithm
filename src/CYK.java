import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;

public class CYK {

    static Grammar grammar;
    static Parser parser;
    static TestSet testSet;

    public static void main(String[] args) {
        // Check if the input is correct, and initialise the TestSet of strings
        String[] test = {};
        if (args.length > 0) {
            test = args[0].split(",");
        }

        if (test.length == 1) {
            // Test set consists of only one string
            testSet = new TestSet(test[0], "", 1, test[0].length(),"");
        } else if (test.length < 4) {
            System.out.println(" To run this program, you must give information on the set of Strings you want to parse.\n" +
                    "Read the README.md for further information on how to generate test sets of strings");
            return;
        } else {
            // Tests set consists of multiple strings
            String initial = test.length > 4 ? test[4] : "";
            testSet = new TestSet(test[0], test[1], Integer.parseInt(test[2]), Integer.parseInt(test[3]), initial);
        }

        // set the algorithm and the input files (Grammar and test set of strings) as given arguments or default
        String algorithm = args.length > 1 ? args[1] : "td";
        String grammar_file = args.length > 2 ? args[2] : "parantheses.txt";


        // construct grammar and test set from the input files, initialise parser with grammar
        try {
            grammar = new Grammar(grammar_file);
            parser = new Parser(grammar);
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
     *
     * @param algorithm the chosen algorithm (naive, bottom up or top down
     */
    private static void parse(String algorithm) {
        // print info and head of table
        String alg = algorithm.equals("naive") ? "naive" : algorithm.equals("bu") ? "bottom-down" : "top-down";
        System.out.println("\nStarting computation with the " + alg + " algorithm input strings up to length " +
                testSet.max + ". Every string will be parsed 10 times, and the average time computed.\nThe" +
                "computed data will be printed again in the end, such that it is easier to copy-paste in order to" +
                "visualize it with another tool.\n");
        System.out.printf("%-7s| %-15s | %-15s | %-7s \n", "Length", "Time in seconds", "Counter", "Truth-Value");
        System.out.print("---------------------------------------------------------\n");

        ArrayList<Integer> length = new ArrayList<>();
        ArrayList<Long> counter = new ArrayList<>();
        ArrayList<Long> duration = new ArrayList<>();
        ArrayList<Boolean> truth = new ArrayList<>();

        int iterations = 5;

        // parse and measure all strings
        while (!testSet.finished()) {
            String s = testSet.nextString();

            System.out.printf("%-7d", s.length());
            parser.set_input(s);

            // initialize variables and arrays
            boolean truth_value = false;
            Instant start;
            long[] end = new long[iterations];

            // parse the string iteration times, to get the average time passed
            for (int j = 0; j < iterations; j++) {
                // start time measurement
                start = Instant.now();

                // parse the current string
                truth_value = parser.parse(algorithm);

                // compute duration of execution
                end[j] = Duration.between(start, Instant.now()).toMillis();
            }

            // remove best and worst time (min and max), compute average
            long min = Arrays.stream(end).min().orElse(-1);
            long max = Arrays.stream(end).max().orElse(-1);
            long end_sum = 0;
            long end_elements = 0;

            for (long l : end) {
                if (l == min) {
                    min = -1; // in case more than one element is the same as min
                } else if (l == max) {
                    max = -1; // in case mor then one element is max
                } else {
                    end_elements++;
                    end_sum += l;
                }

            }
            long end_average = end_sum / end_elements;

            // print result
            System.out.printf("|  %-15d|  %-15d|  %-7b\n", end_average, Parser.counter, truth_value);

            length.add(s.length());
            counter.add(Parser.counter);
            duration.add(end_average);
            truth.add(truth_value);

        }

        // print all tables, to make copy-pasting easier
        System.out.print("\nValues for copy pasting:");
        System.out.println("\nlength:\n" + length);
        System.out.println("\ncounter:\n" + counter);
        System.out.println("\nduration:\n" + duration);
        System.out.println("\ntruth:\n" + truth);
    }

    /**
     * Class to generate the set of test strings, i.e., to generate the next string in the set
     */
    private static class TestSet {
        StringBuilder left = new StringBuilder();
        StringBuilder right = new StringBuilder();
        int max;
        String testString = "";

        /**
         * Initialise the class
         *
         * @param left  string to append on the left of the test String
         * @param right string to append on the right of the test String
         * @param n     number of times left and right should be added to get to the next string
         * @param max   maximal length of the string (nextString appends 2*n elements to the string, as long as the string is smaller)
         */
        TestSet(String left, String right, int n, int max, String initial) {
            for (int i = 0; i < n; i++) {
                this.left.append(left);
                this.right.append(right);
            }
            this.max = max;
            testString = initial;
        }

        /**
         * Produce the next string, appending the pre and suffix
         * @return the next string of the set
         */
        public String nextString() {
            testString = left + testString + right;
            return testString;
        }

        /**
         * Has the Test String reached the maximal length?
         * @return if length from string is bigger than max
         */
        public boolean finished() {
            return testString.length() >= max;
        }

    }

}
