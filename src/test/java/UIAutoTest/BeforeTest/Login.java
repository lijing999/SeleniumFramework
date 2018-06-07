package UIAutoTest.BeforeTest;

import webTools.WebAction;
import webTools.SeleniumDriver;
import webTools.WebElementUtil;
import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import tools.ExcelUnit;
import tools.MyAssert;

import java.io.IOException;
import java.util.HashMap;

/**
 * Created by lijing on 2018/6/5.
 * 仅excel数据驱动：获取登录用户数据
 */
public class Login {
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
    public static void LoginTest(HashMap<String,String> mapdata) throws IOException {
        //打开浏览器，输入登录url地址
        EnvInit.envInit("Pupurl","chrome");

        //获取登录用户参数
        String username=mapdata.get("username");
        String password=mapdata.get("password");

        WebElementUtil.findElement(By.id("j_username")).sendKeys(username);
        WebElementUtil.findElement(By.id("j_password")).sendKeys(password);
        WebElementUtil.findElement(By.id("j_verification_code")).sendKeys("1");
        WebAction.click(By.id("doLogin"));

        //断言
        MyAssert.assertElementExist(By.id("quit"));

        //关闭浏览器
        SeleniumDriver.closedAll();



    }

    public static void Login(HashMap<String,String> mapdata ) throws IOException {
        //打开浏览器，输入登录url地址
        EnvInit.envInit("Pupurl","chrome");

        //获取登录用户参数
        String username=mapdata.get("username");
        String password=mapdata.get("password");

        WebElementUtil.findElement(By.id("j_username")).sendKeys(username);
        WebElementUtil.findElement(By.id("j_password")).sendKeys(password);
        WebElementUtil.findElement(By.id("j_verification_code")).sendKeys("1");
        WebElementUtil.findElement(By.id("doLogin")).click();


    }
}
