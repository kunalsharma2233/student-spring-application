package com.student.studentmanagement.student;

import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.ArrayList;
import java.util.function.Predicate;

@Service
public class StudentService {

    private static int count = 1000;
    private static List<Student> studentList = new ArrayList<Student>();

    static {
        studentList.add(new Student(++count, "student1","Ramesh Jha", "Tenth"));
        studentList.add(new Student(++count, "student1","Aman Saxena", "Eigth"));
        studentList.add(new Student(++count,"student1","Anshul Ranjha", "Tenth"));
    }

    public List<Student> findByUserName(String userName) {
        Predicate<? super Student> student = student1 -> student1.getUsername()
                .equalsIgnoreCase(userName);
        return studentList.stream().filter(student).toList();
    }

    public void addStudent(String userName, String studentName, String standard) {
        Student student = new Student(++count, userName, studentName, standard);
        studentList.add(student);
    }

    public void deleteById(int id) {
        Predicate<? super Student> predicate = student -> student.getId() == id;
        studentList.removeIf(predicate);
    }

    public Student findById(int id) {
        Predicate<? super Student> predicate = student -> student.getId() == id;
        Student student = studentList.stream().filter(predicate).findFirst().get();
        return  student;
    }

    public void updateStudent(@Valid Student student) {
        deleteById(student.getId());
        studentList.add(student);
    }
}
