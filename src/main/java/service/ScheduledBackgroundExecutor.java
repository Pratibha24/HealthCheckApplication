package service;

import java.util.concurrent.ScheduledExecutorService;

import static java.lang.Runtime.getRuntime;
import static java.util.concurrent.Executors.newScheduledThreadPool;
import static java.util.concurrent.TimeUnit.MILLISECONDS;

public class ScheduledBackgroundExecutor implements BackgroundExecutor {
    private final long interval;

    private static final int WAIT_TIME = 100;
    private static final int SERVER_PROCESSING_TIME = 5;
    private static final int OPTIMAL_NUMBER_OF_THREADS = getRuntime()
            .availableProcessors() * (1 + WAIT_TIME / SERVER_PROCESSING_TIME);


    ScheduledExecutorService executorService = newScheduledThreadPool(OPTIMAL_NUMBER_OF_THREADS);

    public ScheduledBackgroundExecutor(final long interval) {
        this.interval = interval;
    }

    @Override
    public void run(Runnable runnable) {
        executorService.scheduleAtFixedRate(runnable, 0, interval, MILLISECONDS);
    }

    @Override
    public void shutdown() {
        executorService.shutdown();
    }
}
