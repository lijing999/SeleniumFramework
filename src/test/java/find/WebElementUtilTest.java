package find;

import com.drivers.SeleniumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

/**
 * Created by lijing on 2018/5/23.
 */
public class WebElementUtilTest {
    @Test
    public void findTest(){
       WebDriver driver= SeleniumDriver.open("chrome");
        driver.get("file:///E:/%E5%AD%A6%E4%B9%A0%E8%B5%84%E6%96%99/selenium+java%E8%87%AA%E5%8A%A8%E5%8C%96%EF%BC%88%E6%9C%80%E6%96%B0%EF%BC%89/index.html");
        WebElementUtil.findElement(By.className("wait")).click();
       // String text=WebElementUtil.findElement(By.className("red")).getText();
        //System.out.println(text);
    }
}
