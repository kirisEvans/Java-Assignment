package assignment4;

public class Group {
    private Student student1;
    private Student student2;
    private char lab;

    public Group(Student student1, Student student2, char lab) {
        this.student1 = student1;
        this.student2 = student2;
        this.lab = lab;
    }

    public Group(Student student1, char lab) {
        this.student1 = student1;
        this.lab = lab;
    }

    public Student getStudent1() {
        return student1;
    }

    private void setStudent1(Student student1) {
        this.student1 = student1;
    }

    public Student getStudent2() {
        return student2;
    }

    public void setStudent2(Student student2) {
        this.student2 = student2;
    }

    public char getLab() {
        return lab;
    }

    public void setLab(char lab) {
        this.lab = lab;
    }

    public boolean checkSameLab() {
        if (student1 != null & student2 != null) {
            return student1.getLab() == lab & student1.getLab() == lab;
        }
        return false;
    }

    public String toString() {
        if (student2 != null) {
            int result = student1.getStudentNumber().compareTo(student2.getStudentNumber());
            if (result <= 0) {
                return lab + "_" + student1.getStudentNumber() + "_" + student2.getStudentNumber();
            }
            else {
                return lab + "_" + student2.getStudentNumber() + "_" + student1.getStudentNumber();
            }

        }
        else {
            return lab + "_" + student1.getStudentNumber() + "_" + null;
        }

    }

}
