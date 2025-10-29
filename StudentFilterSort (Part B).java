import java.util.ArrayList;
import java.util.List;

class Student {
    String name;
    double marks;

    public Student(String name, double marks) {
        this.name = name;
        this.marks = marks;
    }
}

public class partB {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("John", 80));
        students.add(new Student("Alice", 70));
        students.add(new Student("Bob", 90));
        students.add(new Student("Eve", 76));

        System.out.println("Students scoring > 75%, sorted by marks:");
        students.stream()
                .filter(s -> s.marks > 75)
                .sorted((s1, s2) -> Double.compare(s1.marks, s2.marks))
                .map(s -> s.name)
                .forEach(System.out::println);
    }
}

