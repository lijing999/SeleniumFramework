package actions;


import WebAction.WebAction;
import com.drivers.SeleniumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.ArrayList;

/**
 * Created by lijing on 2018/5/24.
 */
public class ActionsTest {
    @Test
    public void testClick() throws InterruptedException {
        WebDriver driver=SeleniumDriver.open("chrome");

        WebAction.get(driver,"http://www.baidu.com");
        WebAction.sendText(By.id("kw"),"selenium");
        WebAction.click(By.id("su"));
        Thread.sleep(3000);
        SeleniumDriver.closedAll();
    }
    @Test
    public void getText() throws InterruptedException {
        WebDriver driver=SeleniumDriver.open("chrome");
        WebAction.get(driver,"http://www.baidu.com");
        String Text=WebAction.getText(By.name("tj_trnews"));
        System.out.println(Text);
        Thread.sleep(3000);
        SeleniumDriver.closedAll();
    }
    @Test
    public void getTexts() throws InterruptedException {
        WebDriver driver=SeleniumDriver.open("chrome");
        WebAction.get(driver,"http://www.baidu.com");
        ArrayList list= WebAction.getTexts(By.xpath(".//*[@id='u1']/a"));
        //System.out.print(list.get(2));
        for(int i=0;i<list.size();i++){
            System.out.print(list.get(i)+ " ");
        }
        Thread.sleep(3000);
        SeleniumDriver.closedAll();
    }

    @Test
    public void DoubClickTest(){
        WebDriver driver=SeleniumDriver.open("chrome");
        WebAction.get(driver,"http://www.baidu.com");
        WebAction.doubleClick(driver,By.id("su"));
        SeleniumDriver.closedAll();
    }
}
