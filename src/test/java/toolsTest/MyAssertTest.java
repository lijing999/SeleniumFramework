package toolsTest;

import org.testng.annotations.Test;
import tools.MyAssert;

/**
 * Created by lijing on 2018/5/25.
 */
public class MyAssertTest {

    @Test
    public void AssertTest(){
        String content="helloword";
        String prefix="h";
        MyAssert.assertStartWith(content,prefix);
    }

    @Test
    public void AssertTest1(){
        String content="helloword";
        String prefix="l";
        MyAssert.assertStartWith(content,prefix);
    }
}
