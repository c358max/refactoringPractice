package com.refactoring.ch11.step08;

import java.util.Map;

/**
 * 11.8 생성자를 팩토리 함수로 바꾸기(Replace Constructor with Factory Function)
 * * 리팩터링 전 : 생성자 이름만으로는 객체의 종류를 명확히 알기 어려움
 * 생성자보다 더 명확한 이름과 다양한 인스턴스 생성 로직을 제공할 수 있는 팩토리 메서드를 사용하여
 * 객체 생성의 명확성과 유연성을 향상시키는 것이 목적
 */
public class Employee {
    private String name;
    private EmployeeType type;

    public Employee(String name, EmployeeType type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public static Employee createEngineer(String name) {
        return new Employee(name, EmployeeType.ENGINEER);
    }

    public static Employee createManager(String name) {
        return new Employee(name, EmployeeType.MANAGER);
    }

    public static Employee createSalesperson(String name) {
        return new Employee(name, EmployeeType.SALESPERSON);
    }

    public EmployeeType getType() {
        return type;
    }

    public static void main(String[] args) {

        Employee e1 = Employee.createEngineer("David");
        Employee e2 = Employee.createManager("Johnson");
        Employee e3 = Employee.createSalesperson("Alice");

        System.out.println("Employee 1: " + e1.getName() + ", Type: " + e1.getType());
        System.out.println("Employee 2: " + e2.getName() + ", Type: " + e2.getType());
        System.out.println("Employee 3: " + e3.getName() + ", Type: " + e3.getType());
    }
}
