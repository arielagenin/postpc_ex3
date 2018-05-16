package com.arielagenin.postpc_ex3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.arielagenin.postpc_ex3.counter_task.BaseCounterTask;
import com.arielagenin.postpc_ex3.counter_task.CounterAsyncTask;
import com.arielagenin.postpc_ex3.counter_task.CounterThreadsTask;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Convenience method for starting a new activity.
     *
     * @param counterTaskClass The class of the task to pass into the new activity.
     */
    private void startActivity(Class<? extends BaseCounterTask> counterTaskClass) {
        final Intent intent = new Intent(this, CounterTaskActivity.class);
        startActivity(intent.putExtra(CounterTaskActivity.EXTRA_COUNTER_TASK_CLASS, counterTaskClass));
    }

    public void openAsyncTaskActivity(View view) {
        startActivity(CounterAsyncTask.class);
    }

    public void openThreadsActivity(View view) {
        startActivity(CounterThreadsTask.class);
    }
}
