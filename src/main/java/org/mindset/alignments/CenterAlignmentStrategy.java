package org.mindset.alignments;

public class CenterAlignmentStrategy extends AbstractAlignmentStrategy {

    public CenterAlignmentStrategy(final int outputWidth) {
        super(outputWidth);
    }

    @Override
    protected StringBuilder addPadding(final StringBuilder line) {
        while(line.length() < outputWidth) {
            line.append(padding);
            if (line.length() < outputWidth) {
                line.insert(0, padding);
            }
        }
        return line;
    }
}
