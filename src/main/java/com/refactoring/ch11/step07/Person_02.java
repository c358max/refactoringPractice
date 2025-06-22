package com.refactoring.ch11.step07;

/**
 * 11.7 세터 제거하기(Remove Setting Method)
 * * final 필드로 변경하여 불변 선언
 * * name 필드에 대한 setter 메서드를 제거하여 외부에서 이름을 변경할 수 없도록 함
 */
public class Person_02 {
    private final String name;

    public Person_02(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
