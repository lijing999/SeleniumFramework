package com.drivers;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

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
