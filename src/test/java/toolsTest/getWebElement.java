package toolsTest;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import tools.EnvProperties;
import webTools.GetLocator;

import java.io.IOException;
import java.util.Properties;

/**
 * Created by lijing on 2018/6/5.
 */
public class getWebElement {

    @Test
    public void getWebElementTest() throws IOException {
        // 获取配置文件
       Properties properties= EnvProperties.getProperties("E:\\TestDevs\\SeleniumFramework\\src\\objectMap.properties");
       String locator=properties.getProperty("pup.loginPage.username");

       //元素定位类型
        String locatorType=locator.split(">")[0];
        //元素定位类型的值
        String locatorValue=locator.split(">")[1];

        System.out.println("获取的定位类型：" + locatorType + "\t 获取的定位表达式" + locatorValue);

    }

   @Test
    public void getLocatorTest() throws Exception {
       GetLocator.getWebElement("pup.loginPage.username");
   }

}
