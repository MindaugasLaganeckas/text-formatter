package org.mindset.app;

import org.mindset.inout.DataPrinter;

import java.util.Arrays;

public class InputParser {

    // considering limits is important because computer resources are finite
    // and it makes it easier to deliver correctly working software
    // these limits can have any other reasonable values and
    // would be discovered during the negotiation with stakeholders
    private static final int MIN_OUTPUT_WIDTH = 1;
    private static final int MAX_OUTPUT_WIDTH = 100;

    private final DataPrinter printer;
    public InputParser(final DataPrinter printer) {
        this.printer = printer;
    }

    public TextFormattingInputs parse(final String[] inputs) {

        if (inputs.length != 2) {
            printUsageAndExit();
        }
        final TextAlignmentStrategies alignment = getAlignment(inputs);
        final int outputWidth = getOutputWidth(inputs);
        return new TextFormattingInputs(alignment, outputWidth);
    }

    private int getOutputWidth(String[] inputs) {
        try {
            final int outputWidth = Integer.parseInt(inputs[1]);
            if (outputWidth < 1 || outputWidth > 100) {
                printer.println(String.format("output width is not in range: %s", inputs[1]));
                printUsageAndExit();
            }
            return outputWidth;
        } catch (NumberFormatException e) {
            printer.println(String.format("Output width is not a number: %s", inputs[1]));
            printUsageAndExit();
        }
        throw new RuntimeException("We shall never get here!");
    }

    private TextAlignmentStrategies getAlignment(String[] inputs) {
        try {
            return TextAlignmentStrategies.valueOf(inputs[0]);
        } catch (IllegalArgumentException e) {
            printer.println(String.format("Unknown alignment: %s", inputs[0]));
            printUsageAndExit();
        }
        throw new RuntimeException("We shall never get here!");
    }

    private void printUsageAndExit() {
        printer.println("Usage: <alignment> <output-width>");
        printer.println("Available alignments:");
        Arrays.stream(TextAlignmentStrategies.values()).map(alignment -> alignment.name()).forEach(printer::println);
        printer.println(String.format("Output width must be between %d and %d", MIN_OUTPUT_WIDTH, MAX_OUTPUT_WIDTH));
        System.exit(1);
    }
}
