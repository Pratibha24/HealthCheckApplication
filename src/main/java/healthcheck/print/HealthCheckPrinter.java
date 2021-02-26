package healthcheck.print;

import java.io.IOException;
import java.util.ArrayList;

import healthcheck.models.HealthCheck;
import healthcheck.models.HealthDetails;
import healthcheck.models.ResultSummary;
import healthcheck.report.HealthCheckGenerator;
import helpers.Transformer;
import storage.Storage;

public class HealthCheckPrinter {
    private final HealthCheckGenerator healthCheckGenerator;
    private final Storage storage;
    private final Transformer<String> transformer;

    private HealthDetails healthDetails = new HealthDetails(new ArrayList<ResultSummary>(), new ArrayList<HealthCheck>());

    public HealthCheckPrinter(final HealthCheckGenerator healthCheckGenerator, final Storage storage, final Transformer<String> transformer) {
        this.healthCheckGenerator = healthCheckGenerator;
        this.storage = storage;
        this.transformer = transformer;
    }


    public void monitorHealth() throws IOException {
        healthDetails = healthCheckGenerator.generateHealthReport(healthDetails.getHistory());

        storage.save(transformer.transformTo(healthDetails));
    }
}