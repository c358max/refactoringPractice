package com.refactoring.ch11.step07;

/**
 * 11.7 세터 제거하기(Remove Setting Method)
 */
public class Person {
    private final String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
