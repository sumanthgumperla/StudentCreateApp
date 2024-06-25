package com.library.librarystudent.repository;

import com.library.librarystudent.model.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreateStudentDao extends CrudRepository<Student, Long> {
}
