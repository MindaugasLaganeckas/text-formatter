package org.mindset.app;

public class TextFormattingInputs {
    private final TextAlignmentStrategies alignment;
    private final int outputWidth;

    public TextFormattingInputs(final TextAlignmentStrategies alignment, final int outputWidth) {
        this.alignment = alignment;
        this.outputWidth = outputWidth;
    }

    public int getOutputWidth() {
        return outputWidth;
    }

    public TextAlignmentStrategies getAlignment() {
        return alignment;
    }
}
