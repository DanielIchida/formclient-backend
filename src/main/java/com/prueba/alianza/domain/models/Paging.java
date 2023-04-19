package com.prueba.alianza.domain.models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Paging<T> {
    private int number;
    private long totalElements;
    private int totalPages;
    private List<T> result;
}
