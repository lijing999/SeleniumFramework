package tools;

import com.drivers.SeleniumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.regex.Pattern;

/**
 * Created by lijing on 2018/5/25.
 */
public class MyAssert extends Assert {


    //以某字符串开头
    public static void assertStartWith(String content,String prefix){

        if(content.startsWith(prefix)){
            System.out.println("前缀匹配校验成功");
        }else {
            System.out.println("前缀匹配校验失败！");
        }
    }

    //以某字符串结尾
    public static void assertEndWith(String content,String endfix){
        if (content.endsWith(endfix)){
            System.out.println("后缀匹配校验成功");
        }else {
            System.out.println("后缀匹配校验失败");
        }
    }

    //是否包含某字符串
    public static void aseertInclude(String content,String included){
        if (content.contains(included)){
            System.out.println("匹配校验成功");
        }else {
            System.out.println("匹配校验失败");
        }
    }

    //根据正则表达式断言是否匹配
    public static void assertMatch(String matcher,String regex){
        if(Pattern.matches(regex,matcher)){
            System.out.println("匹配校验成功！");
        }else {
            System.out.println("匹配校验失败！");
        }
    }

    // 如果可以找到某个页面元素，则断言成功
   public static boolean assertElementExist (By Locator ) {

        try {
            SeleniumDriver.driver.findElement(Locator);
            return true;
        }catch (org.openqa.selenium.NoSuchElementException ex){
            return false;
        }
    }


}
