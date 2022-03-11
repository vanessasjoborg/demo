package com.example.demo.student;

// Data access layer
// Repository is the naming convention for anything that accesses your database

import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{

    // SELECT * FROM student WHERE email = ?
    // OR we use a custom query (Bear in mind this is not SQL it is JBQL
    @Query("SELECT s FROM Student s WHERE s.email = ?1")
    Optional<Student> findStudentByEmail(String email);
}
