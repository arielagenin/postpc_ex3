package com.arielagenin.postpc_ex3.counter_task;

public abstract class BaseCounterTask {
    public static final int MAX_PROGRESS = 10;
    static final long SLEEP_DURATION = 500;

    OnProgressUpdateListener listener;

    public abstract void create();

    public abstract void start();

    public abstract void cancel();

    public void setOnProgressUpdateListener(OnProgressUpdateListener listener) {
        this.listener = listener;
    }

    public interface OnProgressUpdateListener {
        void onProgressUpdate(int progress);
    }
}
