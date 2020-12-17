package sparkybit.FibonacciChecker.repository;

import java.util.List;

public interface IORepository {

    List<String> readData();

    void writeData(List<String> toWriteList);

}
