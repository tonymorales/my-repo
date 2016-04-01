import java.util.ArrayList;

/**
 * Created by Антон on 15.10.2015.
 */
public class SendLogControl {
    private ArrayList<SendLogListener> sendLogListeners = new ArrayList<SendLogListener>();

    public void addSendLogListener(SendLogListener logListener){
        sendLogListeners.add(logListener);
    }

    public void removeSendLogListener(SendLogListener logListener)
    {
        sendLogListeners.remove(logListener);
    }
    public void fireBornLogMessage(String message)
    {
        SendLogEvent ev = new SendLogEvent(this, message);
        for(SendLogListener logListener : sendLogListeners)
        logListener.bornLogMessage(ev);

    }
}
