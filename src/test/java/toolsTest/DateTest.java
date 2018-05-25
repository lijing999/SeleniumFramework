package toolsTest;

import org.testng.annotations.Test;
import tools.DateFormat;
import tools.ExcelUnit;

/**
 * Created by lijing on 2018/5/24.
 */
public class DateTest {

    @Test
    public void testCase(){

        System.out.println(DateFormat.format(DateFormat.DATE_FORMAT));


    }
}
