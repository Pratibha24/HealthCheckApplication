package healthcheck.models;

import java.util.Objects;

public class HealthCheck {
    private final Long timestamp;
    private final Status status;

    public HealthCheck(final Long timestamp, final Status status) {
        this.timestamp = timestamp;
        this.status = status;
    }

    public Status getStatus() {
        return status;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || !(o instanceof HealthCheck)) return false;
        final HealthCheck hc = (HealthCheck) o;
        return Objects.equals(timestamp, hc.timestamp) &&
                status == hc.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(timestamp, status);
    }
}
