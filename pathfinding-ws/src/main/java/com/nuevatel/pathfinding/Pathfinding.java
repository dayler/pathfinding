/**
 * 
 */
package com.nuevatel.pathfinding;

import java.io.FileInputStream;
import java.util.Date;
import java.util.Properties;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

/**
 * <p>The PathfindingApp class.</p>
 * <p>NuevaTel PCS de Bolivia S.A. (c) 2017</p>
 * <p>El contenido de este archivo esta clasificado como: </p>
 * <p>INFORMACION DE CONFIDENCIALIDAD ALTA </p>
 * 
 * TODO
 * 
 * @author asalazar
 * @version 1.0 Apr 8, 2017
 * @since 1.8
 *
 */
public class Pathfinding {
    
    private static Logger logger = Logger.getLogger("");
        
    private static Handler loggerHandler = new LoggerHandler();
    
    static {
        for (Handler handler : logger.getHandlers()) {
            logger.removeHandler(handler);
        }
        logger.addHandler(loggerHandler);
        logger.setLevel(Level.INFO);
        logger.setUseParentHandlers(false);
    }
    
    public static void main(String[] args) {
        if (args.length == 0) {
            logger.log(Level.SEVERE, "Use: java com.nuevatel.pathfinding.Pathfinding </path/to/properties>");
            return;
        }
        // 
        try {
            Properties properties = new Properties();
            try (FileInputStream is = new FileInputStream(args[0])) {
                properties.load(is);
            }
            PathfindingApp app = new PathfindingApp(new Config(properties));
            app.start();
            // Add shutdown hook.
            Runtime.getRuntime().addShutdownHook(new Thread(app::stop));
        } catch (Exception ex) {
            logger.log(Level.SEVERE, "Failed to start PathfindingApp..", ex);
            System.exit(-1);
        }
    }
    
    /**
     * Log handler.
     */
    private static final class LoggerHandler extends Handler {
        
        @Override
        public void publish(LogRecord record) {
            String logRecord;
            if (record.getLevel().intValue() > Level.FINER.intValue()) {
                logRecord = String.format("%1$tF %1$tT", new Date(record.getMillis())) + " " +
                                            record.getLevel().getName() + " " +
                                            record.getSourceClassName() + "." +
                                            record.getSourceMethodName() + " " +
                                            record.getMessage();
            } else {
                logRecord = String.format("%1$tF %1$tT", new Date(record.getMillis())) + " " +
                                            record.getSourceMethodName() + " " +
                                            record.getMessage();
            }
            if (record.getLevel().intValue() > Level.INFO.intValue()) {
                System.out.println(logRecord);
                if (record.getLevel() == Level.SEVERE && record.getThrown() != null) {
                    record.getThrown().printStackTrace(System.out);
                }
            } else {
                System.out.println(logRecord);
            }
        }

        @Override
        public void flush() {
            // no op
        }

        @Override
        public void close() throws SecurityException {
            // no op
        }
        
    }
}
