package sparkybit.FibonacciChecker.service;

import sparkybit.FibonacciChecker.repository.FileRepository;
import sparkybit.FibonacciChecker.repository.IORepository;

import java.util.ArrayList;
import java.util.List;

public class RowActions {
    /**
     * Cumulative method to call from entry point.
     */
    public static void run() {
        IORepository repository = new FileRepository();
        repository.writeData(parseFile(repository));
    }

    /**
     * Takes rows from source and checks for compliance to Fibonacci sequence.
     * If true - reverts and writes to list.
     *
     * @param repo Repository instance to transfer I/O operations
     * @return List of processed strings
     */
    public static List<String> parseFile(IORepository repo) {
        List<String> writeList = new ArrayList<>();
        Integer numFromRow;
        List<Integer> fiboSeq = getFiboSeq();

        for (String row : repo.readData()) {
            numFromRow = getNumFromRow(row);

            if (fiboSeq.contains(numFromRow))
                writeList.add(reverseRow(row));
        }
        return writeList;
    }

    /**
     * Making of Fibonacci sequence.
     *
     * @return List of Fibonacci sequence with 20 members.
     * Example: 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584
     */
    public static List<Integer> getFiboSeq() {

        List<Integer> fiboList = new ArrayList<>();
        fiboList.add(0);
        fiboList.add(1);

        for (int i = 2; i < 20; i++) {
            fiboList.add(i, fiboList.get((i - 1)) +
                    fiboList.get((i - 2)));
        }
        return fiboList;
    }

    /**
     * Parses each row to identifying number.
     *
     * @param str String to clean up from all but numbers.
     * @return int value with the number.
     */
    static int getNumFromRow(String str) {
        return Integer.parseInt(str.replaceAll("[^0-9]+", ""));
    }

    /**
     * Reverses incoming String.
     *
     * @param inputRow String to make reverse.
     * @return inverted String value.
     */
    static String reverseRow(String inputRow) {
        String output = "";
        int j = inputRow.length();
        for (int i = 0; i < inputRow.length(); i++) {
            j--;
            output += Character.toString(inputRow.charAt(j));
        }
        return output;
    }
}
