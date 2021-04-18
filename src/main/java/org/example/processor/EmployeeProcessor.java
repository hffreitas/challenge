package org.example.processor;

import org.example.converter.AsciiConverter;
import org.example.converter.CsvConverter;
import org.example.converter.EmployeeConverter;
import org.example.entity.Employee;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;

public class EmployeeProcessor {

    public static void processor(Path inputFile, Path outputFile, Comparator<Employee> comparator) {
        try (BufferedReader br = Files.newBufferedReader(inputFile, StandardCharsets.US_ASCII);
             BufferedWriter bw = Files.newBufferedWriter(outputFile)
        ) {
            String converterType = br.readLine();
            if (converterType.isEmpty()) {
                throw new RuntimeException("You need to specify the converter type");
            }

            EmployeeConverter employeeConverter;
            if (converterType.trim().equals(AsciiConverter.type)) {
                employeeConverter = new AsciiConverter();
            } else {
                employeeConverter = new CsvConverter();
            }

            br.lines().parallel()
                    .map(employeeConverter::convertTo)
                    .sorted(comparator)
                    .forEach(employee -> {
                        try {
                            bw.write(employee.toString());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
