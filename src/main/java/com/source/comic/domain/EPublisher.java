package com.source.comic.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Blob;
import java.time.LocalDate;

@Entity
@Table(name = "TB_PUBLISHING")
@Data
public class EPublisher {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_PUBLISHER")
    @SequenceGenerator(name = "SEQ_PUBLISHER", sequenceName = "SEQ_PUBLISHER", allocationSize = 1)
    @Column(name ="ID")
    private Long id;

    @NotNull(message = "The parameter name cannot be null.")
    @Size(max = 255, message = "The name parameter cannot be greater than 255.")
    @Column(name ="NAME")
    private String name;

    @NotNull(message = "The parameter website cannot be null.")
    @Size(max = 255, message = "The website parameter cannot be greater than 255.")
    @Column(name ="WEBSITE")
    private String website;

    @NotNull(message = "The parameter birth date cannot be null.")
    @Column(name ="BIRTH_DATE")
    private LocalDate birthDate;

    @Lob
    @NotNull(message = "The parameter logo cannot be null.")
    @Column(name ="LOGO")
    private Blob logo;

    @NotNull(message = "The parameter phone cannot be null.")
    @Size(max = 4000, message = "The description parameter cannot be greater than 4000.")
    @Column(name ="DESCRIPTION")
    private String description;

}
