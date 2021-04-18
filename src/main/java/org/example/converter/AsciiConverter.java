package org.example.converter;

import org.example.entity.Employee;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AsciiConverter implements EmployeeConverter{

    public static final String type = "1";

    private static final String REGEXP = "^([a-zA-Z ]{10})([a-zA-Z ]{17})([0-9]{8})([a-zA-Z 0-9]{10})([a-zA-Z 0-9]{10})([a-zA-Z 0-9]{10})([a-zA-Z ]{2})([a-zA-Z 0-9]{3})([0-9 ]{10})$";

    @Override
    public Employee convertTo(String line) {
        Matcher m = Pattern.compile(REGEXP).matcher(line);
        if (m.find())
            return Employee.builder()
                    .firstName(m.group(1).trim())
                    .lastName(m.group(2).trim())
                    .startDate(LocalDate.parse(m.group(3).trim(),  DateTimeFormatter.ofPattern("yyyyMMdd")))
                    .address1(m.group(4).trim())
                    .address2(m.group(5).trim())
                    .city(m.group(6).trim())
                    .state(m.group(7).trim())
                    .country(m.group(8).trim())
                    .zip(Integer.parseInt(m.group(9).trim()))
                    .build();

        throw new RuntimeException("Line does not match pattern");
    }
}
