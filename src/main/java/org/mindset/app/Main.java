package org.mindset.app;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        final InputParser inputParser = new InputParser();
        final TextFormattingInputs inputs = inputParser.parse(args);
        final TextAlignmentStrategyFactory factory = new TextAlignmentStrategyFactory();
        final TextAlignmentStrategy alignment = factory.createAlignmentStrategy(inputs);

        final Scanner input = new Scanner(System.in);
        boolean quit = false;
        System.out.println("Enter your text. To quit, type 'q'.");
        while (!quit && input.hasNextLine()){
            final String nextLine = input.nextLine();
            if ("q".equals(nextLine)) {
                quit = true;
            } else {
                System.out.println(alignment.format(nextLine));
            }
        }
    }
}
