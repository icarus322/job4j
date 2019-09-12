package ru.job4j.streams;

import java.util.Objects;

public class Student {

    private int score;

    public Student(int score) {
        if (score > 100) {
            score = 100;
        }
        if (score < 0) {
            score = 0;
        }
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "score=" + score +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return score == student.score;
    }

    @Override
    public int hashCode() {
        return Objects.hash(score);
    }
}
