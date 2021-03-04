package com.project.study.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDate;

@Data
public class DClient {

    @Schema(description = "Unique ID.", example = "1",type = "number")
    private Long id;

    @Schema(description = "Client name.", example = "Max Rockatansky",type = "string", maxLength = 255)
    private String name;

    @Schema(description = "Client username.", example = "madmax",type = "string", maxLength = 100)
    private String username;

    @Schema(description = "Birth date.", example = "1995-10-12T12:59:11.332",type = "date")
    private LocalDate birthDate;

    @Schema(description = "Client email.", example = "madmax@email.com",type = "string", maxLength = 155)
    private String email;

    @Schema(description = "Client phone number.", example = "31999995555",type = "string", maxLength = 20)
    private String phone;

}
