package org.example.converter;

import org.example.entity.Employee;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CsvConverter implements EmployeeConverter{

    public static final String type = "2";

    @Override
    public Employee convertTo(String line) {
        String[] lineSplit = line.split(",");

        return Employee.builder()
                .firstName(lineSplit[0].trim())
                .lastName(lineSplit[1].trim())
                .startDate(LocalDate.parse(lineSplit[2].trim(),  DateTimeFormatter.ofPattern("yyyyMMdd")))
                .address1(lineSplit[3].trim())
                .address2(lineSplit[4].trim())
                .city(lineSplit[5].trim())
                .state(lineSplit[6].trim())
                .country(lineSplit[7].trim())
                .zip(Integer.parseInt(lineSplit[8].trim()))
                .build();


    }
}
