package com.sparta.demo.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor

public class PersonRequestDto {
    private final String name;
    private final String gender;
    private final int age;
}
