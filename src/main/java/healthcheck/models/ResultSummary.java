package healthcheck.models;

import java.util.Objects;

public class ResultSummary {
    private final Status status;

    private final String percentage;

    public ResultSummary(final Status status, final String percentage) {
        this.status = status;
        this.percentage = percentage;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final ResultSummary that = (ResultSummary) o;
        return status == that.status &&
                Objects.equals(percentage, that.percentage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(status, percentage);
    }
}
