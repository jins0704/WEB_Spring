package com.sparta.week01.prac;

import java.util.ArrayList;
import java.util.List;

public class Prac {
    public static void main(String[] args) {
        Course course = new Course();
        course.setTitle("a");
        course.setTutor("b");
        course.setDays(14);

        System.out.println(course.getTutor());
        Course course2 = new Course("h", "a", 12);
    }
}

