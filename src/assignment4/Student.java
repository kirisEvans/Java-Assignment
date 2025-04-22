package assignment4;

import java.util.ArrayList;

public class Student extends ArrayList<Student> {
    private String studentNumber;
    private char lab;
    private int grade;

    public Student(String studentNumber, char lab, int grade) {
        this.studentNumber = studentNumber;
        this.lab = lab;
        this.grade = grade;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public char getLab() {
        return lab;
    }

    public void setLab(char lab) {
        this.lab = lab;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String toString() {
        return studentNumber + " " + lab + " " + grade;
    }
}

