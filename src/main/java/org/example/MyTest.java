package org.example;

import org.example.Logic.Excel.ExcelWriter;

import java.io.IOException;

public class MyTest {
    public static void main(String[] args) throws IOException {
        ExcelWriter ew = new ExcelWriter(new String[] {"이름", "나이", "생년월일", "전화번호", "주소", "결혼여부"});

        ew.createExcel("members.xlsx", "회원정보");
    }
}
