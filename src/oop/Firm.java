package oop;

import java.util.ArrayList;
import java.util.List;

public class Firm {
    private String name;
    private List<Employee> employees = new ArrayList<>();

    public Firm(String name) {
        this.name = name;
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
        employee.setFirm(this);
    }

    public List<Employee> getEmployees() {
        return employees;
    }
}
