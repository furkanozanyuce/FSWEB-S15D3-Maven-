package org.example;


import org.example.entity.Employee;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<Employee> employees = new LinkedList<>();
        employees.add(new Employee(1, "Furkan", "Yuce"));
        employees.add(new Employee(1, "Furkan", "Yuce"));
        employees.add(new Employee(2, "Ahmet", "Aka"));
        employees.add(new Employee(3, "Mehmet", "Kamil"));
        employees.add(new Employee(3, "Ayse", "Guler"));

        System.out.println(employees);
        lines();

        List<Employee> duplicates = findDuplicates(employees);
        System.out.println(duplicates);
        lines();

        Map<Integer, Employee> uniques = findUniques(employees);
        System.out.println(uniques);
        lines();

        List<Employee> remove = removeDuplicates(employees);
        System.out.println(remove);
        lines();

        System.out.println(employees);
        lines();

        lines();
        lines();
        Map<String, Integer> calculate = WordCounter.calculatedWord();
        System.out.println(calculate);

    }
    public static List<Employee> findDuplicates(List<Employee> list) {
        Map<Employee, Integer> map = new HashMap<>();
        for (Employee employee : list) {
            if (employee == null) {
                continue;
            }
            if (map.containsKey(employee)) {
                int count = map.get(employee);
                map.put(employee, count + 1);
            } else {
                map.put(employee, 1);
            }
        }

        List<Employee> duplicates = new LinkedList<>();
        for (Map.Entry<Employee, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 1) {
                duplicates.add(entry.getKey());
            }
        }
        return duplicates;
    }

    public static Map<Integer, Employee> findUniques(List<Employee> list) {
        Map<Integer, Employee> map = new HashMap<>();
        for (Employee employee : list) {
            if (employee == null) {
                continue;
            }
            if (!map.containsKey(employee.getId())) {
                map.put(employee.getId(), employee);
            }
        }
        return map;
    }

    public static List<Employee> removeDuplicates(List<Employee> list) {
        Map<Employee, Integer> map = new HashMap<>();
        for (Employee employee : list) {
            if (employee == null) {
                continue;
            }
            if (map.containsKey(employee)) {
                map.put(employee, map.get(employee) + 1);
            } else {
                map.put(employee, 1);
            }
        }

        List<Employee> result = new LinkedList<>();
        for (Employee employee : list) {
            if (employee == null) {
                continue;
            }
            if (map.get(employee) == 1) {
                result.add(employee);
            }
        }
        return result;
    }

    public static void lines() {
        System.out.println("-----------------------------");
    }
}
