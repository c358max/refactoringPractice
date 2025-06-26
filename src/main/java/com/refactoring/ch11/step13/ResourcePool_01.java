package com.refactoring.ch11.step13;

import java.util.*;

/**
 * 11.13 예외를 사전확인으로 바꾸기(Replace Exception with Precheck)
 * 리팩터링 전 : available.pop()에서 예외 발생을 통해 조건을 판별하고 있음.
 * 이 예외는 비즈니스 로직이 아니라 예측 가능한 조건 -> 조건 분기로 처리하는게 적절함.
 */
public class ResourcePool_01 {
    private Deque<Resource> available = new ArrayDeque<>();
    private List<Resource> allocated = new ArrayList<>();

    public Deque<Resource> getAvailable() {
        return available;
    }

    public List<Resource> getAllocated() {
        return allocated;
    }

    public Resource get() {
        Resource result;

        try {
            result = available.pop();   // 비어있으면 예외 발생
            allocated.add(result);
        } catch (NoSuchElementException e) {
            result = Resource.create(); // 예외 발생시 새 리소스 생성
            allocated.add(result);
        }

        return result;
    }

    public static void main(String[] args) {
        ResourcePool_01 pool = new ResourcePool_01();

        // 리소스를 요청하는 호출부
        Resource r1 = pool.get();
        Resource r2 = pool.get();
        System.out.println("두 개의 리소스를 할당했습니다: " + r1 + ", " + r2);
    }
}
