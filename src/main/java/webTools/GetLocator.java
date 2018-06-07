package webTools;

import org.openqa.selenium.By;
import tools.EnvProperties;

import java.util.Properties;

/**
 * Created by lijing on 2018/6/5.
 */
public class GetLocator {
    public static By getWebElement(String ElementName) throws Exception {
        // 获取配置文件
        Properties properties= EnvProperties.getProperties("E:\\TestDevs\\SeleniumFramework\\src\\objectMap.properties");
        String locator=properties.getProperty(ElementName);

        //元素定位类型
        String locatorType=locator.split(">")[0];
        //元素定位类型的值
        String locatorValue=locator.split(">")[1];

        System.out.println("获取的定位类型：" + locatorType + "\t 获取的定位表达式" + locatorValue);

        // 根据locatorType的变量值内容判断返回何种定位方式的by对象
        if(locatorType.toLowerCase().equals("id")){
            return By.id(locatorValue);
        }else if(locatorType.toLowerCase().equals("name")){
            return By.name(locatorValue);
        }else if((locatorType.toLowerCase().equals("classname")) ||(locatorType.toLowerCase().equals("class")) ){
            return By.className(locatorValue);
        }else if((locatorType.toLowerCase().equals("tagname")) ||(locatorType.toLowerCase().equals("tag")) ){
            return By.className(locatorValue);
        }else if((locatorType.toLowerCase().equals("linktext")) ||(locatorType.toLowerCase().equals("link")) ){
            return By.linkText(locatorValue);
        }else if((locatorType.toLowerCase().equals("partiallinktext")) ){
            return By.partialLinkText(locatorValue);
        }else if((locatorType.toLowerCase().equals("cssselector"))||(locatorType.toLowerCase().equals("css") )){
            return By.cssSelector(locatorValue);
        }else if((locatorType.toLowerCase().equals("xpath"))){
            return By.xpath(locatorValue);
        }else {
            throw new Exception("输入的locator type未在程序中被定义：" + locatorType);
        }

    }
}
