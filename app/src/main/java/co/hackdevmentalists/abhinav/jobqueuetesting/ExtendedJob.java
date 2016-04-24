package co.hackdevmentalists.abhinav.jobqueuetesting;


import android.util.Log;

import com.birbit.android.jobqueue.Job;
import com.birbit.android.jobqueue.Params;
import com.birbit.android.jobqueue.RetryConstraint;

import org.greenrobot.eventbus.EventBus;

public class ExtendedJob extends Job{

    public static final int PRIORITY = 1;
    public static final String TAG = "Testing Tag" ;

    public ExtendedJob(String message) {
        super(new Params(PRIORITY).requireNetwork().persist());
        Log.d(TAG, "ExtendedJob() called with: " + "message = [" + message + "]");
    }

    @Override
    public void onAdded() {
        Log.d(TAG, "onAdded: ");
    }

    @Override
    public void onRun() throws Throwable {
        Log.d(TAG, "onRun: ");

        EventBus.getDefault().post(new NotifierEvent("Let's return to Main!"));
    }

    @Override
    protected void onCancel(int cancelReason) {
        Log.d(TAG, "onCancel: ");
    }

    @Override
    protected RetryConstraint shouldReRunOnThrowable(Throwable throwable, int runCount, int maxRunCount) {
        Log.d(TAG, "shouldReRunOnThrowable: ");
        return null;
    }
}
