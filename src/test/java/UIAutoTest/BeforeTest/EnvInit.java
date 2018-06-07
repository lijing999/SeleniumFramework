package UIAutoTest.BeforeTest;

import webTools.SeleniumDriver;
import tools.EnvProperties;

import java.io.IOException;
import java.util.Properties;

/**
 * Created by lijing on 2018/6/5.
 * 从配置文件中获取登录地址，打开浏览器
 */
public class EnvInit extends SeleniumDriver {


    public static void envInit(String urlName,String browserName) throws IOException {
        //获取登录地址
        String filepath="E:\\env.properties";
        Properties pro= EnvProperties.getProperties(filepath);
        String url=pro.getProperty(urlName);
        //打开浏览器
        SeleniumDriver.open(browserName);
        driver.get(url);
    }
}
