package org.mindset.app;

import org.mindset.inout.DataPrinter;
import org.mindset.inout.DataReader;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        try (final DataReader reader = new DataReader()) {

            final DataPrinter printer = new DataPrinter();
            final InputParser inputParser = new InputParser(printer);
            final TextAlignmentStrategyFactory factory = new TextAlignmentStrategyFactory();

            final Main app = new Main(reader, printer, factory);
            app.formatUserInputFromSTDIN(inputParser.parse(args));
        }
    }

    private final DataReader reader;
    private final DataPrinter printer;
    private final TextAlignmentStrategyFactory factory;

    public Main(final DataReader reader, final DataPrinter printer, final TextAlignmentStrategyFactory factory) {
        this.reader = reader;
        this.printer = printer;
        this.factory = factory;
    }

    public void formatUserInputFromSTDIN(final TextFormattingInputs inputs) throws IOException {

        final TextAlignmentStrategy alignment = factory.createAlignmentStrategy(inputs);
        boolean quit = false;
        printer.println("Enter your text. To quit, type 'q'.");
        while (!quit && reader.hasNextLine()){
            final String nextLine = reader.nextLine();
            if ("q".equals(nextLine)) {
                quit = true;
            } else {
                printer.println(alignment.format(nextLine));
            }
        }
    }
}
