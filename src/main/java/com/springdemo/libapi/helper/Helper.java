package com.springdemo.libapi.helper;

import com.springdemo.libapi.entity.Customer;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Helper {

    public static Boolean checkIsExcel(MultipartFile file){

        String contentType = file.getContentType();

        if(contentType.equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"))
            return true;
        else
            return false;
    }
    public static List<Customer> convertExcelToList(InputStream is){
        List<Customer> sheetTolist  = new ArrayList<>();
        try{
            XSSFWorkbook workbook = new XSSFWorkbook(is);
            XSSFSheet sheet = workbook.getSheet("sheet1");
            int rowNumber = 0;
            Iterator<Row> iterator = sheet.iterator();
            while(iterator.hasNext()){
                Row row = iterator.next();
                if(rowNumber == 0){
                    rowNumber++;
                    continue;
                }

                    Iterator<Cell> cells = row.iterator();
                    int cid = 0;
                    Customer customerFromSheet = new Customer();
                    while(cells.hasNext()){
                        Cell cell = cells.next();
                        switch(cid){
                            case 0 :
                                customerFromSheet.setId((int)cell.getNumericCellValue());
                                break;
                            case 1:
                                customerFromSheet.setEmailid(cell.getStringCellValue());
                                break;
                            case 2:
                                customerFromSheet.setName(cell.getStringCellValue());
                                break;
                            default:
                                break;
                        }
                        cid++;
                    }
                    sheetTolist.add(customerFromSheet);
                }
        }
        catch (Exception e){
            e.printStackTrace();
        }

        return sheetTolist;
    }
}
