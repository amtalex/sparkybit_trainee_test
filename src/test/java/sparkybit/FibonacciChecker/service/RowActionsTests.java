package sparkybit.FibonacciChecker.service;

import org.junit.Assert;
import org.junit.Test;

public class RowActionsTests {

    @Test
    public void getFiboSeqTest() {
        Assert.assertTrue(RowActions.getFiboSeq().contains(2584));
    }

    @Test
    public void getNumFromRowTest() {
        String someRow = "row 5";

        Assert.assertEquals(RowActions.getNumFromRow(someRow), 5);
    }

    @Test
    public void reverseRowTest() {
        String orig = "New Montgomery06";
        StringBuilder sb = new StringBuilder(orig);

        Assert.assertEquals(RowActions.reverseRow(orig), sb.reverse().toString());
    }
}