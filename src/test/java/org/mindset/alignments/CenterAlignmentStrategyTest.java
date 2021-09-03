package org.mindset.alignments;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CenterAlignmentStrategyTest {

    @Test
    public void acceptanceTest_outputWidth10() {
        final CenterAlignmentStrategy alignmentStrategy = new CenterAlignmentStrategy(10);
        final String output = alignmentStrategy.format("This   text should    be center  aligned ");
        assertEquals("This text \nshould be \n  center  \n aligned  ", output);
    }

    @Test
    public void acceptanceTest_outputWidth20() {
        final CenterAlignmentStrategy alignmentStrategy = new CenterAlignmentStrategy(20);
        final String output = alignmentStrategy.format("This   text should    be center  aligned ");
        assertEquals("This text should be \n   center aligned   ", output);
    }
}
