package com.refactoring.ch11.step08;

import com.refactoring.ch11.step08.Employee;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {

//    @Test
//    void createEngineer() {
//        Employee emp = new Employee("David", "E");
//
//        assertEquals("David", emp.getName());
//        assertEquals("Engineer", emp.getType());
//    }
//
//    @Test
//    void createManager() {
//        Employee emp = new Employee("Johnson", "M");
//
//        assertEquals("Johnson", emp.getName());
//        assertEquals("Manager", emp.getType());
//    }
//
//    @Test
//    void createSalesperson() {
//        Employee emp = new Employee("Alice", "S");
//
//        assertEquals("Alice", emp.getName());
//        assertEquals("Salesperson", emp.getType());
//    }
//
//    @Test
//    void createWithInvalidTypeCode_shouldReturnUnknown() {
//        Employee emp = new Employee("Nam", "X");
//
//        assertEquals("Nam", emp.getName());
//        assertEquals("Unknown", emp.getType());  // 예외 없이 "Unknown" 반환
//    }

    @DisplayName("엔지니어 생성 테스트")
    @Test
    void createValidEngineer() {
        Employee emp = Employee.createEngineer("David");

        assertEquals("David", emp.getName());
        assertEquals(EmployeeType.ENGINEER, emp.getType());
    }

    @DisplayName("매니저 생성 테스트")
    @Test
    void createValidManager() {
        Employee emp = Employee.createManager("Johnson");

        assertEquals("Johnson", emp.getName());
        assertEquals(EmployeeType.MANAGER, emp.getType());
    }

    @DisplayName("세일즈맨 생성 테스트")
    @Test
    void createValidSalesperson() {
        Employee emp = Employee.createSalesperson("Alice");

        assertEquals("Alice", emp.getName());
        assertEquals(EmployeeType.SALESPERSON, emp.getType());
    }
}