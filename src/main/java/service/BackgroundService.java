package service;

public class BackgroundService {

    private BackgroundExecutor executor;

    public BackgroundService(final BackgroundExecutor executor) {
        this.executor = executor;
    }

    public void runInBackground(Runnable runnable) {
        executor.run(runnable);
    }

    public void cancel() {
        executor.shutdown();
    }
}
