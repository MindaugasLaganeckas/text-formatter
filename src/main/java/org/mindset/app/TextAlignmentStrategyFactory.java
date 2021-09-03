package org.mindset.app;

import org.mindset.alignments.CenterAlignmentStrategy;
import org.mindset.alignments.LeftAlignmentStrategy;
import org.mindset.alignments.RightAlignmentStrategy;

public class TextAlignmentStrategyFactory {

    public TextAlignmentStrategy createAlignmentStrategy(final TextFormattingInputs inputs) {
        switch (inputs.getAlignment()) {
            case LEFT_ALIGN:
                return new LeftAlignmentStrategy(inputs.getOutputWidth());
            case RIGHT_ALIGN:
                return new RightAlignmentStrategy(inputs.getOutputWidth());
            case CENTER_ALIGN:
                return new CenterAlignmentStrategy(inputs.getOutputWidth());
            default:
                throw new RuntimeException(String.format("Alignment %s has not been implemented.", inputs.getAlignment()));
        }
    }
}
