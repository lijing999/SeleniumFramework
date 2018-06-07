package webTools;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

/**
 * Created by lijing on 2018/5/23.
 * 浏览器操作封装：打开、关闭 不同类型浏览器
 */
public class SeleniumDriver {

    public static WebDriver driver;

    public static WebDriver open(String browser){

        //final static LoggerController log = LoggerController.getLogger(SeleniumDriver.class);

        String path=System.getProperty("user.dir");

        if(browser.equals("chrome")){
            System.setProperty("webdriver.chrome.driver",path+"/drivers/chromedriver.exe");
            driver=new ChromeDriver();
        }else if(browser.equals("ie")){
            System.setProperty("webdriver.ie.driver",path+"/drivers/IEDriverServer.exe");
            driver=new InternetExplorerDriver();
        }else if (browser.equals("firefox")){
            driver=new FirefoxDriver();
        }else {
            System.err.println("你传入的浏览器名称有误");
            //通过log4j输出
            //log.error("你传入的浏览器名称有误");

        }
        return  driver;
    }

    public static void closedAll(){
        driver.quit();
    }
    public static void closed(){
        driver.close();
    }
}
