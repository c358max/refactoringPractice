package com.refactoring.ch11.step13;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ResourcePoolTest {
    @DisplayName("리소스를 하나 요청할 때 available에 리소스가 있으면 pop된다")
    @Test
    void get_returnsAvailableResource() {
        ResourcePool pool = new ResourcePool();
        Resource mockResource = new Resource("A");

        pool.getAvailable().push(mockResource);
        Resource result = pool.get();

        assertEquals(mockResource, result);
        assertTrue(pool.getAllocated().contains(mockResource));
    }

    @DisplayName("available이 비어있으면 새 리소스를 생성하여 할당한다")
    @Test
    void get_createsResourceWhenNoneAvailable() {
        ResourcePool pool = new ResourcePool();

        Resource result = pool.get();

        assertNotNull(result);
        assertTrue(pool.getAllocated().contains(result));
    }

    @DisplayName("get()을 여러 번 호출하면 각기 다른 리소스를 할당한다")
    @Test
    void get_multipleResources() {
        ResourcePool pool = new ResourcePool();

        Resource r1 = pool.get();
        Resource r2 = pool.get();

        assertNotNull(r1);
        assertNotNull(r2);
        assertEquals(2, pool.getAllocated().size());
        assertTrue(pool.getAllocated().contains(r1));
        assertTrue(pool.getAllocated().contains(r2));
    }
}