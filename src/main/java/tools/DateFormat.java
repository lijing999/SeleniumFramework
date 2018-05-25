package tools;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by lijing on 2018/5/24.
 */
public class DateFormat {
    public static final String CHECK_LOG_FORMAT="yyyyMMdd";
    public static final String DATE_FORMAT="yyyy-MM-dd HH-mm-ss";

    private static SimpleDateFormat simpleDateFormat;
    public static String format(String type){
        simpleDateFormat=new SimpleDateFormat(type);
        return simpleDateFormat.format(new Date()); //Date()函数返回当前日期
    }
}
