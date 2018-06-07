package webToolsTest;

import webTools.SeleniumDriver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Augmenter;

import java.io.File;

/**
 * Created by lijing on 2018/5/25.
 * 发生错误时做错误截图
 */
public class screenShots extends SeleniumDriver{
    WebDriver augmentedDriver = new Augmenter().augment(driver);
    File file= ((TakesScreenshot)augmentedDriver).getScreenshotAs(OutputType.FILE);
/*
    try{
        MyFile myFile=new MyFile();
        String path=System.getProperty("user.dir");
        //根据日期创建文件夹
        tools.MyFile.createFile(path+ DateFormat.format(tools.DateFormat.CHECK_LOG_FORMAT));
        FileUtils.copyFile(file,new File(path+DateFormat.format(DateFormat.CHECK_LOG_FORMAT) + "/"));
    }catch(IOException e){
        e.printStackTrace();
    }*/


}
