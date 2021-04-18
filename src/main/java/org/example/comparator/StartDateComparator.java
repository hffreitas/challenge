package org.example.comparator;

import org.example.entity.Employee;

import java.util.Comparator;

public class StartDateComparator implements Comparator<Employee> {

    public final static String comparatorField = "StartDate";

    @Override
    public int compare(Employee o1, Employee o2) {
        return o1.getStartDate().compareTo(o2.getStartDate());
    }
}
