package com.refactoring.ch11.step07;

/**
 * 11.7 세터 제거하기(Remove Setting Method)
 * * 리팩터링 전 : Person 클래스에서 setName 메서드를 사용하여 이름을 변경할 수 있음
 * 객체 생성 이후 상태를 변경하지 못하도록 하여 불변성을 유지하는 것이 목적
 */
public class Person_01 {
    private String name;

    public Person_01(String name) {
        this.name = name;
    }

    public void setName(String name) {  // 외부에서 값 변경 가능
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
