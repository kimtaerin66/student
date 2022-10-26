package com.java.student.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    public static int stuId = 1;
    private int id;
    private String name;
    private int korean;
    private int math;
    private int english;
    private int history;
    private int avg;
    private int sum;

    public Student(int id, String name, int math, int korean, int english, int history, int avg) {
        this.id = id;
        this.name = name;
        this.math = math;
        this.korean = korean;
        this.english = english;
        this.history = history;
        this.avg = avg;
        this.sum =  math + korean + english + history;
    }

}
