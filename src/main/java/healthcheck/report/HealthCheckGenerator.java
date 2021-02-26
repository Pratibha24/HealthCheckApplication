package healthcheck.report;

import static healthcheck.Constants.MAGINIFICENT;
import static healthcheck.models.Status.DOWN;
import static healthcheck.models.Status.FAIL;
import static healthcheck.models.Status.SUCCESS;
import static helpers.MagnificenHealthUtil.join;

import java.io.IOException;
import java.util.List;

import healthcheck.models.HealthCheck;
import healthcheck.models.HealthDetails;
import healthcheck.models.Status;
import helpers.time.TimeProvider;
import network.HttpClient;

public class HealthCheckGenerator {

    private final HttpClient httpClient;
    private final TimeProvider timeProvider;

    public HealthCheckGenerator(final HttpClient httpClient, final TimeProvider timeProvider) {
        this.httpClient = httpClient;
        this.timeProvider = timeProvider;
    }

    public HealthDetails generateHealthReport(final List<HealthCheck> history) {
        final Status status = fetchStatus();
        final HealthCheck healthCheck = new HealthCheck(timeProvider.time(), status);

        final HealthCheckReport report = new HealthCheckReport(join(history, healthCheck));
        return report.create();
    }

    private Status fetchStatus() {
        try {
            final String response = httpClient.request();
            return response.equals(MAGINIFICENT) ? SUCCESS : FAIL;
        } catch (IOException exception) {
            return DOWN;
        }
    }


}
