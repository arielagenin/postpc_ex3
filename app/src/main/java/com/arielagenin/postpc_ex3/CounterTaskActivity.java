package com.arielagenin.postpc_ex3;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.arielagenin.postpc_ex3.counter_task.BaseCounterTask;
public class CounterTaskActivity extends AppCompatActivity {
    public static final String EXTRA_COUNTER_TASK_CLASS = "CounterTask class";
    private static final String TAG_TASK_FRAGMENT = "Task Fragment";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_counter_task);

        final FragmentManager fm = getSupportFragmentManager();

        if (fm.findFragmentByTag(TAG_TASK_FRAGMENT) == null) { // Create the TaskFragment for the first time
            // Initialize an instance of the task from the class that the previous activity passed to this one
            final BaseCounterTask task;

            try {
                final Class taskClass = (Class) getIntent().getSerializableExtra(EXTRA_COUNTER_TASK_CLASS);
                task = (BaseCounterTask) taskClass.newInstance();
            } catch (InstantiationException | IllegalAccessException e) { // Shouldn't happen
                e.printStackTrace();
                return;
            }

            final TaskFragment fragment = TaskFragment.newInstance(task);
            fm.beginTransaction().add(R.id.container_view, fragment, TAG_TASK_FRAGMENT).commit();
        }
    }
}
