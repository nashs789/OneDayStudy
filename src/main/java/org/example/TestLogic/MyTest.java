package org.example.TestLogic;

import java.io.IOException;

public class MyTest {
    public static void main(String[] args) throws IOException {
        ExcelWriter ew = new ExcelWriter();

        ew.createExcel("회원정보");
    }
}
