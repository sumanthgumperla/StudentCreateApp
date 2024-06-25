package com.library.librarystudent.model;

import lombok.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StudentOutPut {
    Integer Id;
    String name;
    String email;
    String branch;

}
