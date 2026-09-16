package com.placement.placement_management_system.controller;

import com.placement.placement_management_system.model.Student;
import com.placement.placement_management_system.repository.StudentRepository;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    // Get all students
    @GetMapping
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    // Get student by ID
    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Long id) {
        return studentRepository.findById(id).orElseThrow();
    }

    // Add student
    @PostMapping
    public Student addStudent(@RequestBody Student student) {
        return studentRepository.save(student);
    }

    // Update student
    @PutMapping("/{id}")
    public Student updateStudent(
            @PathVariable Long id,
            @RequestBody Student student) {

        Student existingStudent =
                studentRepository.findById(id).orElseThrow();

        existingStudent.setName(student.getName());
        existingStudent.setEmail(student.getEmail());
        existingStudent.setPhone(student.getPhone());
        existingStudent.setCourse(student.getCourse());
        existingStudent.setSkills(student.getSkills());

        return studentRepository.save(existingStudent);
    }

    // Delete student
    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable Long id) {

        studentRepository.deleteById(id);

        return "Student deleted successfully!";
    }
}