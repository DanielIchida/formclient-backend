package com.prueba.alianza.infraestructure.restful.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class ListClientDTO {
    private String sharedKey;
    private String businessId;
    private String email;
    private String phone;
    private LocalDate dateAdd;
}
