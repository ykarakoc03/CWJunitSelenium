package Day13_Log4j_SeleniumExceptions_ExtentReport;


import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class C01_Log4jDemo {

    public static void main(String[] args) {

        PropertyConfigurator.configure("log4j.properties");
        Logger logger = Logger.getLogger(C01_Log4jDemo.class.getName());

        logger.trace("Trace Mesajı");
        logger.debug("Debug Mesajı");
        logger.info("Info Mesajı");
        logger.warn("Warn Mesajı");
        logger.error("Error Mesajı");
        logger.fatal("Fatal Mesajı");
    }
}
