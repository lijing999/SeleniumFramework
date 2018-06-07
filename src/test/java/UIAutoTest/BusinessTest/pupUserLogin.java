package UIAutoTest.BusinessTest;

import UIAutoTest.AfterTest.TearDown;
import UIAutoTest.BeforeTest.Login;
import UIAutoTest.BeforeTest.LoginPage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import tools.ExcelUnit;

import java.io.IOException;
import java.util.HashMap;

/**
 * Created by lijing on 2018/6/5.
 * pup不同角色的用户登录：excel中获取用户数据
 */
public class pupUserLogin {
    /**
     * 机构管理员、应用管理员、普通用户 登录：excel数据驱动
     */
    @DataProvider(name="testData")
    public Object[][]data(){
        ExcelUnit excelDriven=new ExcelUnit();
        String file="E:\\test.xlsx";
        return excelDriven.testData(file,"pupdata");
    }

    @Test(dataProvider = "testData")
    public static void LoginTest(HashMap<String,String> mapdata ) throws Exception {
        //Login.Login(mapdata);
        LoginPage.LoginPage(mapdata);
        TearDown.Teardown();
    }
}
