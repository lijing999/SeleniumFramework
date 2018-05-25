package toolsTest;

import org.testng.annotations.Test;
import tools.RandomNum;

/**
 * Created by lijing on 2018/5/24.
 */
public class RandomNumTest {
    @Test
    public void lTest(){
        RandomNum.getNumRandom(5);
        int num = RandomNum.getNumRandom(100,200);
        String str=RandomNum.getStringRandom(3);
        System.out.println(str);
    }
}
