package org.mindset.app;

import org.junit.jupiter.api.Test;
import org.mindset.inout.DataPrinter;
import org.mindset.inout.DataReader;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class MainTest {

    private final class DataReaderForTests extends DataReader {

        private String[] data;
        private static final String TEXT_LINE = "a";
        private int currentIndex = 0;
        public DataReaderForTests() {
            data = new String[] {TEXT_LINE, Main.QUIT_COMMAND};
        }
        @Override
        public boolean hasNextLine() {
            return currentIndex < data.length;
        }
        @Override
        public String nextLine() {
            final String line = data[currentIndex];
            currentIndex++;
            return line;
        }

    }

    private final class DataPrinterForTests extends DataPrinter {

        private final List<String> dataToPrint = new LinkedList<>();

        @Override
        public void println(final String str) {
            dataToPrint.add(str);
        }
    }

    @Test
    public void formatUserInputFromSTDINTest() throws IOException {
        try(final DataReaderForTests dataReaderForTests = new DataReaderForTests()) {
            final DataPrinterForTests dataPrinterForTests = new DataPrinterForTests();

            final TextFormattingInputs inputs = new TextFormattingInputs(TextAlignmentStrategies.LEFT_ALIGN, 1);

            final Main app = new Main(dataReaderForTests, dataPrinterForTests);
            app.formatUserInputFromSTDIN(inputs);

            // the whole data has been read from the stream until quit command has been received
            assertEquals(2, dataReaderForTests.currentIndex);
            // instructions and one formatted line of data has been sent to the output stream
            assertEquals(2, dataPrinterForTests.dataToPrint.size());
            // formatted output has been received to the output stream
            assertEquals(DataReaderForTests.TEXT_LINE, dataPrinterForTests.dataToPrint.get(1));
        }
    }
}

