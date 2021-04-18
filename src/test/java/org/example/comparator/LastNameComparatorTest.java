package org.example.comparator;

import org.example.entity.Employee;
import org.junit.jupiter.api.Test;

class LastNameComparatorTest {

    @Test
    void compareEqualObjects() {
        //given
        Employee employee1 = Employee.builder().lastName("LastName").build();
        Employee employee2 = Employee.builder().lastName("LastName").build();

        //when
        int res = employee1.getLastName().compareTo(employee2.getLastName());

        //then
        assert res == 0;
    }

    @Test
    void compareEqualEmployee1LowerThanEmployee2() {
        //given
        Employee employee1 = Employee.builder().lastName("ALastName").build();
        Employee employee2 = Employee.builder().lastName("BLastName").build();

        //when
        int res = employee1.getLastName().compareTo(employee2.getLastName());

        //then
        assert res < 0;
    }

    @Test
    void compareEqualEmployee2LowerThanEmployee1() {
        //given
        Employee employee1 = Employee.builder().lastName("BLastName").build();
        Employee employee2 = Employee.builder().lastName("ALastName").build();

        //when
        int res = employee1.getLastName().compareTo(employee2.getLastName());

        //then
        assert res > 0;
    }
}