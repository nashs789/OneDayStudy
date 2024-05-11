package org.example.Logic.Excel;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.example.Dto.MemberVO;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ExcelWriter {

    private final int HEADER_ROW = 0;
    private final String[] headerNames = {"이름", "나이", "생년월일", "전화번호", "주소", "결혼여부"};

    public void createExcel(String fileName, String sheetName) throws IOException {
        List<MemberVO> members = inputMemberInfo();
        XSSFWorkbook workbook = new XSSFWorkbook();

        try {
            Sheet sheet = workbook.createSheet(sheetName);

            // 헤더 생성
            Row headerRow = sheet.createRow(HEADER_ROW);

            for(int i = 0; i < headerNames.length; i++) {
                headerRow.createCell(i).setCellValue(headerNames[i]);
            }

            // 데이터 생성
            for (int i = 0; i < members.size(); i++) {
                MemberVO member = members.get(i);
                Row row = sheet.createRow(i + 1);

                row.createCell(0).setCellValue(member.getName());
                row.createCell(1).setCellValue(member.getAge());
                row.createCell(2).setCellValue(member.getBirthdate());
                row.createCell(3).setCellValue(member.getPhone());
                row.createCell(4).setCellValue(member.getAddress());
                row.createCell(5).setCellValue(member.isMarried());
            }
            // 엑셀 파일 저장
            FileOutputStream outputStream = new FileOutputStream(new File(fileName));
            workbook.write(outputStream);
            System.out.println("엑셀 파일이 저장되었습니다: " + fileName);

            ExcelBasicReadTest execlRead = new ExcelBasicReadTest();

            execlRead.readExcel(fileName);

        } catch (IOException e) {
            System.out.println("엑셀 파일 저장 중 오류가 발생했습니다.");
            e.printStackTrace();
        } finally {
            workbook.close();
        }
    }

    public List<MemberVO> inputMemberInfo() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<MemberVO> members = new ArrayList<>();

        try {
            while (true) {
                System.out.println("Press 'q' button for Exit");
                if ("q".equals(br.readLine().strip().toLowerCase())) {
                    break;
                }

                MemberVO mem = new MemberVO();

                System.out.print("이름을 입력하세요:");
                mem.setName(br.readLine());

                System.out.print("나이를 입력하세요:");
                mem.setAge(Integer.parseInt(br.readLine()));

                System.out.print("생년월일을 입력하세요:");
                mem.setBirthdate(br.readLine());

                System.out.print("전화번호를 입력하세요:");
                mem.setPhone(br.readLine());

                System.out.print("주소를 입력하세요:");
                mem.setAddress(br.readLine());

                System.out.print("결혼여부를 입력하세요 (Y/N):");
                mem.setMarried("Y".equals(br.readLine().toUpperCase()) ? true : false);

                members.add(mem);
            }
        } catch (Exception err) {
            err.printStackTrace();
        } finally {
            br.close();
        }

        return members;
    }
}
