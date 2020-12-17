package sparkybit.FibonacciChecker.repository;

import org.junit.Assert;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileRepositoryTests {

    @Test
    public void writeDataTest() {

        try (BufferedReader br = new BufferedReader(new FileReader(".\\src\\main\\resources\\output.txt"))) {
            String row;
            List<String> outRows = new ArrayList<>();
            while ((row = br.readLine()) != null) {
                outRows.add(row);
            }
            Assert.assertTrue(outRows.contains("1 wor"));
            Assert.assertFalse(outRows.contains("6 wor"));

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
