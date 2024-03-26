package com.studentform.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.studentform.Entity.Student;

public interface StudentRepository extends JpaRepository<Student,Long>{

	@Query("SELECT s FROM Student s WHERE s.username = :username")
    Student findByUsername(@Param("username") String username);

}
