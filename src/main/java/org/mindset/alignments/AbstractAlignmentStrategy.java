package org.mindset.alignments;

import org.mindset.app.TextAlignmentStrategy;

import java.util.LinkedList;
import java.util.List;

public abstract class AbstractAlignmentStrategy implements TextAlignmentStrategy {

    protected final String padding = " ";

    protected final int outputWidth;
    public AbstractAlignmentStrategy(final int outputWidth) {
        this.outputWidth = outputWidth;
    }

    @Override
    public String format(String input) {
        final List<String> result = new LinkedList<>();
        final String[] words = input.split("\\s+");
        for (int index = 0; index < words.length;) {
            final String word = words[index];
            if (word.length() > outputWidth) {
                throw new IllegalArgumentException(String.format("Word %s is longer than the output-width %d", word, outputWidth));
            }
            final StringBuilder line = new StringBuilder(word);
            index++;
            while(index < words.length && line.length() + words[index].length() + padding.length() <= outputWidth) {
                line.append(padding + words[index]);
                index++;
            }
            result.add(addPadding(line).toString());
        }
        return String.join("\n", result);
    }

    protected abstract StringBuilder addPadding(final StringBuilder line);
}
