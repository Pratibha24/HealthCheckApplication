package healthcheck.report;

import healthcheck.models.ResultSummary;
import healthcheck.models.HealthCheck;
import healthcheck.models.HealthDetails;
import healthcheck.models.Status;

import java.util.Arrays;
import java.util.List;

import static healthcheck.models.Status.*;
import static helpers.NumberFormatter.round;
import static java.util.Collections.unmodifiableList;

class HealthCheckReport {

    final List<HealthCheck> history;

    public HealthCheckReport(final List<HealthCheck> history) {
        this.history = history;
    }

    public HealthDetails create() {
        return new HealthDetails(createBreakDownSummaries(), history);
    }

    private List<ResultSummary> createBreakDownSummaries() {
    	ResultSummary successfulSummary = createBreakdownSummary(SUCCESS);
    	ResultSummary failureSummary = createBreakdownSummary(FAIL);
    	ResultSummary downSummary = createBreakdownSummary(DOWN);

        return unmodifiableList(Arrays.asList(successfulSummary, failureSummary, downSummary));
    }

    private ResultSummary createBreakdownSummary(final Status status) {
        Long count = history.stream()
                .filter(healthCheck -> healthCheck.getStatus() == status)
                .count();

        Double percentage = (count.doubleValue() / history.size()) * 100;

        return new ResultSummary(status, round(percentage));
    }
}
