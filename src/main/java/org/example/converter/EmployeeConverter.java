package org.example.converter;

import org.example.entity.Employee;

public interface EmployeeConverter {
    Employee convertTo(String line);
}
