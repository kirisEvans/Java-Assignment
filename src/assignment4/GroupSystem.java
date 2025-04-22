package assignment4;
import java.util.ArrayList;
import java.util.Comparator;


public class GroupSystem {
    public static Student[] check(Student[] students, Group[] groups) {
        ArrayList<Student> my_list = new ArrayList<>();
        ArrayList<Student> appear_list = new ArrayList<>();

        for (Group group : groups) {
            if (group.getStudent2() == null) {
                my_list.add(group.getStudent1());
            }
            else {
                if (group.getLab() != group.getStudent1().getLab() || group.getLab() != group.getStudent2().getLab()) {
                    my_list.add(group.getStudent1());
                    my_list.add(group.getStudent2());
                }
            }
        }

        int[] counter = new int[students.length];
        for (Group group : groups) {
            for (int i = 0; i < students.length; i++) {
                if (students[i].getStudentNumber().equals(group.getStudent1().getStudentNumber())) {
                    counter[i] += 1;
                }
                if (group.getStudent2() != null) {
                    if (students[i].getStudentNumber().equals(group.getStudent2().getStudentNumber())) {
                        counter[i] += 1;
                    }
                }
            }
        }

        for (int i = 0; i < counter.length; i++) {
            if (counter[i] > 1) {
                appear_list.add(students[i]);
            }
            if (counter[i] == 0) {
                my_list.add(students[i]);
            }
        }

        for (Group group : groups) {
            for (int i = 0; i < appear_list.size(); i++) {
                if (group.getStudent2() != null) {
                    if (appear_list.get(i).getStudentNumber().equals(group.getStudent1().getStudentNumber()) || appear_list.get(i).getStudentNumber().equals(group.getStudent2().getStudentNumber())) {
                        my_list.add(group.getStudent1());
                        my_list.add(group.getStudent2());
                    }
                }

            }
        }

        int[] counter_again = new int[my_list.size()];
        for (int i = 0; i < my_list.size()-1; i++) {
            for (int j = i+1; j < my_list.size(); j++) {
                if (my_list.get(j).getStudentNumber().equals(my_list.get(i).getStudentNumber())) {
                    counter_again[j] += 1;
                }
            }
        }

        appear_list.clear();
        for (int i = 0; i < counter_again.length; i++) {
            if (counter_again[i] == 0) {
                appear_list.add(my_list.get(i));
            }
        }

        Student[] result = new Student[appear_list.size()];
        for (int i = 0; i < appear_list.size(); i++) {
            result[i] = appear_list.get(i);
        }

        if (result.length == 0) {
            return null;
        }
        else {
            return result;
        }
    }

    public static Group[] group(Student[] students) {
        ArrayList<ArrayList<Student>> my_list = new ArrayList<>();
        my_list.add(new ArrayList<Student>());
        my_list.get(0).add(students[0]);
        for (int i = 1; i < students.length; i++) {
            boolean be_executed = false;
            for (int j = 0; j < my_list.size(); j++) {
                if (students[i].getLab() == my_list.get(j).get(0).getLab()) {
                    my_list.get(j).add(students[i]);
                    be_executed = true;
                    break;
                }
            }
            if (!be_executed) {
                my_list.add(new ArrayList<Student>());
                my_list.get(my_list.size()-1).add(students[i]);
            }
        }

        for (ArrayList<Student> studentArrayList : my_list) {
            studentArrayList.sort(new Comparator<Student>() {
                @Override
                public int compare(Student o1, Student o2) {
                    return Integer.compare(o2.getGrade(), o1.getGrade());
                }
            });
        }

        ArrayList<Group> result = new ArrayList<>();
        for (ArrayList<Student> studentArrayList : my_list) {
            if (studentArrayList.size() % 2 == 0) {
                for (int i = 0; i < studentArrayList.size(); i+=2) {
                    result.add(new Group(studentArrayList.get(i), studentArrayList.get(i+1), studentArrayList.get(i+1).getLab()));
                }
            }
            else {
                if (studentArrayList.size() == 1) {
                    result.add(new Group(studentArrayList.get(0), studentArrayList.get(0).getLab()));
                }
                else {
                    for (int i = 0; i < studentArrayList.size()-1; i+=2) {
                        result.add(new Group(studentArrayList.get(i), studentArrayList.get(i+1), studentArrayList.get(i+1).getLab()));
                    }
                    result.add(new Group(studentArrayList.get(studentArrayList.size()-1), studentArrayList.get(studentArrayList.size()-1).getLab()));
                }
            }
        }
        Group[] result_group = new Group[result.size()];
        for (int i = 0; i < result.size(); i++) {
            result_group[i] = result.get(i);
        }
        return result_group;
    }
}
