package webTools;

import webTools.SeleniumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by lijing on 2018/5/23.
 * 查找单个页面元素
 */
public class WebElementUtil extends SeleniumDriver{

    public static WebElement findElement(final By by){

        WebElement element=null;

        try{
            //等待10s, 找到该元素
            WebDriverWait wait=new WebDriverWait(driver,10);
            wait.until(ExpectedConditions.presenceOfElementLocated(by));
        }catch (Exception e){
            System.out.println("元素：" + by + "查找超时!");
            e.printStackTrace();
        }



//      继承了SeleniumDrvier，driver可以直接使用
        element=driver.findElement(by);
        return element;
    }
}
