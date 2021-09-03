package org.mindset.alignments;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class LeftAlignmentStrategyTest {

    @Test
    public void acceptanceTest_outputWidth10() {
        final LeftAlignmentStrategy alignmentStrategy = new LeftAlignmentStrategy(10);
        final String output = alignmentStrategy.format("This   text should    be left  aligned ");
        assertEquals("This text \nshould be \nleft      \naligned   ", output);
    }

    @Test
    public void acceptanceTest_outputWidth20() {
        final LeftAlignmentStrategy alignmentStrategy = new LeftAlignmentStrategy(20);
        final String output = alignmentStrategy.format("This   text should    be left  aligned ");
        assertEquals("This text should be \nleft aligned        ", output);
    }
}
