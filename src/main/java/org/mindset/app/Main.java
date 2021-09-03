package org.mindset.app;

import org.mindset.inout.DataPrinter;
import org.mindset.inout.DataReader;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        final DataPrinter printer = new DataPrinter();
        final InputParser inputParser = new InputParser(printer);
        final TextFormattingInputs inputs = inputParser.parse(args);
        final TextAlignmentStrategyFactory factory = new TextAlignmentStrategyFactory();
        final TextAlignmentStrategy alignment = factory.createAlignmentStrategy(inputs);

        try (final DataReader reader = new DataReader()) {
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
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
