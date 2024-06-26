package com.library.librarystudent.service;

import com.library.librarystudent.exception.StudentDataNotFoundException;
import com.library.librarystudent.model.KafkaStudent;
import com.library.librarystudent.model.Student;
import com.library.librarystudent.model.StudentOutPut;
import com.library.librarystudent.repository.CreateStudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    @Autowired
    CreateStudentDao dao;

    public void insertStudent(KafkaStudent kafkaStudent) {

        Student student=Student.builder().studentId(kafkaStudent.getId())
                        .studentName(kafkaStudent.getName())
                         .email(kafkaStudent.getName()+"@gmail.com")
                         .phone("7799036906")
                          .branch(kafkaStudent.getBranch())
                          .password(kafkaStudent.getName()+kafkaStudent.getId())
                           .yearOfAdmission(kafkaStudent.getYearOfAdmission())
                           .build();

        System.out.println(student.toString());
     dao.save(student);
    }


    public StudentOutPut getStudentDetails(Integer Id){
        Long ID=Long.valueOf(Id);

            Student stdtemp = dao.findById(ID).orElse(null);
            if(stdtemp!=null) {
                StudentOutPut result = StudentOutPut.builder().Id(stdtemp.getStudentId())
                        .name(stdtemp.getStudentName()).branch(stdtemp.getBranch()).email(stdtemp.getEmail()).build();
                return result;
            }else{
                throw new StudentDataNotFoundException("no data found in db for studentId"+Id);
            }




}



}
