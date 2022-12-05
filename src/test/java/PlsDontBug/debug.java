package PlsDontBug;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.testng.annotations.Test;


public class debug {
    private static final Logger log = LogManager.getLogger(debug.class.getName());
    @Test
    public  void debug(){
        log.debug("debug log");
        log.error("error log");
        log.info("info log");
    }
}
