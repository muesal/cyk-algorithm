import java.util.ArrayList;
import java.util.Objects;

public class CYK {

    public static void main(String[] args) {

        // set the input file (Grammar) and algorithm as given arguments or default if no input
        String algorithm = args.length > 0 ? args[0] : "td";
        String input = args.length > 1 ? args[1] : "input.txt";

        // TODO: test-set generieren / einlesen
        String[] test = {"()", "()()", " ())", "(())", ")("};

        // construct grammar from the input file
        Grammar grammar = null;
        try {
            grammar = new Grammar(input);
        } catch (Exception e) {
            // Something at opening the file went wrong, abort
            System.out.println("Grammar could not read/open the input file with the rules:");
            e.printStackTrace();
            return;
        }

        // print info and head of table
        String alg = algorithm.equals("naive") ? "naive" : algorithm.equals("bd") ? "bottom-down" : "top-down";
        System.out.print("\nStarting computation with the " + alg + " algorithm for " + test.length + " input strings:\n\n");
        System.out.printf("%-7s| %-7.4s | %-7s | %-7s \n", "Length", "Time", "Counter", "Truth-Value");
        System.out.print("-----------------------------------------\n");

        Parser parser = new Parser(grammar);
        boolean in_language;
        float start;
        float end;

        // parse and meassure all strings
        for (String s : test) {

            // start time measurement
            start = System.currentTimeMillis();

            // parse the current string
            in_language = parser.parse(s, algorithm);

            // stop time measurement
            end = (System.currentTimeMillis() - start) / 1000;

            // TODO: maybe run parser multiple times and take average (in this case the input string should be parsed beforehand
            // print result
            System.out.printf("%-7d|  %-7.4f|  %-7d|  %-7b\n", s.length(), end, Parser.counter, in_language);
        }
    }

}
