package com.refactoring.ch11.step08;

/**
 * 11.8 생성자를 팩토리 함수로 바꾸기(Replace Constructor with Factory Function)
 * * 리팩터링 전 : 생성자 이름만으로는 객체의 종류를 명확히 알기 어려움
 * 생성자보다 더 명확한 이름과 다양한 인스턴스 생성 로직을 제공할 수 있는 팩토리 메서드를 사용하여
 * 객체 생성의 명확성과 유연성을 향상시키는 것이 목적
 */
public class Employee_01 {
    private String name;
    private String typeCode;

    public Employee_01(String name, String typeCode) {
        this.name = name;
        this.typeCode = typeCode;
    }

    public String getName() {
        return name;
    }

    /** 직원 유형을 반환하는 메서드
     typeCode에 따라 "Engineer", "Manager", "Salesperson" 중 하나를 반환
     예외 처리로 잘못된 typeCode가 들어올 경우 IllegalArgumentException을 발생시킴
     */
    public String getType() {
        return switch (typeCode) {
            case "E" -> "Engineer";
            case "M" -> "Manager";
            case "S" -> "Salesperson";
            default -> throw new IllegalArgumentException("Invalid type code");
        };
    }

    public static void main(String[] args) {

        Employee_01 e1 = new Employee_01("David", "E");
        Employee_01 e2 = new Employee_01("Johnson", "M");
        Employee_01 e3 = new Employee_01("Alice", "S");

        System.out.println("Employee 1: " + e1.getName() + ", Type: " + e1.getType());
        System.out.println("Employee 2: " + e2.getName() + ", Type: " + e2.getType());
        System.out.println("Employee 3: " + e3.getName() + ", Type: " + e3.getType());
    }
}
