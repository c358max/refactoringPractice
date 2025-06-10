package com.refactoring.ch11.step08;

public class Main {
    public static void main(String[] args) {
        // document 객체 가정
        Document document = new Document("홍길동", "M", "이순신");

        // 생성자 직접 사용
//        Employee candidate = new Employee(document.getName(), document.getEmpType());
//        Employee leadEngineer = new Employee(document.getLeadEngineer(), "E");
        Employee candidate = Employee.createEmployee(document.getName(), document.getEmpType());
        Employee leadEngineer = Employee.createEmployee(document.getLeadEngineer(), "E");

        // 출력 확인
        System.out.println("후보자: " + candidate.getName() + ", 직무: " + candidate.getType());
        System.out.println("수석 엔지니어: " + leadEngineer.getName() + ", 직무: " + leadEngineer.getType());
    }
}
