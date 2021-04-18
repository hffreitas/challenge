package org.example.entity;

import lombok.Builder;
import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Data
public class Employee implements Comparable<Employee> {
    private static long nextId = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    private LocalDate startDate;
    private String address1;
    private String address2;
    private String city;
    private String state;
    private String country;
    private Integer zip;

    @Builder
    public Employee(String firstName, String lastName, LocalDate startDate, String address1, String address2, String city, String state, String country, Integer zip) {
        this.id = nextId++;
        this.firstName = firstName;
        this.lastName = lastName;
        this.startDate = startDate;
        this.address1 = address1;
        this.address2 = address2;
        this.city = city;
        this.state = state;
        this.country = country;
        this.zip = zip;
    }

    @Override
    public int compareTo(Employee o) {
        return this.firstName.compareTo(o.getFirstName());
    }

    @Override
    public String toString() {
        return id + "\n\t"
                + firstName + " " + lastName + ", (" + startDate.format(DateTimeFormatter.ofPattern("MM/dd/yyyy")) + "),\n\t"
                + address1 + ", " + address2 + ",\n\t"
                + city + ", " + state + ",\n\t"
                + country + ", " + zip + "\n";
    }
}
