package com.refactoring.ch11.step13;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 11.13 예외를 사전확인으로 바꾸기(Replace Exception with Precheck)
 * 삼항 연산으로 코드 간결화
 */
public class ResourcePool_03 {
    private Deque<Resource> available = new ArrayDeque<>();
    private List<Resource> allocated = new ArrayList<>();

    public Deque<Resource> getAvailable() {
        return available;
    }

    public List<Resource> getAllocated() {
        return allocated;
    }

    public Resource get() {
        Resource result = !available.isEmpty()
                ? available.pop()
                : Resource.create();

        allocated.add(result);
        return result;
    }

    public static void main(String[] args) {
        ResourcePool_03 pool = new ResourcePool_03();

        // 리소스를 요청하는 호출부
        Resource r1 = pool.get();
        Resource r2 = pool.get();
        System.out.println("두 개의 리소스를 할당했습니다: " + r1 + ", " + r2);
    }
}
