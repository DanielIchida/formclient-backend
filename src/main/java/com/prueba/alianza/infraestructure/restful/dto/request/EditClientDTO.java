package com.prueba.alianza.infraestructure.restful.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class EditClientDTO {

    @NotNull
    @NotBlank
    private String name;

    private String phone;

    @NotNull
    @NotBlank
    @Email
    private String email;

    private String startDate;

    private String endDate;
}
