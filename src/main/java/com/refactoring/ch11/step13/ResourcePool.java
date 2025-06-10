package com.refactoring.ch11.step13;

import java.util.*;

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
//    public Resource get() {
//        Resource result;
//        try {
//            result = available.pop();  // 큐가 비면 NoSuchElementException 발생
//            allocated.add(result);
//        } catch (NoSuchElementException e) {
//            result = Resource.create(); // 새로 생성
//            allocated.add(result);
//        }
//        return result;
//    }

    // 리팩터링 후
    public Resource get() {
        Resource result;
        if (!available.isEmpty()) {
            result = available.pop();
        } else {
            result = Resource.create();
        }
        allocated.add(result);
        return result;
    }
}
