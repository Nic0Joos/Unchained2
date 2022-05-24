package ch.fhnw.acrm.business.service;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

//Copied from https://github.com/MathisHermann/TimBan
//Adjusted to append: Nico

@Service
public class LoggerService {

    protected static final Logger logger = Logger.getLogger("MyLog");


    public static void logSystem(String level, String msg) {
        FileHandler fh = null;

        try {
            fh = new FileHandler("system_logs.log", true);
            logger.addHandler(fh);
            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter);

            if (msg.length() > 0) {
                switch (level) {
                    case "info":
                        logger.log(Level.INFO, msg);
                        break;
                    case "warning":
                        logger.log(Level.WARNING, msg);
                        break;
                    case "fine":
                        logger.log(Level.FINE, msg);
                        break;
                    case "finer":
                        logger.log(Level.FINER, msg);
                        break;
                    case "finest":
                        logger.log(Level.FINEST, msg);
                        break;
                    default:
                        logger.log(Level.CONFIG, msg);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fh != null)
                fh.close();
        }

    }

    public static void logUser(String msg) {
        FileHandler fh = null;

        try {
            fh = new FileHandler("user_logs.log", true);
            logger.addHandler(fh);
            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter);

            logger.info(msg);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fh != null)
                fh.close();
        }
    }



}
