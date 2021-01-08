package com.sparta.task01.Controller;

import com.sparta.task01.Person;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {
    @GetMapping("/myinfo")

    public Person getPerson(){
        Person person = new Person();
        person.setAge(25);
        person.setGender("남자");
        person.setJob("학생");
        person.setName("홍진석");

        return person;
    }
}

