package ru.job4j.streams;


import java.util.Objects;

public class Student implements Comparable<Student> {

    private int score;
    private String name;

    public Student() {

    }

    public Student(int score, String name) {
        if (score > 100) {
            score = 100;
        }
        if (score < 0) {
            score = 0;
        }
        this.score = score;
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "score=" + score +
                ", name='" + name + '\'' +
                '}';
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return score == student.score &&
                Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(score, name);
    }

    @Override
    public int compareTo(Student o) {
        return o.getScore() - getScore();
    }
}
