package org.example.comparator;

import lombok.extern.java.Log;
import org.example.entity.Employee;

import java.util.Comparator;

@Log
public class LastNameComparator implements Comparator<Employee> {

    public final static String comparatorField = "LastName";

    @Override
    public int compare(Employee o1, Employee o2) {
        return o2.getLastName().compareTo(o1.getLastName());
    }
}
