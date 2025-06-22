package com.refactoring.ch11.step08;

/**
 * 11.8 생성자를 팩토리 함수로 바꾸기(Replace Constructor with Factory Function)
 * 타입별 코드만 봐서는 어떤 역할인지 명확히 알기 어려운 Employee 클래스
 * createEngineer, createManager, createSalesperson 메서드를 통해 생성의도를 코드수준에서 표현
 * 코드 자체가 곧 문서역할을 함.
 */
public class Employee_02 {
    private String name;
    private String typeCode;

    public Employee_02(String name, String typeCode) {
        this.name = name;
        this.typeCode = typeCode;
    }

    public String getName() {
        return name;
    }

    public static Employee_02 createEngineer(String name) {
        return new Employee_02(name, "E");
    }

    public static Employee_02 createManager(String name) {
        return new Employee_02(name, "M");
    }

    public static Employee_02 createSalesperson(String name) {
        return new Employee_02(name, "S");
    }

    public String getType() {
        return switch (typeCode) {
            case "E" -> "Engineer";
            case "M" -> "Manager";
            case "S" -> "Salesperson";
            default -> throw new IllegalArgumentException("Invalid type code");
        };
    }

    public static void main(String[] args) {

        Employee_02 e1 = Employee_02.createEngineer("David");
        Employee_02 e2 = Employee_02.createManager("Johnson");
        Employee_02 e3 = Employee_02.createSalesperson("Alice");

        System.out.println("Employee 1: " + e1.getName() + ", Type: " + e1.getType());
        System.out.println("Employee 2: " + e2.getName() + ", Type: " + e2.getType());
        System.out.println("Employee 3: " + e3.getName() + ", Type: " + e3.getType());
    }
}
