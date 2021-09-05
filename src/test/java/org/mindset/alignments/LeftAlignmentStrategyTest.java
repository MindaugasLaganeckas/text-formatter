package org.mindset.alignments;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

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

    @Test
    public void emptyString() {
        final LeftAlignmentStrategy alignmentStrategy = new LeftAlignmentStrategy(2);
        final String output = alignmentStrategy.format("");
        assertEquals("  ", output);
    }

    @Test
    public void outputWidth_SmallerThan_WordLength() {
        final LeftAlignmentStrategy alignmentStrategy = new LeftAlignmentStrategy(1);
        try {
            final String output = alignmentStrategy.format("aa");
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Word aa is longer than the output-width 1", e.getMessage());
        }
    }

    @Test
    public void outputWidth_IsEqualTo_WordLength() {
        final LeftAlignmentStrategy alignmentStrategy = new LeftAlignmentStrategy(2);
        final String output = alignmentStrategy.format("aa");
        assertEquals("aa", output);
    }

    @Test
    public void outputWidthIs2_WordLengthIs1() {
        final LeftAlignmentStrategy alignmentStrategy = new LeftAlignmentStrategy(2);
        final String output = alignmentStrategy.format("a");
        assertEquals("a ", output);
    }

    @Test
    public void outputWidthIs3_WordLengthIs1() {
        final LeftAlignmentStrategy alignmentStrategy = new LeftAlignmentStrategy(3);
        final String output = alignmentStrategy.format("a");
        assertEquals("a  ", output);
    }

    @Test
    public void outputWidthIs2_WordLengthIs1_2words() {
        final LeftAlignmentStrategy alignmentStrategy = new LeftAlignmentStrategy(2);
        final String output = alignmentStrategy.format("a b");
        assertEquals("a \nb ", output);
    }

    @Test
    public void outputWidthIs3_WordLengthIs1_2words() {
        final LeftAlignmentStrategy alignmentStrategy = new LeftAlignmentStrategy(3);
        final String output = alignmentStrategy.format("a b");
        assertEquals("a b", output);
    }


}
