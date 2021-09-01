package tdd;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MyRangeTest {

    @Test
    @DisplayName("Start with include [")
    public void startWithInclude() {
        // Arrange
        MyRange myRange = new MyRange("[1,5]");

        // Act
        boolean startWithInclude = myRange.startWithInclude();

        // Assert
        assertTrue(startWithInclude);
    }

    @Test
    @DisplayName("Start with exclude [")
    public void startWithExclude() {
        // Arrange
        MyRange myRange = new MyRange("(1,5]");

        // Act
        boolean startWithInclude = myRange.startWithInclude();

        // Assert
        assertFalse(startWithInclude);
    }

    @Test
    @DisplayName("[1,5] => 1")
    public void startWithIncludeNumber() {
        // Arrange
        MyRange myRange = new MyRange("[1,5]");

        // Act
        int startNumber = myRange.getStartNumber();

        // Assert
        assertEquals(1, startNumber);
    }
}
