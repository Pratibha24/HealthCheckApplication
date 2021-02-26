package network;

import static healthcheck.Constants.URL;

import java.io.IOException;
import java.util.Objects;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MagnificentHttpClient implements HttpClient {
    final private OkHttpClient client = new OkHttpClient();

    @Override
    public String request() throws IOException {
        try (Response response = client.newCall(buildRequest()).execute()) {
            return Objects.requireNonNull(response.body()).string();
        }
    }

    private Request buildRequest() {
        return new Request.Builder()
                .url(URL)
                .build();
    }
}
