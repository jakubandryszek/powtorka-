package oop;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Employee {
    private String name;
    private BigDecimal salary;
    private LocalDate year;
    private Firm firm;

    public Employee(String name, BigDecimal salary, LocalDate year) {
        this.name = name;
        this.salary = salary;
        this.year = year;
    }

    public void setFirm(Firm firm) {
        this.firm = firm;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public LocalDate getYear() {
        return year;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", year=" + year +
                ", firm=" + firm +
                '}';
    }
}
