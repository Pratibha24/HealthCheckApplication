package helpers.time;

import static java.lang.System.currentTimeMillis;

public class CurrentTimeProvider implements TimeProvider {
    @Override
    public long time() {
        return currentTimeMillis();
    }
}
