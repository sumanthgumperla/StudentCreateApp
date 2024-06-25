package com.library.librarystudent.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class KafkaStudent {

    Integer id;
    String name;
    String branch;
    String dateOfJoining;
    String yearOfAdmission;
    String gender;
    Integer age;
}
