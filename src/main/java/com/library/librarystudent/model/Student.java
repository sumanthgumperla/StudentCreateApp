package com.library.librarystudent.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name ="student-bucket")
public class Student {
    @Id
    Integer studentId;
    String studentName;
    String branch;
    String yearOfAdmission;
    String phone;
    String email;
    String password;
}
