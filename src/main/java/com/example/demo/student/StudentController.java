package com.example.demo.student;

// This class will have all of the resources for our API
// API layer of application

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // this annotation allows this class to serve RESTful endpoints
@RequestMapping(path = "api/v1/student") // Instead of going to Localhost 8080, we want localhost8080/api/v1/student
public class StudentController {

    private final StudentService studentService;

    @Autowired // we are saying that ^ studentService should be autowired for us so we don't have to create a new instance
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping // endpoint
    public List<Student> getStudents() {
        return studentService.getStudents();
    }

    @PostMapping
    public void registerNewStudent(@RequestBody Student student) { // from the RequestBody we map it into a student
        studentService.addNewStudent(student);
    }

    @DeleteMapping(path = "{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long studentId) {
        studentService.deleteStudent(studentId);
    }

    @PutMapping(path = "{studentId}")
    public void updateStudent(
            @PathVariable("studentId") Long studentId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email) {
        studentService.updateStudent(studentId, name, email);
    }
    )
}
