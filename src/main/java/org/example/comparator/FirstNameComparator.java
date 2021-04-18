package org.example.comparator;

import org.example.entity.Employee;

import java.util.Comparator;

public class FirstNameComparator implements Comparator<Employee> {

    public final static String comparatorField = "FirstName";

    @Override
    public int compare(Employee o1, Employee o2) {
        return o2.getFirstName().compareTo(o1.getFirstName());
    }
}
