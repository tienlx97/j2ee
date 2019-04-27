package logger;
//
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
import java.util.Date;
public class Logger_Server {

//    final static Logger log = LogManager.getRootLogger();

    public static void Server_On(){
//        log.info("System started at : " + new Date());
    }

    public static void Server_Off(){
//        log.info("System shutdowned at : " + new Date());
    }

    public static void Message(String mess){
//        log.info("Debug : " + mess);
    }
}