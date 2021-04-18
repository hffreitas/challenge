package org.example;

import lombok.extern.java.Log;
import org.example.comparator.FirstNameComparator;
import org.example.comparator.LastNameComparator;
import org.example.comparator.StartDateComparator;
import org.example.entity.Employee;
import org.example.processor.EmployeeProcessor;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;

/**
 * Hello world!
 */
@Log
public class App {

    public static void main(String[] args) {

        if (args.length < 2) {
            throw new RuntimeException("Wrong number of args: inputFile outputFile [comparatorField]\n"
                    + "comparatorField = FirstName | LastName | StartDate");
        }
        Path inputFile = Paths.get(args[0]);
        Path outputFile = Paths.get(args[1]);
        Comparator<Employee> comparator;

        if (args.length == 3) {
            switch (args[2]) {
                case LastNameComparator.comparatorField:
                    comparator = new LastNameComparator();
                    break;
                case StartDateComparator.comparatorField:
                    comparator = new StartDateComparator();
                    break;
                default:
                    comparator = new FirstNameComparator();
            }
        } else {
            comparator = new FirstNameComparator();
        }

        EmployeeProcessor.processor(inputFile, outputFile, comparator);
    }
}
