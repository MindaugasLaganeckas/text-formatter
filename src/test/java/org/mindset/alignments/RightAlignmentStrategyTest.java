package org.mindset.alignments;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

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

    @Test
    public void outputWidth_SmallerThan_WordLength() {
        final RightAlignmentStrategy alignmentStrategy = new RightAlignmentStrategy(1);
        try {
            final String output = alignmentStrategy.format("aa");
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Word aa is longer than the output-width 1", e.getMessage());
        }
    }

    @Test
    public void outputWidth_IsEqualTo_WordLength() {
        final RightAlignmentStrategy alignmentStrategy = new RightAlignmentStrategy(2);
        final String output = alignmentStrategy.format("aa");
        assertEquals("aa", output);
    }

    @Test
    public void outputWidthIs2_WordLengthIs1() {
        final RightAlignmentStrategy alignmentStrategy = new RightAlignmentStrategy(2);
        final String output = alignmentStrategy.format("a");
        assertEquals(" a", output);
    }

    @Test
    public void outputWidthIs3_WordLengthIs1() {
        final RightAlignmentStrategy alignmentStrategy = new RightAlignmentStrategy(3);
        final String output = alignmentStrategy.format("a");
        assertEquals("  a", output);
    }

    @Test
    public void outputWidthIs2_WordLengthIs1_2words() {
        final RightAlignmentStrategy alignmentStrategy = new RightAlignmentStrategy(2);
        final String output = alignmentStrategy.format("a b");
        assertEquals(" a\n b", output);
    }

    @Test
    public void outputWidthIs3_WordLengthIs1_2words() {
        final RightAlignmentStrategy alignmentStrategy = new RightAlignmentStrategy(3);
        final String output = alignmentStrategy.format("a b");
        assertEquals("a b", output);
    }
}
