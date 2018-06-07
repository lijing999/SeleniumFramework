package UIAutoTest.AfterTest;

import org.openqa.selenium.By;
import tools.MyAssert;
import webTools.SeleniumDriver;

/**
 * Created by lijing on 2018/6/5.
 * 断言
 * 关闭浏览器
 */
public class TeardownTest {
    public static void Teardown(){
        //断言------ 改造，可重用
        MyAssert.assertElementExist(By.id("quit"));

        //关闭浏览器
        SeleniumDriver.closedAll();
    }
}
