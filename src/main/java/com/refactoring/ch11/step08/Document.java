package com.refactoring.ch11.step08;

public class Document {
    private String name;
    private String empType;
    private String leadEngineer;

    public Document(String name, String empType, String leadEngineer) {
        this.name = name;
        this.empType = empType;
        this.leadEngineer = leadEngineer;
    }

    public String getName() {
        return name;
    }

    public String getEmpType() {
        return empType;
    }

    public String getLeadEngineer() {
        return leadEngineer;
    }
}
