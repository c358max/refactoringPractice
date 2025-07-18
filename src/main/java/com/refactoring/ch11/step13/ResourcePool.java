package com.refactoring.ch11.step13;

import java.util.*;

/**
 * 11.13 예외를 사전확인으로 바꾸기(Replace Exception with Precheck)
 */
public class ResourcePool {
    private Deque<Resource> available = new ArrayDeque<>();
    private List<Resource> allocated = new ArrayList<>();

    public Deque<Resource> getAvailable() {
        return available;
    }

    public List<Resource> getAllocated() {
        return allocated;
    }

    // 리팩터링 전
    public Resource get() {
        Resource result = !available.isEmpty()
                ? available.pop()
                : Resource.create();

        allocated.add(result);
        return result;
    }

    public static void main(String[] args) {
        ResourcePool pool = new ResourcePool();

        // 리소스를 요청하는 호출부
        Resource r1 = pool.get();
        Resource r2 = pool.get();
        System.out.println("두 개의 리소스를 할당했습니다: " + r1.getId() + ", " + r2.getId());
    }
}
