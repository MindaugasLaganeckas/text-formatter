package org.mindset.alignments;

public class RightAlignmentStrategy extends AbstractAlignmentStrategy {

    public RightAlignmentStrategy(final int outputWidth) {
        super(outputWidth);
    }

    @Override
    protected StringBuilder addPadding(final StringBuilder line) {
        while(line.length() < outputWidth) {
            line.insert(0, padding);
        }
        return line;
    }
}
