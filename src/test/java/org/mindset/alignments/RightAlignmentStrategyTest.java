package org.mindset.alignments;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RightAlignmentStrategyTest {

    @Test
    public void acceptanceTest_outputWidth10() {
        final RightAlignmentStrategy alignmentStrategy = new RightAlignmentStrategy(10);
        final String output = alignmentStrategy.format("This   text should    be right  aligned ");
        assertEquals(" This text\n should be\n     right\n   aligned", output);
    }

    @Test
    public void acceptanceTest_outputWidth20() {
        final RightAlignmentStrategy alignmentStrategy = new RightAlignmentStrategy(20);
        final String output = alignmentStrategy.format("This   text should    be right  aligned ");
        assertEquals(" This text should be\n       right aligned", output);
    }
}
