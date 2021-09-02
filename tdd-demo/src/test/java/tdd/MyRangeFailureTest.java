package tdd;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MyRangeFailureTest {

    @Test
    @DisplayName("Invalid input :: not start with [, (")
    public void case01() {
        MyRange myRange = new MyRange("{1,5]");
        try {
            myRange.validateInput();
            fail();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
