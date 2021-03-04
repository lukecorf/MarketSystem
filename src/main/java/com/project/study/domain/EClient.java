package com.project.study.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
@Table(name = "GERENCIAMENTO_SOLICITACAO")
@Data
public class EClient {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_CLIENT_USER")
    @SequenceGenerator(name = "SEQ_CLIENT_USER", sequenceName = "SEQ_CLIENT_USER", allocationSize = 1)
    @Column(name ="ID")
    private Long id;

    @NotNull(message = "The parameter name cannot be null.")
    @Size(max = 255, message = "The name parameter cannot be greater than 255.")
    @Column(name ="NAME")
    private String name;

    @NotNull(message = "The parameter username cannot be null.")
    @Size(max = 100, message = "The username parameter cannot be greater than 100.")
    @Column(name ="USERNAME")
    private String username;

    @NotNull(message = "The parameter birth date cannot be null.")
    @Column(name ="BIRTH_DATE")
    private LocalDate birthDate;

    @NotNull(message = "The parameter email cannot be null.")
    @Size(max = 155, message = "The email parameter cannot be greater than 100.")
    @Column(name ="EMAIL")
    private String email;

    @NotNull(message = "The parameter phone cannot be null.")
    @Size(max = 20, message = "The phone parameter cannot be greater than 20.")
    @Column(name ="PHONE")
    private String phone;

}
