package PupTest;

import com.drivers.SeleniumDriver;
import find.WebElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

/**
 * Created by lijing on 2018/5/25.
 */
public class login extends SeleniumDriver {


    @Test
    public void LoginTest(){
        SeleniumDriver.open("chrome");
        String url="http://oauth.pre.hubpd.com/pupmanage/auth/toLogin";
        driver.get(url);
        WebElementUtil.findElement(By.id("j_username")).sendKeys("pdmiOrgAdmin");
        WebElementUtil.findElement(By.id("j_password")).sendKeys("pdmiOrgAdmin");
        WebElementUtil.findElement(By.id("j_verification_code")).sendKeys("1");
        WebElementUtil.findElement(By.id("doLogin")).click();
        SeleniumDriver.closedAll();
    }
}
