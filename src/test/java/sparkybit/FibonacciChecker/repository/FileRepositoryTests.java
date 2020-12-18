package sparkybit.FibonacciChecker.repository;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileRepositoryTests {


    @Before
    public void makeFile() {

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(
                ".\\src\\test\\resources\\source.txt"
        ))) {
            bw.write("1 wor");
            bw.newLine();
            bw.write("7 wor");

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Test
    public void readDataTest() {

        FileRepository repo = new FileRepository();
        repo.setFilePath(".\\src\\test\\resources\\");

        try (BufferedReader br = new BufferedReader(new FileReader(
                repo.getFilePath() + "source.txt"
        ))) {
            List<String> outRows = new ArrayList<>(repo.readData());
            Assert.assertTrue(outRows.contains("1 wor"));
            Assert.assertFalse(outRows.contains("6 wor"));

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
