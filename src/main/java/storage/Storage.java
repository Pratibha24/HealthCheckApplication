package storage;

import java.io.IOException;

public interface Storage {
    void save(String message) throws IOException;
}
