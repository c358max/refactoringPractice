package com.refactoring.ch11.step13;

import java.util.*;

/**
 * 11.13 예외를 사전확인으로 바꾸기(Replace Exception with Precheck)
 * 예외 대신 available.isEmpty()로 조건을 확인하여 처리.
 * 공통 로직은 블록 밖으로 추출한다.
 */
public class ResourcePool_02 {
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

        if(!available.isEmpty()) {
            result = available.pop();
        } else {
            result = Resource.create();
        }

        allocated.add(result);
        return result;
    }

    public static void main(String[] args) {
        ResourcePool_02 pool = new ResourcePool_02();

        // 리소스를 요청하는 호출부
        Resource r1 = pool.get();
        Resource r2 = pool.get();
        System.out.println("두 개의 리소스를 할당했습니다: " + r1 + ", " + r2);
    }
}
