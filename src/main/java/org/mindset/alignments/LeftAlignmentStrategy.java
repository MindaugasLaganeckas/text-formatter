package org.mindset.alignments;

public class LeftAlignmentStrategy extends AbstractAlignmentStrategy {

    public LeftAlignmentStrategy(final int outputWidth) {
        super(outputWidth);
    }

    @Override
    protected StringBuilder addPadding(final StringBuilder line) {
        while(line.length() < outputWidth) {
            line.append(padding);
        }
        return line;
    }
}
