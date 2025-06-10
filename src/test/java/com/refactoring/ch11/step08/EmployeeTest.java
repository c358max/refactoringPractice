package com.refactoring.ch11.step08;

import com.refactoring.ch11.step08.Employee;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {

//    @Test
//    void createEngineer() {
//        Employee emp = new Employee("이순신", "E");
//
//        assertEquals("이순신", emp.getName());
//        assertEquals("Engineer", emp.getType());
//    }
//
//    @Test
//    void createManager() {
//        Employee emp = new Employee("김유신", "M");
//
//        assertEquals("김유신", emp.getName());
//        assertEquals("Manager", emp.getType());
//    }
//
//    @Test
//    void createSalesperson() {
//        Employee emp = new Employee("장보고", "S");
//
//        assertEquals("장보고", emp.getName());
//        assertEquals("Salesperson", emp.getType());
//    }
//
//    @Test
//    void createWithInvalidTypeCode_shouldReturnUnknown() {
//        Employee emp = new Employee("홍길동", "X");
//
//        assertEquals("홍길동", emp.getName());
//        assertEquals("Unknown", emp.getType());  // 예외 없이 "Unknown" 반환
//    }
//
    @Test
    void createValidEngineer() {
        Employee emp = Employee.createEmployee("이순신", "E");

        assertEquals("이순신", emp.getName());
        assertEquals("Engineer", emp.getType());
    }

    @Test
    void createValidManager() {
        Employee emp = Employee.createEmployee("김유신", "M");

        assertEquals("김유신", emp.getName());
        assertEquals("Manager", emp.getType());
    }

    @Test
    void createValidSalesperson() {
        Employee emp = Employee.createEmployee("장보고", "S");

        assertEquals("장보고", emp.getName());
        assertEquals("Salesperson", emp.getType());
    }

    @Test
    void createInvalidTypeCode_shouldThrowException() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> Employee.createEmployee("홍길동", "X")
        );

        assertEquals("Invalid type code: X", exception.getMessage());
    }
}