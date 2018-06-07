package demo;

import org.testng.annotations.Test;

/**
 * Created by lijing on 2018/5/24.
 */
public class TestLog4j {

    final static LoggerController log = LoggerController.getLogger("TestLog4j");

    @Test
    public void testCase(){
        log.info("这是info");
        log.warning("这是warning");
        log.error("这是error");

    }

}
