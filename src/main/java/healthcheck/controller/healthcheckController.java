package healthcheck.controller;

import java.io.IOException;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import healthcheck.Constants;
import healthcheck.print.HealthCheckPrinter;
import healthcheck.report.HealthCheckGenerator;
import helpers.JsonTransformer;
import helpers.time.CurrentTimeProvider;
import network.MagnificentHttpClient;
import service.BackgroundService;
import service.ScheduledBackgroundExecutor;
import storage.FileStorage;

@RestController
public class healthcheckController {
	
	@RequestMapping("/hello")
	public String getMessage() {
		return "hi";
	}
	
	@RequestMapping("/health")
	public String getHealth() {

		System.out.println("Welcome to Magnificent Health Check App.");
		System.out.println("Health checks log will be available in " + Constants.FILE_NAME + " file.");
		
		MagnificentHttpClient magnificentHttpClient = new MagnificentHttpClient();
		HealthCheckGenerator healthCheckGenerator = new HealthCheckGenerator(magnificentHttpClient,
				new CurrentTimeProvider());

		HealthCheckPrinter monitor = new HealthCheckPrinter(healthCheckGenerator, new FileStorage(Constants.FILE_NAME),
				new JsonTransformer());

		final BackgroundService service = new BackgroundService(new ScheduledBackgroundExecutor(Constants.INTERVAL));

		service.runInBackground(() -> {
			try {
				monitor.monitorHealth();
			} catch (IOException exception) {
				exception.printStackTrace();
				service.cancel();
			}
		});
		return "Health checks log will be available in " + Constants.FILE_NAME + " file.";
	
	}
}
