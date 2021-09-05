package org.mindset.alignments;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

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

    @Test
    public void outputWidth_SmallerThan_WordLength() {
        final CenterAlignmentStrategy alignmentStrategy = new CenterAlignmentStrategy(1);
        try {
            final String output = alignmentStrategy.format("aa");
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Word aa is longer than the output-width 1", e.getMessage());
        }
    }

    @Test
    public void emptyString() {
        final CenterAlignmentStrategy alignmentStrategy = new CenterAlignmentStrategy(2);
        final String output = alignmentStrategy.format("");
        assertEquals("  ", output);
    }

    @Test
    public void outputWidth_IsEqualTo_WordLength() {
        final CenterAlignmentStrategy alignmentStrategy = new CenterAlignmentStrategy(2);
        final String output = alignmentStrategy.format("aa");
        assertEquals("aa", output);
    }

    @Test
    public void outputWidthIs2_WordLengthIs1() {
        final CenterAlignmentStrategy alignmentStrategy = new CenterAlignmentStrategy(2);
        final String output = alignmentStrategy.format("a");
        assertEquals("a ", output);
    }

    @Test
    public void outputWidthIs3_WordLengthIs1() {
        final CenterAlignmentStrategy alignmentStrategy = new CenterAlignmentStrategy(3);
        final String output = alignmentStrategy.format("a");
        assertEquals(" a ", output);
    }

    @Test
    public void outputWidthIs2_WordLengthIs1_2words() {
        final CenterAlignmentStrategy alignmentStrategy = new CenterAlignmentStrategy(2);
        final String output = alignmentStrategy.format("a b");
        assertEquals("a \nb ", output);
    }

    @Test
    public void outputWidthIs3_WordLengthIs1_2words() {
        final CenterAlignmentStrategy alignmentStrategy = new CenterAlignmentStrategy(3);
        final String output = alignmentStrategy.format("a b");
        assertEquals("a b", output);
    }
}
