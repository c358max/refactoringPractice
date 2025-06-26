package com.refactoring.ch11.step13;

public class Resource {
    private String id;

    public Resource(String id) {
        this.id = id;
    }

    public static Resource create() {
        return new Resource("generated-" + System.nanoTime());
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Resource{" + "id='" + id + '\'' + '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Resource)) return false;
        return this.id.equals(((Resource) obj).id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
