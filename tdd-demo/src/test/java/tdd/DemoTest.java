package tdd;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DemoTest {

    @Test
    @DisplayName("สวัสดี junit 5")
    public void case01() {
        // Arrange, Given
        String expectedResult = "Hello, Leenawat";
        Hello hello = new Hello();

        // Act, When
        String actualResult = hello.sayHi("Leenawat");

        // Assert, Then
        assertEquals(expectedResult, actualResult);
    }
}
