package webToolsTest;

import org.testng.annotations.Test;
import webTools.SeleniumDriver;

/**
 * Created by lijing on 2018/5/23.
 */
public class SeleniumDriverTest {

    @Test
    public void openTest() throws InterruptedException {
      // WebDriver driver = SeleniumDriver.open("chrome");
     //  SeleniumDriver.open("ie");
        SeleniumDriver.open("firefox");
        Thread.sleep(3000);
        SeleniumDriver.closedAll();
    }
}
