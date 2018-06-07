package demo;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import org.openqa.selenium.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import static webTools.SeleniumDriver.driver;

/**
 * Created by lijing on 2018/6/5.
 */
public class GetCaptcha {

    // 1、 将验证码页面截图保存

    public byte[] takeScreenshot(WebDriver driver) throws IOException {

        byte[] screenshot = null;

        screenshot = ((TakesScreenshot) driver)

                .getScreenshotAs(OutputType.BYTES);//得到截图

        return screenshot;

    }

    //2、得到的图片是整个屏幕的截图，我们可以处理一下，对图片进行截取，只保留验证码那一部分
    public BufferedImage createElementImage(WebDriver driver, WebElement webElement, int x, int y, int width, int heigth) throws IOException {

        Dimension size = webElement.getSize();

        BufferedImage originalImage = ImageIO.read(new ByteArrayInputStream(

                takeScreenshot(driver)));

        BufferedImage croppedImage = originalImage.getSubimage(x, y,

                size.getWidth() + width, size.getHeight() + heigth);//进行裁剪

        return croppedImage;

    }


//3、tesseract读取图片，获得验证码，默认是英文，如果要使用中文包，加上instance.setLanguage("chi_sim");
private String getVerificationCode(String path) {

    File imageFile = new File(path);

    try {

        imageFile.createNewFile();

    } catch (IOException e1) {

        e1.printStackTrace();

    }

    WebElement element = driver.findElement(By

            .cssSelector("img[id='codeImg']"));

    try {

        BufferedImage image = createElementImage(driver, element, 687, 362,

                54, 18);//得到裁剪的图片

        ImageIO.write(image, "png", imageFile);//进行保存

    } catch (IOException e) {

        e.printStackTrace();

    }

    ITesseract instance = new Tesseract();//调用Tesseract

    URL url = ClassLoader.getSystemResource("tessdata");//获得Tesseract的文字库

    String tesspath = url.getPath().substring(1);

    instance.setDatapath(tesspath);//进行读取，默认是英文，如果要使用中文包，加上instance.setLanguage("chi_sim");

    String result = null;

    try {

        result = instance.doOCR(imageFile);

    } catch (TesseractException e1) {

        e1.printStackTrace();

    }

    result = result.replaceAll("[^a-z^A-Z^0-9]", "");//替换大小写及数字

    return result;

}
}
