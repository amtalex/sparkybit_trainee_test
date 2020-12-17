package sparkybit.FibonacciChecker.repository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileRepository implements IORepository {

    private String filePath = ".\\src\\main\\resources\\";

    @Override
    public List<String> readData() {
        List<String> rowArray = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath + "source.txt"))) {
            String row;
            while ((row = br.readLine()) != null) {
                rowArray.add(row);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return rowArray;
    }

    @Override
    public void writeData(List<String> toWriteList) {

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath + "output.txt"))) {
            for (String s : toWriteList) {
                bw.write(s);
                bw.newLine();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}
