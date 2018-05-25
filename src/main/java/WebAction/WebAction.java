package WebAction;

import find.WebElementUtil;
import find.WebElementUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lijing on 2018/5/24.
 */
public class WebAction {
    //打开网站
    public static void get(WebDriver driver, String url){

        driver.get(url);

    }

    //封装click方法
    public static void click(By by){
        WebElementUtil.findElement(by).click();
    }

    //封装 文本框输入方法
    public static void sendText(By by,String text){
        WebElement element = WebElementUtil.findElement(by);
        element.clear();
        element.sendKeys(text);
    }
    //获取单个文本
    public static String getText(By by){
        String text=WebElementUtil.findElement(by).getText();
        return text;
    }

    //获取多个文本值
    public static ArrayList getTexts(By by){
        ArrayList arrayList = new ArrayList();
        List<WebElement> list=  WebElementUtils.findElements(by);
        for (int i=0;i<list.size();i++){
            String text= list.get(i).getText();
            arrayList.add(text);
        }
        return arrayList;
    }

    public static void doubleClick(WebDriver driver,By by){
        Actions actions=new Actions(driver);
        WebElement element=WebElementUtil.findElement(by);
        actions.doubleClick(element).perform();
    }
}
