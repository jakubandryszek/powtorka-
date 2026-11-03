package oop;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    static void main() {
        /*
        Zaprojektuj klasę Pracownik posiadającą pola: imię, pensja (użyj BigDecimal)
        oraz data zatrudnienia (użyj LocalDate). Pamiętaj o hermetyzacji (enkapsulacji).

Następnie utwórz klasę Firma, która będzie agregować listę pracowników.
W klasie Firma zaimplementuj dwie metody:
Zwracającą pracownika o najdłuższym stażu pracy (tego, który został zatrudniony najwcześniej).
Obliczającą i zwracającą sumę pensji wszystkich pracowników.
         */
        Firm firm = new Firm("Firma1");

        firm.addEmployee(new Employee("Jakub", new BigDecimal(12300), LocalDate.now()));
        firm.addEmployee(new Employee("Marek", new BigDecimal(12300), LocalDate.of(2000,1,20)));
        firm.addEmployee(new Employee("franek", new BigDecimal(12300), LocalDate.now()));
        firm.addEmployee(new Employee("dawid", new BigDecimal(12300), LocalDate.now()));


        System.out.println(getSumOfAllSalary(firm));
        System.out.println(getTheMostExperiencedEmployee(firm));
    }

    public static BigDecimal getSumOfAllSalary(Firm firm){
        return Optional.ofNullable(firm.getEmployees()).orElse(Collections.emptyList())
                .stream()
                .filter(Objects::nonNull)
                .map(Employee::getSalary)
                .reduce(BigDecimal::add)
                .orElseThrow();
    }

//    public static Optional<Employee> getTheMostExperiencedEmployee(Firm firm){
//        return  Optional.ofNullable(firm.getEmployees()).orElse(Collections.emptyList())
//                .stream()
//                .filter(Objects::nonNull)
//                .collect(Collectors.toMap(employee -> employee , Employee::getYear))
//                .entrySet().stream()
//                .min(Map.Entry.comparingByValue())
//                .map(Map.Entry::getKey);
//
//    }

    public static Optional<Employee> getTheMostExperiencedEmployee(Firm firm){
        return  Optional.ofNullable(firm.getEmployees()).orElse(Collections.emptyList())
                .stream()
                .filter(Objects::nonNull)
                .sorted(Comparator.comparing(Employee::getYear))
                .skip(0)
                .findFirst();
    }
}
