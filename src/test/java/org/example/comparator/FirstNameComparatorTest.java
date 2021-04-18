package org.example.comparator;

import org.example.entity.Employee;
import org.junit.jupiter.api.Test;

class FirstNameComparatorTest {

    @Test
    void compareEqualObjects() {
        //given
        Employee employee1 = Employee.builder().firstName("FirstName").build();
        Employee employee2 = Employee.builder().firstName("FirstName").build();

        //when
        int res = employee1.getFirstName().compareTo(employee2.getFirstName());

        //then
        assert res == 0;
    }

    @Test
    void compareEqualEmployee1LowerThanEmployee2() {
        //given
        Employee employee1 = Employee.builder().firstName("AFirstName").build();
        Employee employee2 = Employee.builder().firstName("BFirstName").build();

        //when
        int res = employee1.getFirstName().compareTo(employee2.getFirstName());

        //then
        assert res < 0;
    }

    @Test
    void compareEqualEmployee2LowerThanEmployee1() {
        //given
        Employee employee1 = Employee.builder().firstName("BFirstName").build();
        Employee employee2 = Employee.builder().firstName("AFirstName").build();

        //when
        int res = employee1.getFirstName().compareTo(employee2.getFirstName());

        //then
        assert res > 0;
    }
}
