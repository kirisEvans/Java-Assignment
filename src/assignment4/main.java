package assignment4;

public class main {
    public static void main(String[] args) {
        Student s1 = new Student("12410100", 'A', 90);
        Student s2 = new Student("12410101", 'A', 84);
        Student s3 = new Student("12410102", 'B', 90);
        Student s4 = new Student("12410103", 'B', 84);
        Group g1 = new Group(s1, s2, 'A');
        Group g2 = new Group(s3, s4, 'B');
        Student[] students = {s1, s2, s3, s4};
        Group[] groups = {g1, g2};
        Student[] result = GroupSystem.check(students, groups);

    }
}
