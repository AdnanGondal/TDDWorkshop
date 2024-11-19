package org.example.foobar;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FooBarTest {

    @Test
    void test_textForNumner_returnsCorrectAnswer_when_33_added() {

        // Act
        String text = FooBar.textForNumber(33);

        // Assert
        assertEquals("FooFooFoo", text);
    }

    @Test
    void test_textForNumner_returnsCorrectAnswer_when_15_added() {

        // Act
        String text = FooBar.textForNumber(15);

        // Assert
        assertEquals("FooBarBar", text);
    }

    @Test
    void test_textForNumner_returnsCorrectAnswer_when_0_added() {

        // Act
        String text = FooBar.textForNumber(0);

        // Assert
        assertEquals("", text);
    }

    @Test
    void test_textForNumner_returnsCorrectAnswer_when_negativeNo_added() {

        // Act
        String text = FooBar.textForNumber(-5);

        // Assert
        assertEquals("", text);
    }


}