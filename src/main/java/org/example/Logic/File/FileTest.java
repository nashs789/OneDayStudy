package org.example.Logic.File;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileTest {

    public static void main(String[] args) throws IOException {

        Path path = Paths.get("src", "fileTest", "data.txt");

        // 파일 글쓰기
        FileWriter fileWriter = null;
        try {
            // 파일 생성
            File file = new File(String.valueOf(path));
            // File file = new File("src/fileTest/data.txt");
            // File file = path.toFile();
            // 존재하지 않을시 파일 생성
            if (!file.exists()) {
                file.createNewFile();
            }

            // data.txt 파일에 글쓰기
            fileWriter = new FileWriter(file);
            // fileWriter = new FileWriter(file, Boolean.TRUE); // 덮어쓰지 않고, 기존 내용에 추가로 사용하려면 파라미터를 하나 더 넘겨야함
            fileWriter.write("Hello, Java!\n");
            fileWriter.write("안녕하세요, 자바!\n");


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            fileWriter.close();
        }


        System.out.println(path.toAbsolutePath());
        System.out.println(path.getParent());
        System.out.println(path.getFileName());

        // 파일 읽기
        BufferedReader bufferedReader = null;
        try {
            // 파일의 내용을 한 줄씩 읽어옴
            //            Stream<String> stream = Files.lines(path, StandardCharsets.UTF_8);
            //            stream.forEach(System.out::println);

            // BufferedReader lines() 메서드 사용
            bufferedReader = new BufferedReader(new FileReader(path.toFile()));
            // 파일의 내용을 한 줄씩 읽어옴
            // while 문 사용
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            bufferedReader.close();
        }
    }
}