package org.example;

import org.example.Logic.Excel.ExcelWriter;

import java.io.IOException;

public class MyTest {
    public static void main(String[] args) throws IOException {
        ExcelWriter ew = new ExcelWriter();

        ew.createExcel("members.xlsx", "회원정보");
    }
}