package com.project.study.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class DClient {

    private Long id;

    private String name;

    private String username;

    private LocalDate birthDate;

    private String email;

    private String phone;

}
