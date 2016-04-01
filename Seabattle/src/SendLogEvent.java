import java.util.EventObject;

/**
 * Created by Антон on 15.10.2015.
 */
public class SendLogEvent extends EventObject{
    String logMessage;

    public SendLogEvent(Object source, String logMessage) {
        super(source);
        this.logMessage = logMessage;
    }
}
