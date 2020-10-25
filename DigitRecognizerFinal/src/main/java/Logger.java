/**
 * Logger is used for initializing the types of loggers
 * and follows the Chain of Responsibility Design and Singleton
 * pattern.
 *
 * @author  Sukhpreet Anand , Sheran Dass , Khushboo Gupta
 * @version 1.0
 * @since   2019-10-15
 */
public abstract class Logger {

    private static AbstractLogger errorLogger;
    private static AbstractLogger fileLogger;
    private static AbstractLogger consoleLogger;

    protected Logger() {}

    public abstract void logMessage(int level, String message);

    public static AbstractLogger getLogger() {
        if (errorLogger == null) {
            errorLogger = new ErrorLogger(AbstractLogger.ERROR);
            fileLogger = new DebugLogger(AbstractLogger.DEBUG);
            consoleLogger = new InfoLogger(AbstractLogger.INFO);
            errorLogger.setNextLogger(fileLogger);
            fileLogger.setNextLogger(consoleLogger);
        }
        return errorLogger;
    }
}
