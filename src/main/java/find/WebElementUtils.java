package find;

import com.drivers.SeleniumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * Created by lijing on 2018/5/24.
 */
public class WebElementUtils extends SeleniumDriver{
    public static List<WebElement> findElements(final By by){

        List<WebElement> elements=null;

        try{
            //等待10s, 找到该元素
            WebDriverWait wait=new WebDriverWait(driver,10);
            wait.until(ExpectedConditions.presenceOfElementLocated(by));
        }catch (Exception e){
            System.out.println("元素：" + by + "查找超时!");
            e.printStackTrace();
        }



//      继承了SeleniumDrvier，driver可以直接使用
        elements=driver.findElements(by);
        return elements;
    }
}
