package org.mindset.inout;

import java.io.Closeable;
import java.io.IOException;
import java.util.Scanner;

public class DataReader implements Closeable {
    private final Scanner scanner;
    public DataReader() {
        this.scanner = new Scanner(System.in);
    }

    public boolean hasNextLine() {
        return scanner.hasNextLine();
    }

    public String nextLine() {
        return scanner.nextLine();
    }

    @Override
    public void close() throws IOException {
        if (scanner != null) {
            scanner.close();
        }
    }
}
