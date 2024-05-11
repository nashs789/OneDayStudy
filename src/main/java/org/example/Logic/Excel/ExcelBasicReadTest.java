package org.example.Logic.Excel;

import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ExcelBasicReadTest {

    public void readExcel(String fileName) throws IOException {
        FileInputStream file = null;

        try {
            file = new FileInputStream(new File(fileName));
            Workbook workbook = WorkbookFactory.create(file);
            Sheet sheet = workbook.getSheetAt(0);
            for (Row row : sheet) {
                for (Cell cell : row) {
                    System.out.print(cell.toString() + " ");
                }
                System.out.println();
            }
            System.out.println();
            System.out.println("엑셀에서 데이터 읽어오기 성공!");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            file.close();
        }
    }
}