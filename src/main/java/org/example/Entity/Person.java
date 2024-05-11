package org.example.Entity;

import lombok.*;
import org.example.Enum.Married;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Person {

    private String name;
    private int age;
    private Married married = Married.N;  // enum 타입
    private LocalDateTime birthDateTime;  // 자바 8 Date 타입

    //    생성자 -> 빌더방식 쓰면 편해짐... 향후에 적용해보세요!
    public Person(String name,  int age, LocalDateTime birthDateTime) {
        this.name = name;
        this.age = age;
        this.birthDateTime = birthDateTime;
    }

    // LocalDateTime을 DateTimeFormatter 이용해서 String으로 포멧
    // 포멧 방법은?
    public String getBirthDateTime() {
        return DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(birthDateTime);
    }

}
