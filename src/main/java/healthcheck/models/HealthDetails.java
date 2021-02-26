package healthcheck.models;

import java.util.List;
import java.util.Objects;

public class HealthDetails {
    private final List<ResultSummary> breakdownSummaries;
    private final List<HealthCheck> history;

    public HealthDetails(final List<ResultSummary> breakdownSummaries, final List<HealthCheck> history) {
        this.breakdownSummaries = breakdownSummaries;
        this.history = history;
    }

    public List<HealthCheck> getHistory() {
        return history;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final HealthDetails that = (HealthDetails) o;
        return Objects.equals(history, that.history) &&
                Objects.equals(breakdownSummaries, that.breakdownSummaries);
    }

    @Override
    public int hashCode() {
        return Objects.hash(history, breakdownSummaries);
    }
}
