package com.refactoring.ch11.step08;

import java.util.Map;

public class Employee {
    private String name;
    private String typeCode;

    private static final Map<String, String> LEGAL_TYPE_CODES = Map.of(
            "E", "Engineer",
            "M", "Manager",
            "S", "Salesperson"
    );

    // 리팩터링 전 생성자
//    public Employee(String name, String typeCode) {
//        this.name = name;
//        this.typeCode = typeCode;
//    }

    // 리팩터링 후 생성자
    // private 생성자
    private Employee(String name, String typeCode) {
        this.name = name;
        this.typeCode = typeCode;
    }

    // 팩토리 메서드
    public static Employee createEmployee(String name, String typeCode) {
        // 유효성 체크 등 추가 가능
        if (!LEGAL_TYPE_CODES.containsKey(typeCode)) {
            throw new IllegalArgumentException("Invalid type code: " + typeCode);
        }
        return new Employee(name, typeCode);
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return LEGAL_TYPE_CODES.getOrDefault(typeCode, "Unknown");
    }
}
