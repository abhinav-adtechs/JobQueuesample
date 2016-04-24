package co.hackdevmentalists.abhinav.jobqueuetesting;


public class NotifierEvent {

    private String messageSuccess ;

    public NotifierEvent(String messageSuccess) {
        this.messageSuccess = messageSuccess;
    }

    public String getMessageSuccess() {
        return messageSuccess;
    }

    public void setMessageSuccess(String messageSuccess) {
        this.messageSuccess = messageSuccess;
    }
}
