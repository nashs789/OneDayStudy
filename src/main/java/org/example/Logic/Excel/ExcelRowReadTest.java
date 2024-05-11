package org.example.Logic.Excel;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.example.Dto.MemberDto;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExcelRowReadTest {

    public static void main(String[] args) {

        List<MemberDto> members = new ArrayList<>();

        try {
            FileInputStream file = new FileInputStream(new File("members.xlsx"));
            // workbook = 엑셀파일 생성
            Workbook workbook = WorkbookFactory.create(file);
            Sheet sheet = workbook.getSheetAt(0);
            for (Row row : sheet) {
                // 맨 처음 row는 건너뛴다
                if (row.getRowNum() == 0) {
                    continue;
                }
                MemberDto member = new MemberDto();

                member.setName(row.getCell(0).getStringCellValue());
                member.setAge((int) row.getCell(1).getNumericCellValue());
                member.setBirthdate(row.getCell(2).getStringCellValue());
                member.setPhone(row.getCell(3).getStringCellValue());
                member.setAddress(row.getCell(4).getStringCellValue());
                member.setMarried(row.getCell(5).getBooleanCellValue());

                members.add(member);
            }
            file.close();
            System.out.println("엑셀에서 데이터 읽어오기 성공");
        } catch (IOException e) {
            e.printStackTrace();
        }

        members.forEach(System.out::println);
    }
}
