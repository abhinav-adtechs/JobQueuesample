package co.hackdevmentalists.abhinav.jobqueuetesting;

import android.app.Application;
import android.content.Intent;

import com.birbit.android.jobqueue.JobManager;
import com.birbit.android.jobqueue.config.Configuration;


public class AppController extends Application{

    private static AppController mInstance;
    private JobManager jobManager ;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this ;
        configureJobManager();
    }

    public static synchronized AppController getInstance() {
        return mInstance;
    }

    private void configureJobManager() {
        Configuration.Builder builder = new Configuration.Builder(this)
                .minConsumerCount(1)
                .maxConsumerCount(3)
                .loadFactor(3)
                .consumerKeepAlive(120);

        jobManager = new JobManager(builder.build());
    }

    public JobManager getJobManager(){
        return jobManager ;
    }
}
