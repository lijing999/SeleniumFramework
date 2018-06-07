package UIAutoTest.AfterTest;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import tools.MyAssert;
import webTools.SeleniumDriver;

/**
 * Created by lijing on 2018/6/5.
 */
public class TearDown {
    @Test
    public static void Teardown(){
        //断言------ 改造，可重用
        MyAssert.assertElementExist(By.id("quit"));

        //关闭浏览器
        SeleniumDriver.closedAll();
    }
}
