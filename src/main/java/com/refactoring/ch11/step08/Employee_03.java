package com.refactoring.ch11.step08;

/**
 * 11.8 생성자를 팩토리 함수로 바꾸기(Replace Constructor with Factory Function)
 * 문자열 대신에 Enum을 사용하여 Employee 클래스를 리팩토링
 *
 */
public class Employee_03 {
    private String name;
    private EmployeeType type;

    public Employee_03(String name, EmployeeType type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public static Employee_03 createEngineer(String name) {
        return new Employee_03(name, EmployeeType.ENGINEER);
    }

    public static Employee_03 createManager(String name) {
        return new Employee_03(name, EmployeeType.MANAGER);
    }

    public static Employee_03 createSalesperson(String name) {
        return new Employee_03(name, EmployeeType.SALESPERSON);
    }

    public EmployeeType getType() {
        return type;
    }

    public static void main(String[] args) {

        Employee_03 e1 = Employee_03.createEngineer("David");
        Employee_03 e2 = Employee_03.createManager("Johnson");
        Employee_03 e3 = Employee_03.createSalesperson("Alice");

        System.out.println("Employee 1: " + e1.getName() + ", Type: " + e1.getType());
        System.out.println("Employee 2: " + e2.getName() + ", Type: " + e2.getType());
        System.out.println("Employee 3: " + e3.getName() + ", Type: " + e3.getType());
    }
}
