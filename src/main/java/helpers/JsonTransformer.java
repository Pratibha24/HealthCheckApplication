package helpers;

import com.google.gson.Gson;

public class JsonTransformer implements Transformer<String> {

    final Gson gson = new Gson();

    @Override
    public <E> String transformTo(final E type) {
        return gson.toJson(type);
    }
}
