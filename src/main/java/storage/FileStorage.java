package storage;

import java.io.FileWriter;
import java.io.IOException;

public class FileStorage implements Storage {
    final String fileName;

    public FileStorage(final String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void save(String message) throws IOException {
        try (FileWriter file = new FileWriter(fileName)) {
            file.write(message);
        }
    }
}
