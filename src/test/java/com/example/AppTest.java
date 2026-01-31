package com.example;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import org.junit.jupiter.api.Test;

class AppTest {

    @Test
    void testMain() {
        // This executes the logic in App.java and covers the lines
        assertDoesNotThrow(() -> App.main(new String[]{}));
    }
}