package com.kunal.oas_email.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {


    @Id
    private String id;

    @NotBlank
    @Size(min = 7, max = 7)
    @Column(unique = true)
    private String userId;

    @NotBlank
    @Size(min = 3, max = 20)
    private String username;

    @NotBlank
    @Size(min = 8, max = 30)
    private String password;

    private boolean isDeleted;


}
