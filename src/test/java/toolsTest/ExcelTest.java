package toolsTest;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import tools.ExcelUnit;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by lijing on 2018/5/24.
 */
public class ExcelTest {



    @DataProvider(name="t")
    public Object[][] data(){
        ExcelTest excelTest=new ExcelTest();
        return ExcelUnit.testData("E:\\test.xlsx",0);
    }

    //@Test(dataProvider="t")
    @Test(dataProvider = "t")
    public void testCase(HashMap<String,String> data){
        String ClientId=data.get("client_id");
        System.out.println("client_id:" + ClientId);
        String ClientSecret=data.get("client_secret");
        System.out.println("client_secret:" + ClientSecret);
        String UserName=data.get("username");
        System.out.println("username:"+UserName);
        String Pwd=data.get("password");
        System.out.println("password:"+Pwd);
    }



}
