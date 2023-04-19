package com.prueba.alianza.infraestructure.restful.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PagingDTO<T> {
    private int number;
    private long totalElements;
    private int totalPages;
    private List<T> result;
}
