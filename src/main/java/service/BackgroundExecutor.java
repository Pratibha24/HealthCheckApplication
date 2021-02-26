package service;

public interface BackgroundExecutor {
    void run(Runnable runnable);

    void shutdown();
}
