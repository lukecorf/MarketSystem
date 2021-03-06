package com.source.comic.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Lob;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Blob;
import java.time.LocalDate;

@Data
public class DPublisher {

    @Schema(description = "Unique ID.", example = "1",type = "number")
    private Long id;

    @Schema(description = "Publisher name.", example = "DC Comics",type = "string")
    private String name;

    @Schema(description = "Publisher website.", example = "www.dccomics.com",type = "string")
    private String website;

    @Schema(description = "Publisher foundation date.", example = "01/01/1001",type = "date")
    private LocalDate birthDate;

    @Schema(description = "Publisher logo.",type = "blob")
    private Blob logo;

    @Schema(description = "Publisher description.", example = "DC Comics is a publisher created by...",type = "string")
    private String description;
}
