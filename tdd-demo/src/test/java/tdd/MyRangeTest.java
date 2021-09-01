package tdd;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MyRangeTest {

    @Test
    @DisplayName("start with include [")
    public void startWithInclude() {
        // Arrange
        MyRange myRange = new MyRange("[1,5]");

        // Act
        boolean startWithInclude = myRange.startWithInclude();

        // Assert
        assertTrue(startWithInclude);
    }

    @Test
    @DisplayName("start with exclude [")
    public void startWithExclude() {
        // Arrange
        MyRange myRange = new MyRange("(1,5]");

        // Act
        boolean startWithInclude = myRange.startWithInclude();

        // Assert
        assertFalse(startWithInclude);
    }

    @Test
    @DisplayName("start with include number [1,5] => 1")
    public void startWithIncludeNumber() {
        // Arrange
        MyRange myRange = new MyRange("[1,5]");

        // Act
        int startNumber = myRange.getStartNumber();

        // Assert
        assertEquals(1, startNumber);
    }

    @Test
    @DisplayName("start with exclude number (1,5] => 2")
    public void startWithExcludeNumber() {
        // Arrange
        MyRange myRange = new MyRange("(1,5]");

        // Act
        int startNumber = myRange.getStartNumber();

        // Assert
        assertEquals(2, startNumber);
    }

    @Test
    @DisplayName("end with include ]")
    public void endWithInclude() {
        // Arrange
        MyRange myRange = new MyRange("[1,5]");

        // Act
        boolean endWithInclude = myRange.endWithInclude();

        // Assert
        assertTrue(endWithInclude);
    }

    @Test
    @DisplayName("end with exclude ]")
    public void endWithExclude() {
        // Arrange
        MyRange myRange = new MyRange("[1,5)");

        // Act
        boolean endWithInclude = myRange.endWithInclude();

        // Assert
        assertFalse(endWithInclude);
    }

    @Test
    @DisplayName("end with include [1,5] => 5")
    public void endWithIncludeNumber() {
        // Arrange
        MyRange myRange = new MyRange("[1,5]");

        // Act
        int endNumber = myRange.getEndNumber();

        // Assert
        assertEquals(5, endNumber);
    }

    @Test
    @DisplayName("end with exclude [1,5) => 4")
    public void endWithExcludeNumber() {
        // Arrange
        MyRange myRange = new MyRange("[1,5)");

        // Act
        int endNumber = myRange.getEndNumber();

        // Assert
        assertEquals(4, endNumber);
    }

    @Test
    @DisplayName("case 05 [1,5] => 1,2,3,4,5")
    public void case05() {
        // Arrange
        MyRange myRange = new MyRange("[1,5]");

        // Act
        List<String> result = myRange.getResult();

        // Assert
        assertEquals("1,2,3,4,5", String.join(",", result));
    }

    @Test
    @DisplayName("case 06 (1,5) => 2,3,4")
    public void case06() {
        // Arrange
        MyRange myRange = new MyRange("(1,5)");

        // Act
        List<String> result = myRange.getResult();

        // Assert
        assertEquals("2,3,4", String.join(",", result));
    }

    @Test
    @DisplayName("case 07 (1,5] => 2,3,4,5")
    public void case07() {
        // Arrange
        MyRange myRange = new MyRange("(1,5]");

        // Act
        List<String> result = myRange.getResult();

        // Assert
        assertEquals("2,3,4,5", String.join(",", result));
    }

    @Test
    @DisplayName("case 08 [1,5) => 1,2,3,4")
    public void case08() {
        // Arrange
        MyRange myRange = new MyRange("[1,5)");

        // Act
        List<String> result = myRange.getResult();

        // Assert
        assertEquals("1,2,3,4", String.join(",", result));
    }
}
