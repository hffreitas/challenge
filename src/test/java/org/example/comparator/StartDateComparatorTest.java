package org.example.comparator;

import org.example.entity.Employee;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.*;

class StartDateComparatorTest {

    @Test
    void compareEqualObjects() {
        //given
        Employee employee1 = Employee.builder()
                .startDate(LocalDate.parse("20210419", DateTimeFormatter.ofPattern("yyyyMMdd"))).build();

        Employee employee2 = Employee.builder()
                .startDate(LocalDate.parse("20210419", DateTimeFormatter.ofPattern("yyyyMMdd"))).build();

        //when
        int res = employee1.getStartDate().compareTo(employee2.getStartDate());

        //then
        assert res == 0;
    }

    @Test
    void compareEqualEmployee1LowerThanEmployee2() {
        //given
        Employee employee1 = Employee.builder()
                .startDate(LocalDate.parse("20200419", DateTimeFormatter.ofPattern("yyyyMMdd"))).build();

        Employee employee2 = Employee.builder()
                .startDate(LocalDate.parse("20210419", DateTimeFormatter.ofPattern("yyyyMMdd"))).build();

        //when
        int res = employee1.getStartDate().compareTo(employee2.getStartDate());

        //then
        assert res < 0;
    }

    @Test
    void compareEqualEmployee2LowerThanEmployee1() {
        //given
        Employee employee1 = Employee.builder()
                .startDate(LocalDate.parse("20220419", DateTimeFormatter.ofPattern("yyyyMMdd"))).build();

        Employee employee2 = Employee.builder()
                .startDate(LocalDate.parse("20210419", DateTimeFormatter.ofPattern("yyyyMMdd"))).build();

        //when
        int res = employee1.getStartDate().compareTo(employee2.getStartDate());

        //then
        assert res > 0;
    }
}