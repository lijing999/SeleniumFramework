package UIAutoTest.BeforeTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import tools.ExcelUnit;
import webTools.GetLocator;
import webTools.WebElementUtil;

import java.io.IOException;
import java.util.HashMap;

/**
 * Created by lijing on 2018/6/5.
 */
public class LoginPage {

    /**
     * 机构管理员、应用管理员、普通用户 登录
     * properties配置文件：页面元素定位方式和定位表达式
     * excel文件：登录用户数据
     */
    @DataProvider(name="testData")
    public Object[][]data(){
        ExcelUnit excelDriven=new ExcelUnit();
        String file="E:\\test.xlsx";
        return excelDriven.testData(file,"pupdata");
    }

    @Test(dataProvider = "testData")
    public void LoginPageTest(HashMap<String,String> mapdata) throws Exception {
        //打开浏览器，输入登录url地址
        EnvInit.envInit("Pupurl","chrome");

        //从配置文件objectMap.properties中，获取登录页面元素的定位方式和定位表达式
       By usernameLocator= GetLocator.getWebElement("pup.loginPage.username");
       WebElement usernameElement= WebElementUtil.findElement(usernameLocator);

       By passwordLocator= GetLocator.getWebElement("pup.loginPage.password");
       WebElement passwordElement= WebElementUtil.findElement(passwordLocator);

        By verificationLocator= GetLocator.getWebElement("pup.loginPage.verification");
        WebElement verificationElement= WebElementUtil.findElement(verificationLocator);

        By loginbuttonLocator= GetLocator.getWebElement("pup.loginPage.loginbutton");
        WebElement loginbuttonElement= WebElementUtil.findElement(loginbuttonLocator);


        //从excel数据文件中，获取登录用户参数
        String username=mapdata.get("username");
        String password=mapdata.get("password");
        // 登录业务逻辑
        usernameElement.sendKeys(username);
        passwordElement.sendKeys(password);
        verificationElement.sendKeys("1");
        loginbuttonElement.click();
    }

    public static void LoginPage(HashMap<String,String> mapdata) throws Exception {
        //打开浏览器，输入登录url地址
        EnvInit.envInit("Pupurl","chrome");

        //从配置文件objectMap.properties中，获取登录页面元素的定位方式和定位表达式
        By usernameLocator= GetLocator.getWebElement("pup.loginPage.username");
        WebElement usernameElement= WebElementUtil.findElement(usernameLocator);

        By passwordLocator= GetLocator.getWebElement("pup.loginPage.password");
        WebElement passwordElement= WebElementUtil.findElement(passwordLocator);

        By verificationLocator= GetLocator.getWebElement("pup.loginPage.verification");
        WebElement verificationElement= WebElementUtil.findElement(verificationLocator);

        By loginbuttonLocator= GetLocator.getWebElement("pup.loginPage.loginbutton");
        WebElement loginbuttonElement= WebElementUtil.findElement(loginbuttonLocator);


        //从excel数据文件中，获取登录用户参数
        String username=mapdata.get("username");
        String password=mapdata.get("password");
        // 登录业务逻辑
        usernameElement.sendKeys(username);
        passwordElement.sendKeys(password);
        verificationElement.sendKeys("1");
        loginbuttonElement.click();
    }
}
