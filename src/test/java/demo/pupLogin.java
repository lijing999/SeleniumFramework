package demo;

import webTools.SeleniumDriver;
import webTools.WebElementUtil;
import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import tools.EnvProperties;
import tools.ExcelUnit;
import tools.MyAssert;

import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

/**
 * Created by lijing on 2018/5/28.
 */
public class pupLogin extends SeleniumDriver {
    /**
     * 获取环境信息pupurl：properties数据驱动
     */
    @BeforeMethod
    public static void setUp () throws IOException {
        //获取登录地址
        String filepath="E:\\env.properties";
       Properties pro= EnvProperties.getProperties(filepath);
       String url=pro.getProperty("Pupurl");
        //打开浏览器
      SeleniumDriver.open("chrome");
      driver.get(url);
    }

    /**
     * 机构管理员、应用管理员、普通用户 登录：excel数据驱动
     */
    @DataProvider(name="testData")
    public Object[][]data(){
        ExcelUnit excelDriven=new ExcelUnit();
        String file="E:\\test.xlsx";
        return excelDriven.testData(file,"pupdata");
    }

    @Test(dataProvider = "testData")
    public static void LoginTest(HashMap<String,String> mapdata ){
        String username=mapdata.get("username");
        String password=mapdata.get("password");

        WebElementUtil.findElement(By.id("j_username")).sendKeys(username);
        WebElementUtil.findElement(By.id("j_password")).sendKeys(password);
        WebElementUtil.findElement(By.id("j_verification_code")).sendKeys("1");
        WebElementUtil.findElement(By.id("doLogin")).click();
    }




    /**
     * 断言，判断登录成功
     * 关闭浏览器
     */
    @AfterMethod
    public void TearDown(){

        // 断言：登录成功后，若页面存在quit元素，则登录成功
        MyAssert.assertElementExist(By.id("quit"));
        SeleniumDriver.closedAll();
    }

}
