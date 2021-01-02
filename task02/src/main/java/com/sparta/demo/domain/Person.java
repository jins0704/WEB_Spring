package com.sparta.demo.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor

public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String gender;

    @Column(nullable = false)
    private int age;

    public Person(PersonRequestDto requestDto){
        this.name = requestDto.getName();
        this.age = requestDto.getAge();
        this.gender = requestDto.getGender();
    }

    public Person(String name, String gender, int age){
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    public void update(PersonRequestDto requestDto) {
        this.name = requestDto.getName();
        this.age = requestDto.getAge();
        this.gender = requestDto.getGender();
    }
}
