package org.example.Logic;

import org.example.Entity.Person;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class IteratorTest {
    public static void main(String[] args) {

        // 1. 배열을 이용한 Iterator 패턴
        List<Person> personList = new ArrayList<>();
        //        personList.add(new Person("Alice", 25));
        //        personList.add(new Person("Bob", 30));
        //        personList.add(new Person("Charlie", 35));

        Scanner scanner = new Scanner(System.in);

        try{

            while (true) {
                Person person = new Person();

                System.out.print("이름을 입력하세요:");
                String name = scanner.nextLine();
                if (name.equals("quit")) {
                    //System.exit(-1);
                    break;
                }
                person.setName(name);

                System.out.print("나이를 입력하세요:");
                person.setAge(scanner.nextInt());
                person.setBirthDateTime(LocalDateTime.now());

                personList.add(person);

            }
        } catch (Exception err) {
            err.printStackTrace();
        } finally {
            scanner.close();
        }

        // iterator를 이용한 출력
        Iterator<Person> personIterator = personList.iterator();
        while (personIterator.hasNext()) {
            Person person = personIterator.next();
            System.out.println(person);
        }
    }
}