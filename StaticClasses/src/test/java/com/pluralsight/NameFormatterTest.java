package com.pluralsight;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class NameFormatterTest {@Test
public void testFormatFirstLast() {
    assertEquals("Dykes, Dave", NameFormatter.format("Dykes", "Dave"));
}

    @Test
    public void testFormatWithAllParts() {
        assertEquals("Dykes, Prof. Dave P, PhD", NameFormatter.format("Prof.", "Dave", "P", "Dykes", "PhD"));
    }

    @Test
    public void testFormatFromFullName() {
        assertEquals("Dykes, Prof. Dave P, PhD", NameFormatter.format("Prof. Dave P Dykes, PhD"));
    }
}


