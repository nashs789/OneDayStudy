package org.example.Dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MemberDto {

    private String name;
    private int age;
    private String birthdate;
    private String phone;
    private String address;
    private boolean isMarried;
}
