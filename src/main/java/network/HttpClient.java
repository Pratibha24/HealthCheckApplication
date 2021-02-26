package network;

import java.io.IOException;

public interface HttpClient {
    String request() throws IOException;
}
