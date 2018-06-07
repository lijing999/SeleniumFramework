package demo;

import webTools.SeleniumDriver;
import webTools.WebElementUtil;
import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import tools.MyAssert;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by lijing on 2018/5/25.
 */
public class login extends SeleniumDriver {

    /**
     * 数据驱动
     * 平台管理员、机构管理员、应用管理员、普通用户的 用户名和密码
     */
    @DataProvider(name="pupdata")
    public Object[][] data(){
        Object[][] data=new Object[][]{
                {"admin","admin1234"},
                {"pdmiOrgAdmin","pdmiOrgAdmin"},
                {"pdmicmsAppAdmin","pdmicmsAppAdmin"},

        };
        return data;
    }

    /**
     * 预置条件：打开浏览器
     * @throws IOException
     */
    @BeforeMethod
    public void SetUp() throws IOException {
        String filepath="E:\\env.properties";
        FileInputStream is=new FileInputStream(filepath);
        Properties prop=new Properties();
        prop.load(is);
        String Pupurl=prop.getProperty("Pupurl");
        System.out.println("PUP登录地址为：" + Pupurl);

        //打开chrome浏览器
        SeleniumDriver.open("chrome");

        driver.get(Pupurl);
    }

    /**
     * 登录业务逻辑
     * @param username
     * @param password
     */
    @Test(dataProvider = "pupdata")
    public void dataDrivelogin(String username,String password) {


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
