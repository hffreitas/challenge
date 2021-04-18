package org.example.converter;

import org.example.entity.Employee;
import org.junit.jupiter.api.Test;

import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.*;

class CsvConverterTest {

    CsvConverter converter = new CsvConverter();
    @Test
    void convertTo() {
        //given
        String line = "Jon,Abner,20041208,1 Jay St,Apt 498,Dublin,CA,,49567";

        //when
        Employee employee = converter.convertTo(line);

        //then
        assertEquals("Jon", employee.getFirstName());
        assertEquals("Abner", employee.getLastName());
        assertEquals("20041208", employee.getStartDate().format(DateTimeFormatter.ofPattern("yyyyMMdd")));
        assertEquals("1 Jay St", employee.getAddress1());
        assertEquals("Apt 498", employee.getAddress2());
        assertEquals("Dublin", employee.getCity());
        assertEquals("CA", employee.getState());
        assertEquals("", employee.getCountry());
        assertEquals(49567, employee.getZip());
    }
}