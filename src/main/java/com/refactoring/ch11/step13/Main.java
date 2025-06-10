package com.refactoring.ch11.step13;

public class Main {
    public static void main(String[] args) {
        ResourcePool pool = new ResourcePool();

        // 리소스를 요청하는 호출부
        Resource r1 = pool.get();
        Resource r2 = pool.get();
        System.out.println("두 개의 리소스를 할당했습니다: " + r1 + ", " + r2);
    }
}
