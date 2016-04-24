package co.hackdevmentalists.abhinav.jobqueuetesting;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.birbit.android.jobqueue.JobManager;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class MainActivity extends AppCompatActivity {

    private String TAG = "Main Testing TAG" ;
    JobManager jobManager ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EventBus.getDefault().register(this);
        Log.d(TAG, "onCreate: ");
        startWork() ;
    }

    private void startWork() {
        jobManager = AppController.getInstance().getJobManager() ;
        jobManager.addJobInBackground(new ExtendedJob("Job Initiating."));
    }

    @Subscribe
    public void handlerMethod(NotifierEvent notifierEvent){
        Log.d(TAG, "handlerMethod: " + notifierEvent.getMessageSuccess());
    }

    @Override
    protected void onStop() {
        EventBus.getDefault().unregister(this);
        super.onStop();
    }
}
