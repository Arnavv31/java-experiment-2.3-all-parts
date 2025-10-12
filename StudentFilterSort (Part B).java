import java.util.*;
import java.util.stream.*;

class Student {
    private String name;
    private double marks;

    public Student(String name, double marks) {
        this.name = name;
        this.marks = marks;
    }

    public String getName() { return name; }
    public double getMarks() { return marks; }

    @Override
    public String toString() {
        return String.format("Name: %-10s Marks: %.2f", name, marks);
    }
}

public class StudentFilterSort {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
            new Student("Ravi", 82.5),
            new Student("Priya", 65.0),
            new Student("Aman", 91.0),
            new Student("Sneha", 74.0),
            new Student("Karan", 88.5)
        );

        System.out.println("All Students:");
        students.forEach(System.out::println);

        System.out.println("\nStudents scoring above 75% (Sorted by Marks):");

        students.stream()
                .filter(s -> s.getMarks() > 75)
                .sorted(Comparator.comparingDouble(Student::getMarks))
                .map(Student::getName)
                .forEach(System.out::println);
    }
}
