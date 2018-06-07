package demo;

import webTools.SeleniumDriver;
import webTools.WebElementUtil;
import org.openqa.selenium.By;
import tools.EnvProperties;

import java.io.IOException;
import java.util.Properties;

/**
 * Created by lijing on 2018/5/29.
 */
public class JGlogin extends SeleniumDriver {
    public static void login(String username,String password) throws IOException {
        //获取登录地址
        String filepath="E:\\env.properties";
        Properties pro= EnvProperties.getProperties(filepath);
        String url=pro.getProperty("Pupurl");
        //打开浏览器
        SeleniumDriver.open("chrome");
        driver.get(url);

        //登录
        WebElementUtil.findElement(By.id("j_username")).sendKeys(username);
        WebElementUtil.findElement(By.id("j_password")).sendKeys(password);
        WebElementUtil.findElement(By.id("j_verification_code")).sendKeys("1");
        WebElementUtil.findElement(By.id("doLogin")).click();
    }
}
