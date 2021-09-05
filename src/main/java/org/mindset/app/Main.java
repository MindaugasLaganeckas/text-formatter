package org.mindset.app;

import org.mindset.inout.DataPrinter;
import org.mindset.inout.DataReader;

import java.io.IOException;

public class Main {

    public static final String QUIT_COMMAND = "q";

    public static void main(String[] args) throws IOException {

        try (final DataReader reader = new DataReader()) {

            final DataPrinter printer = new DataPrinter();
            final InputParser inputParser = new InputParser(printer);

            final Main app = new Main(reader, printer);
            app.formatUserInputFromSTDIN(inputParser.parse(args));
        }
    }

    private final DataReader reader;
    private final DataPrinter printer;

    public Main(final DataReader reader, final DataPrinter printer) {
        this.reader = reader;
        this.printer = printer;
    }

    public void formatUserInputFromSTDIN(final TextFormattingInputs inputs) throws IOException {

        final TextAlignmentStrategyFactory factory = new TextAlignmentStrategyFactory();
        final TextAlignmentStrategy alignment = factory.createAlignmentStrategy(inputs);
        boolean quit = false;
        printer.println("Enter your text. To quit, type 'q'.");
        while (!quit && reader.hasNextLine()){
            final String nextLine = reader.nextLine();
            if (QUIT_COMMAND.equals(nextLine)) {
                quit = true;
            } else {
                printer.println(alignment.format(nextLine));
            }
        }
    }
}
