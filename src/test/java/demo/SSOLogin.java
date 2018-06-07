package demo;

import webTools.SeleniumDriver;
import webTools.WebElementUtil;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import tools.EnvProperties;
import tools.ExcelUnit;

import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

/**
 * Created by lijing on 2018/5/28.
 */
public class SSOLogin extends SeleniumDriver {
    /**
     * 多个应用系统用户登录
     */
    /**
     * 获取环境信息各应用系统url：properties数据驱动
     */
    @BeforeMethod
    public static void setUp () throws IOException {
        //获取所有应用系统的登录地址
        String filepath="E:\\env.properties";
        Properties pro= EnvProperties.getProperties(filepath);
        String CBurl=pro.getProperty("CBurl");
        //String Channelsurl=pro.getProperty("channelsurl");
        //String h5url=pro.getProperty("h5url");

        //打开浏览器，输入登录域名
        SeleniumDriver.open("chrome");
        driver.get(CBurl);
        System.out.println(CBurl);
        //driver.get(Channelsurl);
        //driver.get(h5url);

    }

    /**
     * 机构管理员、应用管理员、普通用户 登录：excel数据驱动
     */
    @DataProvider(name="testData")
    public Object[][]data(){
        ExcelUnit excelDriven=new ExcelUnit();
        String file="E:\\test.xlsx";
        return excelDriven.testData(file,"ssouser");
    }

    @Test(dataProvider = "testData")
    public void pupLogin(HashMap<String,String> mapdata ){
        String username=mapdata.get("username");
        String password=mapdata.get("password");

        WebElementUtil.findElement(By.id("username")).sendKeys(username);
        WebElementUtil.findElement(By.id("password")).sendKeys(password);
        WebElementUtil.findElement(By.id("captcha")).sendKeys("1");
        WebElementUtil.findElement(By.xpath(".//*[@id='loginForm']/div/div[8]")).click();
    }

}
