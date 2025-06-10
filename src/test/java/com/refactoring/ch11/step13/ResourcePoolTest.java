package com.refactoring.ch11.step13;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ResourcePoolTest {
    private ResourcePool resourcePool;

    @BeforeEach
    void setUp() {
        resourcePool = new ResourcePool();
    }

    @Test
    void testGet_CreatesNewResourceWhenAvailableIsEmpty() {
        Resource result = resourcePool.get();

        assertNotNull(result);
        assertEquals(1, resourcePool.getAllocated().size());
    }

    @Test
    void testGet_ReturnsFromAvailableWhenNotEmpty() {
        Resource preloaded = new Resource();
        resourcePool.getAvailable().add(preloaded);

        Resource result = resourcePool.get();

        assertSame(preloaded, result); // 같은 객체인지 비교
        assertEquals(1, resourcePool.getAllocated().size());
        assertTrue(resourcePool.getAllocated().contains(preloaded));
    }

    @Test
    void testGet_AddsToAllocatedAlways() {
        Resource result = resourcePool.get();
        assertTrue(resourcePool.getAllocated().contains(result));
    }
}