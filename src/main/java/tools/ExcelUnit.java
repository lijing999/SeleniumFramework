package tools;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by lijing on 2018/5/24.
 */
public class ExcelUnit {
    /**
     * 读取某个excel文件数据，并放入Map中返回
     * @return Object
     */
    public static Object[][] testData(String filepath){
        //存储excel第一列每个单元格的值，作为key值
        ArrayList<String> arrayKey=new ArrayList<String>();
        //获取excel文件
        Workbook workbook= ExcelUnit.getWorkbook(filepath);
        Sheet sheet=workbook.getSheetAt(0);
        //获取总行数
        int rowTotalNum=sheet.getLastRowNum()+1;
        //总列数
        int columns = sheet.getRow(0).getPhysicalNumberOfCells();

        HashMap<String,String>[][]map=new HashMap[rowTotalNum-1][1];
        //对所有数组中所有元素hashmap进行初始化
        if (rowTotalNum>1){
            for (int i=0;i<rowTotalNum-1;i++){
                map[i][0]=new HashMap();
            }
        }else {
            //log.error("测试的Excel" + file + "中没有数据");
        }
        //获得首行的列名，作为hashmap的key值
        for (int c=0;c<columns;c++){
            String cellvalue=ExcelUnit.getCellValue(sheet,0,c);
            arrayKey.add(cellvalue);
        }

        //遍历所有的单元格的值，添加到hashmap中!!!
        for(int r=1;r<rowTotalNum;r++){
            for (int c=0;c<columns;c++){
                String cellvalue=ExcelUnit.getCellValue(sheet,r,c);
                map[r-1][0].put(arrayKey.get(c),cellvalue);
            }
        }
        return map;
    }


    public static Workbook getWorkbook(String filepath) {
        Workbook wb = null;
        try {
            if (filepath.endsWith(".xls")) {
                File file = new File(filepath);
                FileInputStream is = new FileInputStream(file);
                wb = new HSSFWorkbook(is);
            } else if (filepath.endsWith(".xlsx")) {
                wb = new XSSFWorkbook(filepath);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return wb;
    }

    /**
     * 封装getCellValue()方法
     * 通过sheet行号和列返回值
     * @param sheet sheetname
     * @param rowNum 行号
     * @param cellNum 列号
     * @return
     */
    public static String getCellValue(Sheet sheet, int rowNum, int cellNum) {
        Cell cell = sheet.getRow(rowNum).getCell(cellNum);
        String value = ExcelUnit.getCellValue(cell);
        return value;
    }

    /**
     * 把不同类型的单元格转换为字符串，并返回
     * @param  cell cell
     * @return 当个单元格的值
     */
    public static String getCellValue(Cell cell){
        String value="";
        switch (cell.getCellTypeEnum()){
            case STRING:
                value=String.valueOf(cell.getRichStringCellValue());
                return value;
            case NUMERIC:
                value=String.valueOf(cell.getNumericCellValue());

            case BOOLEAN:
                value = String.valueOf(cell.getBooleanCellValue());
                return value;

            case FORMULA:
                value = String.valueOf(cell.getCellFormula());
                return value;

            case ERROR:
                value = String.valueOf(cell.getErrorCellValue());
                return value;
            case BLANK:
                return value;
            default:
                return value;
        }
    }





}
