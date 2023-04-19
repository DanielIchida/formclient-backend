package com.prueba.alianza.domain.services;

import io.micrometer.common.util.StringUtils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ClientService {

    public static String getSharedKey(String email) {
        String[] splitEmail = email.split("@");
        return splitEmail[0];
    }

    public static LocalDate localDateFormat(String date) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return !StringUtils.isBlank(date) ? LocalDate.parse(date,dateTimeFormatter) : null;
    }

}
