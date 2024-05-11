package org.example;

import org.example.Entity.Person;
import org.example.Enum.Married;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("Alice", 25, Married.Y, LocalDateTime.of(2021, 1, 1, 0, 0, 0)));
        personList.add(new Person("Bob", 30, Married.N, LocalDateTime.now()));
        personList.add(new Person("Charlie", 35, Married.Y, LocalDateTime.now()));

        System.out.println("1) 사람이름에서 A로 시작하는 사람 출력");
        personList.stream()
                  .filter(e -> e.getName().startsWith("A"))
                  .forEach(System.out::println);

        System.out.println("2) 30세 이상인 사람들 출력");
        personList.stream()
                  .filter(e -> e.getAge() >= 30)
                  .forEach(System.out::println);

        System.out.println("3) 연령순, 반대순으로 정렬해주시오");
        personList.stream()
                  .map(Person::getAge)
                  .sorted(Comparator.reverseOrder())
                  .forEach(System.out::println);

        System.out.println("4) 사람들의 평균 연령은?");
        System.out.println(personList.stream()
                                     .map(Person::getAge)
                                     .mapToInt(Integer::intValue)
                                     .average()
                                     .orElseGet(() -> 0)
        );

        System.out.println("5) 사람들 중 결혼한 사람들은?");
        personList.stream()
                  .filter(e -> e.getMarried().equals(Married.Y))
                  .forEach(System.out::println);

        System.out.println("6) 결혼 여부 기준으로 사람들을 그룹화하여 출력해주세요 (Map 사용)");
        System.out.println(personList.stream()
                                     .collect(Collectors.groupingBy(Person::getMarried)));

        System.out.println("7) 사람들의 이름을 “,”으로 조합해서 하나의 문자열로 만들어주세요");
        System.out.println(personList.stream()
                                     .map(Person::getName)
                                     .collect(Collectors.joining(",")));
    }
}