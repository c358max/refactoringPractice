package com.refactoring.ch11.step09;

public class Candidate {
    private String name;
    private String originState;

    public Candidate(String name, String originState) {
        this.name = name;
        this.originState = originState;
    }

    public String getOriginState() {
        return originState;
    }
}
